

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {
	
	public void updatePaymentStatus(String itemid)  
	{
		
		DatabaseController db=new DatabaseController();
		Connection conn=db.getConnection();
		Statement stmt = null;
		Statement stmt2 = null;
		try {
			stmt = conn.createStatement();
			//stmt2 = conn.createStatement();
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

	}

	

}
