package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class NewCustomer extends JFrame implements ActionListener{
    JLabel heading ,meternumText,customerName,meterNum, address,city,state,email,phone;
    JButton next, cancel;
    TextField nameText, addressText, cityText, stateText ,emailText,phoneText;
    String userT;
    NewCustomer( String userT){

        super("New Customer");
        this.userT = userT;
        setSize(700,500);
        setLocation(400,200);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(252,186,3));
        add(panel);

        heading = new JLabel("New Customer");
        heading.setBounds(180,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        customerName = new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meternumText = new JLabel("");
        meternumText.setBounds(180,120,150,20);
        panel.add(meternumText);

        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        meternumText.setText(""+ Math.abs(number) );

        address = new JLabel("Address ");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new TextField();
        addressText.setBounds(180,160,150,20);
        panel.add(addressText);

        city = new JLabel("City ");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(180,200,150,20);
        panel.add(cityText);

        state = new JLabel("State ");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText = new TextField();
        stateText.setBounds(180,240,150,20);
        panel.add(stateText);

        email = new JLabel("Email ");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(180,280,150,20);
        panel.add(emailText);


        phone = new JLabel("Phone ");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(180,320,150,20);
        panel.add(phoneText);

        next = new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        panel.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(230,390,100,25);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLable = new JLabel(i3);
        add(imgLable,"West");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sNewCust = nameText.getText();
        String sMeterNum = meternumText.getText();
        String sAddress = addressText.getText();
        String sCity = cityText.getText();
        String sState = stateText.getText();
        String sEmail = emailText.getText();
        String sPhone = phoneText.getText();
        try{
            if(userT.equals("Admin")){
                if(e.getSource() == next){
                    if(sNewCust.isEmpty() || sAddress.isEmpty() || sCity.isEmpty() || sState.isEmpty() || sEmail.isEmpty() || sPhone.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Please Fill all the Requires Fields");
                    }else{
                        DataBase db = new DataBase();
                        db.statement.executeUpdate("insert into new_customer values('"+sNewCust+"','"+sMeterNum+"','"+sAddress+"','"+sCity+"','"+sState+"','"+sEmail+"','"+sPhone+"')");
                        JOptionPane.showMessageDialog(null, "User Details Added Successfully");
                        new MeterInfo(sMeterNum,userT);
                        setVisible(false);
                    }
                }else if(e.getSource() == cancel){
                    new Main(userT);
                    setVisible(false);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Your Not Admin");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new NewCustomer("");
    }
}