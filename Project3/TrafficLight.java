/*
 * File Name: TrafficLight.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: A runnable traffic light that cycles through RED, GREEN, and YELLOW
 * states with timed delays. Each light is assigned a position and supports pause, 
 * resume, and stop controls.
 */

package cmsc_335_project3;

import java.util.*;

enum TrafficLightColor
{
	RED, GREEN, YELLOW
}

public class TrafficLight implements Runnable
{
	private TrafficLightColor tlc;
	private int x;
	private static int numLights = 0;
	private static final Random rand = new Random();
	private volatile boolean stopped = false;
	private volatile boolean paused = false;
	
	// Constructor with specified initial color.
	TrafficLight(TrafficLightColor c)
	{
		tlc = c;
		initializePosition();
	}
	
	// Default constructor assigns a random initial color.
	TrafficLight()
	{
		TrafficLightColor[] values = TrafficLightColor.values();
		
		tlc = values[rand.nextInt(values.length)];
		initializePosition();
	}
	
	// For the lights to be spaced 1000 meters an int of 250 is equivalent to 1000 meters.
	// Assigns a position to the traffic light and increments the number of lights.
	private void initializePosition()
	{
		synchronized (TrafficLight.class)
		{
			numLights++;
			x = numLights * 250;
		}
	}
	
	// Main execution loop for the traffic light thread.
	// Cycle through GREEN, YELLOW, and RED with delays.
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
				switch(tlc)
				{
					case GREEN:
						sleepWithCheck(10000);
						tlc = TrafficLightColor.YELLOW;
						break;
					case YELLOW:
						sleepWithCheck(2000);
						tlc = TrafficLightColor.RED;
						break;
					case RED:
						sleepWithCheck(12000);
						tlc = TrafficLightColor.GREEN;
						break;
				}
			} catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				break;
			}
		}
	}
	
	// Sleeps in small increments while checking for pause/stop conditions.
	private void sleepWithCheck(int mill) throws InterruptedException
	{
		int elapsed = 0;
		while(elapsed < mill && !stopped)
		{
			while(paused && !stopped)
			{
				Thread.sleep(100);
			}
			Thread.sleep(100);
			elapsed += 100;
		}
	}
	
	// Pauses the traffic light cycle.
	public void pauseLight()
	{
		paused = true;
	}
	
	// Checks if the light is paused.
	public boolean isPaused()
	{
		return paused;
	}
	
	// Resumes the traffic light cycle.
	public void resumeLight()
	{
		paused = false;
	}
	
	// Stops the traffic light thread.
	public void stopLight()
	{
		stopped = true;
	}
	
	// Returns the current light color.
	public TrafficLightColor getColor()
	{
		return tlc;
	}
	
	// Returns the x-position of the traffic light.
	public int getX()
	{
		return x;
	}
}
