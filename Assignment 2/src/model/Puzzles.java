package model;
/**
 * this class has the classification of a puzzle 
 * @author Max
 *
 */
public class Puzzles extends Toy {
	/**
	 * takes in all the classification of a toy and adds in its own classification of a puzzle
	 * @param serialNum
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param minimumAge
	 * @param puzzleType
	 */
	public Puzzles(String serialNum, String name, String brand, float price, int availableCount, int minimumAge, String puzzleType) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.puzzleType = puzzleType;
	}
	/**
	 * initializes puzzle 
	 */
	private String puzzleType;
	/**
	 * get puzzle type
	 * @return
	 */
	public String getPuzzleType() {
		return puzzleType;
	}
	/**
	 * sets puzzle type
	 * @param puzzleType
	 */
	public void setPuzzleType(String puzzleType) {
		this.puzzleType = puzzleType;
	}
	/**
	 * formats puzzle
	 */
	@Override 
	public String toString() {
		return super.toString() + " Puzzle Type: " + puzzleType;
	}
	/**
	 * formats puzzle
	 */
	@Override 
	public String format() {
		return super.format() + ";" + puzzleType;
	}
	

	
}
