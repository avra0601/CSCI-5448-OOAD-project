import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WishListView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
 
	ItemController c1;
	/**
	 * Create the application.
	 */
	public WishListView() {
		initialize();
	}
	JList list;
	/**
	 * Initialize the contents of the frame.
	 */
	DefaultListModel model;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1002, 633);
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
		btnNewButton.setBounds(58, 56, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Message Inbox");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MessageBoxView mv=new MessageBoxView();
			}
		});
		btnNewButton_1.setBounds(437, 56, 155, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(807, 56, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				LoginView lv=new LoginView();	LoginController loginController=new LoginController(lv);
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 244, 446, 248);
		frame.getContentPane().add(scrollPane);
		  model = new DefaultListModel();
		 
		list = new JList(model);
		list.setFont(new Font("Tahoma", Font.BOLD, 25));
		//c1=new ItemController();
		scrollPane.setViewportView(list);
		WishListController wc=new WishListController();
		List<Item> l1=wc.getWishListItems();
		for(Item x:l1)
			model.addElement(x.get_itemid() + " Name : " + x.get_itemname() );
		JButton btnNewButton_3 = new JButton("View Bid Description");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	if(list.getSelectedIndex()!=-1){	
	String id=list.getSelectedValue().toString().substring(0, 4);
	System.out.println("before From cat " + id);
	BidView bv=new BidView();
	bv.init(id.toString());
	
//	ItemDescriptionView v1=new ItemDescriptionView();
	
//	System.out.println("From cat " + id);
//	v1.set_itemid(id);
	frame.setVisible(false);
	}
	else{
		JOptionPane.showMessageDialog(frame, "Please Select an item");
	}
			}
		});
		btnNewButton_3.setBounds(404, 532, 206, 29);
		frame.getContentPane().add(btnNewButton_3);
 
			
	}
}