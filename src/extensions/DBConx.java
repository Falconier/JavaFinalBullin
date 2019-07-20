package extensions;

//import javax.swing.*;

import jdk.nashorn.internal.runtime.ECMAException;
import models.Coffee;
import models.Customer;
import models.Order;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;

public class DBConx {


    public ArrayList<Customer> CustomerList = new ArrayList<Customer>();
    public ArrayList<Coffee> CoffeeList = new ArrayList<Coffee>();
    public ArrayList<Order> OrderList = new ArrayList<Order>();

    private String conxURL = "jdbc:sqlite://C:/Users/jacob/eclipse-workspace/JavaFinalBullin/FinalProjectDB";
    private String pass = "c37f5b1b";
    private String user = "Falconier";

    public DBConx() {
    }

    private boolean testConx() {
        try {
            Connection conx = DriverManager.getConnection(conxURL);
            Statement statmnt = conx.createStatement();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //TODO: continue adding insert statments
    public void createDefaultTables() {
        try {
            Connection conx = DriverManager.getConnection(conxURL, user, pass);
            Statement statmnt = conx.createStatement();
            String sql = "drop table if exists Customer";
            statmnt.execute(sql);
            sql = "create table if not exists Customer (ID integer primary key, FirstName long varchar, LastName long varchar, Address long varchar, City long varchar, State varchar(2), ZIP integer, Phone varchar(10), EMail long varchar, CreditLimit double)";
            statmnt.execute(sql);
//            conx.commit();
            sql = "create table if not exists Coffee (ID integer primary key , CoffeeName long varchar, Description long varchar, Price double, QuantityAvailable integer)";
            statmnt.execute(sql);
//            conx.commit();
            sql = "create table if not exists Orders (ID integer primary key , CustomerID integer references Customer, CoffeeID integer references Coffee, QuantityOrdered double, Total double)";
            statmnt.execute(sql);
//            conx.commit();
            statmnt.execute(sql);
            sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('Jane', 'Doe', '4321 Nowhere St', 'Nowhere', 'OK', 54321, '0987654321', 'janedoe@email.com', 15.00)";
            statmnt.execute(sql);
            sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('John', 'Doe', '4321 Nowhere St', 'Nowhere', 'OK', 54321, '1237899904', 'johndoe@email.com', 5.00)";
            statmnt.execute(sql);
            sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('John', 'Smith', '1234 Nowhere St', 'Somewhere', 'OK', 12345, '1234567890', 'johnsmith@email.com', 20.00)";
            statmnt.execute(sql);
            sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('Tom', 'Long', '451 Anywhere St', 'Thatplace', 'WI', 45678, '4560982345', 'tomlong@email.com', 35.00)";
            statmnt.execute(sql);
            sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('Jacob', 'Bullin', '978 Tangent Rd', 'Shelby', 'NC', 20751, '1238904567', 'jacobbullin@email.com', 105.00)";
            statmnt.execute(sql);
//            conx.commit();
            sql = "drop table if exists Coffee";
            statmnt.execute(sql);
//            conx.commit();
            sql = "create table if not exists Coffee (ID integer primary key , CoffeeName long varchar, Description long varchar, Price double, QuantityAvailable integer)";
            statmnt.execute(sql);
            sql = "insert into Coffee (CoffeeName, Description, Price, QuantityAvailable) VALUES ('Mother Earth Blend','Medium Roast, Smooth and Balanced',2.43,30)";
            statmnt.execute(sql);
            sql = "insert into Coffee (CoffeeName, Description, Price, QuantityAvailable) VALUES ('Other Worldly Blend','Blonde Roast, Mello and Soft',2.75,25)";
            statmnt.execute(sql);
            sql = "insert into Coffee (CoffeeName, Description, Price, QuantityAvailable) VALUES ('Mt. Everest','Dark Roast, Earthy and Herbal Notes',2.66,10)";
            statmnt.execute(sql);
            sql = "insert into Coffee (CoffeeName, Description, Price, QuantityAvailable) VALUES ('Walking On Sunshine','Medium Roast, Bright and Sweet',3.15,12)";
            statmnt.execute(sql);
            sql = "insert into Coffee (CoffeeName, Description, Price, QuantityAvailable) VALUES ('Deep Dark Love','Dark Roast, Rich and Caramelly Notes',2.27,22)";
            statmnt.execute(sql);
//            conx.commit();


            //SideLoad
            this.sideLoad();


//            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            return false;
        }
    }

    protected void sideLoad() {
        ResultSet resultsOfQuery = null;
        try {
            CustomerList.clear();
            CoffeeList.clear();
            OrderList.clear();
            Connection conx = DriverManager.getConnection(conxURL, user, pass);
            Statement statmnt = conx.createStatement();
            String sql = "select * from Customer";
            resultsOfQuery = statmnt.executeQuery(sql);
            ResultSetMetaData meta = resultsOfQuery.getMetaData();
            int numOfCol = meta.getColumnCount();
            int i = 1;
            while (resultsOfQuery.next()) {
                Customer newCustomer = new Customer(resultsOfQuery.getObject(1).toString(), resultsOfQuery.getObject(2).toString(), resultsOfQuery.getObject(3).toString(), resultsOfQuery.getObject(4).toString(), resultsOfQuery.getObject(5).toString(), resultsOfQuery.getObject(6).toString(), resultsOfQuery.getObject(7).toString(), resultsOfQuery.getObject(8).toString(), resultsOfQuery.getObject(9).toString(), resultsOfQuery.getObject(10).toString());
                CustomerList.add(newCustomer);
//                    System.out.println(newCustomer.toString());
            }
            sql = "select * from Coffee";
            resultsOfQuery = statmnt.executeQuery(sql);
            meta = resultsOfQuery.getMetaData();
            numOfCol = meta.getColumnCount();
            i = 1;
            while (resultsOfQuery.next()) {
                Coffee newCoffee = new Coffee(resultsOfQuery.getObject(1).toString(), resultsOfQuery.getObject(2).toString(), resultsOfQuery.getObject(3).toString(), resultsOfQuery.getObject(4).toString(), resultsOfQuery.getObject(5).toString());
                CoffeeList.add(newCoffee);
//                    System.out.println(newCustomer.toString());
            }
        } catch (Exception e) {

        }

    }

    public void newCustomer(String fName, String lName, String address, String city, String state, String zip, String phone, String email) {
        String id = String.valueOf(CustomerList.get(CustomerList.size() - 1).getID() + 1);
        Customer newCustomer = new Customer(id, fName, lName, address, city, state, zip, phone, email, String.valueOf(200.00));
        try {
            Connection conx = DriverManager.getConnection(conxURL, user, pass);
            Statement statmnt = conx.createStatement();
            String sql = "INSERT INTO Customer (\"FirstName\", \"LastName\", \"Address\", \"City\", \"State\", \"ZIP\", \"Phone\", \"EMail\", \"CreditLimit\") VALUES ('" + fName + "', '" + lName + "', '" + address + "', '" + city + "', '" + state + "', " + zip + ", '" + phone + "', '" + email + "', 200.00)";
            if (!statmnt.execute(sql)) {
                CustomerList.add(newCustomer);
            } else {
                System.out.println("Failed to insert new customer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        DBConx conx = new DBConx();
        conx.createDefaultTables();
        for (int i = 0; i < conx.CustomerList.size(); i++) {
            System.out.println(conx.CustomerList.get(i).toString());
        }
    }


}
