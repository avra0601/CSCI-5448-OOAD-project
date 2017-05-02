import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MessageBoxView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
 

	/**
	 * Create the application.
	 */
	public MessageBoxView() {
		initialize();
	}
	JButton btnSelectWinner;
	/**
	 * Initialize the contents of the frame.
	 */
	Message messages[];
	JList list;
	DefaultListModel model;
	String itemid=null;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1014, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(400, 69, 159, 29);
		frame.getContentPane().add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 155, 516, 464);
		frame.getContentPane().add(scrollPane);
		
		JButton  btnNewButton3 = new JButton("Pay");
		btnNewButton3.setBounds(430, 637, 148, 29);
		frame.getContentPane().add(btnNewButton3);
		btnNewButton3.setVisible(false);
		
		JButton  btnNewButton4 = new JButton("Approve Barter");
		btnNewButton4.setBounds(430, 637, 148, 29);
		frame.getContentPane().add(btnNewButton4);
		btnNewButton4.setVisible(false);

		model=new DefaultListModel();
		 list = new JList(model);
		 list.addListSelectionListener(new ListSelectionListener() {
		 	public void valueChanged(ListSelectionEvent arg0) {
		 		Message selected_msg=messages[list.getSelectedIndex()];
				System.out.println(selected_msg.getMessageType());
		 		if(selected_msg.getMessageType().equals("bid"))
				{
					btnSelectWinner.setVisible(true);
					
					
				}
		 		else if(selected_msg.getMessageType().equals("win"))
				{
					
					btnSelectWinner.setVisible(false);
					btnNewButton3.setVisible(true);
					
				}
		 		else if(selected_msg.getMessageType().equals("barter")){
		 			btnSelectWinner.setVisible(false);
					btnNewButton4.setVisible(true);
		 		}
		 		
		 	}
		 });
		scrollPane.setViewportView(list);
		
		 btnSelectWinner = new JButton("Select Winner");
		 btnSelectWinner.setVisible(false);
		btnSelectWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Message selected_mess=messages[list.getSelectedIndex()];
			itemid=selected_mess.getMessage().substring(10,14);
			
			Message message=new Message();
			Item i=new Item();
			i.set_itemid(itemid);
			ItemController ic=new ItemController();
			Item item=ic.getItem(itemid);
			item.set_sellerid(list.getSelectedValue().toString().substring(22,26));
			System.out.println(list.getSelectedValue().toString().substring(22,26));
			item.set_itemprice("100");
			item.set_itemid(itemid);
			message.setMessageType("win");
			message.setItem(item);
			MessageController mc=new MessageController();
			
			mc.sendMessage(message);
			JOptionPane.showMessageDialog(frame, "Winner has been notified");
			
			}
		});
		
		
		btnSelectWinner.setBounds(430, 637, 148, 29);
		frame.getContentPane().add(btnSelectWinner);
		fillMessageBox(model);
		
		
		
		
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);
			    
			    //Call pay controller and pass the item id
			    Message selected_mess=messages[list.getSelectedIndex()];
				String id=selected_mess.getMessage().substring(10,14);
				ItemController ic=new ItemController();
				String seller_id = ic.getItem(id).get_sellerid();
				PaymentOptionsView pv = new PaymentOptionsView();
				pv.init(id.toString(),seller_id.toString());
				System.out.println("item id is");
				System.out.println(id);
				System.out.println("sellerId");
				System.out.println(seller_id);
				
			}
		});
		
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frame.setVisible(false);
			    
			    //Call pay controller and pass the item id
			    
			    System.out.println(list.getSelectedValue().toString().substring(14,18));
			    
				String id=list.getSelectedValue().toString().substring(13,17);
				PaymentController pc = new PaymentController();
				pc.updatePaymentStatus(id);
				
				System.out.println("Sold Item");
				System.out.println(id);
				
			}
		});
		
	}
	public void fillMessageBox(DefaultListModel model)
	{
		MessageController mc=new MessageController();
	
		List<Message> ml=	mc.retrieveMessages();
		int length=0;
		messages=new Message[ml.size()];
   		int i=0;
		for(Message x:ml)
		{
			model.addElement(x.getMessage());
			messages[i++]=x;
		
		}
		 

	}
}
