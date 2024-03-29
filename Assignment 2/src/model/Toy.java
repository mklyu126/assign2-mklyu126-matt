package model;
/**
 * This class represents a toy super class.
 * @author Max
 *
 */
public abstract class Toy {
	/**
	 * Represents serial number of toy.
	 */
	private String serialNum;
	/**
	 * Represents name of the toy.
	 */
	private String name;
	/**
	 * Represents brand of toy.
	 */
	private String brand;
	/**
	 * Represents price of toy.
	 */
	private float price;
	/**
	 * Represents available count of toy.
	 */
	private int availableCount;
	/**
	 * Represents the minimum age rating of toy.
	 */
	private int minimumAge;
	
	/**
	 * Toy constructor.
	 * Initalizes toy super class and common features of all toys.
	 * @param serialNum of toy.
	 * @param name of toy.
	 * @param brand of toy.
	 * @param price of toy.
	 * @param availableCount of toy.
	 * @param Minimum age of toy.
	 */
public Toy(String serialNum, String name, String brand, float price, int availableCount, int minimumAge) {
	this.serialNum = serialNum;
    this.name = name;
	this.brand = brand;
	this.price = price;
	this.availableCount = availableCount;
	this.minimumAge = minimumAge;	
	}
	
/**
 * Toy getter method 
 * @return the serial number.
 */
public String getSerialNum() {
		return serialNum;
	}
/**
 * Toy setter method.
 * @param serialNum of toy.
 */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	/**
	 * Toy getter method.
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Toy setter method.
	 * @param the name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Toy getter method.
	 * @return the brand.
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * Toy setter method.
	 * @param the brand.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * Toy getter method.
	 * @return the price.
	 */
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * Toy getter method.
	 * @return the available count.
	 */
	public int getAvailableCount() {
		return availableCount;
	}
	/**
	 * Toy setter method.
	 * @param the available count.
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	/**
	 * Toy getter method.
	 * @return the minimum age.
	 */
	public int getMinimumAge() {
		return minimumAge;
	}
	/**
	 * Toy setter method.
	 * @param the minimum age.
	 */
	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}
	/**
	 * Overrides stnrd Java toString method.
	 * Shows data in a readable format.
	 */
	public String toString() {
		return "Serial Number: " + serialNum + " Name: " + name + " Brand: " + brand + 
				" Price: " + "$" + price + " Available Count: " + availableCount + " Minimum Age: " + minimumAge;
	}
	/**
	 * Formats the parent toy characteristics
	 * @return parent toy characteristics
	 */
	public String format() {
		return serialNum + ";" + name + ";" + brand + ";" + price +";" + availableCount + ";" + minimumAge;
	}
	
	
}
