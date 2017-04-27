import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
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
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "Insert into users values(\"1001\" , \"" + name + "\",\"" +email+"\",\""+password+"\",\""+address+"\",\""+gender+"\",\""+phone+"\")";
		      
		      stmt.executeUpdate(sql);
 
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
			        	    URL myURL = new URL("http://www.avinashrmaharaj.com/sendingmail.php?website=Youhaveregistered&ipadd=0&email="+theModel.getEmail());
			        	    URLConnection myURLConnection = myURL.openConnection();
			        	    BufferedReader in = new BufferedReader(new InputStreamReader( myURLConnection.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) 
		    System.out.println(inputLine);
		in.close();
			        	} 
			        	catch (MalformedURLException e1) { 
			        	    // new URL() failed
			        	    // ...
			        		System.out.println("Failed");
			        	} 
			        	catch (IOException e2) {   
			        	    // openConnection() failed
			        	    // ...
			        		System.out.println("IO");
			        	}
					
					}

					catch(NumberFormatException ex){
						
					 
						
					}
				}
			});
		}
		
	 
		
	


}
