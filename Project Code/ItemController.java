import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ItemController {
List<String> categories=new ArrayList<String>();
 

Connection conn = null;
Statement stmt = null;
final String USER = "root";
final String DB_URL = "jdbc:mysql://localhost/test";
final String PASS = "";
 
 
 public void addItem(String cat,String name, String item_desc, String min_price,String file)
 {

     try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     try {
		stmt = (Statement) conn.createStatement();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
     try {
		conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     try {
		stmt = (Statement) conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     String sql = "insert into item (userid,itemname,itemdesc,category,minprice,picture) values("+new User().getUserId()+",\""+name+"\",\"" + item_desc+"\",\"" +cat+"\",\""+min_price+"\",?);";
     System.out.println(sql);
     InputStream inputStream;
	try {
		inputStream = new FileInputStream(new File(file));
	 
 
 
	PreparedStatement statement;
		statement = conn.prepareStatement(sql);
	
		statement.setBlob(1, inputStream);
		statement.executeUpdate();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     
     
 }
 
 public Item getItem(String itemid)
 {
	 Item i=null;
	 DatabaseController db=new DatabaseController();
	 Connection conn=db.getConnection();
	 Statement stmt=db.getStatement();
	 String sql="SELECT * FROM item where itemid=\""+itemid+"\";";
	 System.out.println(sql);
	 try {
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			 i=new Item();
			String sellerid=rs.getString("userid");
			String name = rs.getString("itemname");
			String desc=rs.getString("itemdesc");
			 byte[] img = rs.getBytes("picture");

				i.set_itemname(name);
				i.set_sellerid(sellerid);
i.set_itemdesc(desc);
i.set_picture(img);
		 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return i;
	 
 }
 
	public List<String> getCategories()
	{
		

	      try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	      try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      String sql = "SELECT Cat_Name from categories";
	      ResultSet rs;
	      try {
		  rs = stmt.executeQuery(sql);
		
	     while(rs.next())
	     {
	    boolean b1=categories.add(rs.getString("Cat_Name"));
	    	 System.out.println(rs.getString("Cat_Name"));
	     }
	     
	     
	     
	      } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return categories;
	}
	
}
