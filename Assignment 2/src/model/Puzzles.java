package model;

public class Puzzles extends Toy {
	
	public Puzzles(int serialNum, String name, String brand, double price, int availableCount, int minimumAge, String puzzleType) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.puzzleType = puzzleType;
	}
	private String puzzleType;

	public String getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	

	
}
