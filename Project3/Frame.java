/*
 * File Name: Frame.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: Sets up the main GUI for the traffic simulator, including the simulation
 * display, time label, and control buttons. Connects user actions to the controller.
 */

package cmsc_335_project3;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class Frame
{
	// Constructs the main application window and initializes all UI components.
	public Frame()
	{
		// Create the main application window.
		JFrame frame = new JFrame("Traffic Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create controller to manage simulation logic.
		Controller controller = new Controller();
		
		// Get the time tracker from the controller.
		TimeStamp timeStamp = controller.getTime();
		
		// Panel to display the time label.
		JPanel timePanel = new JPanel();
		timePanel.add(timeStamp.getLabel());
		
		// Create a drawing panel for simulation visuals.
		Drawings simulator = new Drawings();		
		simulator.setPreferredSize(new Dimension(1500, 400));
		
		// Provide car and traffic lights to the drawing panel.
		simulator.setCars(controller.getCars());
		simulator.setLights(controller.getLights());
		
		// Panel to hold control buttons.
		JPanel controlPanel = new JPanel();
		
		// Create control buttons.
		JButton start = new JButton("Start/Resume");
		JButton pause = new JButton("Pause");
		JButton stop = new JButton("Stop");
		JButton addCar = new JButton("Add Car");
		JButton addIntersec = new JButton("Add Intersection");
		
		// Add buttons to the control panel.
		controlPanel.add(start);
		controlPanel.add(pause);
		controlPanel.add(stop);
		controlPanel.add(addCar);
		controlPanel.add(addIntersec);
		
		// Add components to the frame using BorderLayout.
		frame.add(timePanel, BorderLayout.CENTER);
		frame.add(simulator, BorderLayout.NORTH);
		frame.add(controlPanel, BorderLayout.SOUTH);
		
		// Size the frame and make it visible.
		frame.pack();
		frame.setVisible(true);
		
		// Attach button actions to controller methods.
		start.addActionListener(e -> controller.startSim());
		pause.addActionListener(e -> controller.pauseSim());
		stop.addActionListener(e -> controller.stopSim());
		addCar.addActionListener(e -> controller.newCar());
		addIntersec.addActionListener(e -> controller.newLight());
		
		// Timer to continuously repaint the simulation every 50 milliseconds.
		new Timer(50, e -> simulator.repaint()).start();
	}
}
