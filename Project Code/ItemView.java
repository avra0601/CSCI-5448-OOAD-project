import java.awt.EventQueue;
 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Button;

public class ItemView {
	 ItemController cat_controller=new ItemController();
	private JFrame frame;
	private JTextField name_field;
	private JTextField price_field;
	private JTextField desc_field;
	JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public ItemView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	String file;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblSelectCategory = new JLabel("Select Category");
		lblSelectCategory.setBounds(222, 146, 127, 20);
		frame.getContentPane().add(lblSelectCategory);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(220, 201, 100, 20);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblMinimumBidPrice = new JLabel("Minimum Bid Price ");
		lblMinimumBidPrice.setBounds(220, 256, 137, 20);
		frame.getContentPane().add(lblMinimumBidPrice);
		
		JLabel lblItemDescription = new JLabel("Item Description");
		lblItemDescription.setBounds(220, 331, 129, 20);
		frame.getContentPane().add(lblItemDescription);

		name_field = new JTextField();
		name_field.setBounds(523, 198, 146, 26);
		frame.getContentPane().add(name_field);
		name_field.setColumns(10);
		
		price_field = new JTextField();
		price_field.setBounds(523, 253, 146, 26);
		frame.getContentPane().add(price_field);
		price_field.setColumns(10);
		
		desc_field = new JTextField();
		desc_field.setBounds(523, 301, 156, 80);
		frame.getContentPane().add(desc_field);
		desc_field.setColumns(10);
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setBounds(523, 408, 228, 20);
		JButton btnUploadPicture = new JButton("Upload Picture");
		btnUploadPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  JFileChooser fc = new JFileChooser();
			        int result = fc.showOpenDialog(null);
			        if (result == JFileChooser.APPROVE_OPTION) {
			            File file1 = fc.getSelectedFile();
			            file = file1.getAbsolutePath(); //THIS WAS THE PROBLEM
			           
			            JLabel image = new JLabel("", new ImageIcon(file), JLabel.CENTER);
			            lblLocation.setText(file);
			          
			            frame.revalidate(); //ADD THIS AS WELL
			            frame.repaint();  //ADD THIS AS WELL
			    
			        
			        }
				
				
			}
		});
		btnUploadPicture.setBounds(336, 404, 156, 29);
		frame.getContentPane().add(btnUploadPicture);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cat=comboBox.getSelectedItem().toString();
			String item_name=name_field.getText();
			String item_desc=desc_field.getText();
			String min_price=price_field.getText();
		
			cat_controller.addItem(cat, item_name, item_desc, min_price,file);
			JOptionPane.showMessageDialog(frame, "Item Added Successfully");
			}
		});
		btnSubmit.setBounds(346, 478, 127, 51);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			name_field.setText("");
			desc_field.setText("");
			price_field.setText("");
		
			
			}
		});
		btnClear.setBounds(346, 550, 127, 51);
		frame.getContentPane().add(btnClear);
		
		comboBox = new JComboBox();
		comboBox.setBounds(523, 143, 146, 26);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAddANew = new JLabel("Add a New Item");
		lblAddANew.setBounds(346, 95, 146, 20);
		frame.getContentPane().add(lblAddANew);
		
		Button button = new Button("DashBoard");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SellerDashboardView sv=new SellerDashboardView();
				frame.setVisible(false);
			}
		});
		button.setBounds(94, 44, 91, 27);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Message Inbox");
		button_1.setBounds(415, 44, 137, 27);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Logout");
		button_2.setBounds(632, 44, 91, 27);
		frame.getContentPane().add(button_2);
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginView lv=new LoginView();
				LoginController loginController=new LoginController(lv);
			}
		});
	
		frame.getContentPane().add(lblLocation);
	 List<String> categories=new ArrayList<String>();
		 
	
		  categories=cat_controller.getCategories();
		 for(String x:categories)
		 comboBox.addItem(x);
		 User u=new User();
	 
	}
	 public void loadCategories()
	 {
	
	 }
}