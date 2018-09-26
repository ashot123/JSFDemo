package net.belisariodongiovanni.jsfdemo.bo;

import net.belisariodongiovanni.jsfdemo.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesBO {


    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jsfdemo?useSSL=false";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "r00t";

    public List<Employee> findAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();
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

            sql = "SELECT * FROM EMPLOYEES";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 6: Extract data from result set
            while (rs.next()) {
                Employee currentEmployee = new Employee();
                //Retrieve by column name
                currentEmployee.setId(rs.getInt("ID"));
                currentEmployee.setFirstName(rs.getString("FIRST_NAME"));
                currentEmployee.setLastName(rs.getString("LAST_NAME"));
                currentEmployee.setCompany(rs.getString("COMPANY"));
                currentEmployee.setEmplNumber(rs.getString("EMPL_NUMBER"));
                currentEmployee.setSalary(rs.getDouble("SALARY"));

                //Display values
                //System.out.println(currentEmployee);
                employeeList.add(currentEmployee);
            }
            //STEP 7: Clean-up environment
            rs.close();

            stmt.close();
            conn.close();
            return employeeList;

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error reading EMPLOYEES table!!");
            return employeeList;
        } finally {
            //f inally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try

    }

    public long insertEmployee(Employee employee) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql;

        //STEP 2: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("insertEmployee(): Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);//getConnection(DB_URL,USER,PASS);

            sql = "INSERT INTO EMPLOYEES"
                    + "(first_name, last_name, company, empl_number, salary) VALUES"
                    + "(?,?,?,?,?)";

            //STEP 4: Create a prepared statement
            System.out.println("Creating prepared statement...");
            preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getCompany());
            preparedStatement.setString(4, employee.getEmplNumber());
            preparedStatement.setDouble(5, employee.getSalary());

            // execute insert SQL statement
            Integer affectedRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();
            return 0;

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error creating row in EMPLOYEES table!!");
            return 0;
        } finally {
            //finally block used to close resources
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
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

    public void deleteEmployee(Employee employee) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        String sql;

        //STEP 2: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("deleteEmployee(): Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);//getConnection(DB_URL,USER,PASS);

            sql = "DELETE FROM EMPLOYEES WHERE ID = ?";

            //STEP 4: Create a prepared statement
            System.out.println("Creating prepared statement...");
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, employee.getId());

            // execute insert SQL statement
            Integer affectedRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error creating row in EMPLOYEES table!!");

        } finally {
            //finally block used to close resources
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
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
