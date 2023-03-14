package model;

public class Puzzles extends Toy {
	
	public Puzzles(String serialNum, String name, String brand, double price, int availableCount, int minimumAge, String puzzleType) {
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
	
	@Override 
	public String toString() {
		return super.toString() + " Puzzle Type: " + puzzleType;
	}
	
	@Override 
	public String format() {
		return super.format() + ";" + puzzleType;
	}
	

	
}
