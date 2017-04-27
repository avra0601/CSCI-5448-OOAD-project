import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class BidView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public String itemid;
	public String id;
	public BidView() {
		
	}
public void init(String itemid)
{
	this.itemid=itemid;
	id=itemid.toString();
	initialize();

}
DefaultListModel model;
	/**
	 * Initialize the contents of the frame.
	 */
JList list;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1013, 719);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(90, 70, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("WishList");
		btnNewButton_1.setBounds(315, 70, 115, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Message Inbox");
		btnNewButton_2.setBounds(519, 70, 146, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBounds(775, 70, 115, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Bid  Information");
		lblNewLabel.setBounds(391, 136, 146, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 172, 618, 296);
		frame.getContentPane().add(scrollPane);
		model=new DefaultListModel();
		 list = new JList(model);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_1 = new JLabel("Post Bid Price");
		lblNewLabel_1.setBounds(346, 533, 115, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(519, 530, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		 
		JButton btnNewButton_4 = new JButton("Post your Bid");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BidController bc=new BidController();
			bc.addBid(itemid,textField.getText() );
			
			}
		});
		btnNewButton_4.setBounds(159, 618, 146, 29);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View Seller Information");
		btnNewButton_5.setBounds(530, 618, 217, 29);
		frame.getContentPane().add(btnNewButton_5);
		System.out.println(id);
	/*	BidController bc=new BidController();
		 
			 
			list.setFont(new Font("Tahoma", Font.BOLD, 25));
			//c1=new ItemController();
			 
			List<String> l1=bc.getBidInformation(id);
		
			for(String x:l1){
				model.addElement(x);
			System.out.println(x);
			}*/
		displayBidInfo(model);
	}
	
public void displayBidInfo(DefaultListModel model)
{
	BidController bc=new BidController();
	 this.model=model;
		 
		list.setFont(new Font("Tahoma", Font.BOLD, 25));
		//c1=new ItemController();
		 
		List<String> l1=bc.getBidInformation(itemid);
	
		for(String x:l1){
			model.addElement(x);
		System.out.println(x);
		}
}
}
