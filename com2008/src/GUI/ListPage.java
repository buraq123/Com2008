package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.sound.midi.SysexMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.result.StringValueFactory;

import Classes.Address;
import Classes.Bike;
import Classes.Customer;
import Classes.Frameset;
import Classes.HandleBar;
import Classes.Order;
import Classes.Staff;
import Classes.Wheel;

public class ListPage {
	
	private static JComboBox handleBarBox;
	private static JComboBox framesetBox;
	private static JComboBox  wheelBox;
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
	private static JLabel		message;
	private static JTextField		nameText;
	
	public ListPage() {
	
		
		List<HandleBar> handelBarList = HandleBar.getAll();
		String[] handleBarStrings = new String[handelBarList.size()];
		for(int i=0; i<handleBarStrings.length; i++) {
			handleBarStrings[i] = "" +handelBarList.get(i).getStyle() + handelBarList.get(i).getBrandName() + handelBarList.get(i).getUnitCost();
			}	
				
				
		List<Wheel> wheelList = Wheel.getAll();
		String[] wheelStrings = new String[wheelList.size()];
		for(int i=0; i<wheelStrings.length; i++) {
			wheelStrings[i] = "" + wheelList.get(i).getBrandName()+ wheelList.get(i).getUnitCost();
		}
		
		
		List<Frameset> framesetList = Frameset.getAll();
		String[] frameStrings = new String[framesetList.size()];
		for(int i=0; i<frameStrings.length; i++) {
			frameStrings[i] = "" +framesetList.get(i).getBrandName()+framesetList.get(i).getUnitCost();
		}

		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		
		
		JComboBox handleBarBox =new JComboBox(handleBarStrings);
		handleBarBox.setSelectedIndex(0);
		
		JComboBox framesetBox =new JComboBox(frameStrings); 
		framesetBox.setSelectedIndex(0);
		
		JComboBox wheelBox=new JComboBox(wheelStrings);  
		wheelBox.setSelectedIndex(0);
	
		
		panel.add(wheelBox);
		panel.add(framesetBox);
		panel.add(handleBarBox);
		
		
		nameText = new JTextField(10);
		nameText.setBounds(110, 20, 85, 25);
		panel.add(nameText);
		
			
		JPanel panel2 = new JPanel();
		panel2.setVisible(false);
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
		panel3.setVisible(false);
		frame.add(panel3, BorderLayout.WEST);
		
		fornameLabel2 = new JLabel("FORENAME");
		fornameLabel2.setBounds(10, 20, 85, 25);
		panel3.add(fornameLabel2);
		
		fornameText2 = new JTextField(10);
		fornameText2.setBounds(100, 20, 10, 25);
		panel3.add(fornameText2);
		
		
		
		surnameLabel2 = new JLabel("SURNAME");
		surnameLabel2.setBounds(10, 20, 85, 25);
		panel3.add(surnameLabel2);
		
		surnameText2 = new JTextField(10);
		surnameText2.setBounds(100, 20, 85, 25);
		panel3.add(surnameText2);
		

	
		houseNumberLabel2 = new JLabel("HOUSENUMBER");
		houseNumberLabel2.setBounds(10, 20, 85, 25);
		panel3.add(houseNumberLabel2);
		
		houseNumberText2 = new JTextField(10);
		houseNumberText2.setBounds(100, 20, 85, 25);
		panel3.add(houseNumberText2);
		
		
		
		postcodeLabel2 = new JLabel("POSTCODE");
		postcodeLabel2.setBounds(10, 20, 85, 25);
		panel3.add(postcodeLabel2);
		
		postcodeText2 = new JTextField(10);
		postcodeText2.setBounds(100, 20, 85, 25);
		panel3.add(postcodeText2);
		
		

		roadNameLabel = new JLabel("ROADNAME");
		roadNameLabel.setBounds(10, 20, 85, 25);
		panel3.add(roadNameLabel);
		
		roadNameText = new JTextField(10);
		roadNameText.setBounds(100, 20, 85, 25);
		panel3.add(roadNameText);
		
		
		cityLabel = new JLabel("CITY NAME");
		cityLabel.setBounds(10, 20, 85, 25);
		panel3.add(cityLabel);
		
		cityText = new JTextField(10);
		cityText.setBounds(100, 20, 85, 25);
		panel3.add(cityText);
		
		

		
		
		
		button = new JButton("EXISTING USER");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel2.setVisible(true);
				panel3.setVisible(false);	
			}
		});
		panel.add(button);
		

		button2 = new JButton("NEW USER");
		button2.setBounds(10, 80, 80, 25);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel3.setVisible(true);
				panel2.setVisible(false);
				
			}
				
		});
		panel.add(button2);

		message = new JLabel("");
		panel.add(message);
		
		
		button3= new JButton("PLACE ORDER");
		button3.setBounds(10, 80, 80, 25);
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wheel wheel = Wheel.findOne(wheelList.get(wheelBox.getSelectedIndex()).getId());
				
				Frameset frameset = Frameset.findOne(framesetList.get(framesetBox.getSelectedIndex()).getId());
			
				HandleBar handleBar = HandleBar.findOne(handelBarList.get(handleBarBox.getSelectedIndex()).getId());
				
				System.out.println(handelBarList.get(handleBarBox.getSelectedIndex()).getId());
				String productName = nameText.getText();
				
				
				if(panel2.isVisible() == true) {
					
					String forename = fornameText.getText();
					String surname = surnameText.getText();
					String hosueNumber = houseNumberText.getText();
					String postcode = postcodeText.getText();
					
					if(Customer.findOne(forename, surname, postcode, hosueNumber) != null) {
						
						Customer customer = Customer.findOne(forename, surname, postcode, hosueNumber);
						Order.placeOrder(wheel, frameset, handleBar, productName,customer);	
					}
					else {
						panel2.setVisible(false);
						panel3.setVisible(true);
					}
					
				}
				else {
					
					String forename = fornameText2.getText();
					String surname = surnameText2.getText();
					String hosueNumber = houseNumberText2.getText();
					String postcode = postcodeText2.getText();
					String road = roadNameText.getText();
					String city = cityText.getText();
					
					
					if(Customer.findOne(forename, surname, postcode, hosueNumber) != null) {
						panel2.setVisible(true);
						panel3.setVisible(false);
					}
					else {
						Address address = null;
						if(Address.findOne(hosueNumber,postcode) != null) {
							address = Address.findOne(hosueNumber, postcode);
						}
						else {
							address = new Address(hosueNumber,postcode,city,road);
						}
						
						Customer customer = new Customer(forename,surname,address);
						Order.placeOrder(wheel, frameset, handleBar, productName,customer);	
				
					}
				}		
			}
		});
		
	
		
		panel.add(button3);	
		frame.setVisible(true);
		
      
	}

}
