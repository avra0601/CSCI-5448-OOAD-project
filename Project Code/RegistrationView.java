
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;
import java.awt.event.ActionListener;
 

public class RegistrationView extends JFrame
  { 

	
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9;

    JTextField textField1, textField2, textField5, textField6, textField7;

    JButton btn1, btn2 , btn3;

    JPasswordField p1, p2;

 

    RegistrationView()
     {

        setVisible(true);

        setSize(700, 700);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 

        l1 = new JLabel("Registration");
 
 

        l2 = new JLabel("Name:");

        l3 = new JLabel("Email-ID:");

        l4 = new JLabel("Create Passowrd:");

        l5 = new JLabel("Confirm Password:");

        l6 = new JLabel("Address:");

        l7 = new JLabel("Gender:");

        l8 = new JLabel("Phone No:"); 
        
        l9 =  new JLabel("Registration Successful");
        l9.setVisible(false);

        textField1 = new JTextField();

        textField2 = new JTextField();

        p1 = new JPasswordField();

        p2 = new JPasswordField();

        textField5 = new JTextField();

        textField6 = new JTextField();

        textField7 = new JTextField();

 

        btn1 = new JButton("Submit");

        btn2 = new JButton("Clear");
        
        btn3= new JButton("close");

 


 

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(90, 70, 200, 30);

        l3.setBounds(90, 110, 200, 30);

        l4.setBounds(90, 150, 200, 30);

        l5.setBounds(90, 190, 200, 30);

        l6.setBounds(90, 230, 200, 30);

        l7.setBounds(90, 270, 200, 30);

        l8.setBounds(90, 310, 200, 30);

        textField1.setBounds(300, 70, 200, 30);

        tf2.setBounds(300, 110, 200, 30);

        p1.setBounds(300, 150, 200, 30);

        p2.setBounds(300, 190, 200, 30);

        textField5.setBounds(300, 230, 200, 30);

        tf6.setBounds(300, 270, 200, 30);

        textField7.setBounds(300, 310, 200, 30);

        btn1.setBounds(50, 350, 100, 30);

        btn2.setBounds(170, 350, 100, 30);
        
        l9.setBounds(300 , 450 , 200 , 30);
        
        btn3.setBounds(50, 520, 100, 30);
        
        

 

        add(l1);

        add(l2);

        add(textField1);

        add(l3);

        add(textField2);

        add(l4);

        add(p1);

        add(l5);

        add(p2);

        add(l6);

        add(textField5);

        add(l7);

        add(textField6);

        add(l8);

        add(textField7);

        add(btn1);

        add(btn2);
        
        add(btn3);
        add(l9);

    }
	void addSubmitListener(ActionListener listenRegisterButton){
		
		btn1.addActionListener(listenRegisterButton);
		
	}
 

	String getUserName()
	{
		return textField1.getText();
	}
String getEmail(){
		
		return textField2.getText();
		
	}
String getAddress(){
	
	return textField5.getText();
	
}
String getGender(){
	
	return textField6.getText();
	
}
String getPhone(){
	
	return textField7.getText();
	
}
	
  }
 