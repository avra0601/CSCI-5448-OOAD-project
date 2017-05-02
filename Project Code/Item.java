import java.util.ArrayList;

public class Item implements Subject{

		String itemid;
		String itemname;
		String itemdesc;
		String itemprice;
		String itemcat;
		byte[] pic;
		String paymentstatus;
		String sellerid;
		int avail_status;

		private ArrayList<Observer> observers = new ArrayList<Observer>();
	
		public String get_sellerid()
		{
			return sellerid;
			
		}
		public void set_sellerid(String sellerid)
		{
			this.sellerid=sellerid;
			System.out.println(sellerid);
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
		
		public void set_itemstatus(int status){
			this.avail_status = status;
			notifyObservers();
			System.out.println("Inside item status");
		}
		
		public void registerObserver(Observer observer){
			
			observers.add(new WishListController());
			System.out.println("Added observer");
		}
		
		
		public void notifyObservers(){
			
			/*for (Observer ob: observers){
				System.out.println("Notifying observer about the changes");
				ob.update(this.avail_status,  this.itemid);
			}*/
			System.out.println("Notifying observer about the changes");
			WishListController wc = new WishListController();
			System.out.println(itemid);
			System.out.println(this.itemid);
			wc.update(avail_status, itemid);
			BidController bd = new BidController();
			bd.update(avail_status, itemid);
		}
		
	
}
