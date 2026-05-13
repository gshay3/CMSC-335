/*
 * File Name: Controller.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: Manages the traffic simulation by coordinating cars, 
 * traffic lights, and the time tracker. Handles starting, pausing, 
 * stopping, and dynamically adding simulation elements.
 */

package cmsc_335_project3;

import java.util.*;

public class Controller
{
	private TimeStamp timeStamp;
	private Thread timeThread;
	
	private List<TrafficLight> lights;
	private List<Thread> lightThreads;
	
	private List<Car> cars;
	private List<Thread> carThreads;
	
	private boolean running = false;
	
	// Initializes the simulation with default cars and traffic lights.
	public Controller()
	{
		timeStamp = new TimeStamp();
		timeThread = new Thread(timeStamp);
		
		cars = new ArrayList<>();
		carThreads = new ArrayList<>();
		
		lights = new ArrayList<>();
		lightThreads = new ArrayList<>();
		
		for(int i = 0; i < 3; i++)
		{
			Car c = new Car();
			cars.add(c);
			carThreads.add(new Thread(c));
		}
		
		for(int i = 0; i < 3; i++)
		{
			TrafficLight t = new TrafficLight();
			lights.add(t);
			lightThreads.add(new Thread(t));
		}
		
		for(Car c : cars)
		{
			c.setLights(lights);
		}
		
	}
	
	// Starts or resumes the simulation.
	// Ensures all threads are running unpaused.
	public void startSim()
	{
		running = true;
		
		if(!timeThread.isAlive())
		{
			timeThread.start();
		}
		if(timeStamp.isPaused())
		{
			timeStamp.resumeTime();
		}
		
		for(int i = 0; i < carThreads.size(); i++)
		{
			if(!carThreads.get(i).isAlive())
			{
				carThreads.get(i).start();
			}
			if(cars.get(i).isPaused())
			{
				cars.get(i).resumeCar();
			}
		}
		
		for(int i = 0; i < lightThreads.size(); i++)
		{
			if(!lightThreads.get(i).isAlive())
			{
				lightThreads.get(i).start();
			}
			if(lights.get(i).isPaused())
			{
				lights.get(i).resumeLight();
			}
		}
	}
	
	// Adds a new car to the simulation.
	// Starts it immediately if the simulation is running.
	public void newCar()
	{
		Car c = new Car();
		c.setLights(lights);
		Thread n = new Thread(c);
		cars.add(c);
		carThreads.add(n);
		
		if(running)
		{
			n.start();
			
			if(timeStamp.isPaused())
			{
				c.pauseCar();
			}
		}
	}
	
	// Adds a new traffic light to the simulation.
	// Updates all cars with the new light list
	public void newLight()
	{
		TrafficLight t = new TrafficLight();
		Thread n = new Thread(t);
		lights.add(t);
		lightThreads.add(n);
		
		for(Car c : cars)
		{
			c.setLights(lights);
		}
		
		if(running)
		{
			n.start();
			
			if(timeStamp.isPaused())
			{
				t.pauseLight();
			}
		}
	}
	
	// Returns the list of cars
	public List<Car> getCars()
	{
		return cars;
	}
	
	// Returns the list of traffic lights.
	public List<TrafficLight> getLights()
	{
		return lights;
	}
	
	// Returns timer.
	public TimeStamp getTime()
	{
		return timeStamp;
	}
	
	// Pauses the entire simulation.
	public void pauseSim()
	{
		timeStamp.pauseTime();
		
		for(Car c : cars)
		{
			c.pauseCar();
		}
		
		for(TrafficLight t : lights)
		{
			t.pauseLight();
		}
	}
	
	// Stops the entire simulation and terminates all threads.
	public void stopSim()
	{
		running = false;
		
		timeStamp.stopTime();
		
		for(Car c : cars)
		{
			c.stopCar();
		}
		
		for(TrafficLight t : lights)
		{
			t.stopLight();
		}
	}
}
