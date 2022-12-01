# Com2008
package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
//import com.mysql.cj.LicenseConfiguration;
//import com.mysql.cj.protocol.a.SqlDateValueEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import Classes.SQL;
import Classes.Staff;

public class StaffLogIn {
	
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JLabel message;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JButton backbutton;
	private static JLabel fail;
	
	public StaffLogIn() {
		
		panel = new JPanel();
		frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setTitle("Staff Login");
		panel.setLayout(new GridLayout(4,2,25,25));
		panel.setBounds(50,50,400,250);
		frame.add(panel);
		
		
		userLabel = new JLabel("USERNAME");
		userLabel.setBounds(10, 20, 85, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 85, 25);
		panel.add(userText);
		
		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(10, 20, 85, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 20, 85, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = userText.getText();
				String password =String.valueOf(passwordText.getPassword());
				
				if(SQL.validate(username) &&  SQL.validate(password)) {
					try {
						if(Staff.findOne(username, password) == null) {
							fail.setText("CHECK ALL THE DETAILS");	
						}
						else {
							StaffMainScreen staffMainScreen = new StaffMainScreen(username);
							frame.dispose();
						}
					} catch (NoSuchAlgorithmException e1) {
						e1.printStackTrace();
					}	
				}
				else {
					fail.setText("SQL INJECTION");	
				}
			}
		});
		
		
		panel.add(button);

		
		
		backbutton = new JButton("BACK TO MAIN PAGE");
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainPage mainPage = new MainPage();
				frame.dispose();
			}
		});
		panel.add(backbutton);
		fail = new JLabel();
		panel.add(fail);
	}
}
