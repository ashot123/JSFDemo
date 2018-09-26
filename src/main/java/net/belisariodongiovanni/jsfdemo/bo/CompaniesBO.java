package net.belisariodongiovanni.jsfdemo.bo;

import net.belisariodongiovanni.jsfdemo.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static net.belisariodongiovanni.jsfdemo.bo.connection.PooledConnection.getConnection;

public class CompaniesBO {

    public List<Company> findAllCompanies() {
        List<Company> companiesList = new ArrayList<Company>();
        Connection conn = null;
        Statement stmt = null;
        String sql;

        //STEP 2: Register JDBC driver
        try {
            //Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);//getConnection(DB_URL,USER,PASS);
            conn = getConnection();
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            sql = "SELECT * FROM COMPANIES";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 6: Extract data from result set

            while (rs.next()) {
                Company currentCompany = new Company();
                //Retrieve by column name

                currentCompany.setId(rs.getLong("ID"));
                currentCompany.setName(rs.getString("NAME"));

                //Display values
                //System.out.println(currentCompany.getName());
                companiesList.add(currentCompany);
            }

            //STEP 7: Clean-up environment
            rs.close();

            stmt.close();
            //conn.close();
            return companiesList;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
