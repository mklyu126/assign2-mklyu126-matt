package exceptions;


/**
 * this is an execption class that tells the user they entered a negative number
 * @author Max
 *
 */
public class NegativeInputPrice extends Exception {
/**
 * this class informs the user they entered a negative number
 */
	public NegativeInputPrice() {
		super("Error: Negative input price");
	}

}
