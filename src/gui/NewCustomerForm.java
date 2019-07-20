package gui;

import extensions.DBConx;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCustomerForm extends JFrame {
    private JTextField txtFristName;
    private JTextField txtLastName;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtState;
    private JTextField txtZIP;
    private JTextField txtPhone;
    private JTextField txtEmail;

    private JLabel fNameError;
    private JLabel lNameError;
    private JLabel addressError;
    private JLabel cityStateError;
    private JLabel zipError;
    private JLabel emailError;
    private JLabel phoneError;


    public NewCustomerForm(DBConx conx) {
        setTitle("The Coffee Made Us Do It -- New Customer");
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

        JLabel lblFirstName = new JLabel("First Name: ");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblFirstName, 53, SpringLayout.NORTH, formPnl);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblFirstName, 66, SpringLayout.WEST, formPnl);
        formPnl.add(lblFirstName);

        txtFristName = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtFristName, 6, SpringLayout.SOUTH, lblFirstName);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtFristName, 66, SpringLayout.WEST, formPnl);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtFristName, 329, SpringLayout.WEST, formPnl);
        formPnl.add(txtFristName);
        txtFristName.setColumns(10);

        JLabel lblLastName = new JLabel("Last Name: ");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblLastName, 23, SpringLayout.SOUTH, txtFristName);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(lblLastName);

        txtLastName = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtLastName, 6, SpringLayout.SOUTH, lblLastName);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtLastName, 0, SpringLayout.WEST, lblFirstName);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtLastName, 0, SpringLayout.EAST, txtFristName);
        formPnl.add(txtLastName);
        txtLastName.setColumns(10);

        JLabel lblAddress = new JLabel("Address: ");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblAddress, 34, SpringLayout.SOUTH, txtLastName);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblAddress, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(lblAddress);

        txtAddress = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtAddress, 6, SpringLayout.SOUTH, lblAddress);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtAddress, 66, SpringLayout.WEST, formPnl);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtAddress, 548, SpringLayout.WEST, formPnl);
        formPnl.add(txtAddress);
        txtAddress.setColumns(10);

        JLabel lblCity = new JLabel("City:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblCity, 25, SpringLayout.SOUTH, txtAddress);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblCity, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(lblCity);

        txtCity = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtCity, 6, SpringLayout.SOUTH, lblCity);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtCity, 0, SpringLayout.WEST, lblFirstName);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtCity, 0, SpringLayout.EAST, txtAddress);
        formPnl.add(txtCity);
        txtCity.setColumns(10);

        JLabel lblState = new JLabel("State:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblState, 0, SpringLayout.NORTH, lblCity);
        sl_formPnl.putConstraint(SpringLayout.EAST, lblState, 537, SpringLayout.EAST, lblAddress);
        formPnl.add(lblState);

        txtState = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.WEST, lblState, 0, SpringLayout.WEST, txtState);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtState, 6, SpringLayout.EAST, txtCity);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, txtState, 0, SpringLayout.SOUTH, txtCity);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtState, 609, SpringLayout.WEST, formPnl);
        formPnl.add(txtState);
        txtState.setColumns(10);

        JLabel lblZip = new JLabel("ZIP:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblZip, 27, SpringLayout.SOUTH, txtCity);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblZip, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(lblZip);

        txtZIP = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtZIP, 6, SpringLayout.SOUTH, lblZip);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtZIP, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(txtZIP);
        txtZIP.setColumns(10);

        JLabel lblPhoneNumber = new JLabel("Phone Number:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblPhoneNumber, 0, SpringLayout.NORTH, lblZip);
        formPnl.add(lblPhoneNumber);

        txtPhone = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.WEST, lblPhoneNumber, 0, SpringLayout.WEST, txtPhone);
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtPhone, 0, SpringLayout.NORTH, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtPhone, -687, SpringLayout.EAST, formPnl);
        formPnl.add(txtPhone);
        txtPhone.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lblEmail, 30, SpringLayout.SOUTH, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.WEST, lblEmail, 0, SpringLayout.WEST, lblFirstName);
        formPnl.add(lblEmail);

        txtEmail = new JTextField();
        sl_formPnl.putConstraint(SpringLayout.NORTH, txtEmail, 6, SpringLayout.SOUTH, lblEmail);
        sl_formPnl.putConstraint(SpringLayout.WEST, txtEmail, 0, SpringLayout.WEST, lblFirstName);
        sl_formPnl.putConstraint(SpringLayout.EAST, txtEmail, 0, SpringLayout.EAST, txtAddress);
        formPnl.add(txtEmail);
        txtEmail.setColumns(10);

        JButton btnValidate = new JButton("Validate");
        btnValidate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateEntries();
            }
        });
        sl_formPnl.putConstraint(SpringLayout.WEST, btnValidate, 0, SpringLayout.WEST, lblFirstName);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, btnValidate, -31, SpringLayout.SOUTH, formPnl);
        formPnl.add(btnValidate);

        JButton btnValidateAndSave = new JButton("Validate and Save");
        btnValidateAndSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (validateEntries()) {
                    conx.newCustomer(txtFristName.getText().toString(), txtLastName.getText().toString(), txtAddress.getText().toString(), txtCity.getText().toString(), txtState.getText().toString(), txtZIP.getText().toString(), txtPhone.getText().toString(), txtEmail.getText().toString());
                    //TODO: make this close the window
                }
            }
        });
        sl_formPnl.putConstraint(SpringLayout.NORTH, btnValidateAndSave, 0, SpringLayout.NORTH, btnValidate);
        sl_formPnl.putConstraint(SpringLayout.WEST, btnValidateAndSave, 27, SpringLayout.EAST, btnValidate);
        formPnl.add(btnValidateAndSave);

        fNameError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, fNameError, 0, SpringLayout.NORTH, txtFristName);
        sl_formPnl.putConstraint(SpringLayout.WEST, fNameError, 6, SpringLayout.EAST, txtFristName);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, fNameError, 0, SpringLayout.SOUTH, txtFristName);
        sl_formPnl.putConstraint(SpringLayout.EAST, fNameError, 280, SpringLayout.EAST, txtFristName);
        formPnl.add(fNameError);

        lNameError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, lNameError, 0, SpringLayout.NORTH, txtLastName);
        sl_formPnl.putConstraint(SpringLayout.WEST, lNameError, 6, SpringLayout.EAST, txtLastName);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, lNameError, -56, SpringLayout.NORTH, txtAddress);
        sl_formPnl.putConstraint(SpringLayout.EAST, lNameError, 0, SpringLayout.EAST, txtState);
        formPnl.add(lNameError);

        addressError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, addressError, 0, SpringLayout.NORTH, txtAddress);
        sl_formPnl.putConstraint(SpringLayout.WEST, addressError, 6, SpringLayout.EAST, txtAddress);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, addressError, 0, SpringLayout.SOUTH, txtAddress);
        sl_formPnl.putConstraint(SpringLayout.EAST, addressError, 280, SpringLayout.EAST, txtAddress);
        formPnl.add(addressError);

        cityStateError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, cityStateError, 0, SpringLayout.NORTH, txtCity);
        sl_formPnl.putConstraint(SpringLayout.WEST, cityStateError, 5, SpringLayout.EAST, txtState);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, cityStateError, 0, SpringLayout.SOUTH, txtCity);
        sl_formPnl.putConstraint(SpringLayout.EAST, cityStateError, 279, SpringLayout.EAST, txtState);
        formPnl.add(cityStateError);

        zipError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.WEST, txtPhone, 6, SpringLayout.EAST, zipError);
        sl_formPnl.putConstraint(SpringLayout.NORTH, zipError, 0, SpringLayout.NORTH, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.WEST, zipError, 6, SpringLayout.EAST, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, zipError, -52, SpringLayout.NORTH, txtEmail);
        sl_formPnl.putConstraint(SpringLayout.EAST, zipError, -870, SpringLayout.EAST, formPnl);
        formPnl.add(zipError);

        emailError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, emailError, 0, SpringLayout.NORTH, txtEmail);
        sl_formPnl.putConstraint(SpringLayout.WEST, emailError, 6, SpringLayout.EAST, txtEmail);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, emailError, 0, SpringLayout.SOUTH, txtEmail);
        sl_formPnl.putConstraint(SpringLayout.EAST, emailError, 434, SpringLayout.EAST, txtEmail);
        formPnl.add(emailError);

        phoneError = new JLabel("");
        sl_formPnl.putConstraint(SpringLayout.NORTH, phoneError, 0, SpringLayout.NORTH, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.WEST, phoneError, 6, SpringLayout.EAST, txtPhone);
        sl_formPnl.putConstraint(SpringLayout.SOUTH, phoneError, 0, SpringLayout.SOUTH, txtZIP);
        sl_formPnl.putConstraint(SpringLayout.EAST, phoneError, -504, SpringLayout.EAST, formPnl);
        formPnl.add(phoneError);

        setVisible(true);

    }

    private boolean validateEntries() {
        boolean masterFlag = true;
        if (!txtFristName.getText().matches("[A-Z][a-zA-Z]*")) {
            fNameError.setText("Invalid First Name");
            masterFlag = false;
        } else
            fNameError.setText("Valid");

        if (!txtLastName.getText().matches("[a-zA-z]+(['-][a-zA-Z]+)*")) {
            lNameError.setText("Invalid Last Name");
            masterFlag = false;
        } else
            lNameError.setText("Valid");

        if (!txtAddress.getText().matches("\\d+\\s+([a-zA-Z]+|[a-zA-z]+\\s[a-zA-z]+)")) {
            addressError.setText("Invalid Address");
            masterFlag = false;
        } else
            addressError.setText("Valid");

        if (!txtCity.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z+])")) {
            cityStateError.setText("Invalid City");
            masterFlag = false;
        } else
            cityStateError.setText("Valid City");

        if (!txtState.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)")) {
            if (!cityStateError.equals("")) {
                cityStateError.setText(cityStateError.getText() + ", Invalid State");
                masterFlag = false;
            } else {
                cityStateError.setText("Invalid State");
                masterFlag = false;
            }

        } else {
            if (!cityStateError.equals("")) {
                cityStateError.setText(cityStateError.getText() + ", Valid State");
            } else
                cityStateError.setText("Valid State");
        }
        if (!txtZIP.getText().matches("\\d{5}")) {
            zipError.setText("Invalid ZIP");
            masterFlag = false;
        } else
            zipError.setText("Valid");

        if (!txtPhone.getText().matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}")) {
            phoneError.setText("Invalid Phone");
            masterFlag = false;
        } else
            phoneError.setText("Valid");
        if (!txtEmail.getText().matches("^(.+)@(.+)$")) {
            emailError.setText("Invalid Email");
            masterFlag = false;
        } else
            emailError.setText("Valid");

        return masterFlag;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
