import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class login extends JFrame implements ActionListener{
    JButton login, clear,singup;
    JTextField textfield;
    JPasswordField pinfield;
    login(){
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons\\logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,400,40);
        add(cardno);
         
        textfield=new JTextField();
        textfield.setBounds(300,150,250,30);
        textfield.setFont(new Font("Arial",Font.BOLD,14));
        add(textfield);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,400,40);
        add(pin);

        pinfield=new JPasswordField();
        pinfield.setBounds(300,220,250,30);
        add(pinfield);

        login=new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        add(login);
        login.addActionListener(this);
         
         clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        add(clear); 
        clear.addActionListener(this);


        singup=new JButton("SIGN UP");
        singup.setBounds(300,350,230,30);
        singup.setBackground(Color.BLACK);
        singup.setForeground(Color.white);
        add(singup); 
        singup.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,150);
        setTitle("AUTOMATIC TELLER MACHINE");

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            textfield.setText("");
            pinfield.setText("");

        }
        else if(ae.getSource()==login){
            conn c=new conn();
            String cardnumber=textfield.getText();
            String pinnumber=pinfield.getText();
            String query="select * from login where Cardnumber='"+cardnumber+"' and Pinnumber='"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==singup){
            setVisible(false);
            new signupone().setVisible(true);

        }
    }
   
    public static void main(String[] args) {
        new login();
        
    }
    
}
