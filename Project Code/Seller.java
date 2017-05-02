import java.util.List;

public class Seller extends User{
	 	 
		private List<Item> items_sold;
		private int seller_rating;
		public List<Item> getItemsBought()
		{
			return items_sold;
			
		}
		public int getSellerRating()
		{
			return seller_rating;
		}
		public void setBuyerRating(int seller_rating)
		{
			this.seller_rating=seller_rating;
		}
		
		
	}

