package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amountField;
    JButton deposit, back;
    String pin;
    Deposit(String pin){

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        JLabel main = new JLabel("Enter the Amount You want to Deposit ");
        main.setFont(new Font("AvantGrade", Font.BOLD, 16));
        main.setForeground(Color.WHITE);
        main.setBounds(460, 50, 400, 350);
        jImage1.add(main);

        amountField = new JTextField();
        amountField.setBounds(460,250,300,30);
        amountField.setFont(new Font("Arial", Font.BOLD, 14));
        jImage1.add(amountField);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("Arial", Font.BOLD, 14));
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(750,370,100,35);
        deposit.addActionListener(this);
        jImage1.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(Color.BLACK);
        back.setBounds(750,410,100,35);
        back.addActionListener(this);
        jImage1.add(back);

        this.pin = pin;
        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Date date = new Date();
            String amount = amountField.getText();

            if(e.getSource() == deposit){
                if(amountField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter the Desposit Amount");
                }else{
                    ConnectingDB c1 = new ConnectingDB();
                    c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Your Amount: "+amount+"has been Deposited Succcessfully");
                    new MainAtm(pin);
                    setVisible(false);
                }
            }else if(e.getSource() == back){
                new MainAtm(pin);
                setVisible(false);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args){
        new Deposit("");
    }
}
