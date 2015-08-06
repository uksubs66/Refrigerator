import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * Orchestrates clicks on the Cool button. It maintains a list of listeners for
 the CoolRequestEvent and invokes their roomRequested method when the button
 is clicked.
 * 
 * @author Brahma Dathan
 *
 */
public class RoomRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static RoomRequestManager instance;

	/**
	 * Private to make it a singleton
	 */
	private RoomRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static RoomRequestManager instance() {
		if (instance == null) {
			instance = new RoomRequestManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addRoomRequestListener(RoomRequestListener listener) {
		listenerList.add(RoomRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeRoomRequestListener(RoomRequestListener listener) {
		listenerList.remove(RoomRequestListener.class, listener);
	}

	/**
	 * Handles the request to room.
	 * 
	 * @param event
	 *            the RoomRequestEvent object
	 */
	public void processEvent(RoomRequestEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(RoomRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((RoomRequestListener) listeners[index]).roomRequested(event);
		}
	}
}

