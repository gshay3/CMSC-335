/*
 * File Name: Car.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: A runnable car that moves horizontally across lanes at a random speed.
 * Cars stop at nearby traffic lights and support pause, resume, and stop controls.
 */

package cmsc_335_project3;

import java.awt.Color;
import java.util.*;

public class Car implements Runnable
{
	private double x;
	private double y;
	private static int numLanes = 0;
	private double speed;
	private double kmph;
	private volatile boolean stopped = false;
	private volatile boolean paused = false;
	private Random km;
	private static Random rand = new Random();
	private Color color;
	private List<TrafficLight> lights;
	
	// Constructor initializes car speed, color, and position.
	public Car ()
	{
		km = new Random();
		kmph = 1 + km.nextDouble() * 60;
		speed = kmph * (5.0 / 18.0);
		color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		initializePosition();
	}
	
	// Assigns the car to a lane and sets initial position.
	// Cycles through 3 lanes spaced 45 units apart.
	private void initializePosition()
	{
		synchronized (Car.class)
		{
			numLanes++;
			y = numLanes * 45;
			if(numLanes == 3)
			{
				numLanes = 0;
			}
		}
		x = 0;
	}
	
	// Main execution loop.
	// Moves the car forward unless paused/stopped or blocked by a red light.
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
				sleepWithCheck(1000);
				if(!redLight())
				{
					x += speed;
				}
			} catch (InterruptedException e)
			{
				Thread.currentThread().interrupt();
				break;
			}
			
		}
	}
	
	// Sleeps in small increments to allow responsiveness to pause/stop.
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
	
	// Pause the car's movement.
	public void pauseCar()
	{
		paused = true;
	}
	
	// Checks if the car is paused.
	public boolean isPaused()
	{
		return paused;
	}
	
	// Resumes the car's movement.
	public void resumeCar()
	{
		paused = false;
	}
	
	// Stops the car thread.
	public void stopCar()
	{
		stopped = true;
	}
	
	// Returns the x-position of the car.
	public double getX()
	{
		return x;
	}
	
	// Returns the y-position of the car.
	public double getY()
	{
		return y;
	}
	
	// Returns the speed of the car.
	public double getSpeed()
	{
		return speed;
	}
	
	// Returns the color of the car.
	public Color getColor()
	{
		return color;
	}
	
	// Assigns the list of traffic lights the car should monitor.
	public void setLights(List<TrafficLight> lights)
	{
		this.lights = lights;
	}
	
	// Checks if there is a red light ahead within stopping distance.
	private boolean redLight()
	{
		for(TrafficLight t : lights)
		{
			double lightX = t.getX();
			
			if(t.getColor() == TrafficLightColor.RED && x < lightX && (lightX - x) < 50)
			{
				return true;
			}
		}
		
		return false;
	}
}
