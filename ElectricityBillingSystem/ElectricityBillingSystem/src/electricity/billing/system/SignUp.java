package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener{
    JLabel EmployerText;
    Choice loginASCho;
    TextField meterText,userNameText,nameText,passwordText;
    JButton create,back;
    String userT;
    SignUp(String userT){
        super("Signup Page");
        this.userT = userT;
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginASCho = new Choice();
        loginASCho.add("Admin");
        loginASCho.add("Customer");
        loginASCho.setBounds(170,50,120,20);
        add(loginASCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel Employer = new JLabel("Employer ID");
        Employer.setBounds(30,100,125,20);
        Employer.setVisible(true);
        add(Employer);

        EmployerText = new JLabel("");
        EmployerText.setBounds(170,100,125,20);
        EmployerText.setVisible(true);
        add(EmployerText);


        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        EmployerText.setText(""+ Math.abs(number) );



        loginASCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
              String user = loginASCho.getSelectedItem();

              if(user.equals("Customer")){
                  Employer.setVisible(false);
                  EmployerText.setVisible(false);
                  meterNo.setVisible(true);
                  meterText.setVisible(true);
              }else if(user.equals("Admin")){
                  Employer.setVisible(true);
                  EmployerText.setVisible(true);
                  meterNo.setVisible(false);
                  meterText.setVisible(false);
              }

            }
        });

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);


        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText = new TextField("");
        nameText.setBounds(170,180,125,20);
        add(nameText);


        JLabel password = new JLabel("Password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);


        create = new JButton("Create");
        create.setBackground(new Color(66,127,219));
        create.setForeground(Color.black);
        create.setBounds(50,285,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(66,127,219));
        back.setForeground(Color.black);
        back.setBounds(180,285,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.png"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(320,30,250,250);
        add(boyLabel);


        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String sLoginASCho = loginASCho.getSelectedItem();
        String sMeterText =  meterText.getText();
        String sEmployeeId = EmployerText.getText();
        String sUserNameText = userNameText.getText();
        String sNameText = nameText.getText();
        String sPasswordText = passwordText.getText();
        try{
            if(e.getSource() == create){
                if(sLoginASCho.equals("Admin")){
                    if(userT.equals("Admin") ){
                        if(sNameText.isEmpty() || sMeterText.isEmpty() || sLoginASCho.isEmpty() || sPasswordText.isEmpty() || sUserNameText.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Fill all the Required Fields");
                        }else{
                            DataBase c = new DataBase();
                            c.statement.executeUpdate("insert into admin_table values('"+sEmployeeId+"','"+sUserNameText+"','"+sNameText+"','"+sPasswordText+"','"+sLoginASCho+"')");
                            JOptionPane.showMessageDialog(null, "User Created Successfully");
                            new Login();
                            setVisible(false);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Only Admin can SignUp Admin Account");
                    }
                }else if(sLoginASCho.equals("Customer")){
                    if(sNameText.isEmpty() || sMeterText.isEmpty() || sLoginASCho.isEmpty() || sPasswordText.isEmpty() || sUserNameText.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Fill all the Required Fields");
                    }else{
                        DataBase c = new DataBase();
                        c.statement.executeUpdate("insert into Signup values('"+sMeterText+"','"+sUserNameText+"','"+sNameText+"','"+sPasswordText+"','"+sLoginASCho+"')");
                        JOptionPane.showMessageDialog(null, "User Created Successfully");
                        new Login();
                        setVisible(false);
                    }
                }
            }else if(e.getSource() == back){
                new Login();
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new SignUp("");
    }
}