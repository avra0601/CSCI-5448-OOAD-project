import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;


public class UpdateProfileController {
	
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	   //  Database credentials
	    final String USER = "root";
	  final String DB_URL = "jdbc:mysql://localhost/test";
	  final String PASS = "";
	
		private UpdateProfileView theView;
		
		

	 	 
		public UpdateProfileController(UpdateProfileView theView) {
			//this.theModel = theModel;
		 
			this.theView=theView;
			System.out.println("Inside constructor of updatecontolr");
			// Tell the View that when ever the calculate button
			// is clicked to execute the actionPerformed method
			// in the CalculateListener inner class
			
			this.theView.addUpdatetListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					System.out.println("Inside update");

					int firstNumber, secondNumber = 0;
					System.out.println("Calling update");
					updateUser(theView.getUserName(),theView.getEmail(),theView.getPassowrd(), theView.getAddress(),theView.getEmail(),theView.getPhone());
					// Surround interactions with the view with
					// a try block in case numbers weren't
					// properly entered
					
				}
			});
			
			
			
			
			///********Added clear
			this.theView.clearListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					theView.tf1.setText("");
					theView.tf2.setText("");
					theView.tf5.setText("");
					theView.tf6.setText("");
					theView.tf7.setText("");
					theView.p1.setText("");
					theView.p2.setText("");
					
				}
			});
			
			////****** Added Close
			this.theView.closeListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					theView.setVisible(false);
					
				}
			});

		}
		
		public void updateName(String name){
		 	DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set Name=\""+name+"\""+" where userid=\""+new User().getUserId();
			System.out.println(sql1);
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 public void updateEmail(String email){
		 
		 DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set Email=\""+email+"\""+" where userid=\""+new User().getUserId();
			
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 
	 public void updatePassword(String password){
		 DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set password=\""+password+"\""+" where userid=\""+new User().getUserId();
			
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	
	 public void updateGender(String gender){
		 DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set Gender=\""+gender+"\""+" where userid=\""+new User().getUserId();
			
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 public void updatePhone(String phone ){
		 DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set Phone=\""+phone+"\""+" where userid=\""+new User().getUserId();
			
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 public void updateAddress(String address ){
		 DatabaseController db=new DatabaseController();
			Connection conn=db.getConnection();
			String sql1="update users set Address=\""+address+"\""+" where userid=\""+new User().getUserId();
			
			try {
				Statement stmt=conn.createStatement();
			    stmt.executeUpdate(sql1);
	
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }

	
		 public void updateUser(String name,String email, String password,String address,String gender, String phone )
			{
				if(name!=null){
					   updateName(name);
				}
				if(email!=null){
					   updateEmail(email);
				}
				if(address!=null){
					   updateAddress(address);
				}
				if(password!=null){
					   updatePassword(password);
				}
				if(gender!=null){
					   updateGender(gender);
				}
				if(phone!=null){
					   updatePhone(phone);
			}
				  
		}
		
				
	



}
