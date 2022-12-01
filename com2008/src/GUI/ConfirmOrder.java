package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Classes.Order;
import Classes.OrderDTO;
import Classes.OrderDTO2;

public class ConfirmOrder {
	
	
	private static JButton button;
	private static JButton backbutton;
	private static JLabel error;

	
	
	public ConfirmOrder(String username) {
		
		List<OrderDTO> orderList = Order.findPendingOrders();
		String order[][] = new String[orderList.size()][10];
		for(int i=0; i<orderList.size(); i++) {
			String id =String.valueOf(orderList.get(i).getId());
			String totalCost  = String.valueOf(orderList.get(i).getTotalCost());
			String date = orderList.get(i).getDate();
			
			String wheelSerialNumber = orderList.get(i).getWheelSerialNumber();
			String wheelBrandName = orderList.get(i).getWheelBrandName();
			
			String frameSeriallNumber = orderList.get(i).getFrameSerialNumber();
			String frameBrandName = orderList.get(i).getFrameBrandName();
			
			
			String handlebarSerialNumber = orderList.get(i).getHandlebarSerialNumber();
			String handlebarBrandName = orderList.get(i).getHandlebarBrandName();
			
			
			
			order[i][0] = id;
			order[i][1] = totalCost;
			order[i][2] = date;
			order[i][3] = wheelSerialNumber;
			order[i][4] = wheelBrandName;
			order[i][5] = frameSeriallNumber;
			order[i][6] = frameBrandName;
			order[i][7] = handlebarSerialNumber;
			order[i][8] = handlebarBrandName;
	
		}
		
		
		String column[]={"ORDER ID","TOTAL COST","DATE","WHEEL SERIAL NO","WHEEL BRAND NAME","FRAME SERIAL NO","FRAME BRAND NAME","HANDLEBAR SERIAL NO","HANDLEBAR BRANDNAME"};       
		
		
		
		JTable jTable = new JTable(order,column);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setVisible(true);
		panel.add(jTable);
		
		frame.add(new JScrollPane(jTable));
		
		button = new JButton("CONFIRM ORDER");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						Order.confirmOrder(orderList.get(jTable.getSelectedRow()).getId(),username);
						panel.repaint();
						
					}
					catch (ArrayIndexOutOfBoundsException ex) {
						error.setText("NO ROW HAS BEEN CHOSEN");
					}
			}
		});
		panel.add(button);
		
		backbutton = new JButton("BACK TO STAFF PAGE");
		backbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StaffMainScreen staffMainScreen = new StaffMainScreen(username);
				frame.dispose();
			}
		});
		panel.add(backbutton);
		error = new JLabel();
		panel.add(error);
	}
	
}