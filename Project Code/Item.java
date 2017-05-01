
public class Item {

	String itemid;
	String itemname;
	String itemdesc;
	String itemprice;
	String itemcat;
	byte[] pic;
	String paymentstatus;
	String sellerid;

	
public String get_sellerid()
{
	return sellerid;
	
}
public void set_sellerid(String sellerid)
{
	this.sellerid=sellerid;
}
	
public String get_itemid()
{
	return itemid;
	
}
public void set_itemid(String itemid)
{
	this.itemid=itemid;
}
public String get_itemname()
{
	return itemname;
	
}
public void set_picture(byte[] pic)
{
	this.pic=pic;
}
public byte[] get_picture()
{
	return pic;
	
}
public void set_itemname(String itemname)
{
	this.itemname=itemname;
}

public String get_itemdesc()
{
	return itemdesc;
	
}
public void set_itemdesc(String itemdesc)
{
	this.itemdesc=itemdesc;
}


public String get_itemprice()
{
	return itemprice;
	
}
public void set_itemprice(String itemprice)
{
	this.itemprice=itemprice;
}


public String get_itemcat()
{
	return itemcat;
	
}
public void set_itemcat(String itemcat)
{
	this.itemcat=itemcat;
}


	
}
