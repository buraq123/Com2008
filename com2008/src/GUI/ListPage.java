package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.result.StringValueFactory;

import Classes.Customer;
import Classes.Frameset;
import Classes.HandleBar;
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
	
	
	
	public static void main(String[] args) {
		
//		
//		List<HandleBar> handelBarList = HandleBar.getAll();
//		String[] handleBarStrings = new String[handelBarList.size()];
//		for(int i=0; i<handleBarStrings.length; i++) {
//			handleBarStrings[i] = "" +handelBarList.get(i).getStyle() + handelBarList.get(i).getBrandName() + handelBarList.get(i).getUnitCost();
//			}	
//				
//				
//		List<Wheel> wheelList = Wheel.getAll();
//		String[] wheelStrings = new String[wheelList.size()];
//		for(int i=0; i<wheelStrings.length; i++) {
//			wheelStrings[i] = "" + wheelList.get(i).getSize() +wheelList.get(i).getBrandName()+ wheelList.get(i).getUnitCost();
//		}
//		
//		
//		List<Frameset> framesetList = Frameset.getAll();
//		String[] frameStrings = new String[framesetList.size()];
//		for(int i=0; i<frameStrings.length; i++) {
//			frameStrings[i] = "" +framesetList.get(i).getType() + framesetList.get(i)+framesetList.get(i).getUnitCost();
//		}
//		
		
		
		
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		
		
//		JComboBox handleBarBox =new JComboBox(handleBarStrings);
//		handleBarBox.setSelectedIndex(0);
//		
//		JComboBox framesetBox =new JComboBox(frameStrings); 
//		framesetBox.setSelectedIndex(0);
//		
//		JComboBox  wheelBox=new JComboBox(wheelStrings);  
//		wheelBox.setSelectedIndex(0);
		
//		
//		panel.add(wheelBox);
//		panel.add(framesetBox);
//		panel.add(framesetBox);
//		
//		
//		
		JPanel panel2 = new JPanel();
		panel2.setVisible(true);
		frame.add(panel2,BorderLayout.SOUTH);
		
		fornameLabel = new JLabel("FORENAME");
		fornameLabel.setBounds(100, 20, 85, 25);
		panel2.add(fornameLabel);
		
		fornameText = new JTextField(20);
		fornameText.setBounds(110, 20, 85, 25);
		panel2.add(fornameText);
		
		
		
		surnameLabel = new JLabel("SURNAME");
		surnameLabel.setBounds(120, 20, 85, 25);
		panel2.add(surnameLabel);
		
		surnameText = new JTextField(20);
		surnameText.setBounds(130, 20, 85, 25);
		panel2.add(surnameText);
		

	
		houseNumberLabel = new JLabel("HOUSENUMBER");
		houseNumberLabel.setBounds(140, 20, 85, 25);
		panel2.add(houseNumberLabel);
		
		houseNumberText = new JTextField(20);
		houseNumberText.setBounds(150, 20, 85, 25);
		panel2.add(houseNumberText);
		
		
		
		postcodeLabel = new JLabel("ADDRESS");
		postcodeLabel.setBounds(160, 20, 85, 25);
		panel2.add(postcodeLabel);
		
		postcodeText = new JTextField(20);
		postcodeText.setBounds(170, 20, 85, 25);
		panel2.add(postcodeText);
		

		JPanel panel3 = new JPanel();
		panel3.setVisible(true);
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
		
		

		button = new JButton("EXISTING USER");
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(button);
		

		button2 = new JButton("NEW USER");
		button2.setBounds(10, 80, 80, 25);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		panel.add(button2);

		button3= new JButton("PLACE ORDER");
		button3.setBounds(10, 80, 80, 25);
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		panel.add(button3);
	
		
		frame.setVisible(true);
		
      
	}

}
