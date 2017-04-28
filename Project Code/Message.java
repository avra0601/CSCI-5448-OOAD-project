
public class Message {
private String messageId;
private String messageType;
	private String message;
	private String price;
	private Item item;
	public Item getItem()
	{
		return item;
	}
	public void setItem(Item item)
	{
		this.item=item;
	}
	 
public void setMessageId(String messageId)
{
	this.messageId=messageId;
}
public String gettMessageId()
{
	return messageId;
}

public void setMessageType(String messageType)
{
	this.messageType=messageType;
}

public String getMessageType( )
{
	return messageType;
}


public void setMessage(String message)
{
	this.message=message;
}

public String getMessage( )
{
	return message;
}




	
}
