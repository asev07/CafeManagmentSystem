package mukeraMAin;

import Order.AddNewOrder;
import Order.Order;

import java.sql.SQLException;

public class Waa {

    public static void main(String[] args) throws SQLException {
        AddNewOrder aa = new AddNewOrder();
        Order o = new Order();

        o.employeeId=12345;
        o.quantity = 3;
        o.serviceId = 12;
        aa.addOrder(o);
    }
}
