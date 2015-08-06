/**
 *
 * @author willhawkins
 */
/**
 * Represents the door close button
 *
 */
public class SetRoomButton extends GUIButton {
	/**
	 * Crates the button with the required label
	 * 
	 * @param string
	 *            the label
	 */
	public SetRoomButton(String string) {
		super(string);
	}

	/**
	 * Tell the context to send it to the right listener
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		DoorCloseManager.instance().processEvent(new DoorCloseEvent(source));
	}
}
