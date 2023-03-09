package model;

public class BoardGames extends Toy {

	public BoardGames(long serialNum, String name, String brand, double price, int availableCount, int minimumAge, int minPlayers, int maxPlayers, String nameDesigners) {
		super(serialNum, name, brand, price, availableCount, minimumAge);
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.nameDesigners = nameDesigners;
	}
	private int minPlayers;
	private int maxPlayers;
	private String nameDesigners;
	

	public int getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public String getNameDesigners() {
		return nameDesigners;
	}
	public void setNameDesigners(String nameDesigners) {
		this.nameDesigners = nameDesigners;
	}
	@Override
	public String toString() {
		return super.toString() + "Minimum Number of Players: " + minPlayers + "Maximum Number of Players " + maxPlayers + "Name of Designers: " + nameDesigners;
	}
	@Override 
	public String format() {
		return super.format() + minPlayers + maxPlayers + nameDesigners;
	}
}
