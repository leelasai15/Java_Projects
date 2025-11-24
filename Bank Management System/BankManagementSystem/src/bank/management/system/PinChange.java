package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PinChange extends JFrame implements ActionListener {

    String pin;
    JLabel main,opin,npin,rnpin;
    JTextField opinField, npinField, rnpinField;
    JButton change,back;
    PinChange(String pin){

        this.pin = pin;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image image1Scaling = image1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0,0,1550,830);
        add(jImage1);

        main = new JLabel("Change Your PIN");
        main.setFont(new Font("AvantGrade", Font.BOLD, 18));
        main.setForeground(Color.WHITE);
        main.setBounds(420, 35, 400, 350);
        jImage1.add(main);

        opin = new JLabel("Enter Original PIN:");
        opin.setFont(new Font("AvantGrade", Font.BOLD, 13));
        opin.setForeground(Color.WHITE);
        opin.setBounds(420, 90, 400, 350);
        jImage1.add(opin);

        opinField = new JTextField();
        opinField.setBounds(600,250,200,30);
        opinField.setFont(new Font("Arial", Font.BOLD, 14));
        jImage1.add(opinField);

        npin = new JLabel("Enter New PIN:");
        npin.setFont(new Font("AvantGrade", Font.BOLD, 13));
        npin.setForeground(Color.WHITE);
        npin.setBounds(420, 130, 400, 350);
        jImage1.add(npin);

        npinField = new JTextField();
        npinField.setBounds(600,290,200,30);
        npinField.setFont(new Font("Arial", Font.BOLD, 14));
        jImage1.add(npinField);

        rnpin = new JLabel("Re-Enter New PIN:");
        rnpin.setFont(new Font("AvantGrade", Font.BOLD, 13));
        rnpin.setForeground(Color.WHITE);
        rnpin.setBounds(420, 170, 400, 350);
        jImage1.add(rnpin);

        rnpinField = new JTextField();
        rnpinField.setBounds(600,330,200,30);
        rnpinField.setFont(new Font("Arial", Font.BOLD, 14));
        jImage1.add(rnpinField);

        change = new JButton("Change");
        change.setFont(new Font("Arial", Font.BOLD, 14));
        change.setForeground(Color.BLACK);
        change.setBounds(750,370,100,35);
        change.addActionListener(this);
        jImage1.add(change);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        back.setForeground(Color.BLACK);
        back.setBounds(750,410,100,35);
        back.addActionListener(this);
        jImage1.add(back);

        setSize(1550,1080);
        setLocation(0,0);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args){
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String oldPin = opinField.getText();
        String newPin = npinField.getText();
        String reNewPin = rnpinField.getText();

        if(e.getSource() == change){
            if(oldPin.isEmpty() || newPin.isEmpty() || reNewPin.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please Provide all the Required Fields");
                return;
            }

            if(!newPin.equals(reNewPin)){
                JOptionPane.showMessageDialog(null,"New PINs do not match. Please try again.");
                return;
            }

            ConnectingDB c1 = new ConnectingDB();
            try{
                String selectQuery = "SELECT * FROM login WHERE pin = '"+oldPin+"'";
                ResultSet rs = c1.statement.executeQuery(selectQuery);

                if(rs.next()){
                    String updateQuery = "UPDATE login SET pin = '"+newPin+"' WHERE pin = '"+oldPin+"'";
                    c1.statement.executeUpdate(updateQuery);

                    this.pin = newPin;

                    JOptionPane.showMessageDialog(null,"PIN Changed Successfully!");
                    setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Old PIN.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Database Error: Failed to change PIN.");
            }
        }else if(e.getSource() == back){
            new MainAtm(pin);
            setVisible(false);
        }
    }
}
