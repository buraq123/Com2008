package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.Address;
import Classes.Customer;

public class CustomerChangeDetails {
	
	private static JLabel   fornameLabel;
	private static JTextField  fornameText;
	private static JLabel    surnameLabel;
	private static JTextField  surnameText;
	private static JLabel		houseNumberLabel;
	private static JTextField  houseNumberText;
	private static JLabel		postcodeLabel;
	private static JTextField postcodeText;
	
	private static JButton  button;
	
	private static JLabel   fornameLabel2;
	private static JTextField  fornameText2;
	private static JLabel    surnameLabel2;
	private static JTextField  surnameText2;
	private static JLabel		houseNumberLabel2;
	private static JTextField  houseNumberText2;
	private static JLabel		postcodeLabel2;
	private static JTextField postcodeText2;
	private static JButton  button2;
	private static JButton  button3;
	private static JLabel		roadNameLabel;
	private static JTextField roadNameText;
	private static JLabel		cityLabel;
	private static JTextField cityText;
	
	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setVisible(true);
		frame.add(panel2,BorderLayout.SOUTH);
		
		fornameLabel = new JLabel("FORENAME");
		fornameLabel.setBounds(100, 20, 85, 25);
		panel2.add(fornameLabel);
		
		fornameText = new JTextField(10);
		fornameText.setBounds(110, 20, 85, 25);
		panel2.add(fornameText);
		
		
		
		surnameLabel = new JLabel("SURNAME");
		surnameLabel.setBounds(120, 20, 85, 25);
		panel2.add(surnameLabel);
		
		surnameText = new JTextField(10);
		surnameText.setBounds(130, 20, 85, 25);
		panel2.add(surnameText);
		

	
		houseNumberLabel = new JLabel("HOUSENUMBER");
		houseNumberLabel.setBounds(140, 20, 85, 25);
		panel2.add(houseNumberLabel);
		
		houseNumberText = new JTextField(10);
		houseNumberText.setBounds(150, 20, 85, 25);
		panel2.add(houseNumberText);
		
		
		
		postcodeLabel = new JLabel("POSTCODE");
		postcodeLabel.setBounds(160, 20, 85, 25);
		panel2.add(postcodeLabel);
		
		postcodeText = new JTextField(10);
		postcodeText.setBounds(170, 20, 85, 25);
		panel2.add(postcodeText);
		
		
		
		
		
		

		JPanel panel3 = new JPanel();
		panel3.setVisible(true);
		frame.add(panel3, BorderLayout.WEST);
		
		fornameLabel2 = new JLabel("NEW FORENAME");
		fornameLabel2.setBounds(10, 20, 85, 25);
		panel3.add(fornameLabel2);
		
		fornameText2 = new JTextField(10);
		fornameText2.setBounds(100, 20, 10, 25);
		panel3.add(fornameText2);
		
		
		
		surnameLabel2 = new JLabel("NEW SURNAME");
		surnameLabel2.setBounds(10, 20, 85, 25);
		panel3.add(surnameLabel2);
		
		surnameText2 = new JTextField(10);
		surnameText2.setBounds(100, 20, 85, 25);
		panel3.add(surnameText2);
		

	
		houseNumberLabel2 = new JLabel("NEW HOUSENUMBER");
		houseNumberLabel2.setBounds(10, 20, 85, 25);
		panel3.add(houseNumberLabel2);
		
		houseNumberText2 = new JTextField(10);
		houseNumberText2.setBounds(100, 20, 85, 25);
		panel3.add(houseNumberText2);
		
		
		
		postcodeLabel2 = new JLabel("NEW POSTCODE");
		postcodeLabel2.setBounds(10, 20, 85, 25);
		panel3.add(postcodeLabel2);
		
		postcodeText2 = new JTextField(10);
		postcodeText2.setBounds(100, 20, 85, 25);
		panel3.add(postcodeText2);
		
		

		roadNameLabel = new JLabel("NEW ROADNAME");
		roadNameLabel.setBounds(10, 20, 85, 25);
		panel3.add(roadNameLabel);
		
		roadNameText = new JTextField(10);
		roadNameText.setBounds(100, 20, 85, 25);
		panel3.add(roadNameText);
		
		
		cityLabel = new JLabel("NEW CITY NAME");
		cityLabel.setBounds(10, 20, 85, 25);
		panel3.add(cityLabel);
		
		cityText = new JTextField(10);
		cityText.setBounds(100, 20, 85, 25);
		panel3.add(cityText);
		
		
		button = new JButton("CHANGE DETAILS");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					if(Customer.findOne(fornameText.getText(),surnameText.getText(), postcodeText.getText(),houseNumberText.getText()) != null) {
						Customer customer = Customer.findOne(fornameText.getText(),surnameText.getText(),postcodeText.getText(),houseNumberText.getText());
						if(Customer.findOne(fornameText2.getText(),surnameText2.getText(),postcodeText2.getText(),houseNumberText2.getText()) == null) {
							System.out.print(customer.getForename());
							customer.setForename(fornameText2.getText());
							customer.setSurname(surnameText2.getText());
							if(Address.findOne(houseNumberText2.getText(), postcodeText2.getText()) != null) {
								System.out.print("address exist");
								Address address = Address.findOne(houseNumberText2.getText(), postcodeText2.getText());
								customer.setAddress(address);
								Customer.update(customer);
							}
							else {
								System.out.print("does nort exist");
								Address address = new Address(houseNumberText2.getText(), postcodeText2.getText(),cityText.getText(),roadNameText.getText());
								customer.setAddress(address);
								Customer.update(customer);
							}
						}
						else {
							//customer already exist
						}
					}
					else {
						//customer does not exist
					}
				}
				catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		panel.add(button);
		frame.setVisible(true);
		
		
		
		
	}

}
