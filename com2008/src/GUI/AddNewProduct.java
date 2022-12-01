package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.result.StringValueFactory;

import Classes.HandleBar.Style;
import Classes.Frameset;
import Classes.HandleBar;
import Classes.Wheel;
import Classes.Wheel.BrakeStyle;
import Classes.Wheel.StyleWheel;

public class AddNewProduct {
	
	
	
	private static JLabel wheelSerialNumberLabel;
	private static JLabel wheelProductNameLabel;
	private static JLabel wheelBrandNameLabel;
	private static JLabel wheelUnitCostLabel;
	private static JLabel wheelDiameterLabel;
	
	
	private static JTextField wheelSerialNumberText;
	private static JTextField wheelProductNameTextField;
	private static JTextField wheelBrandNameTextField;
	private static JTextField wheelUnitCostTextField;
	private static JTextField wheelDiametereTextField;
	private static JComboBox<String> wheelStyle;
	private static JComboBox<String> brakeStyle;
	
	private static JButton wheelButton;
	
	
	
	private static JLabel frameSerialNumberLabel;
	private static JLabel frameProductNameLabel;
	private static JLabel frameBrandNameLabel;
	private static JLabel frameUnitCostLabel;
	private static JLabel frameSizeLabel;
	private static JLabel frameGearLabel;
	
	private static JTextField frameSerialNumberText;
	private static JTextField frameProductNameTextField;
	private static JTextField frameBrandNameTextField;
	private static JTextField frameUnitCostTextField;
	private static JRadioButton absorbersButton;
	private static JTextField frameSizeTextField;
	private static JTextField frameGearTextField;
	
	
	private static JButton frameButton;
	
	
	
	private static JLabel handlebarSerialNumberLabel;
	private static JLabel handlebarProductNameLabel;
	private static JLabel handlebarBrandNameLabel;
	private static JLabel handlebarUnitCostLabel;

	private static JTextField handlebarSerialNumberText;
	private static JTextField handlebarProductNameTextField;
	private static JTextField handlebarBrandNameTextField;
	private static JTextField handlebarUnitCostTextField;
	
	private static JComboBox<String> handlebarStyle;
	
	private static JButton handlebarButton;
	
	private static JLabel errorWheeL;
	private static JLabel errorFrame;
	private static JLabel errorHandle;
	
	

    public AddNewProduct() {
		
		
		

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		frame.setVisible(true);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setVisible(true);
		frame.add(panel2,BorderLayout.NORTH);
		
		
		
		wheelSerialNumberLabel= new JLabel("WHEEL   SERIAL NUMBER");
		panel2.add(wheelSerialNumberLabel);
		
		wheelSerialNumberText = new JTextField(10);
		panel2.add(wheelSerialNumberText);
		
		wheelProductNameLabel=new JLabel("PRODUCT NAME");
		panel2.add(wheelProductNameLabel);
		
		wheelProductNameTextField= new JTextField(10);
		panel2.add(wheelProductNameTextField);
		
		
		wheelBrandNameLabel= new JLabel("BRANDNAME");
		panel2.add(wheelBrandNameLabel);
		
		wheelBrandNameTextField= new JTextField(10);
		panel2.add(wheelBrandNameTextField);
		
		
		wheelUnitCostLabel= new JLabel("UNIT COST");
		panel2.add(wheelUnitCostLabel);
		
		wheelUnitCostTextField= new JTextField(10);	
		panel2.add(wheelUnitCostTextField);
		
		
		wheelDiameterLabel= new JLabel("DIAMETER");
		panel2.add(wheelDiameterLabel);
		
		wheelDiametereTextField= new JTextField(10);
		panel2.add(wheelDiametereTextField);
		
		
		wheelStyle = new JComboBox<String>();
		wheelStyle.addItem("MOUNTAIN");
		wheelStyle.addItem("ROAD");
		wheelStyle.addItem("HYBRID");
		panel2.add(wheelStyle);
		
	
		brakeStyle = new JComboBox<String>();
		brakeStyle.addItem("RIM");
		brakeStyle.addItem("DISK");
		panel2.add(brakeStyle);
		
		
		errorWheeL = new JLabel();
		panel2.add(errorWheeL);
		
		
		wheelButton = new JButton();
		wheelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(wheelSerialNumberText.getText().isEmpty()  || wheelBrandNameTextField.getText().isEmpty() ||  wheelDiametereTextField.getText().isEmpty() ||
						wheelUnitCostTextField.getText().isEmpty()	|| wheelDiametereTextField.getText().isEmpty()) {
					errorWheeL.setText("FILL ALL THE FIELD");
				}
				else {
					try {
					
						String serialNumber = wheelSerialNumberText.getText();
						String brandName = wheelBrandNameTextField.getText();
						String productName = wheelProductNameTextField.getText();

						StyleWheel styleWheel = StyleWheel.valueOf(String.valueOf(wheelStyle.getSelectedItem())); 
						BrakeStyle brakestyle = BrakeStyle.valueOf(String.valueOf(brakeStyle.getSelectedItem())); 
						String diameter = wheelDiametereTextField.getText();
						int diameter2 =Integer.parseInt(wheelDiametereTextField.getText());
						int unitCost = Integer.parseInt(wheelUnitCostTextField.getText());
						
						if(unitCost <= 0) {
							errorWheeL.setText("PUT VALID UNIT COST");
						}
						else {
							if(Wheel.findOne(serialNumber,brandName) == null) {
								Wheel wheel = new Wheel(serialNumber,productName,brandName,unitCost,0,styleWheel,brakestyle,diameter);
								wheel.save();
								AddNewProduct addNewProduct = new AddNewProduct();
								frame.dispose();
							}
							else {
								errorWheeL.setText("THIS PRODUCT EXIST");
							}
						}
					}		
					 catch (Exception e2) {
						 System.out.print("usmna");
						 errorWheeL.setText("INTEGER VALUES");
					}
				}
			}
			
		
			
		});
		panel2.add(wheelButton);
		
		
		
		
		
		JPanel panel3 = new JPanel();
		panel3.setVisible(true);
		frame.add(panel3,BorderLayout.SOUTH);
		
		
		frameSerialNumberLabel= new JLabel("FRAME  SERIAL NUMBER");
		panel3.add(frameSerialNumberLabel);
		
		frameSerialNumberText = new JTextField(10);
		panel3.add(frameSerialNumberText);
		
		
		
		
		frameProductNameLabel=new JLabel("PRODUCT NAME");
		panel3.add(frameProductNameLabel);
		
		frameProductNameTextField= new JTextField(10);
		panel3.add(frameProductNameTextField);
		
		
		
		
		frameBrandNameLabel= new JLabel("BRANDNAME");
		panel3.add(frameBrandNameLabel);
		
		frameBrandNameTextField= new JTextField(10);
		panel3.add(frameBrandNameTextField);
		
		
		frameUnitCostLabel= new JLabel("UNIT COST");
		panel3.add(frameUnitCostLabel);
		
		frameUnitCostTextField= new JTextField(10);
		panel3.add(frameUnitCostTextField);
		
		absorbersButton = new JRadioButton("ABSORBERS");  
		panel3.add(absorbersButton);
	
		
		frameSizeLabel= new JLabel("SIZE");
		panel3.add(frameSizeLabel);
		
		frameSizeTextField= new JTextField(10);
		panel3.add(frameSizeTextField);
		
		
		frameGearLabel= new JLabel("GEAR");
		panel3.add(frameGearLabel);
		
		frameGearTextField= new JTextField(10);
		panel3.add(frameGearTextField);
		
		
		errorFrame = new JLabel();
		panel3.add(errorFrame);
		
		frameButton = new JButton();
		frameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int unitCost = Integer.valueOf(frameUnitCostTextField.getText());
					if(unitCost <= 0) {
						errorFrame.setText("PUT VALID COST");
					}
					Boolean absorbers = absorbersButton.isSelected();
					String size = frameSizeTextField.getText();
					String gear = frameGearTextField.getText();
					String serialNumber = frameSerialNumberText.getText();
					String brandName = frameBrandNameTextField.getText();
					String productName = frameProductNameTextField.getText();
					
					if(Frameset.findOne(serialNumber,brandName) == null) {
						Frameset frameset = new Frameset(serialNumber, productName, brandName, unitCost, 0, size, absorbers, gear);
						frameset.save();
					}
					else {
						errorFrame.setText("THIS PRODUCT EXIST");
					}
					
				
				}
				catch (Exception ex) {
					
					errorFrame.setText("");
				}
			}
		});
		panel3.add(frameButton);
		
		
		
		

		JPanel panel4 = new JPanel();
		panel4.setVisible(true);
		frame.add(panel4,BorderLayout.EAST);
		
		
		
		handlebarSerialNumberLabel= new JLabel("HANDLEBAR   SERIAL NUMBER");
		panel4.add(handlebarSerialNumberLabel);
		
		handlebarSerialNumberText = new JTextField(10);
		panel4.add(handlebarSerialNumberText);
		
		handlebarProductNameLabel=new JLabel("PRODUCT NAME");
		panel4.add(handlebarProductNameLabel);
		
		handlebarProductNameTextField= new JTextField(10);
		panel4.add(handlebarProductNameTextField);
		
		
		handlebarBrandNameLabel= new JLabel("BRANDNAME");
		panel4.add(handlebarBrandNameLabel);
		
		handlebarBrandNameTextField= new JTextField(10);
		panel4.add(handlebarBrandNameTextField);
		
		
		handlebarUnitCostLabel= new JLabel("UNIT COST");
		panel4.add(handlebarUnitCostLabel);
		
		handlebarUnitCostTextField= new JTextField(10);	
		panel4.add(handlebarUnitCostTextField);
		
		
		handlebarStyle= new JComboBox<String>();
		handlebarStyle.addItem("HIGH");
		handlebarStyle.addItem("STRAIGHT");
		handlebarStyle.addItem("DROPPED");
		panel4.add(handlebarStyle);
		
		handlebarButton = new JButton();
		handlebarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String serialNumber = handlebarSerialNumberText.getText();
				String brandName = handlebarBrandNameTextField.getText();
				String productName = handlebarProductNameTextField.getText();
				int unitCost = Integer.valueOf(handlebarUnitCostTextField.getText());
				Style style = Style.valueOf(String.valueOf(handlebarStyle.getSelectedItem())); 
				
				if(HandleBar.findOne(serialNumber,brandName) == null) {
					HandleBar handleBar = new HandleBar(serialNumber,productName,brandName,unitCost,0,style);
					handleBar.save();
				}
				
			}
		});
		panel4.add(handlebarButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
