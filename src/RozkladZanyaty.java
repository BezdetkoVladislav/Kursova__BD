import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;
import java.time.LocalDate;

public class RozkladZanyaty {
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JButton повернутисяНаГоловнеМенюButton;
    private JComboBox comboBox1;
    private JButton переглянутиButton;
    private JButton button1;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;
    private JComboBox comboBox8;
    private JButton додатиButton;
    protected JPanel pan;
    private JPanel kl;
    private JPanel set;
    private JPanel teach;
    private JLabel День_тижня;
    private JComboBox comboBox2;
    Ucheny acc=null;
    Teacher ac=null;
    Admin a=null;
    int listnum;
    JFrame fram;
    String saver,zmina,nom,chas,predm,klas,kab,vch;
    Connector connector;
    protected RozkladZanyaty(Connector connect, CardLayout cardLayout, JFrame fram){
        День_тижня.setText(LocalDate.now().getDayOfWeek().name());
        this.connector = connect;
        this.fram = fram;
        comboBox1 = connect.getcombo2(comboBox1);
        повернутисяНаГоловнеМенюButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc!=null){fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"uch");
                } else if (ac!=null) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"tch");
                } else if (a!=null) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"adm");
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                selected.toString();
                saver = selected.toString();
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zmina = connect.combo_crt(e);
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nom = connect.combo_crt(e);
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chas = connect.combo_crt(e);
            }
        });
        comboBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                predm = connect.combo_crt(e);
                if(!predm.isEmpty()){
                    comboBox8.setModel(setvch());
                    comboBox8.setSelectedIndex(0);
                }
            }
        });
        comboBox6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                selected.toString();
                klas = selected.toString();
            }
        });
        comboBox7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kab = connect.combo_crt(e);
                }
        });
        comboBox8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vch = connect.combo_crt(e);
            }
        });
        переглянутиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(get_roz_table_acc(2));
                table2.setModel(get_roz_table_acc(3));
                table3.setModel(get_roz_table_acc(4));
                table4.setModel(get_roz_table_acc(5));
                table5.setModel(get_roz_table_acc(6));
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chcklist();
            }
        });
        додатиButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!zmina.isEmpty() && !nom.isEmpty() && !chas.isEmpty() && !predm.isEmpty() && !klas.isEmpty() && !kab.isEmpty() && !vch.isEmpty()) {
                    addem();
                    chcklist();
                }
            }
        });
    }

    void chcklist() {
        if(listnum==1){
            kl.setVisible(true);
            set.setVisible(true);
            teach.setVisible(false);
            comboBox2.setModel(setbox(2));
            comboBox2.setSelectedIndex(0);
            comboBox3.setModel(setbox(7));
            comboBox3.setSelectedIndex(0);
            comboBox4.setModel(setbox(5));
            comboBox4.setSelectedIndex(0);
            comboBox5 = connector.getcombo(comboBox5,0);
            comboBox5.setSelectedIndex(0);
            comboBox6 = connector.getcombo2(comboBox6);
            comboBox6.setSelectedIndex(0);
            comboBox7.setModel(setkabs());
            comboBox7.setSelectedIndex(0);

            try {
                table1.setModel(a.get_roz_table(2));
                table2.setModel(a.get_roz_table(3));
                table3.setModel(a.get_roz_table(4));
                table4.setModel(a.get_roz_table(5));
                table5.setModel(a.get_roz_table(6));
            } catch (Exception e){}
        } else if(listnum==2){
            kl.setVisible(false);
            set.setVisible(true);
            teach.setVisible(true);
            try {
                table1.setModel(ac.get_roz_table(2));
                table2.setModel(ac.get_roz_table(3));
                table3.setModel(ac.get_roz_table(4));
                table4.setModel(ac.get_roz_table(5));
                table5.setModel(ac.get_roz_table(6));
            } catch (Exception e){}
        } else if(listnum==3){
            kl.setVisible(false);
            set.setVisible(false);
            teach.setVisible(false);
            try {
                table1.setModel(acc.get_roz_table(2));
                table2.setModel(acc.get_roz_table(3));
                table3.setModel(acc.get_roz_table(4));
                table4.setModel(acc.get_roz_table(5));
                table5.setModel(acc.get_roz_table(6));
            } catch (Exception e){}
        }
        fram.revalidate();
        fram.repaint();
    }
    DefaultTableModel get_roz_table_acc(int date){
        String sql = "call school.date_week_pred_ok(?,?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1, date);
            connector.preparedStatement.setString(2, saver);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    ComboBoxModel setbox(int num){
        DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
        int i =0;
        while (i<num) {
            i++;
            jbox.addElement(String.valueOf(i));
        }
        return jbox;
    }
    ComboBoxModel setkabs(){
        String sql = "call school.get_kabs();";
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
    ComboBoxModel setvch(){
        String sql = "call school.get_vchs(?);";
        try{
            connector.preparedStatement =  connector.connector.prepareStatement(sql);
            connector.preparedStatement.setString(1,predm);
            connector.results = connector.preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (connector.results.next()) {
                jbox.addElement(connector.results.getString(1));
            }
            return jbox;
        } catch (Exception w){
            System.out.println(w);
        }
        return null;
    }
    void addem(){
        String sql = "call school.inserter(?,?,?,?,?,?,?);";
        try{
            connector.preparedStatement =  connector.connector.prepareStatement(sql);
            connector.preparedStatement.setString(1,zmina);
            connector.preparedStatement.setString(2,nom);
            connector.preparedStatement.setString(3,chas);
            connector.preparedStatement.setString(4,predm);
            connector.preparedStatement.setString(5,klas);
            connector.preparedStatement.setString(6,kab);
            connector.preparedStatement.setString(7,vch);
            connector.results = connector.preparedStatement.executeQuery();
        } catch (Exception w){
            System.out.println(w);
        }
    }



}
