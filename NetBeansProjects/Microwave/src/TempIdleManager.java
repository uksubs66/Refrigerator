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
 * This class manages the listeners associated with states that must act when
 * the timer runs out.
 * 
 * @author mh6624pa
 *
 */
public class TempIdleManager {
	private EventListenerList listenerList = new EventListenerList();
	private static TempIdleManager instance;

	/**
	 * Private for making the class a singleton
	 */
	TempIdleManager() {
	}

	/**
	 * Returns the instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static TempIdleManager instance() {
		if (instance == null) {
			instance = new TempIdleManager();
		}
		return instance;
	}

	/**
	 * Add a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTempIdleListener(TempIdleListener listener) {
		listenerList.add(TempIdleListener.class, listener);
	}

	/**
	 * Remove a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTempIdleListener(TempIdleListener listener) {
		listenerList.remove(TempIdleListener.class, listener);
	}

	/**
	 * Process the event by calling the timeRanOut method of the listener
	 * 
	 * @param event
	 *            the TimerRanoutEvent object
	 */
	public void processEvent(TempIdleEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(TempIdleListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((TempIdleListener) listeners[index]).tempIsIdle(event);
		}
	}
}
