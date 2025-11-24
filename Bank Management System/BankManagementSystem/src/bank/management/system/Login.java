package bank.management.system;

import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends  JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField textField;
    JPasswordField passwordField;
    JButton button1, button2, button3;
    String pin;

    Login(){
        super("Bank Management System");

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("Icon/bank.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(350, 10, 100, 100);
        add(jImage1);

        ImageIcon image2 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image image2Scaling = image2.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image2Scaling);
        JLabel jImage2 = new JLabel(imageIcon2);
        jImage2.setBounds(630, 350, 100, 100);
        add(jImage2);

        label1 = new JLabel("Welcome To Bank");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade",Font.BOLD, 38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setForeground(Color.WHITE);
        label2.setBounds(150,190,375,30);
        add(label2);

        textField = new JTextField(15);
        textField.setBounds(325,190,230,30);
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField);

        label3 = new JLabel("Pin:");
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setForeground(Color.WHITE);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField = new JPasswordField(15);
        passwordField.setBounds(325, 250, 230,30);
        passwordField.setFont(new Font("Arial", Font.BOLD,14));
        add(passwordField);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.BLACK);
        button1.setBounds(300,300,100,30);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.BLACK);
        button2.setBounds(430,300,100,30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.BLACK);
        button3.setBounds(300,350,230,30);
        button3.addActionListener(this);
        add(button3);

        ImageIcon image3 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image image3Scaling = image3.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon imageIcon3 = new ImageIcon(image3Scaling);
        JLabel jImage3 = new JLabel(imageIcon3);
        jImage3.setBounds(0,0,850,480);
        add(jImage3);

        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button1){
            String cardNo = textField.getText();
            char[] pinChars = passwordField.getPassword();
            String pinText = String.valueOf(pinChars);

            try{
                // Validation check
                if(cardNo.isEmpty() || pinText.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter Card No. and Pin");
                    return;
                }

                // Database Connection and Query
                ConnectingDB c1 = new ConnectingDB();

                String query = "SELECT * FROM login WHERE card_number = '"+cardNo+"' AND pin = '"+ pinText +"'";
                ResultSet rs = c1.statement.executeQuery(query);

                // Check the result
                if(rs.next()){
                    this.pin = pinText;
                    new MainAtm(pinText);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            } finally {
                // SECURITY: Clear the char array immediately after use
                Arrays.fill(pinChars, '0');
            }

        } else if(e.getSource() == button2){
            // CLEAR button logic
            textField.setText("");
            passwordField.setText("");

        } else if(e.getSource() == button3){
            // SIGN UP button logic
            new SignUp();
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new Login();
    }
}