package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StaffMainScreen {
	
	

	private static JButton  button;
	private static JButton  button2;
	private static JButton  button3;
	private static JButton  button4;
	private static JButton  button5;
	private static JButton  button6;
	
	
	public StaffMainScreen(String username) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		
		button= new JButton("CONFIRM ODERS");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfirmOrder confirmOrder = new ConfirmOrder(username);
				frame.dispose();
			}
		});
		panel.add(button);
		
		
		
		button2= new JButton("FULLFILL ORDER");
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FulfillOrder fulfillOrder = new FulfillOrder(username);
				frame.dispose();
				
			}
		});
		panel.add(button2);
	
		button3= new JButton("ADD NEW PRODUCT");
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddNewProduct addNewProduct =new AddNewProduct();
				frame.dispose();
			}
		});
		panel.add(button3);
		
		button4= new JButton("ADD STOCK");
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddStock addStock = new AddStock();
				frame.dispose();
			}
		});
		panel.add(button4);
		
		
		
		
	
	}

}
