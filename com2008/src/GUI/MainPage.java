package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainPage extends JFrame {
	
	private static JButton  button;
	private static JButton  button2;
	
	
	
	public MainPage() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.SOUTH);
	
		
		
		
		button= new JButton("STAFF");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaffLogIn staffLogIn = new StaffLogIn();
				frame.dispose();
			}
		});
		panel.add(button);
		
		
		
		button2= new JButton("SHOPPER/CUSTOMER");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerMainScreen customerMainScreen = new CustomerMainScreen();
				frame.dispose();
			}
		});
		panel.add(button2);
		frame.setVisible(true);
	}
	
		
	
	public static void main(String[] args) {
		MainPage mainPage =new MainPage();
	}

}
