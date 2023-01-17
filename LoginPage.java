import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
public class LoginPage implements ActionListener{
	// form make here
	String Username1;
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JPasswordField Userpassword = new JPasswordField();
	JTextField UserUsername = new JTextField();
	JLabel UserPlaceUsername = new JLabel("Username:");
	JLabel UserPlacePassword = new JLabel("Password:");
	JLabel MessagePanel12 = new JLabel("");
	JButton GOButton = new JButton("Go Dashboard");
	
	
	
	
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	// constructor
	LoginPage(HashMap<String,String> loginInfoOrg){
		loginInfo = loginInfoOrg;
		
		
		UserPlaceUsername.setBounds(50, 100, 75, 25);
		UserPlacePassword.setBounds(50, 150, 75, 25);
		
		MessagePanel12.setBounds(125, 250, 250, 35);
		MessagePanel12.setFont(new Font(null, Font.ITALIC, 25));
		
		Userpassword.setBounds(125, 150, 200, 25);
		UserUsername.setBounds(125, 100, 200, 25);
		
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		GOButton.setBounds(225, 300, 100, 25);
		GOButton.setFocusable(false);
		GOButton.addActionListener(this);
		GOButton.setVisible(false);
		
		frame.add(GOButton);
		frame.add(resetButton);
		frame.add(loginButton);
		frame.add(UserUsername);
		frame.add(Userpassword);
		frame.add(MessagePanel12);
		frame.add(UserPlaceUsername);
		frame.add(UserPlacePassword);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Login Page");
		frame.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// reset button
		if(e.getSource()==resetButton) {
			UserUsername.setText("");
			Userpassword.setText("");
		}
		// login button
		if(e.getSource()== loginButton) {
			String userID = UserUsername.getText();
			Username1=userID;
			String userpas = String.valueOf(Userpassword.getPassword());
			if(loginInfo.containsKey(userID)) {
				if(loginInfo.get(userID).equals(userpas)) {
					MessagePanel12.setForeground(Color.GREEN);
					MessagePanel12.setText("Login Successfuly");
					GOButton.setVisible(true);
					
					
				}
				else if(loginInfo.get(userID)!=userpas){
					MessagePanel12.setForeground(Color.BLUE);
					MessagePanel12.setText("Login Failed");
					GOButton.setVisible(false);
					
				}
			}
			else {
				MessagePanel12.setForeground(Color.RED);
				GOButton.setVisible(false);
				MessagePanel12.setText("Not exist");
			}
		}
		
		// Go Dashboard
		if(e.getSource()== GOButton) {
			frame.dispose();
			Dashboard dash = new Dashboard(loginInfo);
		}
	}
}
