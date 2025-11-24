package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    String pin;
    JLabel main;
    JButton hun, fiveHun, thou, twoThou,fiveThou, tenThou, back;
    FastCash(String pin){
        this.pin = pin;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        main = new JLabel("SELECT WITHDRAWAL AMOUNT");
        main.setFont(new Font("AvantGrade", Font.BOLD, 18));
        main.setForeground(Color.WHITE);
        main.setBounds(470, 40, 400, 350);
        jImage1.add(main);

        hun = new JButton("RS.100");
        hun. setForeground (Color.BLACK);
        hun.setFont(new Font("AvantGrade", Font.BOLD, 14));
        hun. setBackground(new Color ( 65,  125, 128)) ;
        hun.setBounds (410, 274, 150, 35);
        hun.addActionListener(this);
        jImage1.add(hun);

        fiveHun = new JButton("RS.500");
        fiveHun. setForeground (Color.BLACK);
        fiveHun.setFont(new Font("AvantGrade", Font.BOLD, 14));
        fiveHun. setBackground(new Color ( 65,  125, 128)) ;
        fiveHun.setBounds (410, 314, 150, 35);
        fiveHun.addActionListener(this);
        jImage1.add(fiveHun);

        thou = new JButton("RS.1000");
        thou. setForeground (Color.BLACK);
        thou.setFont(new Font("AvantGrade", Font.BOLD, 14));
        thou. setBackground(new Color ( 65,  125, 128)) ;
        thou.setBounds (410, 354, 150, 35);
        thou.addActionListener(this);
        jImage1.add(thou);

        twoThou = new JButton("RS.2000");
        twoThou. setForeground (Color.BLACK);
        twoThou.setFont(new Font("AvantGrade", Font.BOLD, 14));
        twoThou. setBackground(new Color ( 65,  125, 128)) ;
        twoThou.setBounds (700, 264, 150, 35);
        twoThou.addActionListener(this);
        jImage1.add(twoThou);

        fiveThou = new JButton("RS.5000");
        fiveThou. setForeground (Color.BLACK);
        fiveThou.setFont(new Font("AvantGrade", Font.BOLD, 14));
        fiveThou. setBackground(new Color ( 65,  125, 128)) ;
        fiveThou.setBounds (700, 304, 150, 35);
        fiveThou.addActionListener(this);
        jImage1.add(fiveThou);

        tenThou = new JButton("RS.10000");
        tenThou. setForeground (Color.BLACK);
        tenThou.setFont(new Font("AvantGrade", Font.BOLD, 14));
        tenThou. setBackground(new Color ( 65,  125, 128)) ;
        tenThou.setBounds (700, 344, 150, 35);
        tenThou.addActionListener(this);
        jImage1.add(tenThou);

        back = new JButton("Back");
        back. setForeground (Color.BLACK);
        back.setFont(new Font("AvantGrade", Font.BOLD, 14));
        back. setBackground(new Color ( 65,  125, 128)) ;
        back.setBounds (700, 384, 150, 35);
        back.addActionListener(this);
        jImage1.add(back);


        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Date date = new Date();
        try{
            ConnectingDB c1 = new ConnectingDB();
            ResultSet res = c1.statement.executeQuery("select * from deposit where pin = '"+pin+"'");
            int balance = 0;
            while (res.next()){
                if(res.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(res.getString("amount"));
                }else {
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }
            if(e.getSource() == hun){
                String amount = "100";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);

            }else if(e.getSource() == fiveHun){
                String amount = "500";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);

            }else if(e.getSource() == thou){
                String amount = "1000";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);

            }else if(e.getSource() == twoThou){
                String amount = "2000";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);

            }else if(e.getSource() == fiveThou){
                String amount = "5000";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);

            }else if(e.getSource() == tenThou){
                String amount = "10000";
                c1.statement.executeUpdate("insert into deposit values('"+pin+"','"+date+"','Withdrawal','"+amount+"')");
                JOptionPane.showMessageDialog(null,"Amount "+amount+" got Debited Successfully");
                new MainAtm(pin);
                setVisible(false);
            }else if(e.getSource() == back){
                new MainAtm(pin);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        new FastCash("");
    }
}
