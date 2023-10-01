import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

public class Admin extends AbUser{

    String pib;
    String pos;


    public Admin(Connector connector, int identificator) {
        this.connector = connector;
        id = identificator;
        get_data();
    }

    private void get_data() {
        String sql = "call school.admn_data(?,?,?);";
        try {
            connector.callableStatement = connector.connector.prepareCall(sql);
            connector.callableStatement.setInt(1, id);
            connector.callableStatement.registerOutParameter(2, Types.VARCHAR);
            connector.callableStatement.registerOutParameter(3, Types.VARCHAR);
            connector.callableStatement.execute();
            pib = connector.callableStatement.getString(2);
            pos = connector.callableStatement.getString(3);
        } catch (Exception ss) {
            System.out.println(ss);
        }
    }

    protected DefaultTableModel get_table(int num) throws SQLException {
        String sql = "";
        if (num == 1) {
            sql = "call school.getspiv()";
        } else if (num == 2) {
            sql = "call school.getvch()";
        } else if (num == 3) {
            sql = "call school.getuch()";
        }
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

    protected DefaultTableModel get_roz_table(int date){
        String sql = "call school.date_week(?)";
        try {
            connector.preparedStatement = connector.connector.prepareStatement(sql);
            connector.preparedStatement.setInt(1,date);
            connector.results = connector.preparedStatement.executeQuery();
            return connector.model_create();
        } catch (Exception w) {
        }
        return null;
    }

}
