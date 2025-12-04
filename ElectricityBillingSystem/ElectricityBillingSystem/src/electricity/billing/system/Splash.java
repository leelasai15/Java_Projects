package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/Splash.jpg"));
        Image image1Scaling = image1.getImage().getScaledInstance(500,700, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image1Scaling);
        JLabel jImage1 = new JLabel(imageIcon1);
        jImage1.setBounds(0, 0, 500, 700);
        add(jImage1);

        setLayout(null);
        setSize(500,700);
        setBounds(400,100,500,700);
        setVisible(true);

        try{
            Thread.sleep(2000);
            new Login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static  void main(String[] args){
        new Splash();
    }
}
