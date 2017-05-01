import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
public class LoginController {
	private LoginView theView;
	 Connection conn = null;
	   Statement stmt = null;
	    final String USER = "root";
	  final String DB_URL = "jdbc:mysql://localhost/test";
	  final String PASS = "";
	  
	  
	public boolean checkLogin(String user,String password)
	{
		
		
		try{
		  
		      Class.forName("com.mysql.jdbc.Driver");

		      conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = (Statement) conn.createStatement();

		      String sql = "SELECT userid from users where userid=\""+theView.getUserName()+"\" and password=\""+theView.getPassword()+"\"";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      
		      if(rs.next()){
		         //Retrieve by column name
		    //	  JOptionPane.showMessageDialog(theView.frame, "You are successfully logged in");
		     User u=new User();
		     u.setUserId(user);
		  // ItemView v1=new ItemView();
		       //CategoryView v1=new CategoryView();
		     return true;
		      }
		      else
		      {
		    	  return false;
		    	    //JOptionPane.showMessageDialog(theView.frame, "Invalid username/password");
		      }
		       
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
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		
		
		return false;
		
		
	}
LoginController(LoginView v1)
{
	this.theView=v1;
	
	this.theView.addLoginListener(new ActionListener() {
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean check= checkLogin(theView.getUserName(),theView.getPassword());
			if(check)

			{
				
				JOptionPane.showMessageDialog(theView.frame, "You are successfully logged in");
			   if(v1.sellerChecked())
			   {
				  System.out.println("Seller");
			      SellerDashboardView sv=new SellerDashboardView();
			      theView.frame.setVisible(false);   /////*******Added to close the window
			   }
				   else if(v1.buyerChecked())
			   {
				   System.out.println("Buyer");
			   BuyerDashboardView bv=new BuyerDashboardView();
			   theView.frame.setVisible(false);  /////*******Added to close the window
			   }
				   else
						JOptionPane.showMessageDialog(theView.frame, "Please Select an option");
				
				
			}
			else
			{
				JOptionPane.showMessageDialog(theView.frame, "Invalid username/password");
				   
			}
		}
	});
	
}



}
