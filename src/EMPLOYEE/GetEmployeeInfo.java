package EMPLOYEE;

import java.sql.*;

public class GetEmployeeInfo {


        public Employee getEmployeeInfo(int empId) throws SQLException {
            Employee emp = new Employee();
            try {
                DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

            Connection addConn = null;
            Statement statement ;
            ResultSet rs = null;
            try {
                addConn = DriverManager.getConnection(url);
                System.out.println("connected to the data base : " + addConn.getCatalog());
                //getting customer data from getCustomer function
                System.out.println("ID is " + empId);
                String getEmpInfo_query = "select firstname, lastname, GENDER, age, contrat_type, role_id from employee where id = " + String.valueOf(empId);
                statement = addConn.createStatement();
                rs = statement.executeQuery(getEmpInfo_query);

                while (rs.next()) {

                    emp.firstName = rs.getString("firstName");
                    emp.lastName = rs.getString("lastName");
                    emp.gender = rs.getString("gender");
                    emp.age = rs.getInt("age");
                    emp.contratType = rs.getString("contrat_type");
                    emp.roleId = rs.getInt("role_id");

                }

                System.out.println(getEmpInfo_query);

                String getEmpRoleInfo_query = "select  salary, POSITION from role where id = " + String.valueOf(emp.roleId);

                statement = addConn.createStatement();
                rs = statement.executeQuery(getEmpRoleInfo_query);

                while (rs.next()) {
                    emp.salary = rs.getInt("salary");
                    emp.position = rs.getString("position");

                }




                    emp.id = empId;

            } catch (SQLException e) {
                System.out.println("Error in connection to the data base !!!");
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        System.out.println("cannot close the connection to the data base:due to the result statment");
                    }
                }

                if (addConn != null) {
                    try {
                        addConn.close();
                    } catch (SQLException e) {
                        System.out.println("cannot close the connection to the data base");
                    }
                }
                assert addConn != null;
                if (addConn.isClosed())
                    System.out.println("successfully closed the connection");
                else
                    System.out.println("connection not closed");

            }
          return emp;
        }


    public Employee[][] GetEmployees() throws SQLException
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
        Employee emp[][] = null;
        try {
            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function
            statement = addConn.createStatement();
            ResultSet rs ;



            String getOrderSize = "select count(*) from employee ";
            int orderSize = 0 , j=0;

            rs = statement.executeQuery(getOrderSize);
            while (rs.next()) {
                orderSize = rs.getInt(1);
            }

            emp = new Employee[orderSize][1];
            for (int i = 0 ; i < orderSize ; i++)
            {
                for(int k = 0 ; k<1 ; k++)
                    emp[i][k] = new Employee();
            }
            String getEmpInfo_query = "select * from employee  ";
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {

                emp[j][0].firstName = rs.getString("firstName");
                emp[j][0].id = rs.getInt("id");
                emp[j][0].lastName = rs.getString("lastName");
                emp[j][0].gender = rs.getString("gender");
                emp[j][0].age = rs.getInt("age");
                emp[j][0].date = rs.getString("date_Of_Employment");
                emp[j][0].roleId = rs.getInt("role_Id");
                emp[j][0].contratType = rs.getString("contrat_type");

                j+=1;

            }

        for(int i=0 ; i<orderSize ; i++) {
            getEmpInfo_query = "select * from Role  where  id =" + String.valueOf(emp[i][0].roleId);
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {

                emp[i][0].position = rs.getString("position");
                emp[i][0].salary = rs.getInt("salary");

            }
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
        return emp;
    }



        public boolean getEmployeeInfo(Employee emp,int empId) throws SQLException {
         boolean success=false;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";

        Connection addConn = null;
        Statement statement ;
        ResultSet rs = null;
        try {
            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());

            String getEmpInfo_query = "select count(*) from employee where id=" + empId;
            statement = addConn.createStatement();
            rs = statement.executeQuery(getEmpInfo_query);
int num = 0;
            while (rs.next()) {
                num = rs.getInt(1);
            }


if(num==1) {
    //getting customer data from getCustomer function
    getEmpInfo_query = "select * from employee where id = " + String.valueOf(empId);
    statement = addConn.createStatement();
    rs = statement.executeQuery(getEmpInfo_query);
String date = "no date";
    while (rs.next()) {

        emp.firstName = rs.getString("firstName");
        emp.lastName = rs.getString("lastName");
        emp.gender = rs.getString("gender");
        emp.age = rs.getInt("age");
        emp.contratType = rs.getString("contrat_type");
        emp.roleId = rs.getInt("role_id");
        emp.date = String.valueOf(rs.getDate("date_of_employment"));

    }

    System.out.println(getEmpInfo_query );

    String getEmpRoleInfo_query = "select  salary, POSITION from role where id = " + String.valueOf(emp.roleId);

    statement = addConn.createStatement();
    rs = statement.executeQuery(getEmpRoleInfo_query);

    while (rs.next()) {
        emp.salary = rs.getInt("salary");
        emp.position = rs.getString("position");

    }

    emp.id = empId;
    success = true;
}
        }
        catch (SQLException e) {
            System.out.println("Error in connection to the data base !!!");
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base:due to the result statment");
                }
            }

            if (addConn != null) {
                try {
                    addConn.close();
                } catch (SQLException e) {
                    System.out.println("cannot close the connection to the data base");
                }
            }
            assert addConn != null;
            if (addConn.isClosed())
                System.out.println("successfully closed the connection");
            else
                System.out.println("connection not closed");

        }
        return success;
    }



}
