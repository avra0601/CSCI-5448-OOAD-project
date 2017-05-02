import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;

public class LoginView {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
void makeVisible() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
 
	
	}
	JButton btnLogin = new JButton("Login");
	private JButton btnSignUp;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnBuyer;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(216, 191, 216));
		frame.setBounds(100, 100, 706, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(145, 181, 111, 20);
		frame.getContentPane().add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(281, 175, 146, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(145, 224, 69, 20);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(281, 221, 146, 26);
		frame.getContentPane().add(passwordField);
		
		
		btnLogin.setBounds(281, 281, 115, 29);
		frame.getContentPane().add(btnLogin);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationView rView=new RegistrationView();
				RegistrationModel rModel=new RegistrationModel();
				RegistrationController rController=new RegistrationController(rView,rModel);
				rView.setVisible(true);
			
			}
		});
		btnSignUp.setBounds(281, 352, 115, 29);
		frame.getContentPane().add(btnSignUp);
		
		rdbtnNewRadioButton = new JRadioButton("Seller");
		rdbtnNewRadioButton.setBounds(140, 105, 155, 29);
		
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnBuyer = new JRadioButton("Buyer");
		rdbtnBuyer.setBounds(319, 105, 155, 29);
		frame.getContentPane().add(rdbtnBuyer);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnBuyer);
		
	}
	void addLoginListener(ActionListener listenForLoginButton){
		
		btnLogin.addActionListener(listenForLoginButton);
		
	}
	String getUserName()
	{
		return textField.getText();
	}
	String getPassword()
	{
		return passwordField.getText();
	}
	public boolean sellerChecked()
	{
		if(rdbtnNewRadioButton.isSelected())
		return true;
		else
		return false;
	}
	public boolean buyerChecked()
	{
		if(rdbtnBuyer.isSelected())
		return true;
		else
		return false;
	}
}
