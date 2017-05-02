
public class UserFactory {
		
		   //use getShape method to get object of type shape 
		   public User getUser(String userType){
		      if(userType == null){
		         return null;
		      }		
		      if(userType.equals("seller")){
		         return new Seller();
		         
		      } else if(userType.equals("buyer")){
		         return new Buyer();
		         
		      }
		      return null;
		   }
		}

