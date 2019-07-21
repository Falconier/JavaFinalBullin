package gui;

import extensions.DBConx;
import models.Coffee;
import models.Customer;
import models.Order;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import java.awt.GridBagLayout;
import java.awt.Toolkit;

import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class DisplayInfo extends JFrame {

    private String lookupEntry = "";

    private JList list;

    public DisplayInfo(String state, DBConx conx) {

        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenDimensions.width - 200;
        int height = screenDimensions.height - 200;
        setResizable(false);
        setSize(width, height);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        Component horizontalStrut = Box.createHorizontalStrut(50);
        getContentPane().add(horizontalStrut, BorderLayout.WEST);

        Component horizontalStrut_1 = Box.createHorizontalStrut(50);
        getContentPane().add(horizontalStrut_1, BorderLayout.EAST);

        Component verticalStrut = Box.createVerticalStrut(50);
        getContentPane().add(verticalStrut, BorderLayout.NORTH);

        Component verticalStrut_1 = Box.createVerticalStrut(50);
        getContentPane().add(verticalStrut_1, BorderLayout.SOUTH);


        if (state.equalsIgnoreCase("coffee")) {
            setTitle("The Coffee Made Us Do It - Coffee List");
            String[] listEntries = new String[conx.CoffeeList.size()];
            for (int i = 0; i < conx.CoffeeList.size(); i++) {
                listEntries[i] = conx.CoffeeList.get(i).toString();
            }
            list = new JList(listEntries);
        } else if (state.equalsIgnoreCase("customers")) {
            setTitle("The Coffee Made Us Do It - Customer List");
            String[] listEntries = new String[conx.CustomerList.size()];
            for (int i = 0; i < conx.CustomerList.size(); i++) {
                listEntries[i] = conx.CustomerList.get(i).toString();
            }
            list = new JList(listEntries);
        } else if (state.equalsIgnoreCase("orders")) {
            setTitle("The Coffee Made Us Do It - Orders List");
            String[] listChoices = {"First and Last Name", "ID"};
            String choice = (String) JOptionPane.showInputDialog(list, "Select Lookup Type", "Customer Look-Up", JOptionPane.PLAIN_MESSAGE, null, listChoices, listChoices[1]);
//			System.out.println(choice);
            if (choice.equalsIgnoreCase(listChoices[0])) {
                String fNameEntry = JOptionPane.showInputDialog("Enter Customers First Name:");
                String lNameEntry = JOptionPane.showInputDialog("Enter Customers Last Name:");
            }else
            {
                int customerID = Integer.parseInt(JOptionPane.showInputDialog("Enter Customer ID Number:"));
                ArrayList<Order> searchedOrders = new ArrayList<Order>();
                for (int i = 0; i<conx.OrderList.size();i++)
                {
                    if(conx.OrderList.get(i).getCustomerID() == customerID) {
                        searchedOrders.add(conx.OrderList.get(i));
                    }
                }

                String[] listEntries = new String[searchedOrders.size()];
                for (int i = 0; i < searchedOrders.size(); i++) {
                    Order tempOrder = searchedOrders.get(i);
                    Customer tempCustomer = null;
                    Coffee tempCoffee = null;
                    for (int j = 0; j < conx.CustomerList.size(); j++) {
                        if(conx.CustomerList.get(j).getID() == tempOrder.getCustomerID())
                        {
                            tempCustomer = conx.CustomerList.get(j);
                            break;
                        }
                    }
                    for (int j = 0; j<conx.CoffeeList.size();j++)
                    {
                        if(conx.CoffeeList.get(j).getID() == tempOrder.getCoffeeID())
                        {
                            tempCoffee = conx.CoffeeList.get(j);
                            break;
                        }
                    }
                    listEntries[i] = "" + tempOrder.getID() + ", " + tempCustomer.getFullName() + ", " + tempCoffee.getName() + ", " + tempOrder.getQuantity() + ", " + tempOrder.getTotal();
                }
                list = new JList(listEntries);

            }
        } else {
            setTitle("The Coffee Made Us Do It");
        }

        getContentPane().add(list, BorderLayout.CENTER);
        setVisible(true);
    }

//	public static void main(String[] args)
//		{
//			DisplayInfo window = new DisplayInfo("orders");
//
//		}

}
