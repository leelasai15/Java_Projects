package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JLabel main, submain;
    JTextField field;
    JButton withdraw, back;
    String pin;
    Withdrawal(String pin){
        this.pin = pin;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        main = new JLabel("MAXIMUM WITHDRAWAL IS RS.10000");
        main.setFont(new Font("AvantGrade", Font.BOLD, 16));
        main.setForeground(Color.WHITE);
        main.setBounds(460, 30, 400, 350);
        jImage1.add(main);

        submain = new JLabel("PLEASE ENTER THE AMOUNT");
        submain.setFont(new Font("AvantGrade", Font.BOLD, 16));
        submain.setForeground(Color.WHITE);
        submain.setBounds(460, 60, 400, 350);
        jImage1.add(submain);

        field = new JTextField();
        field.setBounds(460,250,300,30);
        field.setFont(new Font("Arial", Font.BOLD, 14));
        jImage1.add(field);


        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("Arial", Font.BOLD, 14));
        withdraw.setForeground(Color.BLACK);
        withdraw.setBounds(750,370,100,35);
        withdraw.addActionListener(this);
        jImage1.add(withdraw);

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
            String amount = field.getText();
            Date date = new Date();

            if(e.getSource() == withdraw){
                if(field.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter the Amount");
                }else{
                    ConnectingDB c1 = new ConnectingDB();
                    ResultSet res = c1.statement.executeQuery("select * from deposit where pin = '"+pin+"'");

                    int balance = 0;
                    while (res.next()){
                        if(res.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(res.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(res.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");
                        return;
                    }
                    c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
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
        new Withdrawal("");
    }

}
