import java.util.EventObject;
/**
 * Represents the Fridge request
 *
 */
public class FridgeRequestEvent extends EventObject {
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public FridgeRequestEvent(Object source) {
		super(source);
	}

}
