package Repository;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

public class Getconnection {

    public static Connection getConnection() {
        SQLServerDataSource data = new SQLServerDataSource();
        data.setUser("sa");
        data.setPassword("123456");
        data.setEncrypt(Boolean.FALSE);
        data.setPortNumber(1433);
        data.setDatabaseName("DuAn1");
        Connection connection = null;
        try {
            connection = data.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
