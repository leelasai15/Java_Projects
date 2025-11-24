package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class SignUpTwo extends JFrame implements ActionListener {

JLabel formNo,pageNo, pageName, religion, category, income, education, occupation, panNum, aadharNum, seniorCitizen,existingAccount;
JComboBox comboBox1, comboBox2, comboBox3, comboBox4, comboBox5;
JTextField panField, aadharFiled;
JRadioButton yes, no, yes1, no1;
JButton button;

String formNum;
    SignUpTwo(String formNum) {

    ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
    Image image1Scaling = image1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon image1Icon = new ImageIcon(image1Scaling);
    JLabel jImage = new JLabel(image1Icon);
    jImage.setBounds(50, 10, 100, 100);
    add(jImage);

    this.formNum = formNum;

    pageNo = new JLabel("Page No: 2");
    pageNo.setFont(new Font("AvantGrade", Font.BOLD, 25));
    pageNo.setForeground(Color.BLACK);
    pageNo.setBounds(300, 20, 500, 40);
    add(pageNo);

    pageName = new JLabel("Additional Details");
    pageName.setFont(new Font("AvantGrade", Font.BOLD, 25));
    pageName.setForeground(Color.BLACK);
    pageName.setBounds(250, 50, 500, 40);
    add(pageName);

    religion = new JLabel("Religion: ");
    religion.setFont(new Font("AvantGrade", Font.BOLD, 15));
    religion.setForeground(Color.BLACK);
    religion.setBounds(80,150,200,30);
    add(religion);

    String religions[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
    comboBox1 = new JComboBox<>(religions);
    comboBox1.setBounds(250,150,400,30);
    comboBox1.setFont(new Font("Arial",Font.PLAIN, 14));
    add(comboBox1);

    category = new JLabel("Category: ");
    category.setFont(new Font("AvantGrade", Font.BOLD, 15));
    category.setForeground(Color.BLACK);
    category.setBounds(80,200,200,30);
    add(category);

    String categories[] = {"General", "OBC", "SC", "ST", "Other"};
    comboBox2 = new JComboBox<>(categories);
    comboBox2.setBounds(250,200,400,30);
    comboBox2.setFont(new Font("Arial",Font.PLAIN, 14));
    add(comboBox2);

    income = new JLabel("Income: ");
    income.setFont(new Font("AvantGrade", Font.BOLD, 15));
    income.setForeground(Color.BLACK);
    income.setBounds(80,250,200,30);
    add(income);

    String incomes[] = {"Null","<1,50,000","<2,50,000", "5,00,000", "Upto 10,00,000" ,"Above 10,00,000"};
    comboBox3 = new JComboBox<>(incomes);
    comboBox3.setBounds(250,250,400,30);
    comboBox3.setFont(new Font("Arial",Font.PLAIN, 14));
    add(comboBox3);

    education = new JLabel("Educational ");
    education.setFont(new Font("AvantGrade", Font.BOLD, 15));
    education.setForeground(Color.BLACK);
    education.setBounds(80,300,200,30);
    add(education);

    String edu[] = {"Non-Graduate", "Graduate", "Post_Graduate", "Doctrate", "Other"};
    comboBox4 = new JComboBox<>(edu);
    comboBox4.setBounds(250,310,400,30);
    comboBox4.setFont(new Font("Arial",Font.PLAIN, 14));
    add(comboBox4);

    education = new JLabel("Qualification:  ");
    education.setFont(new Font("AvantGrade", Font.BOLD, 15));
    education.setForeground(Color.BLACK);
    education.setBounds(80,320,200,30);
    add(education);

    occupation = new JLabel("Occupation: ");
    occupation.setFont(new Font("AvantGrade", Font.BOLD, 15));
    occupation.setForeground(Color.BLACK);
    occupation.setBounds(80,370,200,30);
    add(occupation);

    String ocu[] = {"Salaried", "Self-Employed", "Business", "Student","Retired", "Other"};
    comboBox5 = new JComboBox<>(ocu);
    comboBox5.setBounds(250,360,400,30);
    comboBox5.setFont(new Font("Arial",Font.PLAIN, 14));
    add(comboBox5);


    panNum = new JLabel("PAN Number: ");
    panNum.setFont(new Font("AvantGrade", Font.BOLD, 15));
    panNum.setForeground(Color.BLACK);
    panNum.setBounds(80,420,200,30);
    add(panNum);

    panField = new JTextField(15);
    panField.setBounds(250,420,400,30);
    panField.setFont(new Font("Arial", Font.BOLD, 14));
    add(panField);

    aadharNum = new JLabel("Aadhar Number: ");
    aadharNum.setFont(new Font("AvantGrade", Font.BOLD, 15));
    aadharNum.setForeground(Color.BLACK);
    aadharNum.setBounds(80,470,200,30);
    add(aadharNum);

    aadharFiled = new JTextField(15);
    aadharFiled.setBounds(250,470,400,30);
    aadharFiled.setFont(new Font("Arial", Font.BOLD, 14));
    add(aadharFiled);

    seniorCitizen = new JLabel("Senior Citizen: ");
    seniorCitizen.setFont(new Font("AvantGrade", Font.BOLD, 15));
    seniorCitizen.setForeground(Color.BLACK);
    seniorCitizen.setBounds(80,520,200,30);
    add(seniorCitizen);

    yes = new JRadioButton("Yes");
    yes.setBounds(400,520,150,30);
    yes.setFont(new Font("Arial", Font.BOLD, 14));
    add(yes);

    no = new JRadioButton("No");
    no.setBounds(550,520,150,30);
    no.setFont(new Font("Arial", Font.BOLD, 14));
    add(no);

    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(yes);
    buttonGroup.add(no);

    existingAccount = new JLabel("Existing Account: ");
    existingAccount.setFont(new Font("AvantGrade", Font.BOLD, 15));
    existingAccount.setForeground(Color.BLACK);
    existingAccount.setBounds(80,570,200,30);
    add(existingAccount);

    yes1 = new JRadioButton("Yes");
    yes1.setBounds(400,570,150,30);
    yes1.setFont(new Font("Arial", Font.BOLD, 14));
    add(yes1);

    no1 = new JRadioButton("No");
    no1.setBounds(550,570,150,30);
    no1.setFont(new Font("Arial", Font.BOLD, 14));
    add(no1);

    ButtonGroup buttonGroup1 = new ButtonGroup();
    buttonGroup1.add(yes1);
    buttonGroup1.add(no1);

    button = new JButton("Next");
    button.setFont(new Font("Arial", Font.BOLD, 14));
    button.setForeground(Color.BLACK);
//        next.setBackground(Color.BLACK);
//        next.setOpaque(true);
//        next.setBorderPainted(false);
//        next.setFocusPainted(false);
    button.setBounds(550,620,100,30);
    button.addActionListener(this);
    add(button);


    setLayout(null);
    setSize(800, 700);
    setLocation(360, 40);
    getContentPane().setBackground(Color.ORANGE);
    setVisible(true);
}
    @Override
    public void actionPerformed(ActionEvent e) {

        String rel = (String) comboBox1.getSelectedItem();
        String cat = (String) comboBox2.getSelectedItem();
        String inc = (String) comboBox3.getSelectedItem();
        String edu = (String) comboBox4.getSelectedItem();
        String occ = (String) comboBox5.getSelectedItem();

        String pan = panField.getText();
        String aadhar = aadharFiled.getText();

        String citizen = null;
        if(yes.isSelected()){
            citizen = "Yes";
        }else if(no.isSelected()){
            citizen = "No";
        }

        String eAccount = null;
        if(yes1.isSelected()){
            eAccount = "Yes";
        }else if(no1.isSelected()){
            eAccount = "No";
        }

        try {
            if(panField.getText().equals("") || aadharFiled.getText().equals("")){
                JOptionPane.showMessageDialog(null,"FILL ALL THE FIELDS");
            }else {
                ConnectingDB c1 = new ConnectingDB();
                String q = "insert into signUpTwo values('"+formNum+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+citizen+"','"+eAccount+"')";
                c1.statement.executeUpdate(q);
                new SignUpThree(formNum);
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try{
            if(e.getSource() == button){

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        new SignUpTwo("");
    }
}
