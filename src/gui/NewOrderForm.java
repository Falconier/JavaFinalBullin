package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import extensions.DBConx;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewOrderForm extends JFrame {
    private JTextField txtQuantity;

    public NewOrderForm(DBConx conx) {
        setTitle("The Coffee Made Us Do It -- New Order");
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenDimensions.width - 200;
        int height = screenDimensions.height - 200;
        setResizable(false);
        setSize(width, height);

        Component horizontalStrut = Box.createHorizontalStrut(250);
        getContentPane().add(horizontalStrut, BorderLayout.WEST);

        Component horizontalStrut_1 = Box.createHorizontalStrut(250);
        getContentPane().add(horizontalStrut_1, BorderLayout.EAST);

        Component verticalStrut = Box.createVerticalStrut(150);
        getContentPane().add(verticalStrut, BorderLayout.NORTH);

        Component verticalStrut_1 = Box.createVerticalStrut(150);
        getContentPane().add(verticalStrut_1, BorderLayout.SOUTH);

        JPanel formPnl = new JPanel();
        getContentPane().add(formPnl, BorderLayout.CENTER);
        SpringLayout sl_formPnl = new SpringLayout();
        formPnl.setLayout(sl_formPnl);

        JLabel lblCustomerName = new JLabel("Customer Name:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblCustomerName, 49, SpringLayout.NORTH, formPnl);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblCustomerName, 92, SpringLayout.WEST, formPnl);
        formPnl.add(lblCustomerName);


        String[] nameEntries = new String[conx.CustomerList.size()];
        for (int i = 0; i < conx.CustomerList.size(); i++) {
            nameEntries[i] = conx.CustomerList.get(i).getFullName();
        }
        JComboBox cBoxName = new JComboBox(nameEntries);
        sl_formPnl.putConstraint(SpringLayout.NORTH, cBoxName, 6, SpringLayout.SOUTH, lblCustomerName);
        sl_formPnl.putConstraint(SpringLayout.WEST, cBoxName, 92, SpringLayout.WEST, formPnl);
        sl_formPnl.putConstraint(SpringLayout.EAST, cBoxName, 267, SpringLayout.WEST, formPnl);
        formPnl.add(cBoxName);

        JLabel lblCoffeeType = new JLabel("Coffee Type:");
        sl_formPnl.putConstraint(SpringLayout.WEST, lblCoffeeType, 191, SpringLayout.EAST, lblCustomerName);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, lblCoffeeType, 0, SpringLayout.SOUTH, lblCustomerName);
        formPnl.add(lblCoffeeType);

        String[] coffeeEntries = new String[conx.CoffeeList.size()];
        for (int i = 0; i < conx.CoffeeList.size(); i++) {

            coffeeEntries[i] = conx.CoffeeList.get(i).getName() + "; Avail: " + conx.CoffeeList.get(i).getQuantity();
        }
        JComboBox cBoxCoffee = new JComboBox(coffeeEntries);

        sl_formPnl.putConstraint(SpringLayout.NORTH, cBoxCoffee, 6, SpringLayout.SOUTH, lblCoffeeType);
        sl_formPnl.putConstraint(SpringLayout.WEST, cBoxCoffee, 113, SpringLayout.EAST, cBoxName);
        sl_formPnl.putConstraint(SpringLayout.EAST, cBoxCoffee, 363, SpringLayout.EAST, cBoxName);
        formPnl.add(cBoxCoffee);

        JLabel lblQuantity = new JLabel("Quantity:");
        sl_formPnl.putConstraint(SpringLayout.WEST, lblQuantity, 214, SpringLayout.EAST, lblCoffeeType);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, lblQuantity, 0, SpringLayout.SOUTH, lblCustomerName);
        formPnl.add(lblQuantity);

        txtQuantity = new JTextField();
        
        txtQuantity.setText("1");

        sl_formPnl.putConstraint(SpringLayout.WEST, txtQuantity, 0, SpringLayout.WEST, lblQuantity);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, txtQuantity, 0, SpringLayout.SOUTH, cBoxName);
        formPnl.add(txtQuantity);
        txtQuantity.setColumns(10);

        JLabel lblTotal = new JLabel("Total:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblTotal, 0, SpringLayout.NORTH, lblCustomerName);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblTotal, 118, SpringLayout.EAST, lblQuantity);
        formPnl.add(lblTotal);

        JLabel lblOutputTotal = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblOutputTotal, 6, SpringLayout.SOUTH, lblTotal);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblOutputTotal, 54, SpringLayout.EAST, txtQuantity);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, lblOutputTotal, 0, SpringLayout.SOUTH, cBoxName);
        sl_formPnl.putConstraint(SpringLayout.EAST, lblOutputTotal, 164, SpringLayout.EAST, txtQuantity);
        formPnl.add(lblOutputTotal);

        JButton btnPlaceOrder = new JButton("Place Order");

        sl_formPnl.putConstraint(SpringLayout.WEST, btnPlaceOrder, 483, SpringLayout.WEST, formPnl);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, btnPlaceOrder, -129, SpringLayout.SOUTH, formPnl);
        formPnl.add(btnPlaceOrder);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			dispose();
        	}
        });
        sl_formPnl.putConstraint(SpringLayout.SOUTH, btnCancel, 0, SpringLayout.SOUTH, btnPlaceOrder);
        sl_formPnl.putConstraint(SpringLayout.EAST, btnCancel, 0, SpringLayout.EAST, lblQuantity);
        formPnl.add(btnCancel);

        //ActionListners and Actions
        cBoxCoffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double selectedCoffeeCost = conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getPrice();
                double quantityToOrder = Double.parseDouble((txtQuantity.getText().toString().isEmpty() ? "0.00" : txtQuantity.getText().toString()));
                if (quantityToOrder > conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity()) {
                }
                double subTotal = selectedCoffeeCost * quantityToOrder;
                lblOutputTotal.setText("" + subTotal);
            }
        });

        txtQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double selectedCoffeeCost = conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getPrice();
                double quantityToOrder = Double.parseDouble((txtQuantity.getText().toString().isEmpty() ? "0.00" : txtQuantity.getText().toString()));
                if (quantityToOrder > conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity()) {
                    JOptionPane.showMessageDialog(rootPane,"There are only " + conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity() + " available.");
                }
                double subTotal = selectedCoffeeCost * quantityToOrder;
                lblOutputTotal.setText("" + subTotal);
            }
        });
        
//        txtQuantity.addKeyListener(new KeyAdapter() {
//            	@Override
//            	public void keyTyped(KeyEvent arg0) {
//            			double selectedCoffeeCost = conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getPrice();
//                        double quantityToOrder = Double.parseDouble((txtQuantity.getText().toString().isEmpty() ? "0.00" : txtQuantity.getText().toString()));
//                        if (quantityToOrder > conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity()) {
//                        }
//                        double subTotal = selectedCoffeeCost * quantityToOrder;
//                        lblOutputTotal.setText("" + subTotal);
//            	}
//            });

        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//                System.out.println(("insert into Orders (CustomerID, CoffeeID, QuantityOrdered, Total) values (" + conx.CustomerList.get(cBoxName.getSelectedIndex()).getID() + ", " + conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getID() + ", " + Double.parseDouble(txtQuantity.getText().toString()) + ", " + Double.parseDouble(lblOutputTotal.getText().toString()) + ");"));
                double selectedCoffeeCost = conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getPrice();
                double quantityToOrder = Double.parseDouble((txtQuantity.getText().toString().isEmpty() ? "0.00" : txtQuantity.getText().toString()));
                if (quantityToOrder > conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity()) {
                    JOptionPane.showMessageDialog(rootPane,"There are only " + conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getQuantity() + " available.");
                }
                else
                {
                    conx.newOrder(String.valueOf(conx.CustomerList.get(cBoxName.getSelectedIndex()).getID()),String.valueOf(conx.CoffeeList.get(cBoxCoffee.getSelectedIndex()).getID()),txtQuantity.getText().toString(),String.valueOf(selectedCoffeeCost * quantityToOrder));
                    JOptionPane.showMessageDialog(rootPane,"Order Placed");
                    dispose();
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
    }
}
