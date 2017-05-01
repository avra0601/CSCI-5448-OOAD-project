import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ItemDescriptionView {

	private JFrame frame;
	private JTextField textField;
private String itemid;

	/**
	 * Launch the application.
	 */
 
	/**
	 * Create the application.
	 */
	public ItemDescriptionView() {
	
		
	}
public void set_itemid(String id)
{
	itemid=id;
	initialize();
	
}
JLabel lblNewLabel_1 ;
	/**
	 * Initialize the contents of the frame.
	 */
JLabel lblNewLabel;
JLabel itemnamelabel ;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1069, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Dashboard");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BuyerDashboardView bv=new BuyerDashboardView();
			frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(49, 57, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wishlist");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WishListView v1=new WishListView();
			}
		});
		btnNewButton_1.setBounds(274, 57, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Message Inbox");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
MessageBoxView mv=new MessageBoxView();
			}
		});
		btnNewButton_2.setBounds(521, 57, 156, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBounds(811, 57, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		 lblNewLabel_1 = new JLabel("Item Description");
		lblNewLabel_1.setBounds(158, 496, 156, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(454, 469, 242, 74);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Add to Wishlist");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			WishListController wc=new WishListController();
			wc.addToWishList(itemid);
			JOptionPane.showMessageDialog(frame, "Item successfully added to Wish List");
			}
		});
		btnNewButton_4.setBounds(418, 583, 195, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		  itemnamelabel = new JLabel("Item Name : ");
		itemnamelabel.setBounds(401, 130, 147, 20);
		frame.getContentPane().add(itemnamelabel);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(373, 180, 393, 254);
		frame.getContentPane().add(lblNewLabel);
		displayItem();
		
		JButton btnNewButton5 = new JButton("Close");
		btnNewButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			frame.setVisible(false);
			}
		});
		btnNewButton5.setBounds(418, 620, 195, 29);
		frame.getContentPane().add(btnNewButton5);
	}
	public void displayItem()
	{
		ItemController c1=new ItemController();
		
		Item i1=c1.getItem(itemid);
byte[] img=null;
		String itemname=null;
		String itemdesc=null;
		
			itemname=i1.get_itemname();
		itemdesc=i1.get_itemdesc();
		img=i1.get_picture();
	
		
		
			itemnamelabel.setText("Item Name : "+itemname);
		
			
			  ImageIcon image = new ImageIcon(img);
              Image im = image.getImage();
              Image myImg = im.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
              ImageIcon newImage = new ImageIcon(myImg);
              lblNewLabel.setIcon(newImage);
              textField.setText(itemdesc);
			
	}
}