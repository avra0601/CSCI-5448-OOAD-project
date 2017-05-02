import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JFrame;

public class PaymentOptionsView {

	private JFrame frame;
	private String itemid;
	private String sellerid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentOptionsView window = new PaymentOptionsView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentOptionsView() {
		
	}
	public void init(String itemid, String sellerid){
		this.itemid = itemid;
		this.sellerid = sellerid;
		System.out.println(itemid);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(43, 56, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wishlist");
		btnNewButton_1.setBounds(433, 56, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Message Inbox");
		btnNewButton_2.setBounds(607, 56, 145, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBounds(823, 56, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Pay By Card");
		btnNewButton_4.setBounds(351, 252, 215, 61);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pay By Barter");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);
			    
			    //Call pay controller and pass the item id
			    PayByBarterView pv = new PayByBarterView();
			    pv.init(itemid, sellerid);
			}
		});
		btnNewButton_5.setBounds(351, 384, 215, 61);
		frame.getContentPane().add(btnNewButton_5);
	}


}
