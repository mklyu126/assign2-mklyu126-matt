package exceptions;

public class TooManyMinNumPlayers extends Exception{

	public TooManyMinNumPlayers() {
		super("Error: Minimum number of players is greater than maximum number of players");
	}

}
