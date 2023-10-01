import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSetMetaData;

public class Test {
    private JTable table1;
    private JButton переглядButton;
    private JButton переглядButton1;
    private JButton переглядButton2;
    private JButton переглядButton4;
    private JTextField textField1;
    private JTextField textField2;
    JPanel pan; JFrame fram;
    private JButton переглядButton5;
    private JButton переглядButton6;
    private JButton переглядButton7;
    private JButton переглядButton3;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField41;
    private JTextField textField5;
    private JTextField textField51;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField71;
    private JButton переглядButton8;
    private JButton переглядButton9;
    private JButton переглядButton10;
    private JButton переглядButton11;
    private JButton переглядButton12;
    private JButton назадButton;
    Connector connector;

    protected Test(Connector connect, CardLayout cardLayout, JFrame fram) {
        this.fram = fram;
        this.connector = connect;
        переглядButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField1.getText().isEmpty())
                    but1(textField1.getText());
            }
        });
        переглядButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField2.getText().isEmpty())
                    but2(textField2.getText());
            }
        });
        переглядButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField3.getText().isEmpty())
                    but3(textField3.getText());
            }
        });
        переглядButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField4.getText().isEmpty() && !textField41.getText().isEmpty())
                    but4(textField4.getText(), textField41.getText());
            }
        });
        переглядButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField5.getText().isEmpty() && !textField51.getText().isEmpty())
                    but5(textField5.getText(), textField51.getText());
            }
        });
        переглядButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField6.getText().isEmpty())
                    but6(textField6.getText());
            }
        });
        переглядButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but7();
            }
        });
        переглядButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but8();
            }
        });
        переглядButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but9();
            }
        });
        переглядButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but10();
            }
        });
        переглядButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but11();
            }
        });
        переглядButton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                but12();
            }
        });
        переглядButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField7.getText().isEmpty() && !textField71.getText().isEmpty())
                    but13(textField7.getText(), textField71.getText());
            }
        });
        назадButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fram.setSize(675,300);fram.setLocationRelativeTo(null);cardLayout.show(fram.getContentPane(),"adm");
            }
        });
    }
    protected void but1(String x){
        String sql = "call school.tt1(?)";
        try{
        table1.setModel(connector.gtt(sql,x));}catch (Exception e){}
}
protected void but2(String x){
    String sql = "call school.tt2(?)";
    try{
    table1.setModel(connector.gtt(sql,x));}catch (Exception e){}
    }
    protected void but3(String x){
        String sql = "call school.tt3(?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setString(1,x);
            connector.results = connector.preparedStatement.executeQuery();
            try{table1.setModel(connector.model_create());}catch (Exception xz){}
        } catch (Exception w) {
        }
    }
    protected void but4(String x,String y){
        String sql = "call school.tt4(?,?)";
        try {
            table1.setModel(connector.gtts(sql,x,y));}catch (Exception e){}
    }
    protected void but5(String x,String y){
        String sql = "call school.tt5(?,?)";
            try {
                table1.setModel(connector.gtts(sql,x,y));}catch (Exception e){}
    }
    protected void but6(String x){
        String sql = "call school.tt6(?)";
                try {
                    table1.setModel(connector.gtt(sql,x));}catch (Exception e){}
    }
    protected void but7(){
        String sql = "call school.tt7()";
                    try {
                        table1.setModel(connector.gtter(sql));}catch (Exception e){}
    }
    protected void but8(){
        String sql = "call school.tt8()";
                        try {
                            table1.setModel(connector.gtter(sql));}catch (Exception e){}
    }
    protected void but9(){
        String sql = "call school.tt9()";
        try {
            table1.setModel(connector.gtter(sql));}catch (Exception e){}
    }
    protected void but10(){
        String sql = "call school.tt10()";
        try {
            table1.setModel(connector.gtter(sql));}catch (Exception e){}
    }
    protected void but11(){
        String sql = "call school.tt11()";
try {
table1.setModel(connector.gtter(sql));}catch (Exception e){}
}
    protected void but12(){
        String sql = "call school.tt12()";
        try {
            table1.setModel(connector.gtter(sql));}catch (Exception e){}
    }
    protected void but13(String x,String y){
        String sql = "call school.tt13(?,?)";
            try {
                table1.setModel(connector.gtts(sql,x,y));}catch (Exception e){}
    }

}
