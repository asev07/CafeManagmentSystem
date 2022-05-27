package EMPLOYEE;

import java.sql.*;

public class UpdateEmployee {
    public boolean updateEmployee( Employee c ) throws SQLException {
        boolean success=false;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        Connection addConn = null;
        Statement statement = null;
        PreparedStatement pS = null;
        try {

            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function

            String add_query = "update employee set   firstname=?, lastname=?, age=?, contrat_Type=?, role_Id=?,gender=?,password=?,date_of_employment=? where id = ?";

            statement = addConn.createStatement();
            pS = addConn.prepareStatement(add_query);
            pS.setString(1, c.firstName);
            pS.setString(2, c.lastName);
            pS.setInt(3, c.age);
            pS.setString(4, c.contratType);
            pS.setInt(5, c.roleId);
            pS.setString(6,c.gender);
            pS.setString(7,c.password);
            pS.setString(8,c.date);
            pS.setInt(9,c.id);

            pS.executeUpdate();
            System.out.println("Add successfull");
            success=false;
            addConn.close();

        } catch (SQLException e) {
            System.out.println("Error in connection to the data base !!!");
            e.printStackTrace();
        } finally {
            if (pS != null) {
                try {
                    pS.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base:due to the prepared statment");
                }
            }

            if (addConn != null) {
                try {
                    addConn.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base");
                }
            }
            if (addConn.isClosed())
                System.out.println("successfully closed the connection");
            else
                System.out.println("connection not closed");

        }
        return success;
    }
}
