import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ozinku  {
    private JTable table1;
    private JButton button1;
    private JComboBox comboBox1;
    private JButton button2;
    private JButton button3;
    private JSpinner spinner1;
    private JButton назадButton;
    private JButton button4;
    protected JPanel pan;
    private JPanel kl;
    private JComboBox cm2;
    Ucheny acc=null;
    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    Teacher ac=null;
    int listnum;
    JFrame fram;
    String saver,bigger;
    Connector connector;
    protected DefaultTableModel get_oz_pred(String pr,int x) {
        String sql = "call school.oz_all_predm(?,?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,x);
            connector.preparedStatement.setString(2,pr);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
            return null;
        }

    }
    protected DefaultTableModel get_oz_bm(String pr,int oz,int x) {
        String sql = "call school.oz_all_bm(?,?,?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,x);
            connector.preparedStatement.setString(2,pr);
            connector.preparedStatement.setInt(3,oz);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
            return null;
        }

    }
    private String combo_crt(ActionEvent e){
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selected = comboBox.getSelectedItem();
        return selected.toString();
    }
    protected Ozinku(Connector connect, CardLayout cardLayout, JFrame fram){
        this.fram = fram;
        this.connector = connect;
        назадButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc!=null){fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(),"uch");
                } else if (ac!=null) {fram.setSize(675,300);fram.setLocationRelativeTo(null);
                    cardLayout.show(fram.getContentPane(), "tch");
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc!=null){
                    table1.setModel(acc.get_oz_week());
                } else if (ac!=null) {
                    table1.setModel(ac.get_oz_week());
                }
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver = combo_crt(e);
            }
        });
        cm2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bigger = combo_crt(e);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acc!=null) {
                    table1.setModel(get_oz_pred(saver,acc.id));
                } else if(ac!=null){
                    table1.setModel(get_oz_pred(saver,0));
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    spinner1.commitEdit();
                } catch ( java.text.ParseException ess ) {}
                int value = (Integer)spinner1.getValue();
                if(acc!=null && !bigger.isEmpty()&& value<13 && value>-1  ) {
                    table1.setModel(get_oz_bm(bigger,value,acc.id));
                } else if (ac!=null && !bigger.isEmpty()&& value<13 && value>-1 ) {
                    table1.setModel(get_oz_bm(bigger,value,0));
                }

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table1.setModel(ac.get_oz_sers());
            }
        });
    }

    void chcklist() {
        comboBox1 = this.connector.getcombo(comboBox1,1);
        cm2 = this.connector.getcombo1(cm2);
        if(listnum==1){
            kl.setVisible(false);
            try {
                table1.setModel(acc.get_oz_week());
            } catch (Exception e){}
        } else if(listnum==2){
            kl.setVisible(true);
            try {
                table1.setModel(ac.get_oz_week());
            } catch (Exception e){}
        }
        fram.revalidate();
        fram.repaint();
    }


}
