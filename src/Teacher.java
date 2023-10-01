import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
public class Teacher extends AbUser{
    String pib;
    String spec;
    String kat;
    int pr_id;
    int x=0;


    public Teacher(Connector connector,int identificator){
        this.connector = connector;
        id = identificator;
        get_data();
    }
    private void get_data() {
        String sql = "call school.teach_data(?,?,?,?,?);";
        try {
            connector.callableStatement  = connector.connector.prepareCall(sql);
            connector.callableStatement.setInt(1,id);
            connector.callableStatement.registerOutParameter(2, Types.VARCHAR);
            connector.callableStatement.registerOutParameter(3,Types.VARCHAR);
            connector.callableStatement.registerOutParameter(4,Types.DATE);
            connector.callableStatement.registerOutParameter(5,Types.DATE);
            connector.callableStatement.execute();
            pib =connector.callableStatement.getString(2);
            spec =connector.callableStatement.getString(3);
            kat =connector.callableStatement.getString(4);
            pr_id = connector.callableStatement.getInt(5);
        }catch (Exception ss) {
            System.out.println(ss);
        }
    }

    protected DefaultTableModel get_table() throws SQLException {
        String sql = "call school.getpmuch(?,?)";
        try {
            x++;
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,this.pr_id);
            connector.preparedStatement.setInt(2,x);
            connector.results = connector.preparedStatement.executeQuery();
            if(x==2){
                x=0;
            }
            return connector.model_create();
        } catch (Exception w) {
            System.out.println(w);
        }
        return null;
    }

    protected DefaultTableModel get_roz_table(int date){
        String sql = "call school.date_week_pred(?,?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,date);
            connector.preparedStatement.setInt(2,this.id);
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
            connector.preparedStatement.setInt(1,0);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected DefaultTableModel get_oz_pred(String pr) {
        String sql = "call school.oz_all_predm(?,?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,0);
            connector.preparedStatement.setString(2,pr);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }
    protected DefaultTableModel get_oz_bm(String pr,int oz) {
        String sql = "call school.oz_all_bm(?,?,?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,0);
            connector.preparedStatement.setString(2,pr);
            connector.preparedStatement.setInt(3,oz);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }
    protected DefaultTableModel get_oz_sers() {
        String sql = "call school.get_sers();";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected DefaultTableModel get_oz_week() {
        String sql = "call school.oz_all_week_pr(?);";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,this.pr_id);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected void chng_oz(String a, String b,String c, int d,int old) {
        String sql = "call school.update_tab(?,?,?,?,?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setString(1,b);
            connector.preparedStatement.setString(2,a);;
            connector.preparedStatement.setString(3,c);
            connector.preparedStatement.setInt(4,d);
            connector.preparedStatement.setInt(5,old);
            connector.preparedStatement.execute();
        } catch (Exception w) {
            System.out.println(w);
        }
    }
    protected void addt(String a, String b, int d) {
        String sql = "call school.add_tab(?,?,?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setString(1,b);
            connector.preparedStatement.setString(2,a);;
            connector.preparedStatement.setInt(3,d);
            connector.preparedStatement.execute();
        } catch (Exception w) {
            System.out.println(w);
        }
    }
}