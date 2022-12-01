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

public class FulfillOrder {
	
	private static JButton button;
	private static JButton backbutton;
	private static JLabel error;
	



	public FulfillOrder(String username) {
		
		List<OrderDTO> orderList = Order.findConfirmedOrders();
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
			
			String staffName = orderList.get(i).getStaffName();
			
			
			order[i][0] = id;
			order[i][1] = totalCost;
			order[i][2] = date;
			order[i][3] = wheelSerialNumber;
			order[i][4] = wheelBrandName;
			order[i][5] = frameSeriallNumber;
			order[i][6] = frameBrandName;
			order[i][7] = handlebarSerialNumber;
			order[i][8] = handlebarBrandName;
			order[i][9] = staffName;
		}
		
		
		String column[]={"ORDER ID","TOTAL COST","DATE","WHEEL SERIAL NO","WHEEL BRAND NAME","FRAME SERIAL NO","FRAME BRAND NAME","HANDLEBAR SERIAL NO","HANDLEBAR BRANDNAME","CONFIRMEDBY"};   
		
		
		
		JTable jTable = new JTable(order,column);
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel,BorderLayout.SOUTH);
		frame.setVisible(true);
		panel.add(jTable);
		frame.add(new JScrollPane(jTable));
		
		button = new JButton("FULFILL ORDER");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				Order.fulfillOrder(orderList.get(jTable.getSelectedRow()).getId(),
						orderList.get(jTable.getSelectedRow()).getWheelSerialNumber(),orderList.get(jTable.getSelectedRow()).getWheelBrandName(),
						orderList.get(jTable.getSelectedRow()).getFrameSerialNumber(),orderList.get(jTable.getSelectedRow()).getFrameBrandName(),
						orderList.get(jTable.getSelectedRow()).getHandlebarSerialNumber(),orderList.get(jTable.getSelectedRow()).getHandlebarBrandName());
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
