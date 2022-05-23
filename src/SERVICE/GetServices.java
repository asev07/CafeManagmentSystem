package SERVICE;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;

public class GetServices {

    private Connection addConn = null;
   private Statement statement = null;
   private PreparedStatement pS = null;
   private ServiceNames ord = null;
   private   ResultSet rs ;
    public ServiceNames getServices() throws SQLException
    {
        try {
            DriverManager.registerDriver(new SQLServerDriver());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String url = "jdbc:sqlserver://DESKTOP-LPP4R31:1433;database=cafe;integratedSecurity=true;encrypt=false";


        try {
            ord = new ServiceNames();
            addConn = DriverManager.getConnection(url);
            System.out.println("connected to the data base : " + addConn.getCatalog());
            //getting customer data from getCustomer function
            statement = addConn.createStatement();


            //commands for getting the size of each drop down menus
             String food = "get_food_names";
            String drinks = "get_bottledDrinks_names";
            String desert = "get_desert_names";
            String coffee = "get_coffee_names";

            String getService = "select * from ";

            int serviceSize = 0 , j=0;

            //this function is generic to get the size of each catagory sizes
            serviceSize = getQuerySize(food);

            ord.food = new Service[serviceSize];

            for (int i = 0 ; i < serviceSize ; i++)
            {
                    ord.food[i] = new Service();
            }
            ord.arrySize= serviceSize;

            String getEmpInfo_query = getService + food;
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {
                ord.food[j].name = rs.getString("name");
                ord.food[j].id = rs.getInt("id");
                ord.food[j].singlePrice = rs.getDouble("singlePrice");
                j+=1;
    //food data collected
            }


                // getting coffee data from data base
            j = 0;
                serviceSize = getQuerySize(coffee);

            ord.coffee = new Service[serviceSize];

            for (int i = 0 ; i < serviceSize ; i++)
            {
                ord.coffee[i] = new Service();
            }
            ord.arrySize= serviceSize;

            getEmpInfo_query = getService + coffee;
            rs = statement.executeQuery(getEmpInfo_query);

            System.out.println(getEmpInfo_query + " is the info query and here i am service sixe and arry size " + serviceSize + "\t" + ord.arrySize);
            while (rs.next()) {
                ord.coffee[j].name = rs.getString("name");
                ord.coffee[j].id = rs.getInt("id");
                ord.coffee[j].singlePrice = rs.getDouble("singlePrice");
                j+=1;
            }
            //food data collected

            System.out.println();


            // getting desert data from data base
            j = 0;
            serviceSize = getQuerySize(desert);

            ord.desert = new Service[serviceSize];

            for (int i = 0 ; i < serviceSize ; i++)
            {
                ord.desert[i] = new Service();
            }
            ord.arrySize= serviceSize;

            getEmpInfo_query = getService + desert;
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {
                ord.desert[j].name = rs.getString("name");
                ord.desert[j].id = rs.getInt("id");
                ord.desert[j].singlePrice = rs.getDouble("singlePrice");
                j+=1;
                //food data collected
            }

            System.out.println("from get services class");
// getting drinks data from data base
            j = 0;
            serviceSize = getQuerySize(drinks);

            ord.drinks = new Service[serviceSize];

            for (int i = 0 ; i < serviceSize ; i++)
            {
                ord.drinks[i] = new Service();
            }
            ord.arrySize= serviceSize;

            getEmpInfo_query = getService + drinks;
            rs = statement.executeQuery(getEmpInfo_query);

            while (rs.next()) {
                ord.drinks[j].name = rs.getString("name");
                ord.drinks[j].id = rs.getInt("id");
                ord.drinks[j].singlePrice = rs.getDouble("singlePrice");
                j+=1;
                //food data collected
            }
        } catch (SQLException e) {
            System.out.println("Error in connection to the data base !!!");
            e.printStackTrace();
        } finally {

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
        return ord;
    }

    private int getQuerySize( String name )throws SQLException {
    int serviceSize = 0;
    String getServiceSize = "select count(*) from ";

    rs = statement.executeQuery(getServiceSize + name);
    while (rs.next()) {
        serviceSize = rs.getInt(1);
    }
return  serviceSize;
}
}
