package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomerMainScreen{
	
	private static JButton  button;
	private static JButton  button2;
	private static JButton  button3;
	private static JButton  button4;
	private static JButton  button5;
	private static JButton  button6;
	
	public CustomerMainScreen() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		button= new JButton("ASSEMBLE BIKE");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListPage listPage = new ListPage();
				frame.dispose();
				
			}
		});
		panel.add(button);
		
		button2= new JButton("ACESS ORDER WITH ID");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderViewById orderViewById =new OrderViewById();
				frame.dispose();
			}
		});
		panel.add(button2);
		
		button3= new JButton("PENDING ORDER");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerViewOrderPending customerViewOrderPending = new CustomerViewOrderPending();
				frame.dispose();		
			}
		});
		panel.add(button3);
		
		button4= new JButton("CONFIRMED AND FULFILLED ORDERS");
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerViewNonPendingOrder customerViewNonPendingOrder = new CustomerViewNonPendingOrder();
				frame.dispose();
				
			}
		});
		panel.add(button4);
	}
	

}
