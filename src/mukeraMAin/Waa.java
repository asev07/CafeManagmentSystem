package mukeraMAin;

import EMPLOYEE.Employee;
import EMPLOYEE.GetEmployeeInfo;
import Order.AddNewOrder;
import Order.Order;

import java.sql.SQLException;

public class Waa {

    public static void main(String[] args) throws SQLException {
        GetEmployeeInfo aa = new GetEmployeeInfo();
        Employee[][] o;
        o = aa.GetEmployees();
        int j = 0;
        for (int i = 0; i < o.length; i++) {

                System.out.println(o[i][j].firstName + "  " + o[i][j].lastName + o[i][j].id + "   " + o[i][j].position + "   " + o[i][j].salary);

        }
    }
}
