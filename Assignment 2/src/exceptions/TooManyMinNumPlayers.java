package exceptions;
/**
 * This is an execption class that is used in add toy and tells the user they added more minimum players then maximum players
 * @author Max
 *
 */
public class TooManyMinNumPlayers extends Exception{
/**
 * this class tells the user they entered more minimum player then maximum player
 */
	public TooManyMinNumPlayers() {
		super("Error: Minimum number of players is greater than maximum number of players");
	}

}
