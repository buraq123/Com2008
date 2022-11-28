package Classes;

import java.sql.Date;
import java.time.LocalDateTime;

import Classes.Order.Status;

public class OrderDTO {
	
	private int id;
	private int totalCost;
	private String date;
	private String wheelSerialNumber;
	private String wheelBrandName;
	private String frameSerialNumber;
	private String frameBrandName;
	private String handlebarSerialNumber;
	private String handlebarBrandName;
	private String staffName;
	private Status status;
	public OrderDTO(int id, int totalCost, String date, String wheelSerialNumber, String wheelBrandName,
			String frameSerialNumber, String frameBrandName, String handlebarSerialNumber, String handlebarBrandName,
			String staffName, Status status) {
		super();
		this.id = id;
		this.totalCost = totalCost;
		this.date = date;
		this.wheelSerialNumber = wheelSerialNumber;
		this.wheelBrandName = wheelBrandName;
		this.frameSerialNumber = frameSerialNumber;
		this.frameBrandName = frameBrandName;
		this.handlebarSerialNumber = handlebarSerialNumber;
		this.handlebarBrandName = handlebarBrandName;
		this.staffName = staffName;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWheelSerialNumber() {
		return wheelSerialNumber;
	}
	public void setWheelSerialNumber(String wheelSerialNumber) {
		this.wheelSerialNumber = wheelSerialNumber;
	}
	public String getWheelBrandName() {
		return wheelBrandName;
	}
	public void setWheelBrandName(String wheelBrandName) {
		this.wheelBrandName = wheelBrandName;
	}
	public String getFrameSerialNumber() {
		return frameSerialNumber;
	}
	public void setFrameSerialNumber(String frameSerialNumber) {
		this.frameSerialNumber = frameSerialNumber;
	}
	public String getFrameBrandName() {
		return frameBrandName;
	}
	public void setFrameBrandName(String frameBrandName) {
		this.frameBrandName = frameBrandName;
	}
	public String getHandlebarSerialNumber() {
		return handlebarSerialNumber;
	}
	public void setHandlebarSerialNumber(String handlebarSerialNumber) {
		this.handlebarSerialNumber = handlebarSerialNumber;
	}
	public String getHandlebarBrandName() {
		return handlebarBrandName;
	}
	public void setHandlebarBrandName(String handlebarBrandName) {
		this.handlebarBrandName = handlebarBrandName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
