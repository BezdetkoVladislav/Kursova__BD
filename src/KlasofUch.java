import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlasofUch  {
    private JTable table1;
    private JButton назадButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton оновитиButton;
    protected JPanel pan;
    private JLabel name;
    private JPanel vykl;
    private JButton сортуватиЗаОцінкоюButton;
    private JPanel sort;
    Ucheny acc=null;
    Teacher ac=null;
    Admin a=null;
    int listnum;
    JFrame fram;
    int x =0;
    Connector connector;
    String h1,h2;
    protected KlasofUch(Connector connect, CardLayout cardLayout, JFrame fram){
        this.fram = fram;
        this.connector =connect;
        назадButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc!=null){ fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"uch");
                } else if (ac!=null) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"tch");
                } else if (a!=null) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"adm");
                }
            }
        });
        сортуватиЗаОцінкоюButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table1.setModel(ac.get_table());
                }catch(Exception ee){}
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h1 = connect.combo_crt(e);
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h2 = connect.combo_crt(e);
            }
        });
        оновитиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField1.getText().isEmpty() && !h1.isEmpty() && !h2.isEmpty()){
                    prod(textField1.getText());
                    chcklist();
                }
            }
        });
    }

    void chcklist(){
        if(listnum== 1){
            name.setText("Співробітники");
            vykl.setVisible(false);
            sort.setVisible(false);
            try {
                table1.setModel(a.get_table(listnum));
            } catch (Exception e){}
        } else if (listnum==2) {
            name.setText("Вчителі");
            vykl.setVisible(true);
            sort.setVisible(false);
            comboBox1.setModel(setbox());
            comboBox1.setSelectedIndex(0);
            comboBox2.setModel(setkat());
            comboBox2.setSelectedIndex(0);
            try {
                table1.setModel(a.get_table(listnum));
            } catch (Exception e){}
        } else if (listnum==3) {
            name.setText("Учні");
            vykl.setVisible(false);
            sort.setVisible(false);
            try {
                table1.setModel(a.get_table(listnum));
            } catch (Exception e){}
        } else if (listnum==4) {
            name.setText("Учні");
            vykl.setVisible(false);
            sort.setVisible(true);
            try {
                table1.setModel(ac.get_table());
            } catch (Exception e){}
        } else if (listnum==5) {
            name.setText(acc.klass);
            vykl.setVisible(false);
            sort.setVisible(false);
            try {
                table1.setModel(acc.get_table());
            } catch (Exception e){}
        }
        fram.revalidate();
        fram.repaint();
    }

    ComboBoxModel setbox(){
        String sql = "call school.vykl_id();";
        try{
            connector.preparedStatement =  connector.connector.prepareStatement(sql);
            connector.results = connector.preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (connector.results.next()) {
                jbox.addElement(connector.results.getString(1));
            }
            return jbox;
        } catch (Exception w){}
        return null;
    }
    ComboBoxModel setkat(){
        String sql = "call school.kat_add();";
        try{
            connector.preparedStatement =  connector.connector.prepareStatement(sql);
            connector.results = connector.preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (connector.results.next()) {
                jbox.addElement(connector.results.getString(1));
            }
            return jbox;
        } catch (Exception w){}
        return null;
    }
    Exception prod(String str){
        String sql = "call school.onovutu(?,?,?);";

        try{
            connector.preparedStatement =  connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,Integer.parseInt(h1));
            connector.preparedStatement.setInt(2,Integer.parseInt(h2));
            connector.preparedStatement.setString(3,str);
            connector.preparedStatement.execute();
            return null;
        } catch (Exception sda){
            System.out.println(sda);
            return sda;
        }
    }
}
