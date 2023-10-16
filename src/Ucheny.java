import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Type;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class Ucheny extends AbUser{
    String pib;
    String num;
    float avg_mark;
    String date;
    String har;
    String klass;


    public Ucheny(Connector connect, int identificator){

        connector = connect;
        id = identificator;
        get_data();
    }

    private void get_data(){
        String sql = "call school.uch_data(?,?,?,?,?,?,?);";
        try {
            connector.callableStatement  = connector.connector.prepareCall(sql);
            connector.callableStatement.setInt(1,id);
            connector.callableStatement.registerOutParameter(2, Types.VARCHAR);
            connector.callableStatement.registerOutParameter(3,Types.VARCHAR);
            connector.callableStatement.registerOutParameter(4,Types.VARCHAR);
            connector.callableStatement.registerOutParameter(5,Types.VARCHAR);
            connector.callableStatement.registerOutParameter(6,Types.VARCHAR);
            connector.callableStatement.registerOutParameter(7,Types.FLOAT);
            connector.callableStatement.execute();
            pib =connector.callableStatement.getString(2);
            date =connector.callableStatement.getString(3);
            num =connector.callableStatement.getString(4);
            har =connector.callableStatement.getString(5);
            klass =connector.callableStatement.getString(6);
            avg_mark =connector.callableStatement.getFloat(7);
        }catch (Exception ss) {
            System.out.println(ss);
        }
    }
    protected DefaultTableModel get_table() throws SQLException {
        String sql = "call school.getkluch(?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,this.id);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected DefaultTableModel get_roz_table(int date){
        String sql = "call school.date_week_uch(?,?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,date);
            connector.preparedStatement.setString(2,this.klass);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected DefaultTableModel get_oz(){
        String sql = "call school.oz_all(?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,this.id);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }
    protected DefaultTableModel get_oz_week() {
        String sql = "call school.oz_all_week(?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,this.id);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }



}
