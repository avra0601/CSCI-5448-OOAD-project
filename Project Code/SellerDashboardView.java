import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerDashboardView{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	 

	/**
	 * Create the application.
	 */
	public SellerDashboardView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1018, 723);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Message Inbox");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MessageBoxView mv=new MessageBoxView();
			}
		});
		btnNewButton.setBounds(484, 78, 164, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBounds(748, 78, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add a New Item");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ItemView iv=new ItemView();
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(360, 223, 224, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Items Added");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SellerItemsView iv=new SellerItemsView();
				//frame.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(360, 306, 224, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update Profile");
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			UpdateProfileView up =new UpdateProfileView();
			}
		});*/
		btnNewButton_4.setBounds(360, 416, 224, 29);
		frame.getContentPane().add(btnNewButton_4);
	}

}
