package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame  implements ActionListener{
    JTextField userText,passwordText;
    Choice loginChoice;

    JButton loginButton,cancelButton,signupButton;

    Login(){
        super("Login");
        getContentPane().setBackground(Color.white);
        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        JLabel loggin = new JLabel("Login In As");
        loggin.setBounds(300,140,100,20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);

        loginButton = new JButton("Login");
        loginButton.setBounds(330,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(460,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        signupButton = new JButton("Signup");
        signupButton.setBounds(400,215,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profileOne =  new ImageIcon(ClassLoader.getSystemResource("icon/profile.png"));
        Image profileTow = profileOne.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profileTow);
        JLabel profileLable = new JLabel(fprofileOne);
        profileLable.setBounds(5,5,250,250);
        add(profileLable);



        setSize(640,300);
        setLocation(400,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sUserText = userText.getText();
        String sPassword = passwordText.getText();
        String sUser = loginChoice.getSelectedItem();
        try{
            if(e.getSource() == loginButton){
                if(sUser.equals("Admin")){
                    if(sUserText.isEmpty() || sPassword.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please Fill the Required Fields");
                    }else{
                        DataBase db = new DataBase();
                        ResultSet rs = db.statement.executeQuery("select * from admin_table where user_name = '"+sUserText+"' AND password = '"+sPassword+"'");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Login Successfull");
                            new Main(sUser);
                            setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null,"Invalid UserName or Password or UserType");
                        }
                    }
                }else if(sUser.equals("Customer")) {
                    if(sUserText.isEmpty() || sPassword.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Please Fill the Required Fields");
                    }else{
                        DataBase db = new DataBase();
                        ResultSet rs = db.statement.executeQuery("select * from Signup where username = '"+sUserText+"' AND password = '"+sPassword+"'");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Login Successfull");
                            new Main(sUser);
                            setVisible(false);
                        }else{
                            JOptionPane.showMessageDialog(null,"Invalid UserName or Password or UserType");
                        }
                    }
                }
            }else if(e.getSource() == signupButton){
                new SignUp(sUser);
                setVisible(false);
            }else if(e.getSource() == cancelButton){
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }

}