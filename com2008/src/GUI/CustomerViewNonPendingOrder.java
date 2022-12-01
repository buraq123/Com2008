package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classes.Customer;
import Classes.Order;
import Classes.OrderDTO;

public class CustomerViewNonPendingOrder {
	
	private static JLabel   fornameLabel;
	private static JTextField  fornameText;
	private static JLabel    surnameLabel;
	private static JTextField  surnameText;
	private static JLabel		houseNumberLabel;
	private static JTextField  houseNumberText;
	private static JLabel		postcodeLabel;
	private static JTextField postcodeText;
	private static JButton  button;
	private static JButton  button2;
	private static JTable  table;
	

	public CustomerViewNonPendingOrder() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
		
		
		
		fornameLabel = new JLabel("FORENAME");
		fornameLabel.setBounds(100, 20, 85, 25);
		panel.add(fornameLabel);
		
		fornameText = new JTextField(10);
		fornameText.setBounds(110, 20, 85, 25);
		panel.add(fornameText);
		
		
		
		surnameLabel = new JLabel("SURNAME");
		surnameLabel.setBounds(120, 20, 85, 25);
		panel.add(surnameLabel);
		
		surnameText = new JTextField(10);
		surnameText.setBounds(130, 20, 85, 25);
		panel.add(surnameText);
		

	
		houseNumberLabel = new JLabel("HOUSENUMBER");
		houseNumberLabel.setBounds(140, 20, 85, 25);
		panel.add(houseNumberLabel);
		
		houseNumberText = new JTextField(10);
		houseNumberText.setBounds(150, 20, 85, 25);
		panel.add(houseNumberText);
		
		
		
		postcodeLabel = new JLabel("POSTCODE");
		postcodeLabel.setBounds(160, 20, 85, 25);
		panel.add(postcodeLabel);
		
		postcodeText = new JTextField(10);
		postcodeText.setBounds(170, 20, 85, 25);
		panel.add(postcodeText);
		
		
		button= new JButton("PLACE ORDER");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String forename = fornameText.getText();
				String surname = surnameText.getText();
				String hosueNumber = houseNumberText.getText();
				String postcode = postcodeText.getText();
				
				if(Customer.findOne(forename, surname, postcode, hosueNumber) != null) {
				
					Customer customer = Customer.findOne(forename, surname, postcode, hosueNumber);
					List<OrderDTO> orderList = Order.findNonPendingOrdersByCusId(customer.getId());
					String order[][] = new String[orderList.size()][9];
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
					}
					
					
					String column[]={"1","1","1","1","1","1","1","1","1"};      
					table = new JTable(order,column);
					panel.add(table);
					
				}
				
			}
		});
		panel.add(button);
		
		
		
		
	}


}
