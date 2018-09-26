package net.belisariodongiovanni.jsfdemo.bo.connection;

import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Sergii.Zagriichuk
 */
public class PooledConnection {
    private static DataSource ds;

    static {
        DriverAdapterCPDS cpds = new DriverAdapterCPDS();
        try {
            cpds.setDriver("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        cpds.setUrl("jdbc:mysql://localhost:3306/jsfdemo");
        cpds.setUser("root");
        cpds.setPassword("r00t");

        SharedPoolDataSource tds = new SharedPoolDataSource();
        tds.setConnectionPoolDataSource(cpds);
        //tds.setMaxTotal(4);
        //tds.setDefaultMaxIdle(1);
        //tds.setDefaultMaxWaitMillis(60000); // 1 sec = 1000 ms, 10 seconds

        //tds.setMaxTotal(50);

        ds = tds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}