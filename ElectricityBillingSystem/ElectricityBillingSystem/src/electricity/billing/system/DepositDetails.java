package electricity.billing.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;

public class DepositDetails extends JFrame implements ActionListener {

    Choice searchMeterCho,searchMonthCho;
    JTable table;
    JButton search,print,close;

    DepositDetails(){
        super("Deposit Details");
        getContentPane().setBackground(new Color(192,186,254));
        setSize(700,500);
        setLocation(400,200);
        setLayout(null);

        JLabel searchMeter = new JLabel("Search By Meter Number");
        searchMeter.setBounds(20,20,170,20);
        add(searchMeter);

        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        try{
            DataBase db = new DataBase();
            ResultSet es = db.statement.executeQuery("Select * from new_customer");
            while(es.next()){
                searchMeterCho.addItem(es.getString("meter_num"));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

        JLabel searchMonth = new JLabel("Search By Month");
        searchMonth.setBounds(400,20,100,20);
        add(searchMonth);

        searchMonthCho = new Choice();


        searchMonthCho = new Choice();
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        searchMonthCho.setBounds(520,20,150,20);
        add(searchMonthCho);

        table = new JTable();
        try{
            DataBase c =new DataBase();
            ResultSet resultSet = c.statement.executeQuery("select * from calculate_bill");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,700,500);
        scrollPane.setBackground(Color.white);
        add(scrollPane);


        search = new JButton("Search");
        search.setBackground(Color.white);
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBackground(Color.white);
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        close = new JButton("Close");
        close.setBackground(Color.white);
        close.setBounds(600,70,80,20);
        close.addActionListener(this);
        add(close);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==search){
            String query_search = "select * from new_customer where meter_num = '"+searchMeterCho.getSelectedItem()+"' and name = '"+searchMonthCho.getSelectedItem()+"'" ;
            try{
                DataBase c = new DataBase();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==print)
        {
            try {
                boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, null, null, true, null, true);

                if (complete) {
                    JOptionPane.showMessageDialog(null, "Printing Complete", "Printer Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Printing Cancelled or Failed.", "Printer Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (PrinterException E) {
                JOptionPane.showMessageDialog(null, "ERROR: No print service found or printing failed.\nPlease ensure a printer (physical or virtual) is installed and running.", "Printing Error", JOptionPane.ERROR_MESSAGE);
                E.printStackTrace();
            } catch (Exception E) {
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new DepositDetails();
    }
}