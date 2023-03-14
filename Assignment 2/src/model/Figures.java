package model;
/**
 * Child class of Toy.
 * @author Max
 *
 */
public class Figures extends Toy {
	/**
	 * Inherits base characteristics from Toy super class but adds classification as a Figures toy unique characterstic..
	 * @param serialNum of toy.
	 * @param name of toy.
	 * @param brand of toy.
	 * @param price of toy.
	 * @param availableCount of toy.
	 * @param minimumAge of toy.
	 * @param classification of toy.
	 */
	public Figures(String serialNum, String name, String brand, double price, int availableCount, int minimumAge, String classification) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.classification = classification;
	}
	/**
	 * Classification of figure class toy.
	 */
	private String classification;
/**
 * Figures getter method.
 * @return classification of Figures toy.
 */
	public String getClassification() {
		return classification;
	}
	/**
	 * Figures setter method.
	 * @param the classification.
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}
/**
 * Overrides Toy parent class toString method.
 * Adds classification to super.ToString method.
 */
	@Override
	public String toString() {
		return super.toString()+ " Classification: " + classification;
	}
	/**
	 * Overrides Toy parent class format method.
	 * Adds classification to super.format method.
	 */
	@Override 
	public String format() {
		return super.format() + ";" + classification;
	}
}
