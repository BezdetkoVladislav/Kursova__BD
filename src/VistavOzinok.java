import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistavOzinok  {
    private JTable table1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JSpinner spinner1;
    private JButton додатиButton;
    private JButton змінитиButton;
    private JComboBox comboBox3;
    private JButton назадButton;
    protected JPanel pan;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    Teacher ac;
    int listnum;
    JFrame fram;
    String saver,baver,uch,tyu;
    int old;

    public Exception addt(String a, String b, int d) {
        String sql = "call school.add_tab(?,?,?)";
        if(d>0 && d<12){
        try {
            ac.connector.preparedStatement = ac.connector.connector.prepareStatement(sql);
            ac.connector.preparedStatement.setString(1,b);
            ac.connector.preparedStatement.setString(2,a);;
            ac.connector.preparedStatement.setInt(3,d);
            ac.connector.preparedStatement.execute();
            return null;
        } catch (Exception w) {
            System.out.println(w);
            return w;
        }} else{
            try{throw new NullPointerException();}catch(Exception w){
            return w;}
        }
    }

    protected VistavOzinok(Connector connect, CardLayout cardLayout, JFrame fram){
       this.fram=fram;
        comboBox2 =connect.getcombo2(comboBox2);
        comboBox4 = connect.getcombo(comboBox4,0);
        назадButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                cardLayout.show(fram.getContentPane(),"tch");
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver = connect.combo_crt(e);
                comboBox1 = connect.getcombo3(comboBox1,saver);
                try{
                    comboBox1.setSelectedIndex(0);
                } catch (Exception sda){}
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uch = connect.combo_crt(e);
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                baver = connect.combo_crt(e);
                comboBox3 = connect.getcombo4(comboBox3,baver,uch);
                try{
                    comboBox3.setSelectedIndex(0);
                } catch (Exception sda){
                    comboBox5 = connect.getcombo5(comboBox5,uch,baver,tyu);
                    try{
                        comboBox5.setSelectedIndex(0);
                    } catch (Exception sdas){}
                }
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tyu = connect.combo_crt(e);
                comboBox5 = connect.getcombo5(comboBox5,uch,baver,tyu);
                try{
                    comboBox5.setSelectedIndex(0);
                } catch (Exception sda){}
            }
        });
        comboBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                old = Integer.parseInt(connect.combo_crt(e));
            }
        });
        змінитиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                spinner1.commitEdit();} catch (Exception es){}
                int value = (Integer)spinner1.getValue();
                if(!saver.isEmpty() && !baver.isEmpty() && !uch.isEmpty() && !tyu.isEmpty() && value<13 && value>0 && old>0){
                    ac.chng_oz(baver,uch,tyu,value,old);
                    comboBox3 = connect.getcombo4(comboBox3,baver,uch);
                    comboBox5 = connect.getcombo5(comboBox5,uch,baver,tyu);
                }
                try {
                    table1.setModel(ac.get_oz());
                } catch (Exception ess){}
            }
        });
        додатиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    spinner1.commitEdit();} catch (Exception es){}
                int value = (Integer)spinner1.getValue();
                if(!saver.isEmpty() && !baver.isEmpty() && !uch.isEmpty() && value<13 && value>0){
                    addt(baver,uch,value);
                    comboBox3 = connect.getcombo4(comboBox3,baver,uch);
                    comboBox5 = connect.getcombo5(comboBox5,uch,baver,tyu);
                }
                try {
                    table1.setModel(ac.get_oz());
                } catch (Exception ess){}
            }
        });
    }
    protected void chcklist(){
        try {
            table1.setModel(ac.get_oz());
        } catch (Exception e){}
        fram.revalidate();
        fram.repaint();
    }

}
