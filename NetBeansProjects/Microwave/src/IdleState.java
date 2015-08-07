

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
 * Represents the state of the refrigerator when the cool button has been pressed
 * with the door closed. At that time, the run method of this class is called.
 * After that, when an event occurs, the handle method is invoked.
 *
 */
public class IdleState extends RefrigeratorState implements
		CoolRequestListener, TimerRanOutListener, TimerTickedListener,
		DoorOpenListener {
	private static IdleState instance;

	/**
	 * Private for the singleton pattern
	 */
	private IdleState() {
	}

	/**
	 * When the Refrigerator leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	@Override
	public void leave() {
		CoolRequestManager.instance().removeCoolRequestListener(this);
		DoorOpenManager.instance().removeDoorOpenListener(this);
		TimerRanOutManager.instance().removeTimerRanOutListener(this);
		TimerTickedManager.instance().removeTimerTickedListener(this);
	}

	/**
	 * For singleton
	 * 
	 * @return the object
	 */
	public static IdleState instance() {
		if (instance == null) {
			instance = new IdleState();
		}
		return instance;
	}

	/**
	 * Process Cool request
	 */
	@Override
	public void coolRequested(CoolRequestEvent event) {
		Timer.instance().addTimeValue(100);
		display.displayFridgeTemp(Timer.instance().getTimeValue());
	}

	/**
	 * Process door open request
	 */
	@Override
	public void doorOpened(DoorOpenEvent event) {
		context.changeCurrentState(DoorOpenState.instance());
	}

	/**
	 * Process clock tick Generates the timer runs out event
	 */
	@Override
	public void timerTicked(TimerTickedEvent event) {
		display.displayFridgeTemp(Timer.instance().getTimeValue());
	}

	/**
	 * Process clock ticks Generates the timer runs out event
	 */
	@Override
	public void timerRanOut(TimerRanOutEvent event) {
		display.displayFridgeTemp(Timer.instance().getTimeValue());
		context.changeCurrentState(DoorClosedState.instance());
	}

	/**
	 * Initializes the state Adds itself as a listener to managers Updates the
	 * dosplays
	 * 
	 */
	@Override
	public void run() {
                
		DoorOpenManager.instance().addDoorOpenListener(this);
		CoolRequestManager.instance().addCoolRequestListener(this);
		TimerRanOutManager.instance().addTimerRanOutListener(this);
		TimerTickedManager.instance().addTimerTickedListener(this);
		display.turnLightOff();
		Timer.instance().setTimeValue(13);
		display.startCooling();
		display.displayFridgeTemp(Timer.instance().getTimeValue());
	}
}