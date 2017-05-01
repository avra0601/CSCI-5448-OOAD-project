
public  class User {
private static String userid;
private  static String username;

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


}
