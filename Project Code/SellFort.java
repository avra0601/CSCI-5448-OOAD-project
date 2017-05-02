import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.*;

//import javafx.scene.layout.Region;
public class SellFort  
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
 /*
		JFrame f=new JFrame();//creating instance of JFrame
		JTextField t1=new JTextField("");	
		JTextField t2=new JTextField("");
		JButton b=new JButton("click");//creating instance of JButton
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height
				t1.setBounds(100,100,100,100);
				t2.setBounds(200,200,200,200);
				f.add(t1);
				f.add(t2);
		f.add(b);//adding button in JFrame
				
		f.setSize(400,500);//400 width and 500 height
		f.setLayout(null);//using no layout managers
		f.setVisible(true);//making the frame visible
		 
	    b.addActionListener(new ActionListener() {
	    	//@Override
	        public void actionPerformed(ActionEvent ae){
	        	int a=Integer.parseInt(t1.getText());
	        	int b=Integer.parseInt(t2.getText());
	        	int c=a+b;
	        	JOptionPane.showMessageDialog(null, "The answer is " +c );
	        	try {
	        	    URL myURL = new URL("http://www.avinashrmaharaj.com/sendingmail.php?website=Theresultis"+c+"&ipadd=0&email=avinashrmaharaj@hotmail.com");
	        	    URLConnection myURLConnection = myURL.openConnection();
	        	    BufferedReader in = new BufferedReader(new InputStreamReader( myURLConnection.getInputStream()));
String inputLine;
while ((inputLine = in.readLine()) != null) 
    System.out.println(inputLine);
in.close();
	        	} 
	        	catch (MalformedURLException e) { 
	        	    // new URL() failed
	        	    // ...
	        		System.out.println("Failed");
	        	} 
	        	catch (IOException e) {   
	        	    // openConnection() failed
	        	    // ...
	        		System.out.println("IO");
	        	}
	        	
	        
	        }
	       });

		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/
	//	SellerInfoView sv1=new SellerInfoView();
		LoginView rView1=new LoginView();
		LoginController loginController=new LoginController(rView1);
		//RegistrationView rView=new RegistrationView();
		//RegistrationModel rModel=new RegistrationModel();
	//	RegistrationController rController=new RegistrationController(rView,rModel);
		//rView.setVisible(true);
		
		//v1.getCategories();
		System.out.print("a");
}
	
}
