
/**
 *
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 *
 * Redistribution and use with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * - the use is for academic purpose only - Redistributions of source code must
 * retain the above copyright notice, this list of conditions and the following
 * disclaimer. - Neither the name of Brahma Dathan or Sarnath Ramnath may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in
 * this module and are not responsible for any loss or damage resulting from its
 * use.
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Implementation of RefrigeratorDisplay. Has no conditionals.
 *
 */
public class GUIDisplay extends RefrigeratorDisplay implements ActionListener {

    private static SimpleDisplay frame;

    /**
     * Creates the frame and displays it.
     */
    private GUIDisplay() {
        frame = new SimpleDisplay();
        initialize();
    }

    /**
     * Inner class because the outer class extends RefrigeratorDisplay.
     *
     */
    private class SimpleDisplay extends JFrame {

        private GUIButton doorCloser = new DoorCloseButton("close door");
        private GUIButton doorOpener = new DoorOpenButton("open door");
        private GUIButton coolButton = new CoolButton("cool");
        private JLabel doorStatus = new JLabel("Door Closed");
        private JLabel timerValue = new JLabel("            ");
        private JLabel lightStatus = new JLabel("Light Off");
        private JLabel coolingStatus = new JLabel("Not cooling");

        private JTextField roomTempInput = new JTextField();
        private JTextField fridgeInput = new JTextField();
        private JPanel topPanel = new JPanel(new GridLayout(3, 2));
        private JPanel midPanel = new JPanel(new GridLayout(3, 1));
        private JPanel bottomPanel = new JPanel(new GridLayout(4, 2));
        private JLabel roomLabel = new JLabel("Room temp (50-100)");
        private JLabel fridgeLabel = new JLabel("Desired fidge temp (37-41)");
        private JButton setRoomTemp = new JButton("Set room temp");
        private JButton setFridgeTemp = new JButton("Set desired fridge temp");

        /**
         * Set up the JFrame
         */
        private SimpleDisplay() {
            super("Refrigerator");
            topPanel.add(roomLabel);
            topPanel.add(fridgeLabel);
            topPanel.add(roomTempInput);
            topPanel.add(fridgeInput);
            topPanel.add(setRoomTemp);
            topPanel.add(setFridgeTemp);
 
            midPanel.add(doorOpener);
            midPanel.add(doorCloser);
            midPanel.add(coolButton);

            bottomPanel.add(doorStatus);
            bottomPanel.add(lightStatus);
            bottomPanel.add(timerValue);
            bottomPanel.add(coolingStatus);

            getContentPane().add(midPanel);
            getContentPane().add(bottomPanel, BorderLayout.SOUTH);
            getContentPane().add(topPanel, BorderLayout.NORTH);
//			getContentPane().setLayout(new FlowLayout());
//			getContentPane().add(doorStatus);
//			getContentPane().add(lightStatus);
//			getContentPane().add(timerValue);
//			getContentPane().add(coolingStatus);
//			getContentPane().add(doorCloser);
//			getContentPane().add(doorOpener);
//			getContentPane().add(coolButton);
            doorCloser.addActionListener(GUIDisplay.this);
            doorOpener.addActionListener(GUIDisplay.this);
            coolButton.addActionListener(GUIDisplay.this);
            pack();
            setVisible(true);
        }
    }

    /**
     * No conditionals. Let the clicked button do the hard work.
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        ((GUIButton) event.getSource()).inform(this);
    }

    /**
     * Display a text indicating that the light is on
     */
    @Override
    public void turnLightOn() {
        frame.lightStatus.setText("Light On");
    }

    /**
     * Display a text indicating that the light is off
     */
    @Override
    public void turnLightOff() {
        frame.lightStatus.setText("Light Off");
    }

    /**
     * Display a text indicating that the door is closed
     */
    @Override
    public void doorClosed() {
        frame.doorStatus.setText("Door Closed");
    }

    /**
     * Display a text indicating that the door is open
     */
    @Override
    public void doorOpened() {
        frame.doorStatus.setText("Door Opened");
    }

    /**
     * Display the remaining cool time
     */
    @Override
    public void displayTimeRemaining(int value) {
        frame.timerValue.setText(" " + value);
    }

    /**
     * Display a text indicating that cooling has started
     */
    @Override
    public void startCooling() {
        frame.coolingStatus.setText("Cooling");
    }

    /**
     * Display a text indicating that cooling has ended
     */
    @Override
    public void notCooling() {
        frame.coolingStatus.setText("Not cooling");
    }

    /**
     * Start the whole show
     *
     * @param args not used
     */
    public static void main(String[] args) {
        RefrigeratorDisplay display = new GUIDisplay();
    }
}
