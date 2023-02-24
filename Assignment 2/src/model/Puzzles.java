package model;

public class Puzzles extends Toy {
	
	public Puzzles(String puzzleType) {
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
