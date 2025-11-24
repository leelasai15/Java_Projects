package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

    String pin;
    JLabel main, balanceFiled;
    JButton back;
    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        main = new JLabel("Your Current Balance is:");
        main.setFont(new Font("AvantGrade", Font.BOLD, 16));
        main.setForeground(Color.WHITE);
        main.setBounds(460, 50, 400, 350);
        jImage1.add(main);

        balanceFiled = new JLabel();
        balanceFiled.setFont(new Font("AvantGrade", Font.BOLD, 16));
        balanceFiled.setForeground(Color.WHITE);
        balanceFiled.setBounds(460, 90, 400, 350);
        jImage1.add(balanceFiled);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(Color.BLACK);
        back.setBounds(750,410,100,35);
        back.addActionListener(this);
        jImage1.add(back);

        int balance = 0;
        try{
            ConnectingDB c1 = new ConnectingDB();
            ResultSet res = c1.statement.executeQuery("select * from deposit where pin = '"+pin+"'");
            while (res.next()){
                if(res.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(res.getString("amount"));
                }else{
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        balanceFiled.setText(""+balance);

        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            new MainAtm(pin);
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
