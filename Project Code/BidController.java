import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BidController {
public List<String> getBidInformation(String itemid)
{
	List<String> bids=new ArrayList<String>();
	DatabaseController db=new DatabaseController();
	Connection conn=db.getConnection();
	try {
		Statement stmt=conn.createStatement();
		
		String sql="select * from bid where itemid=\""+itemid+"\";";
		System.out.println(sql);
		ResultSet rs=stmt.executeQuery(sql);	
		while(rs.next())
		{
			String id=rs.getString("userid");
			String price=rs.getString("bidprice");
			String text="User : " + id +"    Bid Price : " + price;
			bids.add(text);
			System.out.println(text);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bids;
}



public void addBid(String itemid,String price)
{
	DatabaseController db=new DatabaseController();
	Connection conn=db.getConnection();
	String sql1="Select * from bid where userid=\""+new User().getUserId()+"\" and itemid=\""+itemid+"\"";
	
	try {
		Statement stmt=conn.createStatement();
	ResultSet result=stmt.executeQuery(sql1);
	if(result.next())
	{
	stmt=conn.createStatement();
	sql1="update bid set bidprice=\""+price+"\""+" where userid=\""+new User().getUserId()+"\" and itemid=\""+itemid+"\"";
	System.out.println(sql1);
	stmt.executeUpdate(sql1);
	}
	else
	{
	String sql="Insert into bid values(\""+itemid+"\",\""+new User().getUserId()+"\",\""+price+"\")";
	
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	} 

}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
