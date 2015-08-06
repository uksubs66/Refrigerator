import java.util.EventObject;

public class TempIdleEvent extends EventObject {
	/**
	 * The event is created with the identity of the
	 * 
	 * @param source
	 *            the object that created the event
	 */
	public TempIdleEvent(Object source) {
		super(source);
	}

}