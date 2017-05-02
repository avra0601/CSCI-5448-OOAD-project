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
public class RegistrationController  {
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	   //  Database credentials
	    final String USER = "root";
	  final String DB_URL = "jdbc:mysql://localhost/test";
	  final String PASS = "";
	
		private RegistrationView theView;
		

		private RegistrationModel theModel;
	 public void addUser(String name,String email, String password,String address,String gender, String phone )
	 {
		 Connection conn = null;
		 PreparedStatement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      
		      //Added Prepared Statement
		      String insertSQL = "INSERT INTO users (Name, Email,password,Address,Gender,Phone) VALUES (?, ?,?,?,?,?)";
		      stmt = conn.prepareStatement(insertSQL);
		      stmt.setString(1, name);
		      stmt.setString(2, email);
		      stmt.setString(3, password);
		      stmt.setString(4, address);
		      stmt.setString(5, gender);
		      stmt.setString(6, phone);
		      stmt.executeUpdate();
 
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try    
	 }
	 
	
	 
		public RegistrationController(RegistrationView theView,RegistrationModel theModel) {
			this.theModel = theModel;
		 
			this.theView=theView;
			// Tell the View that when ever the calculate button
			// is clicked to execute the actionPerformed method
			// in the CalculateListener inner class
			
			this.theView.addSubmitListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					int firstNumber, secondNumber = 0;
					addUser(theView.getUserName(),theView.getEmail(),theView.getPassowrd(), theView.getAddress(),theView.getEmail(),theView.getPhone());
					// Surround interactions with the view with
					// a try block in case numbers weren't
					// properly entered
					theModel.setEmail(theView.getEmail());
					System.out.println(theView.getEmail());
					try{
						try {
							///MonChange
			        	    URL myURL = new URL("http://www.avinashrmaharaj.com/sendingmail.php?website=You have sucessfully registered on the SellFort App&ipadd=0&email="+theModel.getEmail());
			        	    URLConnection myURLConnection = myURL.openConnection();
			        	    BufferedReader in = new BufferedReader(new InputStreamReader( myURLConnection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
		    System.out.println(inputLine);
		in.close();
		theView.l9.setVisible(true);
		
			        	} 
			        	catch (MalformedURLException e1) { 
			        	    // new URL() failed
			        	    // ...
			        		System.out.println("Failed");
			        		theView.l9.setText("Incorrect Entries");
			        	} 
			        	catch (IOException e2) {   
			        	    // openConnection() failed
			        	    // ...
			        		System.out.println("IO");
			        		theView.l9.setText("Incorrect Entries");
			        	}
					
					}

					catch(NumberFormatException ex){
						
					 
						
					}
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
		
	 
		
	


}
