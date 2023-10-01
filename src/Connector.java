import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.*;
public class Connector {
    protected Connection connector = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet results = null;
    protected CallableStatement callableStatement = null;
    public String position;

    protected Connector() {
        try {
            String url1 = "jdbc:mysql://localhost:3306/mysql";
            String user = "Vlad";
            String password = "Karandasch12";
            connector = DriverManager.getConnection(url1, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    DefaultTableModel model_create(){
        try {
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        DefaultTableModel model = new DefaultTableModel();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            model.addColumn(metaData.getColumnName(columnIndex));
        }
        while (results.next()) {
            Object[] rowData = new Object[columnCount];
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                rowData[columnIndex - 1] = results.getObject(columnIndex);
            }
            model.addRow(rowData);
        }
        return model;
        }   catch (Exception e){return null; }
    }
    protected int chck_user (String acc, String pass){
        String sql = "call school.chck_user(?,?,?,?);";
        try {
            callableStatement = connector.prepareCall(sql);
            callableStatement.setString(1, acc);
            callableStatement.setString(2, pass);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.execute();
            position = callableStatement.getString(3);
            int s = callableStatement.getInt(4);
            return s;
        } catch (Exception ss) {
            System.out.println(ss);
        }
        return 0;
    }
    JComboBox getcombo(JComboBox comboBox1,int i){
        String sql = "call school.get_prs();";
        try{
            preparedStatement =  connector.prepareStatement(sql);
            results = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (results.next()) {
                jbox.addElement(results.getString(1));
            }
            if(i==1) {
                jbox.addElement(("Усі"));
            }
            comboBox1.setModel(jbox);
            return comboBox1;
        } catch (Exception w){
            System.out.println(w);
        }
        return null;
    }
    JComboBox getcombo1(JComboBox comboBox1){
        try{
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            jbox.addElement("Більше");
            jbox.addElement("Менше");
            comboBox1.setModel(jbox);
            return comboBox1;
        } catch (Exception w){}
        return null;
    }
    JComboBox getcombo2(JComboBox comboBox){
        String sql = "call school.get_klas();";
        try{
            preparedStatement =  connector.prepareStatement(sql);
            results = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (results.next()) {
                jbox.addElement(results.getString(1));
            }
            comboBox.setModel(jbox);
            return comboBox;
        } catch (Exception w){}
        return null;
    }
    JComboBox getcombo3(JComboBox comboBox, String kl){
        String sql = "call school.get_uch_frklas(?);";
        try{
            preparedStatement =  connector.prepareStatement(sql);
            preparedStatement.setString(1,kl);
            results = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (results.next()) {
                jbox.addElement(results.getString(1));
            }
            comboBox.setModel(jbox);
            return comboBox;
        } catch (Exception w){}
        return null;
    }
    JComboBox getcombo4(JComboBox comboBox, String kl,String uch){
        String sql = "call school.get_uch_pr(?,?);";
        try{
            preparedStatement =  connector.prepareStatement(sql);
            preparedStatement.setString(1,kl);
            preparedStatement.setString(2,uch);
            results = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (results.next()) {
                jbox.addElement(results.getString(1));
            }
            comboBox.setModel(jbox);
            return comboBox;
        } catch (Exception w){}
        return null;    
    }
    JComboBox getcombo5(JComboBox comboBox,String uch, String pred, String data){
        String sql = "call school.get_uch_pr_oz(?,?,?);";
        try{
            preparedStatement =  connector.prepareStatement(sql);
            preparedStatement.setString(1,uch);
            preparedStatement.setString(2,pred);
            preparedStatement.setString(3,data);
            results = preparedStatement.executeQuery();
            DefaultComboBoxModel<String> jbox = new DefaultComboBoxModel();
            while (results.next()) {
                jbox.addElement(results.getString(1));
            }
            comboBox.setModel(jbox);
            return comboBox;
        } catch (Exception w){}
        return null;
    }

    DefaultTableModel gtt(String sql, String x){
        try {
            preparedStatement = connector.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(x));
            results = preparedStatement.executeQuery();
            return model_create();
        } catch (Exception w) {
        }
        return null;
    }
    DefaultTableModel gtts(String sql, String x,String y){
        try {
            preparedStatement = connector.prepareStatement(sql);
            preparedStatement.setInt(1,Integer.parseInt(x));
            preparedStatement.setInt(2,Integer.parseInt(y));
            results = preparedStatement.executeQuery();
            return model_create();
        } catch (Exception w) {
        }
        return null;
    }
    DefaultTableModel gtter(String sql){
        try {
            preparedStatement = connector.prepareStatement(sql);
            results = preparedStatement.executeQuery();
            return model_create();
        } catch (Exception w) {
        }
        return null;
    }
    public String combo_crt(ActionEvent e){
        JComboBox comboBox = (JComboBox) e.getSource();
        Object selected = comboBox.getSelectedItem();
        return selected.toString();
    }
}