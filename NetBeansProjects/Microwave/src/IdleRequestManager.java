/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * Orchestrates clicks on the Idle button. It maintains a list of listeners for
 the IdleRequestEvent and invokes their idleRequested method when the button
 is clicked.
 * 
 * @author Brahma Dathan
 *
 */
public class IdleRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static IdleRequestManager instance;

	/**
	 * Private to make it a singleton
	 */
	private IdleRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static IdleRequestManager instance() {
		if (instance == null) {
			instance = new IdleRequestManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addIdleRequestListener(IdleRequestListener listener) {
		listenerList.add(IdleRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeIdleRequestListener(IdleRequestListener listener) {
		listenerList.remove(IdleRequestListener.class, listener);
	}

	/**
	 * Handles the request to idle.
	 * 
	 * @param event
	 *            the IdleRequestEvent object
	 */
//	public void processEvent(IdleRequestEvent event) {
//		EventListener[] listeners = listenerList
//				.getListeners(IdleRequestListener.class);
//		for (int index = 0; index < listeners.length; index++) {
//			((IdleRequestListener) listeners[index]).idleRequested(event);
//		}
//	}
}
