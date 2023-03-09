package model;

public class BoardGames extends Toy {

	public BoardGames(int serialNum, String name, String brand, double price, int availableCount, int minimumAge, int numOfPlayers, String nameDesigners) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.numOfPlayers = numOfPlayers;
		this.nameDesigners = nameDesigners;
	}
	private int numOfPlayers;
	private String nameDesigners;

	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	public String getNameDesigners() {
		return nameDesigners;
	}
	public void setNameDesigners(String nameDesigners) {
		this.nameDesigners = nameDesigners;
	}
	@Override
	public String toString() {
		return super.toString() + "Number of Players: " + numOfPlayers + "Name of Designers: " + nameDesigners;
	}
	@Override 
	public String format() {
		return super.format() + numOfPlayers + nameDesigners;
	}
}
