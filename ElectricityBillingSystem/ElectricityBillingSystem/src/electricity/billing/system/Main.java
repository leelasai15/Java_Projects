package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JMenu menu, information, user, bill, utility, exit;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4,
            informationItem1, informationItem2,
            userItem1, userItem2,
            billItem1,
            utilityItem1, utilityItem2,
            exitItem;
    String userT;

    Main(String userT){

        super("Electricity Billing System - Main Menu");
        this.userT = userT;

        ImageIcon mainBg = new ImageIcon(ClassLoader.getSystemResource("icons/ebs.png"));
        Image mainImg = mainBg.getImage().getScaledInstance(1630, 930, Image.SCALE_SMOOTH);
        ImageIcon mainIcon = new ImageIcon(mainImg);
        JLabel mainLabel = new JLabel(mainIcon);
        add(mainLabel);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        int iconSize = 20;

        menu = new JMenu("Menu");
        menu.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(menu);

        menuItem1 = new JMenuItem("New Customer");
        menuItem1.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        menuItem1.setIcon(new ImageIcon(customerImage));
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("Customer Details");
        menuItem2.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerDetImg = new ImageIcon(ClassLoader.getSystemResource("icons/customerDetails.png"));
        Image customerDetImage = customerDetImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        menuItem2.setIcon(new ImageIcon(customerDetImage));
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        menuItem3 = new JMenuItem("Deposit Details");
        menuItem3.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositDetImg = new ImageIcon(ClassLoader.getSystemResource("icons/depositdetails.png"));
        Image depostDetImage = depositDetImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        menuItem3.setIcon(new ImageIcon(depostDetImage));
        menuItem3.addActionListener(this);
        menu.add(menuItem3);

        menuItem4 = new JMenuItem("Calculate Bill");
        menuItem4.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculateBillImg = new ImageIcon(ClassLoader.getSystemResource("icons/calculatorbills.png"));
        Image calculateBillImage = calculateBillImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        menuItem4.setIcon(new ImageIcon(calculateBillImage));
        menuItem4.addActionListener(this);
        menu.add(menuItem4);

        information = new JMenu("Information");
        information.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(information);

        informationItem1 = new JMenuItem("Update Information");
        informationItem1.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon updateInfImg = new ImageIcon(ClassLoader.getSystemResource("icons/refresh.png"));
        Image updateInfImage = updateInfImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        informationItem1.setIcon(new ImageIcon(updateInfImage));
        informationItem1.addActionListener(this);
        information.add(informationItem1);

        informationItem2 = new JMenuItem("View Information");
        informationItem2.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon viewInfImg = new ImageIcon(ClassLoader.getSystemResource("icons/information.png"));
        Image viewInfImage = viewInfImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        informationItem2.setIcon(new ImageIcon(viewInfImage));
        informationItem2.addActionListener(this);
        information.add(informationItem2);

        user = new JMenu("User");
        user.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(user);

        userItem1 = new JMenuItem("Pay Bill");
        userItem1.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon payBillImg = new ImageIcon(ClassLoader.getSystemResource("icons/pay.png"));
        Image payBillImage = payBillImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        userItem1.setIcon(new ImageIcon(payBillImage));
        userItem1.addActionListener(this);
        user.add(userItem1);

        userItem2 = new JMenuItem("Bill Details");
        userItem2.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon BillDetImg = new ImageIcon(ClassLoader.getSystemResource("icons/detail.png"));
        Image BillDetImage = BillDetImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        userItem2.setIcon(new ImageIcon(BillDetImage));
        userItem2.addActionListener(this);
        user.add(userItem2);

        bill = new JMenu("Bill");
        bill.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(bill);

        billItem1 = new JMenuItem("Generate Bill");
        billItem1.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon genBillImg = new ImageIcon(ClassLoader.getSystemResource("icons/bill.png"));
        Image genBillImage = genBillImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        billItem1.setIcon(new ImageIcon(genBillImage));
        billItem1.addActionListener(this);
        bill.add(billItem1);


        utility = new JMenu("Utility");
        utility.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(utility);

        utilityItem1 = new JMenuItem("Notepad");
        utilityItem1.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        utilityItem1.setIcon(new ImageIcon(notepadImage));
        utilityItem1.addActionListener(this);
        utility.add(utilityItem1);

        utilityItem2 = new JMenuItem("Calculator");
        utilityItem2.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calImg = new ImageIcon(ClassLoader.getSystemResource("icons/calculator.png"));
        Image calImage = calImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        utilityItem2.setIcon(new ImageIcon(calImage));
        utilityItem2.addActionListener(this);
        utility.add(utilityItem2);

        exit = new JMenu("Exit");
        exit.setFont(new Font("serif" ,Font.PLAIN,15));
        menuBar.add(exit);

        exitItem = new JMenuItem("Exit");
        exitItem.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon exitImg = new ImageIcon(ClassLoader.getSystemResource("icons/exit.png"));
        Image exitImage = exitImg.getImage().getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT);
        exitItem.setIcon(new ImageIcon(exitImage));
        exitItem.addActionListener(this);
        exit.add(exitItem);

        setBounds(0, 0, 1630, 930);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String command = e.getActionCommand();

            if(e.getSource() == menuItem1){
                new NewCustomer(userT);
                setVisible(false);
            } else if(e.getSource() == menuItem2){
                new CustomerDetails();
            } else if(e.getSource() == menuItem3){
                new DepositDetails();
            } else if(e.getSource() == menuItem4){
                new CalculateBill();
            } else if(e.getSource() == informationItem1){
                new UpdateDetails("");
            } else if(e.getSource() == informationItem2){

            } else if(e.getSource() == userItem1){

            } else if(e.getSource() == userItem2){

            } else if(e.getSource() == billItem1){

            } else if(e.getSource() == utilityItem1){
                Runtime.getRuntime().exec("notepad.exe");
            } else if(e.getSource() == utilityItem2){
                Runtime.getRuntime().exec("calc.exe");
            } else if(e.getSource() == exitItem){
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Main("");
    }
}