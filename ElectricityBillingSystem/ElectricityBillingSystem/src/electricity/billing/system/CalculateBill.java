package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateBill extends JFrame implements ActionListener {
    JLabel nameText, addressText;
    TextField unitText;
    Choice meternumCho,monthCho;
    JButton submit, cancel;
    CalculateBill(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(214,195,247));
        add(panel);

        JLabel heading = new JLabel("---Calculate Electricity Bill---");
        heading.setBounds(70,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel meternum = new JLabel("Meter Number:");
        meternum.setBounds(50,80,100,20);
        panel.add(meternum);

        meternumCho = new Choice();
        try{
            DataBase db = new DataBase();
            ResultSet rs = db.statement.executeQuery("select * from meter_information");
            while(rs.next()){
                meternumCho.addItem(rs.getString("meter_num"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        meternumCho.setBounds(180,80,100,20);
        panel.add(meternumCho);

        JLabel name = new JLabel("Name:");
        name.setBounds(50,120,100,20);
        panel.add(name);

        nameText = new JLabel();
        nameText.setBounds(193,120,100,20);
        String metNUm = meternumCho.getSelectedItem();
        try{
            DataBase db = new DataBase();
            ResultSet rs = db.statement.executeQuery("select * from new_customer where meter_num = '"+metNUm+"'");
            if(rs.next()){
                nameText.setText(rs.getString("name"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        panel.add(nameText);

        JLabel address = new JLabel("Address:");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new JLabel();
        addressText.setBounds(180,160,150,20);
        try{
            DataBase db = new DataBase();
            ResultSet rs = db.statement.executeQuery("select * from new_customer where meter_num = '"+metNUm+"'");
            if(rs.next()){
                addressText.setText(rs.getString("address"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        panel.add(addressText);


        JLabel unitconsumed = new JLabel("Unit Consumed");
        unitconsumed.setBounds(50,200,100,20);
        panel.add(unitconsumed);

        unitText = new TextField();
        unitText.setBounds(180,200,150,20);
        panel.add(unitText);

        JLabel month = new JLabel("Month");
        month.setBounds(50,240,100,20);
        panel.add(month);

        monthCho = new Choice();
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(180,240,150,20);
        panel.add(monthCho);

        submit = new JButton("Submit");
        submit.setBounds(80,300,100,25);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,300,100,25);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel,"East");

        setSize(650,400);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Only get inputs if the submit button is clicked
        if(e.getSource() == submit){
            String sMeterNum = meternumCho.getSelectedItem();
            String sMonth = monthCho.getSelectedItem();
            String sUnit = unitText.getText();
            String totalBill = null;

            try{
                if(sUnit.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Enter the Units");
                    return;
                }

                int units;
                try {
                    units = Integer.parseInt(sUnit);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null,"Units Consumed must be a valid whole number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                totalBill = String.valueOf((units * 10) + 45 + 20 + 58 + 5 + 18);

                // 3. Database operation
                DataBase db = new DataBase();
                db.statement.executeUpdate("insert into calculate_bill values('" + sMeterNum + "','" + sMonth + "','" + units + "','" + totalBill + "','Not Paid')");
                JOptionPane.showMessageDialog(null, "Bill Calculated ");
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if(e.getSource() == cancel){
            new Main("");
            setVisible(false);

        }
    }

    public static void main(String[] args){
        new CalculateBill();
    }
}