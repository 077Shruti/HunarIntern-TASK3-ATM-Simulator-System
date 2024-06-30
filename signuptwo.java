import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class signuptwo extends JFrame implements ActionListener{
    JComboBox<String> rb,cat,in,edu,occ;
    JRadioButton scy,scn,accy,accn;
    JTextField adharfield,panfield;
    String formno;
    JButton next;

    

    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION -PAGE 2");
       

        JLabel details=new JLabel("Page 2: Additional Details");
        details.setFont(new Font("Raleway",Font.BOLD,22));
        details.setBounds(250,80,400,30);
        add(details);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] str={"Hindu","Muslim","Sikh","Christian","Other"};
        rb=new JComboBox<>(str);
        rb.setBounds(300,140,400,30);
        rb.setBackground(Color.WHITE);
        add(rb);

        JLabel category=new JLabel("Catgory");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);

        String[] str2={"General","OBC","SC","ST","Other"};
        cat=new JComboBox<>(str2);
        cat.setBounds(300,190,400,30);
        cat.setBackground(Color.WHITE);
        add(cat);

        JLabel income=new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,400,30);
        add(income);

        String[] str3={"Null","<1,50,000","<2,50,000","<5,00,000","10,00,000"};
        in=new JComboBox<>(str3);
        in.setBounds(300,240,400,30);
        in.setBackground(Color.WHITE);
        add(in);

        JLabel education=new JLabel("Educational/");
        education.setFont(new Font("Raleway",Font.BOLD,22));
        education.setBounds(100,290,200,30);
        add(education);

        JLabel qualification=new JLabel("Qualification");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        String[] str4={"Non-Graduation","Graduate","post-Graduation","Other"};
        edu=new JComboBox<>(str4);
        edu.setBounds(300,340,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);


        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String[] str5={"Salaried","Self-Employeed","Bussiness","Student","Retired","Other"};
        occ=new JComboBox<>(str5);
        occ.setBounds(300,390,400,30);
        occ.setBackground(Color.WHITE);
        add(occ);

        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        panfield=new JTextField();
        panfield.setFont(new Font("Raleway",Font.BOLD,14));
        panfield.setBounds(300,440,400,30);
        add(panfield);

        JLabel adhar=new JLabel("Adhar Numbar:");
        adhar.setFont(new Font("Raleway",Font.BOLD,22));
        adhar.setBounds(100,490,200,30);
        add(adhar);

        adharfield=new JTextField();
        adharfield.setFont(new Font("Raleway",Font.BOLD,14));
        adharfield.setBounds(300,490,400,30);
        add(adharfield);

        JLabel sc=new JLabel("Senior Citizen");
        sc.setFont(new Font("Raleway",Font.BOLD,22));
        sc.setBounds(100,540,200,30);
        add(sc);

        scy=new JRadioButton("Yes");
        scy.setBounds(300,540,100,30);
        scy.setBackground(Color.white);
        add(scy);

        scn=new JRadioButton("No");
        scn.setBounds(450,540,100,30);
        scn.setBackground(Color.white);
        add(scn);

        ButtonGroup sz=new ButtonGroup();
        sz.add(scy);
        sz.add(scn);


        JLabel acc=new JLabel("Existing Account:");
        acc.setFont(new Font("Raleway",Font.BOLD,22));
        acc.setBounds(100,590,200,30);
        add(acc);

        accy=new JRadioButton("Yes");
        accy.setBounds(300,590,100,30);
        accy.setBackground(Color.white);
        add(accy);

        accn=new JRadioButton("No");
        accn.setBounds(450,590,100,30);
        accn.setBackground(Color.white);
        add(accn);

        ButtonGroup ac=new ButtonGroup();
        ac.add(accy);
        ac.add(accn);
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
        String sreligion=(String)rb.getSelectedItem();
        String scateogory=(String)cat.getSelectedItem();
        String sincome=(String)in.getSelectedItem();
        String sedu=(String)edu.getSelectedItem();
        String socc=(String)occ.getSelectedItem();

        String scitizen="Null";
        if(scy.isSelected()){
            scitizen="Yes";
        }else if(scn.isSelected()){
            scitizen="No";
        }
        String sacc="Null";
        if(accy.isSelected()){
            sacc="Yes";
        }else if(accn.isSelected()){
            sacc="No";
        }
        String span=panfield.getText();
        String sadhar=adharfield.getText();
        
        try{
            conn c=new conn();
                String query="insert into signup2 values('"+formno+"','"+sreligion+"','"+scateogory+"','"+sincome+"','"+sedu+"','"+socc+"','"+span+"','"+sadhar+"','"+scitizen+"','"+sacc+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno).setVisible(true);

                

                
        }catch(Exception e){
            System.out.println(e);
        }


         
    }
    public static void main(String[] args) {
        new signuptwo("");
    }
    
    
}


