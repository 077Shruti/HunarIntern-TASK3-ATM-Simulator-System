import java.awt.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class signupone extends JFrame implements ActionListener{
    long random;
    JTextField namefield ,fnamefield,emailfield,addfield,cityfield,statefield,pinfield;
    JButton next;
    JRadioButton male,female,other,married,unmarried;
    JDateChooser date;
    

    signupone(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%9000L)+ 1000L);
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(120,20,600,40);
        add(formno);

        JLabel detail=new JLabel("Page 1: Personal Details");
        detail.setFont(new Font("Raleway",Font.BOLD,22));
        detail.setBounds(250,80,400,30);
        add(detail);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        namefield = new JTextField();
        namefield.setFont(new Font("Raleway",Font.BOLD,14));
        namefield.setBounds(300,140,400,30);
        add(namefield);

        JLabel fname=new JLabel("Father Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnamefield=new JTextField();
        fnamefield.setFont(new Font("Raleway",Font.BOLD,14));
        fnamefield.setBounds(300,190,400,30);
        add(fnamefield);

        JLabel dob=new JLabel("Date Of Birth");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,400,30);
        add(dob);

        date=new JDateChooser();
        date.setBounds(300,240,200,30);
        date.setForeground(new Color(105,105,105));
        add(date);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup group=new ButtonGroup();
        group.add(male);
        group.add(female);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailfield=new JTextField();
        emailfield.setFont(new Font("Raleway",Font.BOLD,14));
        emailfield.setBounds(300,340,400,30);
        add(emailfield);

        JLabel marital=new JLabel("Marital Status");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other=new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup mgroup=new ButtonGroup();
        mgroup.add(married);
        mgroup.add(unmarried);
        mgroup.add(other);

        JLabel address=new JLabel("Address");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        addfield=new JTextField();
        addfield.setFont(new Font("Raleway",Font.BOLD,14));
        addfield.setBounds(300,440,400,30);
        add(addfield);

        JLabel city=new JLabel("City");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityfield=new JTextField();
        cityfield.setFont(new Font("Raleway",Font.BOLD,14));
        cityfield.setBounds(300,490,400,30);
        add(cityfield);

        JLabel state=new JLabel("State");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        statefield=new JTextField();
        statefield.setFont(new Font("Raleway",Font.BOLD,14));
        statefield.setBounds(300,540,400,30);
        add(statefield);

        JLabel pincode=new JLabel("Pin Code");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pinfield=new JTextField();
        pinfield.setFont(new Font("Raleway",Font.BOLD,14));
        pinfield.setBounds(300,590,400,30);
        add(pinfield);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);
        setSize(800,750);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=namefield.getText();
        String fname=fnamefield.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender="Male";
        if(male.isSelected()){
            gender="Male";
        }else if(unmarried.isSelected()){
            gender="Female";
        }
        String email=emailfield.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addfield.getText();
        String city=cityfield.getText();
        String state=statefield.getText();
        String pin=pinfield.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                conn c=new conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }


         
    }
    public static void main(String[] args) {
        new signupone();
    }
    
    
}

