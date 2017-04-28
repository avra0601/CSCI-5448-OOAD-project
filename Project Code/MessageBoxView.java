import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
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
		JButton btnNewButton = new JButton("Dashboard");
		btnNewButton.setBounds(58, 69, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Message Inbox");
		btnNewButton_1.setBounds(512, 69, 159, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(785, 69, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 155, 516, 464);
		frame.getContentPane().add(scrollPane);
		
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
				else
					
				{
					btnSelectWinner.setVisible(false);
				}
		 	}
		 });
		scrollPane.setViewportView(list);
		
		 btnSelectWinner = new JButton("Select Winner");
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
			
			}
		});
		btnSelectWinner.setBounds(430, 637, 148, 29);
		frame.getContentPane().add(btnSelectWinner);
		fillMessageBox(model);
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
