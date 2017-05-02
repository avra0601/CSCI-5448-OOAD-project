import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class BuyerItemsView {
	private JFrame frame;

	public BuyerItemsView() {
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
		
		
		BuyerInfoController bi=new BuyerInfoController();
		model=new DefaultListModel();
		list = new JList(model);
		List<String> l1=bi.getItemsBought(new User().getUserId());
		System.out.println("got items");
		
		for(String x:l1){
			model.addElement(x);
		System.out.println(x);
		}
		scrollPane.setViewportView(list);
 


}
}
