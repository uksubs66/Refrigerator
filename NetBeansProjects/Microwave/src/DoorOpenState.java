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
/**
 * Represents the state of the refrigerator when the door is open. When the
 * refrigerator has its door opened, the run method of this class is called. After
 * that, when an event occurs, the handle method is invoked.
 */
public class DoorOpenState extends RefrigeratorState implements DoorCloseListener {
	private static DoorOpenState instance;

	/**
	 * Private to make it a singleton
	 */
	private DoorOpenState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		DoorCloseManager.instance().removeDoorCloseListener(this);
	}

	/**
	 * For the singleton pattern
	 * 
	 * @return the object
	 */
	public static DoorOpenState instance() {
		if (instance == null) {
			instance = new DoorOpenState();
		}
		return instance;
	}

	/**
	 * Process door closed event
	 */
	@Override
	public void doorClosed(DoorCloseEvent event) {
		context.changeCurrentState(DoorClosedState.instance());

	}

	/**
	 * Initialize the state
	 */
	@Override
	public void run() {
		DoorCloseManager.instance().addDoorCloseListener(this);
		display.turnLightOn();
		display.nowIdle();
		display.doorOpened();
		display.displayFridgeTemp(0);
	}

}