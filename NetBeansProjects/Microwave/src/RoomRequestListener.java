
import java.util.EventListener;



/**
 * Any class may be a CoolRequestListener to process cool requests
 * 
 * @author Brahma Dathan
 *
 */
public interface RoomRequestListener extends EventListener {
	/**
	 * Processes cool requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void roomRequested(RoomRequestEvent event);
}