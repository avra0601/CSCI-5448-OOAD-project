

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {
	public void updateItemsBought(String buyerid,String itemid)
	{
		String user=buyerid;
		DatabaseController db=new DatabaseController();
		Connection conn=db.getConnection();
		try {
			Statement stmt=conn.createStatement();
			String sql="Insert into items_bought values(\""+user+"\",\""+itemid+"\");";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updatePaymentStatus(String itemid)  
	{
		
		DatabaseController db=new DatabaseController();
		Connection conn=db.getConnection();
		Statement stmt = null;
		Statement stmt2 = null;
		try {
			stmt = conn.createStatement();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="update item set status="+0+" where itemid=\""+itemid+"\"";
		//String sql2="update bid set status="+0+" where itemid=\""+itemid+"\"";
		System.out.println(sql);
		
		try {
		 stmt.executeUpdate(sql);
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ItemController ic = new ItemController();
		Item i = ic.getItem(itemid);
		System.out.println("vishnu");
		System.out.println(i.get_itemid());
		i.set_itemstatus(0);
		

	}

	

}
