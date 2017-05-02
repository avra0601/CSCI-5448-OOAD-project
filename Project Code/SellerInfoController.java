import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

public class SellerInfoController {
	
	public String userid;
	
	public List<String> getItemsAdded(String userid)
	{
		List<String> Items=new ArrayList<String>();
		DatabaseController db=new DatabaseController();
		Connection conn=db.getConnection();
		try {
			Statement stmt=conn.createStatement();
			
			String sql="select * from item where userid=\""+userid+"\";";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);	
			while(rs.next())
			{
				String id=rs.getString("itemid");
				String itemname=rs.getString("itemname");
				String price = rs.getString("minprice");
			 
				String text="Item : " + id +" "+ itemname +"   Price : " + price;
				Items.add(text);
				System.out.println(text);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Items;
	}




	public List<Item> getItemsSold(String userid)
	{
		List<Item> Items=new ArrayList<Item>();
		DatabaseController db=new DatabaseController();
		Connection conn=db.getConnection();
		try {
			Statement stmt=conn.createStatement();
			
			String sql="select * from item where userid="+userid+" and status=0;";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);	
			while(rs.next())
			{
				String itemid=rs.getString("itemid");
			Item i1=new Item();
			ItemController ic=new ItemController();
			i1=ic.getItem(itemid);
			Items.add(i1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Items;
	}



	public User getSellerInfo(String userid)
	{
		UserFactory uf=new UserFactory();
		User u=uf.getUser("seller");
		
	    DatabaseController db=new DatabaseController();
     	Connection conn=db.getConnection();
	    try {
	 	    Statement stmt=conn.createStatement();
	    	String sql="Select * from users where userid="+userid+";";
		
		    ResultSet rs=stmt.executeQuery(sql);
		    while(rs.next())
		     {
		    	u.setUserId(userid);
		    	String name=rs.getString("Name");
		    	String email=rs.getString("Email");
		    	String address=rs.getString("Address");
		    	String phone=rs.getString("Phone");
				u.setName(name);
				u.setEmail(email);
				u.setAddress(address);
				u.setPhone(phone);
			    List<Item> l1=getItemsSold(userid);
			    
				
		}
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		return u;
		
		//Todo
		
		
		
	}
}
