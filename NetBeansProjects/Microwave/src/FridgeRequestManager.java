import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * Orchestrates clicks on the Cool button. It maintains a list of listeners for
 the CoolRequestEvent and invokes their fridgeRequested method when the button
 is clicked.
 * 
 * @author Brahma Dathan
 *
 */
public class FridgeRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FridgeRequestManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeRequestManager instance() {
		if (instance == null) {
			instance = new FridgeRequestManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFridgeRequestListener(FridgeRequestListener listener) {
		listenerList.add(FridgeRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFridgeRequestListener(FridgeRequestListener listener) {
		listenerList.remove(FridgeRequestListener.class, listener);
	}

	/**
	 * Handles the request to fridge.
	 * 
	 * @param event
	 *            the FridgeRequestEvent object
	 */
	public void processEvent(FridgeRequestEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeRequestListener) listeners[index]).fridgeRequested(event);
		}
	}
}

