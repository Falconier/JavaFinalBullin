package models;

/*
-- Coffee Table
create table if not exists Coffee (
ID integer primary key ,
CoffeeName long varchar,
Description long varchar,
Price double,
QuantityAvailable integer);

 */
public class Coffee {

    private int ID;
    private String Name;
    private String Description;
    private double Price;
    private int Quantity;

    public Coffee(int id, String name, String description, double price, int quantity) {
        ID = id;
        Name = name;
        Description = description;
        Price = price;
        Quantity = quantity;
    }

    public Coffee(String id, String name, String description, String price, String quantity) {
        ID = Integer.parseInt(id);
        Name = name;
        Description = description;
        Price = Double.parseDouble(price);
        Quantity = Integer.parseInt(quantity);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    @Override
    public String toString()
    {
        String result = "" + this.getID() + ", " + this.getName() + ", " + this.getDescription() + ", " + this.getPrice() + ", " + this.getQuantity();
        return result;
    }

}
