import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class SellerInfoView {

	private JFrame frame;
String userid;
	/**
	 * Launch the application.
*/

	/**
	 * Create the application.
	 */
	public SellerInfoView() {
	 
	}
public void set_userid(String userid)
{
	this.userid=userid;
	initialize();
}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1063, 860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BuyerDashboardView bv=new BuyerDashboardView();
			frame.setVisible(false);
			}
			
		});
		btnDashboard.setBounds(59, 75, 115, 29);
		frame.getContentPane().add(btnDashboard);
		
		JButton btnMessageBox = new JButton("Message Box");
		btnMessageBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMessageBox.setBounds(363, 75, 152, 29);
		frame.getContentPane().add(btnMessageBox);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(545, 75, 115, 29);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginView lv=new LoginView();
				LoginController loginController=new LoginController(lv);
			}
		});
		JTextPane textPane = new JTextPane();
		textPane.setBounds(196, 190, 559, 411);
		frame.getContentPane().add(textPane);
		frame.setVisible(true);
		SellerInfoController sc=new SellerInfoController();
	 
		User seller=sc.getSellerInfo(userid);
		String output="Name\t\t:\t\t" + seller.getName()+"\n\n";
		output+="Address\t\t:\t\t"+seller.getAddress()+"\n\n";
		output+="Email\t\t:\t\t"+seller.getEmail()+"\n\n";
		output+="Phone\t\t:\t\t"+seller.getPhone()+"\n\n";
		textPane.setText(output);
	}
}
