
public  class User {
protected static String userid;
protected  static String username;
protected String name;
protected String address;
protected String email;
protected String phone;
public String getPhone()
{
	return phone;
	
}

public void setPhone(String phone)
{
	this.phone=phone;
}
public void setUserId(String userid)
{
	this.userid=userid;
}
public String getUserId()
{
	return userid;
}
public static void userLogout()
{
	userid="";
	
}

public String getName()
{
	return name;
}
public String getAddress()
{
	return address;
}

public String getEmail()
{
	return email;
}
public void setName(String name)
{
	this.name=name;
}
public void setAddress(String address)
{
	this.address=address;
}
public void setEmail(String email)
{
	this.email=email;
}
}
