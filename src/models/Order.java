package models;

/*
-- Orders Table
create table if not exists Orders (
ID integer primary key ,
CustomerID integer references Customer,
CoffeeID integer references Coffee,
QuantityOrdered double,
Total double);

 */
public class Order {

    private int ID;
    private int CustomerID;
    private int CoffeeID;
    private int Quantity;
    private double Total;

    public Order(int id, int custID, int cofeID, int quantity, int total) {
        ID = id;
        CustomerID = custID;
        CoffeeID = cofeID;
        Quantity = quantity;
        Total = total;
    }

    public Order(String id, String custID, String cofeID, String quantity, String total) {
        ID = Integer.parseInt(id);
        CustomerID = Integer.parseInt(custID);
        CoffeeID = Integer.parseInt(cofeID);
        Quantity = Integer.parseInt(quantity);
        Total = Double.parseDouble(total);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getCoffeeID() {
        return CoffeeID;
    }

    public void setCoffeeID(int coffeeID) {
        CoffeeID = coffeeID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
