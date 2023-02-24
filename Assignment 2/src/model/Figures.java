package model;

public class Figures extends Toy {
	
	public Figures(String classification) {
		this.classification = classification;
	}
	private String classification;

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

}
