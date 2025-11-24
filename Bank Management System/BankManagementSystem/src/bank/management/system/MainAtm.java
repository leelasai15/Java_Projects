package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainAtm extends JFrame implements ActionListener {
    JLabel main;
    JButton deposit,fastCash,pinChange,cashWithdraw,miniStatement,balanceEnquiry,exit;
    String pin;
    MainAtm(String pin){

        this.pin = pin;
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        main = new JLabel("Please Select Your Transaction");
        main.setFont(new Font("AvantGrade", Font.BOLD, 18));
        main.setForeground(Color.WHITE);
        main.setBounds(470, 40, 400, 350);
        jImage1.add(main);

        deposit = new JButton("DEPOSIT");
        deposit. setForeground (Color.BLACK);
        deposit.setFont(new Font("AvantGrade", Font.BOLD, 14));
        deposit. setBackground(new Color ( 65,  125, 128)) ;
        deposit.setBounds (410, 274, 150, 35);
        deposit.addActionListener(this);
        jImage1.add(deposit);

        fastCash = new JButton("FAST CASH");
        fastCash. setForeground (Color.BLACK);
        fastCash.setFont(new Font("AvantGrade", Font.BOLD, 14));
        fastCash. setBackground(new Color ( 65,  125, 128)) ;
        fastCash.setBounds (410, 314, 150, 35);
        fastCash.addActionListener(this);
        jImage1.add(fastCash);

        pinChange = new JButton("PIN CHANGE");
        pinChange. setForeground (Color.BLACK);
        pinChange.setFont(new Font("AvantGrade", Font.BOLD, 14));
        pinChange. setBackground(new Color ( 65,  125, 128)) ;
        pinChange.setBounds (410, 354, 150, 35);
        pinChange.addActionListener(this);
        jImage1.add(pinChange);

        cashWithdraw = new JButton("CASH WITHDRAW");
        cashWithdraw. setForeground (Color.BLACK);
        cashWithdraw.setFont(new Font("AvantGrade", Font.BOLD, 14));
        cashWithdraw. setBackground(new Color ( 65,  125, 128)) ;
        cashWithdraw.setBounds (700, 264, 150, 35);
        cashWithdraw.addActionListener(this);
        jImage1.add(cashWithdraw);

        miniStatement = new JButton("MINI STATEMENT");
        miniStatement. setForeground (Color.BLACK);
        miniStatement.setFont(new Font("AvantGrade", Font.BOLD, 14));
        miniStatement. setBackground(new Color ( 65,  125, 128)) ;
        miniStatement.setBounds (700, 304, 150, 35);
        miniStatement.addActionListener(this);
        jImage1.add(miniStatement);

        pinChange = new JButton("PIN CHANGE");
        pinChange. setForeground (Color.BLACK);
        pinChange.setFont(new Font("AvantGrade", Font.BOLD, 14));
        pinChange. setBackground(new Color ( 65,  125, 128)) ;
        pinChange.setBounds (700, 344, 150, 35);
        pinChange.addActionListener(this);
        jImage1.add(pinChange);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry. setForeground (Color.BLACK);
        balanceEnquiry.setFont(new Font("AvantGrade", Font.BOLD, 14));
        balanceEnquiry. setBackground(new Color ( 65,  125, 128)) ;
        balanceEnquiry.setBounds (700, 384, 150, 35);
        balanceEnquiry.addActionListener(this);
        jImage1.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit. setForeground (Color.BLACK);
        exit.setFont(new Font("AvantGrade", Font.BOLD, 14));
        exit. setBackground(new Color ( 65,  125, 128)) ;
        exit.setBounds (550, 424, 150, 35);
        exit.addActionListener(this);
        jImage1.add(exit);

        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == deposit){
                new Deposit(pin);
                setVisible(false);
            }
            else if(e.getSource() == fastCash){
                new FastCash(pin);
                setVisible(false);

            }else if(e.getSource() == pinChange){
                new PinChange(pin);
                setVisible(false);

            }else if(e.getSource() == cashWithdraw){
                new Withdrawal(pin);
                setVisible(false);

            }else if(e.getSource() == miniStatement){
                new MiniStatement(pin);
                setVisible(false);

            }else if(e.getSource() == balanceEnquiry){
                new BalanceEnquiry(pin);
                setVisible(false);

            }else if(e.getSource() == exit){
                System.exit(0);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new MainAtm("");
    }
}
