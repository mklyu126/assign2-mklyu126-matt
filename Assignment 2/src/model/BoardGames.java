package model;

public class BoardGames extends Toy {

	public BoardGames(int numOfPlayers, String nameDesigners) {
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
		return "Number of Players: " + numOfPlayers + "Name of Designers: " + nameDesigners;
	}

}
