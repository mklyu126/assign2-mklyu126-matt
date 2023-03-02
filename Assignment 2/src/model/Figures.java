package model;

public class Figures extends Toy {
	
	public Figures(int serialNum, String name, String brand, double price, int availableCount, int minimumAge, String classification) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.classification = classification;
	}
	private String classification;

	public String getClassification() {
		return classification;
	}
	
	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return super.toString()+ "Classification: " + classification;
	}
	
	@Override 
	public String format() {
		return super.format() + classification;
	}
}
