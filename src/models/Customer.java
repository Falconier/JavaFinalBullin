package models;

import java.sql.Statement;

/*
-- Customer Table
create table if not exists Customer (
ID integer primary key,
FirstName long varchar,
LastName long varchar,
Address long varchar,
City long varchar,
State varchar(2),
ZIP integer,
Phone varchar(10),
EMail long varchar,
CreditLimit double);

 */
public class Customer {

    private int ID;
    private String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String State;
    private int ZIP;
    private String Phone;
    private String EMail;
    private double CreditLimit;

    public Customer(int id, String firstName, String lastName, String address, String city, String state, int zip, String phone, String email, double creditLimit) {
        ID = id;
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        City = city;
        State = state;
        ZIP = zip;
        Phone = phone;
        EMail = email;
        CreditLimit = creditLimit;
    }

    public Customer(String id, String firstName, String lastName, String address, String city, String state, String zip, String phone, String email, String creditLimit) {
        ID = Integer.parseInt(id);
        FirstName = firstName;
        LastName = lastName;
        Address = address;
        City = city;
        State = state;
        ZIP = Integer.parseInt(zip);
        Phone = phone;
        EMail = email;
        CreditLimit = Double.parseDouble(creditLimit);
    }

//    public Customer(Customer temp)
//    {
//        ID = temp.ID;
//        FirstName = temp.FirstName;
//        LastName = temp.LastName;
//        Address = temp.Address;
//        City = temp.City;
//        State = temp.State;
//        ZIP = temp.ZIP;
//        Phone = temp.Phone;
//        EMail = temp.EMail;
//        CreditLimit = temp.CreditLimit;
//    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZIP() {
        return ZIP;
    }

    public void setZIP(int ZIP) {
        this.ZIP = ZIP;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        CreditLimit = creditLimit;
    }

    public String getFullName()
    {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString() {
        String result = "" + this.getID() + ", " + this.getFirstName() + " " + this.getLastName() + ", " + this.getAddress() + ", " + this.getCity() + ", " + this.getState() + ", " + this.getZIP() + ", " + this.getPhone() + ", " + this.getEMail() + ", " + this.getCreditLimit();
        return result;
    }
}
