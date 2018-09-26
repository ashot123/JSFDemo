package net.belisariodongiovanni.jsfdemo.bo;

import net.belisariodongiovanni.jsfdemo.model.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompaniesBO {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jsfdemo?useSSL=false";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "r00t";

    public List<Company> findAllCompanies() {
        List<Company> companiesList = new ArrayList<Company>();
        Connection conn = null;
        Statement stmt = null;
        String sql;
        String result;

        //STEP 2: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);//getConnection(DB_URL,USER,PASS);

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
            conn.close();
            return companiesList;

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error reading COMPANIES table!!");
            return null;
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

    }

}
