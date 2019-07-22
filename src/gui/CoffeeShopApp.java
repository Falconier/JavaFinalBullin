package gui;

import extensions.DBConx;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CoffeeShopApp extends JFrame {
    public CoffeeShopApp() {

        //TODO: add paragraph to screen and move logo image

        DBConx conx = new DBConx();
        conx.createDefaultTables();

        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenDimensions.width - 200;
        int height = screenDimensions.height - 200;
        setResizable(false);
        setSize(width, height);

        setTitle("The Coffee Made Us Do It");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel pnlBtns = new JPanel();
        getContentPane().add(pnlBtns, BorderLayout.WEST);
        GridBagLayout gbl_pnlBtns = new GridBagLayout();
        gbl_pnlBtns.columnWidths = new int[]
                {0, 195, 0};
        gbl_pnlBtns.rowHeights = new int[]
                {((height - 450) / 2), 50, 50, 50, 50, 50, 50, 50, 50, 50, 90, 0};
        gbl_pnlBtns.columnWeights = new double[]
                {0.0, 0.0, Double.MIN_VALUE};
        gbl_pnlBtns.rowWeights = new double[]
                {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        pnlBtns.setLayout(gbl_pnlBtns);

        JButton btnDspCoffee = new JButton("Display Coffee");
        btnDspCoffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DisplayInfo window = new DisplayInfo("Coffee", conx);
            }
        });
        GridBagConstraints gbc_btnDspCoffee = new GridBagConstraints();
        gbc_btnDspCoffee.fill = GridBagConstraints.BOTH;
        gbc_btnDspCoffee.insets = new Insets(0, 0, 5, 0);
        gbc_btnDspCoffee.gridx = 1;
        gbc_btnDspCoffee.gridy = 1;
        pnlBtns.add(btnDspCoffee, gbc_btnDspCoffee);

        JButton btnDspCustomer = new JButton("Display Customer");
        btnDspCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DisplayInfo window = new DisplayInfo("Customers", conx);
            }
        });
        GridBagConstraints gbc_btnDspCustomer = new GridBagConstraints();
        gbc_btnDspCustomer.fill = GridBagConstraints.BOTH;
        gbc_btnDspCustomer.insets = new Insets(0, 0, 5, 0);
        gbc_btnDspCustomer.gridx = 1;
        gbc_btnDspCustomer.gridy = 3;
        pnlBtns.add(btnDspCustomer, gbc_btnDspCustomer);

        JButton btnDspOrders = new JButton("Display Orders for Customer");
        btnDspOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DisplayInfo window = new DisplayInfo("orders", conx);
            }
        });
        GridBagConstraints gbc_btnDspOrders = new GridBagConstraints();
        gbc_btnDspOrders.fill = GridBagConstraints.BOTH;
        gbc_btnDspOrders.insets = new Insets(0, 0, 5, 0);
        gbc_btnDspOrders.gridx = 1;
        gbc_btnDspOrders.gridy = 5;
        pnlBtns.add(btnDspOrders, gbc_btnDspOrders);

        JButton btnNewCustomer = new JButton("New Customer");
        btnNewCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewCustomerForm window = new NewCustomerForm(conx);
            }
        });
        GridBagConstraints gbc_btnNewCustomer = new GridBagConstraints();
        gbc_btnNewCustomer.fill = GridBagConstraints.BOTH;
        gbc_btnNewCustomer.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewCustomer.gridx = 1;
        gbc_btnNewCustomer.gridy = 7;
        pnlBtns.add(btnNewCustomer, gbc_btnNewCustomer);

        JButton btnNewOrder = new JButton("New Order");
        btnNewOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	    NewOrderForm window = new NewOrderForm(conx);
        	}
        });
        GridBagConstraints gbc_btnNewOrder = new GridBagConstraints();
        gbc_btnNewOrder.fill = GridBagConstraints.BOTH;
        gbc_btnNewOrder.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewOrder.gridx = 1;
        gbc_btnNewOrder.gridy = 9;
        pnlBtns.add(btnNewOrder, gbc_btnNewOrder);

        JPanel pnlLogo = new JPanel();
        getContentPane().add(pnlLogo, BorderLayout.CENTER);
        GridBagLayout gbl_pnlLogo = new GridBagLayout();
        gbl_pnlLogo.columnWidths = new int[]
                {201, 310, 0};
        gbl_pnlLogo.rowHeights = new int[]
                {810, 0};
        gbl_pnlLogo.columnWeights = new double[]
                {0.0, 0.0, Double.MIN_VALUE};
        gbl_pnlLogo.rowWeights = new double[]
                {0.0, Double.MIN_VALUE};
        pnlLogo.setLayout(gbl_pnlLogo);

        JLabel imgLogo = new JLabel("");
        imgLogo.setIcon(new ImageIcon(CoffeeShopApp.class.getResource("/images/CoffeeLogo 2[300].jpg")));
        GridBagConstraints gbc_imgLogo = new GridBagConstraints();
        gbc_imgLogo.fill = GridBagConstraints.BOTH;
        gbc_imgLogo.gridx = 1;
        gbc_imgLogo.gridy = 0;
        pnlLogo.add(imgLogo, gbc_imgLogo);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        getContentPane().add(panel, BorderLayout.SOUTH);

        Component horizontalGlue = Box.createHorizontalGlue();
        panel.add(horizontalGlue);

        JButton btnCreateDatabase = new JButton("Create Database");
        btnCreateDatabase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                conx.createDefaultTables();
            }
        });
        panel.add(btnCreateDatabase);

        Component horizontalStrut = Box.createHorizontalStrut(50);
        panel.add(horizontalStrut);

        JButton btnNewButton = new JButton("Reset Database");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                conx.createDefaultTables();
            }
        });
        panel.add(btnNewButton);

        Component horizontalGlue_2 = Box.createHorizontalGlue();
        panel.add(horizontalGlue_2);

        setVisible(true);
    }

    public static void main(String[] args) {
        CoffeeShopApp window = new CoffeeShopApp();
    }

}
