import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CategoryView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
 
	ItemController c1;
	/**
	 * Create the application.
	 */
	public CategoryView() {
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
		btnNewButton.setBounds(58, 56, 115, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Message Inbox");
		btnNewButton_1.setBounds(437, 56, 155, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(807, 56, 115, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(233, 244, 446, 248);
		frame.getContentPane().add(scrollPane);
		  model = new DefaultListModel();
		 
		list = new JList(model);
		list.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		scrollPane.setViewportView(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				CategoryController cc=new CategoryController();
				List<Item> l1=cc.getItems(comboBox.getSelectedItem().toString());
				// model=new DefaultListModel();
			System.out.println("changed");
				 //  list=new JList(model);
					model.clear();
					model.removeAllElements();
					//model.removeAllElements();
				    // Initialize the list with items
			 
				      int i=0;
				 
				for(Item x:l1)
				{
					
					String name=x.get_itemname();
					String id=x.get_itemid();
					String desc=x.get_itemdesc();
					String display="Item ID : " + id + " " + name+" Item Description : "+desc;
					model.addElement(display);
					 
				i++;
				}
			 
			 
			}
		});
		comboBox.setBounds(495, 138, 115, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose Category");
		lblNewLabel.setBounds(233, 141, 130, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("View Item Description");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	String id=list.getSelectedValue().toString().substring(10, 14);
	System.out.println("before From cat " + id);
	ItemDescriptionView v1=new ItemDescriptionView();
	
	System.out.println("From cat " + id);
	v1.set_itemid(id);
			}
		});
		btnNewButton_3.setBounds(404, 532, 206, 29);
		frame.getContentPane().add(btnNewButton_3);
	 c1=new ItemController();
		
		List<String> items=c1.getCategories();
		for( String x: items)
			comboBox.addItem(x);
			
	}
}