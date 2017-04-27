
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryController {
List<Item> l1=new ArrayList<Item>();

public List<Item> getItems(String cat)  
{
	
	DatabaseController db=new DatabaseController();
	Connection conn=db.getConnection();
	Statement stmt = null;
	try {
		stmt = conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String sql="SELECT itemid,itemname,itemdesc FROM item where Category=\"" +cat+"\";";
	ResultSet rs;
	try {
	 rs=stmt.executeQuery(sql);
	
	
	
	while(rs.next())
	{
	Item i1=new Item();
	i1.set_itemname(rs.getString("itemname"));
	i1.set_itemid(""+rs.getInt("itemid"));
	i1.set_itemdesc(rs.getString("itemdesc"));
	
	l1.add(i1);
	
	}}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return l1;
}

}
