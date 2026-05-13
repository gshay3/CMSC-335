/*
 * File Name: TimeStamp.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: A runnable timer that updates a JLabel every second to display the elapsed time.
 * Supports pause, resume, and stop controls, and safely handles the UI
 * using SwingUtilities.invokeLater.
 */

package cmsc_335_project3;

import javax.swing.*;

public class TimeStamp implements Runnable
{
	private JLabel timeStamp;
	private int currentTime;
	private volatile boolean stopped = false;
	private volatile boolean paused = false;
	
	// Constructor initializes the label and starting time.
	public TimeStamp()
	{
		timeStamp = new JLabel("Time: 0 s");
		currentTime = 0;
	}
	
	/*
	 * The main execution method for the thread.
	 * Increments time every second and updates the label.
	 * Handles pause and stop functionality. 
	 */
	public void run()
	{
		while(!stopped)
		{
			try
			{
				while(paused)
				{
					Thread.sleep(100);
				}
				Thread.sleep(1000);
				currentTime++;
				SwingUtilities.invokeLater(() -> 
				{
					timeStamp.setText("Time: " + currentTime + " s");
				});
			} catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
	
	// Returns the JLabel displaying the time.
	public JLabel getLabel()
	{
		return timeStamp;
	}
	
	// Pause the timer.
	public void pauseTime()
	{
		paused = true;
	}
	
	// Check if the timer is currently paused.
	public boolean isPaused()
	{
		return paused;
	}
	
	// Resumes the timer if it was paused.
	public void resumeTime()
	{
		paused = false;
	}
	
	// Stops the timer thread.
	public void stopTime()
	{
		stopped = true;
	}
}
