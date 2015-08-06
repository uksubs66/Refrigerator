import java.util.EventObject;
/**
 * Represents the Room request
 *
 */
public class RoomRequestEvent extends EventObject {
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public RoomRequestEvent(Object source) {
		super(source);
	}

}
