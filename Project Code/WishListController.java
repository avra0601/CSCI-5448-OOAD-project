
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.*;
public class WishListController {
	DatabaseController db=null;
	Connection conn=null;
	Statement stmt=null;
	
	
 
public void addToWishList(String itemid)
{
	DatabaseController db=new DatabaseController();
	/////////////************* added check
	String sql1 = "select * from wishlist where userid=" + new User().getUserId() + " and items=\""+itemid+"\";";
	System.out.println(sql1);
	ResultSet rs1 = null;
	try {
		Connection conn=db.getConnection();
		Statement stmt=conn.createStatement();
		
		 rs1 = stmt.executeQuery(sql1);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		if(rs1.isBeforeFirst()){
			System.out.println("already present in the wishlist");
		}
		else{
		String sql="Insert into wishlist values (" + new User().getUserId() + ",\""+itemid+"\")";
		System.out.println(sql);
		try {
			Connection conn=db.getConnection();
			Statement stmt=conn.createStatement();
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Item> getWishListItems()
{
	List<Item> l1=new ArrayList<Item>();
	
	DatabaseController db=new DatabaseController();
 conn=db.getConnection();
 stmt=db.getStatement();
	String sql="Select items from wishlist where userid=" + new User().getUserId();
	System.out.println(sql);
	try {
		ResultSet rs=stmt.executeQuery(sql);
	 
		 while(rs.next()){
			Item i1=new Item();
			
		String itemid=rs.getString("items")+"";
		i1.set_itemid(itemid);
		 sql="Select itemname from item where itemid=" + i1.get_itemid();
		System.out.println(sql);
		ResultSet result;
		result=null;
		Statement stmt1=conn.createStatement();
result=stmt1.executeQuery(sql);
String itemname="";
if(result.next())
itemname=result.getString("itemname");
		
	
i1.set_itemname(itemname);

		l1.add(i1);
	
	
		 }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return l1;
	
}




}
