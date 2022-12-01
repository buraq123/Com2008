package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Classes.Frameset;
import Classes.HandleBar;
import Classes.Wheel;

public class AddStock {
	
	private static JLabel wheelQuantityLabel;
	private static JLabel frameQuantityLabel;
	private static JLabel handlebarQuantityLabel;
	
	private static JTextField wheelQuantityText;
	private static JTextField frameQuantityText;
	private static JTextField handlebarQuantityText;
	
	
	private static JButton wheelButton;
	private static JButton frameButton;
	private static JButton handlebarButton;
	
	private static JLabel error;
	
	
	 public AddStock() {
		 
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
		
		
		error= new JLabel();
		panel.add(error);

		wheelQuantityLabel = new JLabel("WHEEL QUANTITY");
		wheelQuantityLabel.setBounds(100, 20, 85, 25);
		panel.add(wheelQuantityLabel);
		
		wheelQuantityText = new JTextField(10);
		wheelQuantityText.setBounds(110, 20, 85, 25);
		panel.add(wheelQuantityText);
		
		wheelButton = new JButton("EXISTING USER");
		wheelButton .setBounds(10, 80, 80, 25);
		wheelButton .addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Wheel wheel = Wheel.findOne(wheelList.get(wheelBox.getSelectedIndex()).getId());
				try {
					int addedQuantity = Integer.valueOf(wheelQuantityText.getText());
					
					if(addedQuantity<=0) {
						error.setText("ENTER A VALID NUMBER");
					}
					else {
						wheel.setQuantity(wheel.getQuantity()+addedQuantity);
						wheel.updateStock();
					}
					
				}
				catch (NumberFormatException ex) {
					error.setText("ENTER A VALID NUMBER");
				}
	
			}
		});
		panel.add(wheelButton);
		
		
		
		frameQuantityLabel = new JLabel("FRAME QUANTITY");
		frameQuantityLabel.setBounds(120, 20, 85, 25);
		panel.add(frameQuantityLabel);
		
		frameQuantityText = new JTextField(10);
		frameQuantityText.setBounds(130, 20, 85, 25);
		panel.add(frameQuantityText);
		
		frameButton = new JButton("EXISTING USER");
		frameButton.setBounds(10, 80, 80, 25);
		frameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frameset frameset = Frameset.findOne(framesetList.get(framesetBox.getSelectedIndex()).getId());
				try {
					int addedQuantity = Integer.valueOf(frameQuantityText.getText());
					if(addedQuantity<=0) {
						error.setText("ENTER A VALID NUMBER");
					}
					else {
						frameset.setQuantity(frameset.getQuantity()+addedQuantity);
						frameset.updateStock();	
					}
				}
				catch (NumberFormatException ex) {
					error.setText("ENTER A VALID NUMBER");
				}
				
			}
		});
		panel.add(frameButton);
	
		handlebarQuantityLabel = new JLabel("HANDLEBAR QUANTITY");
		handlebarQuantityLabel.setBounds(140, 20, 85, 25);
		panel.add(handlebarQuantityLabel);
		
		handlebarQuantityText = new JTextField(10);
		handlebarQuantityText.setBounds(150, 20, 85, 25);
		panel.add(handlebarQuantityText);
		
		handlebarButton = new JButton("EXISTING USER");
		handlebarButton .setBounds(10, 80, 80, 25);
		handlebarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HandleBar handleBar = HandleBar.findOne(handelBarList.get(handleBarBox.getSelectedIndex()).getId());
				try {
					int addedQuantity = Integer.valueOf(handlebarQuantityText.getText());
					
					if(addedQuantity<=0) {
						error.setText("ENTER A VALID NUMBER");
					}
					else {

						handleBar.setQuantity(handleBar.getQuantity()+addedQuantity);
						handleBar.updateStock();
					}
				}
				catch (NumberFormatException ex) {
					error.setText("ENTER A VALID NUMBER");
				}	
			}
		});
		
		panel.add(handlebarButton);
		frame.setVisible(true);
	}

}
