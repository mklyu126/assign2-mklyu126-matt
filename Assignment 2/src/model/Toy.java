package model;

public abstract class Toy {
	protected int serialNum;
	protected String name;
	protected String brand;
	protected double price;
	protected int availableCount;
	protected int minimumAge;
	
	
public Toy(int serialNum, String name, String brand, double price, int availableCount, int minimumAge) {
	this.serialNum = serialNum;
    this.name = name;
	this.brand = brand;
	this.price = price;
	this.availableCount = availableCount;
	this.minimumAge = minimumAge;	
	}
	
public int getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableCount() {
		return availableCount;
	}
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	public int getMinimumAge() {
		return minimumAge;
	}
	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}
	
	public String toString() {
		return "Serial Number: " + serialNum + "Name: " + name + "Brand: " + brand + 
				"Price:" + price + "Available Count: " + availableCount + "Minimum Age: " + minimumAge;
	}
	public String format() {
		return serialNum + name + brand + price + availableCount + minimumAge;
	}
	
	
}
