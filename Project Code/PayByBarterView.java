import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PayByBarterView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String itemid;
	private String sellerid;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayByBarterView window = new PayByBarterView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public PayByBarterView() {
		//initialize();
	}

	public void init(String itemid , String sellerid){
		this.itemid = itemid;
		this.sellerid = sellerid;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1017, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(63, 59, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add a Wishlist");
		btnNewButton_1.setBounds(379, 59, 158, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Message Inbox");
		btnNewButton_2.setBounds(594, 59, 158, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBounds(807, 59, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame.setVisible(false);
				LoginView lv=new LoginView();	LoginController loginController=new LoginController(lv);
			}
		});
		JLabel lblNewLabel_1 = new JLabel("Item Name");
		lblNewLabel_1.setBounds(122, 207, 120, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Item Description");
		lblNewLabel_2.setBounds(123, 273, 138, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("Send Barter Request");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);
			    Message message=new Message();
				Item i=new Item();
				System.out.println("item id in barter view");
				System.out.println(itemid);
				i.set_itemid(itemid);   /// item id is still of the item he wants to buy
				i.set_itemprice(textField_2.getText());
				i.set_itemdesc(textField_1.getText());
				i.set_itemname(textField.getText());
				i.set_sellerid(sellerid); /// id of the user who put the item for selling
				message.setMessageType("barter");
				message.setItem(i);
				MessageController mc=new MessageController();
				mc.sendMessage(message);
				JOptionPane.showMessageDialog(frame, "Barter request sent successfully");
			    
			}
		});
		
		btnNewButton_4.setBounds(355, 598, 218, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBounds(379, 199, 194, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(383, 273, 312, 77);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblItemPrice = new JLabel("Item Price");
		lblItemPrice.setBounds(140, 392, 121, 20);
		frame.getContentPane().add(lblItemPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(391, 389, 304, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
