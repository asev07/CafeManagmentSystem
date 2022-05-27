package ROLE;

import EMPLOYEE.Employee;
import Order.Order;

import java.sql.*;

public class GetRole {
    public String[] GetPosition() throws SQLException
    {
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        Connection addConn = null;
        Statement statement = null;
        PreparedStatement pS = null;
        Role r[] = null;
        String[] s = null;

        try {
            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function
            statement = addConn.createStatement();
            ResultSet rs ;



            String getOrderSize = "select count(*) from Role ";
            int orderSize = 0 , j=0;

            rs = statement.executeQuery(getOrderSize);
            while (rs.next()) {
                orderSize = rs.getInt(1);
            }
            s = new String[orderSize];
            String getEmpInfo_query = "select position from role ";
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {


                s[j] = rs.getString("position");

                j+=1;

            }
            for (String o : s) {

                System.out.println(o);
            }


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
        return s;
    }



}
