package Functionalities;

import ROLE.Role;

import java.sql.*;

public class GetFunctionalities {



        public Functions getFunc() throws SQLException
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
           Functions s = null;

            try {
                addConn = DriverManager.getConnection(url);
                System.out.println("connected to the data base : " + addConn.getCatalog());
                //getting customer data from getCustomer function
                statement = addConn.createStatement();
                ResultSet rs ;

                s = new Functions();

                String getOrderSize = "select count(*) from S_ORDER ";
                int orderSize = 0 , j=0;

                rs = statement.executeQuery(getOrderSize);
                while (rs.next()) {
                    s.totalOrders = rs.getInt(1);
                }

                String getEmpInfo_query = "select sum(S_ORDER.QUANTITY * SERVICE.singlePrice ) from S_ORDER,SERVICE where SERVICE.ID = S_ORDER.SERVICEID";
                rs = statement.executeQuery(getEmpInfo_query);

                while (rs.next()) {


                    s.totRevenue = rs.getDouble(1);

                }
                 getEmpInfo_query = "select top 1 count(serviceid) as sid_count , s_order.serviceid , service.name from S_order inner join SERVICE on SERVICE.ID = S_ORDER.SERVICEID group by s_order.serviceid , service.name order by sid_count desc";
                rs = statement.executeQuery(getEmpInfo_query);

                while (rs.next()) {
                    s.topOrder = rs.getString(3);
                }

                getEmpInfo_query = " select top 1 count(employeeid) as top_Emp , employeeid, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME from S_ORDER,EMPLOYEE\n" +
                        " where s_order.employeeid = EMPLOYEE.ID\n" +
                        " group by EMPLOYEEId, EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME\n" +
                        " order by top_Emp desc";
                rs = statement.executeQuery(getEmpInfo_query);

                while (rs.next()) {
                    s.topCashier = rs.getString(3);
                    s.topCashier= s.topCashier.concat("-");
                    s.topCashier =s.topCashier.concat( rs.getString(4) );
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
