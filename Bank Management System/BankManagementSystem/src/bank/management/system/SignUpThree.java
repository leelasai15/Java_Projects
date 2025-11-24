package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JLabel pageNo,pageName, accountType, card,cardDigits, number, numberText, pin,pinDigit, digits, services;
    JRadioButton saving, fixed, current, recurring;
    JCheckBox atmCard, ib,mb,cb,ea,es, knowledge;
    JButton submit, cancel;
    String formNum;
    ButtonGroup bg = new ButtonGroup();
    SignUpThree(String formNum){
        this.formNum = formNum;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon image1Icon = new ImageIcon(image1Scaling);
        JLabel jImage = new JLabel(image1Icon);
        jImage.setBounds(50, 10, 100, 100);
        add(jImage);

        pageNo = new JLabel("Page No: 3");
        pageNo.setFont(new Font("AvantGrade", Font.BOLD, 25));
        pageNo.setForeground(Color.BLACK);
        pageNo.setBounds(300, 20, 500, 40);
        add(pageNo);

        pageName = new JLabel("Account Details");
        pageName.setFont(new Font("AvantGrade", Font.BOLD, 25));
        pageName.setForeground(Color.BLACK);
        pageName.setBounds(270, 50, 500, 40);
        add(pageName);

        accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("AvantGrade", Font.BOLD, 18));
        accountType.setForeground(Color.BLACK);
        accountType.setBounds(70, 150, 500, 40);
        add(accountType);

        saving = new JRadioButton("Savings Account");
        saving.setBounds(70,200,150,30);
        saving.setFont(new Font("Arial", Font.BOLD, 14));
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setBounds(370,200,250,30);
        fixed.setFont(new Font("Arial", Font.BOLD, 14));
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setBounds(70,240,150,30);
        current.setFont(new Font("Arial", Font.BOLD, 14));
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(370,240,250,30);
        recurring.setFont(new Font("Arial", Font.BOLD, 14));
        add(recurring);

        bg.add(saving);
        bg.add(fixed);
        bg.add(current);
        bg.add(recurring);

        card = new JLabel("Card Number:");
        card.setFont(new Font("AvantGrade", Font.BOLD, 18));
        card.setForeground(Color.BLACK);
        card.setBounds(70, 300, 500, 40);
        add(card);

        cardDigits = new JLabel("(Your 16-digit Card Number)");
        cardDigits.setFont(new Font("AvantGrade", Font.BOLD, 10));
        cardDigits.setForeground(Color.BLACK);
        cardDigits.setBounds(70, 320, 500, 40);
        add(cardDigits);

        number = new JLabel("XXXX-XXXX-XXXX-4849");
        number.setFont(new Font("AvantGrade", Font.BOLD, 18));
        number.setForeground(Color.BLACK);
        number.setBounds(300, 300, 500, 40);
        add(number);

        numberText = new JLabel("(It would appear on atm card/cheque Book and Statements");
        numberText.setFont(new Font("AvantGrade", Font.BOLD, 10));
        numberText.setForeground(Color.BLACK);
        numberText.setBounds(300, 320, 500, 40);
        add(numberText);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("AvantGrade", Font.BOLD, 18));
        pin.setForeground(Color.BLACK);
        pin.setBounds(70, 380, 500, 40);
        add(pin);

        pinDigit = new JLabel("(4-digit Password)");
        pinDigit.setFont(new Font("AvantGrade", Font.BOLD, 10));
        pinDigit.setForeground(Color.BLACK);
        pinDigit.setBounds(70, 400, 500, 40);
        add(pinDigit);

        digits = new JLabel("XXXX");
        digits.setFont(new Font("AvantGrade", Font.BOLD, 18));
        digits.setForeground(Color.BLACK);
        digits.setBounds(300, 380, 500, 40);
        add(digits);

        services = new JLabel("Services Required:");
        services.setFont(new Font("AvantGrade", Font.BOLD, 18));
        services.setForeground(Color.BLACK);
        services.setBounds(70, 450, 500, 40);
        add(services);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setFont(new Font("AvantGrade", Font.BOLD, 15));
        atmCard.setForeground(Color.BLACK);
        atmCard.setBounds(70, 500, 200, 40);
        add(atmCard);

        mb = new JCheckBox("Mobile Banking");
        mb.setFont(new Font("AvantGrade", Font.BOLD, 15));
        mb.setForeground(Color.BLACK);
        mb.setBounds(70, 540, 200, 40);
        add(mb);

        cb = new JCheckBox("Cheque Book");
        cb.setFont(new Font("AvantGrade", Font.BOLD, 15));
        cb.setForeground(Color.BLACK);
        cb.setBounds(70, 580, 200, 40);
        add(cb);

        ib = new JCheckBox("Internet Banking");
        ib.setFont(new Font("AvantGrade", Font.BOLD, 15));
        ib.setForeground(Color.BLACK);
        ib.setBounds(350, 500, 500, 40);
        add(ib);

        ea = new JCheckBox("EMAIL Alerts");
        ea.setFont(new Font("AvantGrade", Font.BOLD, 15));
        ea.setForeground(Color.BLACK);
        ea.setBounds(350, 540, 500, 40);
        add(ea);

        es = new JCheckBox("E-Statement");
        es.setFont(new Font("AvantGrade", Font.BOLD, 15));
        es.setForeground(Color.BLACK);
        es.setBounds(350, 580, 500, 40);
        add(es);

        knowledge = new JCheckBox("I here by declares that the above entered details correct to the best of my Knowledge.");
        knowledge.setFont(new Font("AvantGrade", Font.BOLD, 12));
        knowledge.setForeground(Color.BLACK);
        knowledge.setBounds(70, 650, 1000, 40);
        add(knowledge);

        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setForeground(Color.BLACK);
        submit.setBounds(250,690,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(400,690,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setSize(700, 800);
        setLocation(360, 40);
        getContentPane().setBackground(new Color(215,252,252));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accountType = null;
        if(saving.isSelected()){
            accountType = "Savings Account";
        }else if(fixed.isSelected()){
            accountType = "Fixed Deposit Account";
        } else if (current.isSelected()) {
            accountType = "Current Account";
        }else if(recurring.isSelected()){
            accountType = "Recurring Deposit Account";
        }

        Random r = new Random();
        long num = (r.nextLong() % 9000000000L) + 1409963000000000L;
        String cardno = " " + Math.abs(num);
        long first3 = (r.nextLong() % 9000L) + 1000L;
        String pin = ""+ Math.abs(first3);

        String fac = "";

        if(atmCard.isSelected()){
            fac += "ATM Card ";
        }
        if(mb.isSelected()){
            fac += "Mobile Banking";
        }
        boolean cbr = false;
        if(cb.isSelected()){
            fac += "Cheque Book";
        }
        if(ib.isSelected()){
            fac += "Internet Banking";
        }
        if(ea.isSelected()){
            fac +="EMAIL Alerts";
        }
        if(es.isSelected()){
            fac += "E-Statement";
        }
        try{
            if(e.getSource() == submit){
              if(saving.isSelected() || fixed.isSelected() || current.isSelected() || recurring.isSelected()){
                  if(knowledge.isSelected()){
                        ConnectingDB c1 = new ConnectingDB();

                        String q1 = "insert into signUpThree values('"+formNum+"','"+accountType+"','"+cardno+"','"+pin+"','"+fac+"')";
                        String q2 = "insert into login values('"+formNum+"','"+cardno+"','"+pin+"')";
                        c1.statement.executeUpdate(q1);
                        c1.statement.executeUpdate(q2);
                        JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\n Pin: " +pin );
                        new Deposit(pin);
                        setVisible(false);
                  }else {
                      JOptionPane.showMessageDialog(null,"Fill all the Required Fields");
                  }
              }else{
                  JOptionPane.showMessageDialog(null,"Fill all the Required Fields");
              }
            }else if(e.getSource() == cancel){
                System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public  static void main(String[] args){
        new SignUpThree("");
    }


}
