import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class MessageController {
	
public List<Message>	retrieveMessages()
{
	List<Message> messages = new ArrayList<Message>();
	String sql="select * from message where r_userid=\""+new User().getUserId()+"\"";
	DatabaseController db=new DatabaseController();
	Connection conn=db.getConnection();
	try {
		Statement  stmt=conn.createStatement();
		
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			Message mess=new Message();
			mess.setMessage(rs.getString("message"));
			mess.setMessageId(""+rs.getInt("messageid"));
			mess.setMessageType(rs.getString("messagetype"));
		messages.add(mess);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return messages;
	
}
public void sendMessage(Message message)
{
	Item temp=message.getItem();
	String price=temp.get_itemprice();
	String itemid=temp.get_itemid();
	ItemController ic=new ItemController();
	Item i=new Item();
	
	Item  item=ic.getItem(itemid);
	
	DatabaseController db=new DatabaseController();
	Connection conn=db.getConnection();
	String m1=null;
	String receiverid=null;
	String senderid=null;
	if(message.getMessageType().equals("bid"))
	{
		receiverid=item.get_itemid();
		senderid=new User().getUserId();
		m1="Item ID : "+itemid+" User : " + senderid + " has bidded for the item " + item.get_itemname() + " Price : "+price;
		
	}
		else if(message.getMessageType().equals("win"))
	{
			receiverid=message.getItem().get_sellerid();
			 senderid=new User().getUserId();
	
		m1="Congratulations You have won the bid for the item " + item.get_itemname();
	
	}
		message.setMessage(m1);
	try {
		Statement stmt=conn.createStatement();
		String sql="insert into message (messagetype,message,s_userid,r_userid) values(\"" + message.getMessageType() +"\",\""+message.getMessage()+"\",\""+senderid + "\",\""+receiverid+"\" );";
System.out.println(sql);
stmt.executeUpdate(sql);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
