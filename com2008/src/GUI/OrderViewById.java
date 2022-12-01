package GUI;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classes.Order;
import Classes.Order.Status;
import Classes.OrderDTO;

public class OrderViewById {
	
	public static JLabel orderNumberLabel;
	public static JTextField orderNumberJTextField;
	public static JButton button;
	public static JButton button2;
	public static JTable table;
	
	 public OrderViewById() {

		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
		orderNumberLabel= new JLabel("ORDER NUMBER");
		panel.add(orderNumberLabel);
		
		orderNumberJTextField= new JTextField(10);
		panel.add(orderNumberJTextField);
		
		
		button = new JButton("View Order");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(Order.findOne(Integer.valueOf(orderNumberJTextField.getText())) != null) {
						
						OrderDTO orderDTO = Order.findOne((int)Integer.valueOf(orderNumberJTextField.getText()));
						String order[][] = new String[1][9];
						order[0][0] = String.valueOf(orderDTO.getId());
						order[0][1] = String.valueOf(orderDTO.getTotalCost());
						order[0][2] = orderDTO.getDate();
						order[0][3] = orderDTO.getWheelSerialNumber();
						order[0][4] = orderDTO.getWheelBrandName();
						order[0][5] = orderDTO.getFrameSerialNumber();
						order[0][6] = orderDTO.getFrameBrandName();
						order[0][7] = orderDTO.getHandlebarSerialNumber();
						order[0][8] = orderDTO.getHandlebarBrandName();
						
						String column[]={"1","1","1","1","1","1","1","1","1"};  
						if(orderDTO.getStatus() == Status.PENDING) {
							button2 =new JButton("DELETE");
							button2.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									Order.delete((int)Integer.valueOf(orderNumberJTextField.getText()));
								}
							});
							panel.add(button2);
						}
						table = new JTable(order,column);
						panel.add(table);
					}
				}
				catch(IndexOutOfBoundsException ex) {
					
				}
				
			}
		});
		panel.add(button);
		
		
		
		
		
	}

}
