package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classes.Staff;

public class StaffLogIn {
	
	private static JLabel userLabel;
	private static JLabel passwordLabel;
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel sucess;
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
				
				Staff staff = new Staff(username,password);
				
				if(staff.findOne() == null) {
					sucess.setText("wrong username or password");
				}
				else {
					ListPage listPage = new ListPage();	
				}
			}
		});
		panel.add(button);
		sucess = new JLabel("");
		panel.add(sucess);
	}
}
