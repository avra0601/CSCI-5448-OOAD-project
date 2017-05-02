import java.util.List;

public class Buyer extends User{
 
	private List<Item> items_bought;
	private int buyer_rating;
	public List<Item> getItemsBought()
	{
		return items_bought;
		
	}
	public int getBuyerRating()
	{
		return buyer_rating;
	}
	public void setBuyerRating(int buyer_rating)
	{
		this.buyer_rating=buyer_rating;
	}
	
	
}
