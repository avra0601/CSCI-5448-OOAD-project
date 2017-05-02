import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuyerDashboardView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the application.
	 */
	public BuyerDashboardView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1016, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton_1 = new JButton("Message Inbox");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MessageBoxView mv=new MessageBoxView();
			}
		});
		btnNewButton_1.setBounds(594, 56, 171, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(814, 56, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				frame.setVisible(false);
			LoginView lv=new LoginView();
			LoginController loginController=new LoginController(lv);
			}
			
		});
		JButton btnNewButton_3 = new JButton("Buy Items");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CategoryView iv=new CategoryView();
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(371, 190, 232, 55);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Items Bought");
		btnNewButton_4.setBounds(371, 278, 232, 55);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BuyerItemsView bv=new BuyerItemsView();
				
			}
		});
		
		JButton btnNewButton_5 = new JButton("WishList");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WishListView wv=new WishListView();
				frame.setVisible(false);
				
			}
		});
		btnNewButton_5.setBounds(371, 385, 232, 44);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Update Profile");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateProfileView wv=new UpdateProfileView();
				frame.setVisible(false);
				
			}
		});
		btnNewButton_6.setBounds(371, 489, 232, 44);
		frame.getContentPane().add(btnNewButton_6);
	}

}
