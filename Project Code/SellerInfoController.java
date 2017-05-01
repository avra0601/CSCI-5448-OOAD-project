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



	public void viewSellerInfo(String userid)
	{
		//Todo
		
	}
}
