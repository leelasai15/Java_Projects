package bank.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SignUp extends JFrame implements ActionListener {

    JLabel mainHeading, pageNo, pageHeading, name, fatherName, gender, DOB, email, mStatus,address,city, state, pinCode;
    JTextField nameField, fatherNameField, emailField, addressField, cityField, stateField, pinCodeField;
    JRadioButton male, female, married, unMarried;
    JButton next;
    JDateChooser date;

    Random r = new Random();
    long num = (r.nextLong() % 9000L) + 1000L;
    String str = " " + Math.abs(num);

    SignUp(){
        super("Application From");
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(25,10,100,100);
        add(jImage1);

        mainHeading = new JLabel("APPLICATION FORM NO. "+ str);
        mainHeading.setFont(new Font("AvantGrade", Font.BOLD, 38));
        mainHeading.setForeground(Color.BLACK);
        mainHeading.setBounds(160,20,600,40);
        add(mainHeading);

        pageNo = new JLabel("Page No: 1");
        pageNo.setFont(new Font("AvantGrade", Font.BOLD, 22));
        pageNo.setForeground(Color.BLACK);
        pageNo.setBounds(330,65,600,30);
        add(pageNo);

        pageHeading = new JLabel("Personal Details");
        pageHeading.setFont(new Font("AvantGrade", Font.BOLD, 22));
        pageHeading.setForeground(Color.BLACK);
        pageHeading.setBounds(300,95,600,30);
        add(pageHeading);

        name = new JLabel("Name: ");
        name.setFont(new Font("AvantGrade", Font.BOLD, 15));
        name.setForeground(Color.BLACK);
        name.setBounds(80,150,200,30);
        add(name);

        nameField = new JTextField(50);
        nameField.setBounds(250,150,400,30);
        nameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(nameField);

        fatherName = new JLabel("Father Name : ");
        fatherName.setFont(new Font("AvantGrade", Font.BOLD, 15));
        fatherName.setForeground(Color.BLACK);
        fatherName.setBounds(80,190,200,30);
        add(fatherName);

        fatherNameField = new JTextField(50);
        fatherNameField.setBounds(250,190,400,30);
        fatherNameField.setFont(new Font("Arial", Font.BOLD, 14));
        add(fatherNameField);

        gender = new JLabel("Gender : ");
        gender.setFont(new Font("AvantGrade", Font.BOLD, 15));
        gender.setForeground(Color.BLACK);
        gender.setBounds(80,230,200,30);
        add(gender);

        male = new JRadioButton("Male ");
        male.setBounds(250,230,150,30);
        male.setFont(new Font("Arial", Font.BOLD, 14));
        add(male);

        female = new JRadioButton("Female ");
        female.setBounds(400,230,150,30);
        female.setFont(new Font("Arial", Font.BOLD, 14));
        add(female);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        DOB = new JLabel("Date of Birth: ");
        DOB.setFont(new Font("AvantGrade", Font.BOLD, 15));
        DOB.setForeground(Color.BLACK);
        DOB.setBounds(80,270,200,30);
        add(DOB);

        date = new JDateChooser();
        date.setForeground(new Color(105,105,105));
        date.setBounds(250,270,400,30);
        add(date);


        email = new JLabel("Email: ");
        email.setFont(new Font("AvantGrade", Font.BOLD, 15));
        email.setForeground(Color.BLACK);
        email.setBounds(80,310,200,30);
        add(email);

        emailField = new JTextField(50);
        emailField.setBounds(250, 310, 400, 30);
        emailField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailField);

        mStatus = new JLabel("Marital Status: ");
        mStatus.setFont(new Font("AvantGrade", Font.BOLD, 15));
        mStatus.setForeground(Color.BLACK);
        mStatus.setBounds(80,350,200,30);
        add(mStatus);

        married = new JRadioButton("Married ");
        married.setBounds(250,350,150,30);
        married.setFont(new Font("Arial", Font.BOLD, 14));
        add(married);

        unMarried = new JRadioButton("UnMarried ");
        unMarried.setBounds(400,350,150,30);
        unMarried.setFont(new Font("Arial", Font.BOLD, 14));
        add(unMarried);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(married);
        buttonGroup1.add(unMarried);

        address = new JLabel("Address: ");
        address.setFont(new Font("AvantGrade", Font.BOLD, 15));
        address.setForeground(Color.BLACK);
        address.setBounds(80,390,200,30);
        add(address);

        addressField = new JTextField(50);
        addressField.setBounds(250,390,400,30);
        addressField.setFont(new Font("Arial", Font.BOLD, 14));
        add(addressField);

        city = new JLabel("City: ");
        city.setFont(new Font("AvantGrade", Font.BOLD, 15));
        city.setForeground(Color.BLACK);
        city.setBounds(80,430,200,30);
        add(city);

        cityField = new JTextField(50);
        cityField.setBounds(250,430,400,30);
        cityField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cityField);

        state = new JLabel("State: ");
        state.setFont(new Font("AvantGrade", Font.BOLD, 15));
        state.setForeground(Color.BLACK);
        state.setBounds(80,470,200,30);
        add(state);

        stateField = new JTextField(50);
        stateField.setBounds(250,470,400,30);
        stateField.setFont(new Font("Arial", Font.BOLD, 14));
        add(stateField);

        pinCode = new JLabel("Pine Code: ");
        pinCode.setFont(new Font("AvantGrade", Font.BOLD, 15));
        pinCode.setForeground(Color.BLACK);
        pinCode.setBounds(80,510,200,30);
        add(pinCode);

        pinCodeField = new JTextField(50);
        pinCodeField.setBounds(250,510,400,30);
        pinCodeField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinCodeField);

        next = new JButton("Next");
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setForeground(Color.BLACK);
//        next.setBackground(Color.BLACK);
//        next.setOpaque(true);
//        next.setBorderPainted(false);
//        next.setFocusPainted(false);
        next.setBounds(550,550,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(252,208,76));
        setLayout(null);
        setLocation(360,40);
        setSize(800,700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String formNo = str;
        String name = nameField.getText();
        String fname = fatherNameField.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailField.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }else if(unMarried.isSelected()){
            marital = "UnMarried";
        }

        String address = addressField.getText();
        String city = cityField.getText();
        String pinCode = pinCodeField.getText();
        String state = stateField.getText();

        try{
            if(nameField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all the fields");
            }else{
                ConnectingDB con1 = new ConnectingDB();
                String q = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+ marital+"','"+address+"','"+city+"','"+pinCode+"','"+state+"')";
                con1.statement.executeUpdate(q);
                new SignUpTwo(formNo);
                setVisible(false);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args){
        new SignUp();
    }
}
