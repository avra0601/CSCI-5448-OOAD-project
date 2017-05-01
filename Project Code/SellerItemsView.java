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

public class SellerItemsView {
	
	
	private JFrame frame;

	public SellerItemsView() {
		initialize();
	}
	JButton btnSelectWinner;
	/**
	 * Initialize the contents of the frame.
	 */
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
		SellerInfoController si=new SellerInfoController();
		model=new DefaultListModel();
		list = new JList(model);
		List<String> l1=si.getItemsAdded(new User().getUserId());
		System.out.println("got items");
		
		for(String x:l1){
			model.addElement(x);
		System.out.println(x);
		}
 


}
}