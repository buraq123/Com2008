package Classes;

import java.util.List;

import com.mysql.cj.result.StringValueFactory;

import Classes.HandleBar.Style;
import com2008.DBWheel;

public class Wheel extends Product{
	
	public enum BrakeStyle{
		RIM,
		DISK
	}
	
	public enum StyleWheel{
		
		ROAD,
		MOUNTAIN,
		HYBRID
	}
	
	private StyleWheel style;
	private BrakeStyle breakStyle;
	private String diameter;
	
	public Wheel(String serialNumber, String productName, String brandName, int unitCost, int quantity,StyleWheel style, BrakeStyle breakStyle,String diameter) {
		super(serialNumber, productName, brandName, unitCost, quantity);
		this.diameter = diameter;
		this.style = style;
		this.breakStyle = breakStyle;
	}

	public Wheel(int id,String serialNumber, String productName, String brandName, int unitCost, int quantity,StyleWheel style, BrakeStyle breakStyle,String diameter) {
		super(id,serialNumber, productName, brandName, unitCost, quantity);
		this.diameter = diameter;
		this.style = style;
		this.breakStyle = breakStyle;
	}
	
	


	public String getDiameter() {
		return diameter;
	}


	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}


	public StyleWheel getStyle() {
		return style;
	}


	public void setStyle(StyleWheel style) {
		this.style = style;
	}


	public BrakeStyle getBreakStyle() {
		return breakStyle;
	}


	public void setBreakStyle(BrakeStyle breakStyle) {
		this.breakStyle = breakStyle;
	}

	
	
	
	
	
	
	public static List<Wheel> getAll() {
		DBWheel dbWheel =new DBWheel();
		return dbWheel.getAll();
		
	}

	

	public static Wheel findOne(int wheelId) {
		DBWheel dbWheel = new DBWheel();
		return dbWheel.findOne(wheelId);
	}

	
	
	

}
