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
import java.util.Observable;
import java.util.Observer;

/**
 * The Temp for the refrigerator
 *
 */
public class Temp implements Observer {
	private static Temp instance;
	private static int tempValue;
        private static int setTemp = 50;
        private static int setRoom = 80;
        private static int roomHigh;
        private static int roomLow;
        private static int fridgeHigh;
        private static int fridgeLow;
        private static int lossOpen;
        private static int lossClosed;
        private static int startDiff = 2;
        private static int coolRate = 20;
        

	/**
	 * For singleton
	 */
	private Temp() {
		instance = this;
		Clock.instance().addObserver(instance);
	}

	/**
	 * For singleton pattern
	 * 
	 * @return the instance
	 */
	public static Temp instance() {
		if (instance == null) {
			instance = new Temp();
		}
		return instance;
	}

	/**
	 * Set the time for the Temp
	 * 
	 * @param value
	 *            Temp initial value
	 */
	public void setTempValue(int value) {
		this.tempValue = value;
	}

	/**
	 * Add to the time value
	 * 
	 * @param value
	 *            extra time for the time value
	 */
	public void coolingTemp() {
		
                tempValue -= (setRoom / coolRate);
            //tempValue += value;
	}

	/**
	 * Get the remaining time
	 * 
	 * @return
	 */
	public int getTempValue() {
		return tempValue;
	}

	/**
	 * Get the clock tick and process it
	 */
	@Override
	public void update(Observable clock, Object value) {
		if (tempValue > (setTemp + startDiff)) {
			TempCoolManager.instance().processEvent(
					new TempCoolEvent(instance));
		} else {
			TempIdleManager.instance().processEvent(
					new TempIdleEvent(instance));
		}

	}
}