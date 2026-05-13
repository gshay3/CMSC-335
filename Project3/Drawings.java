/*
 * File Name: Drawings.java
 * Date: 05/05/2026
 * Author: Griffin Shay
 * Description: A custom JPanel responsible for rendering the traffic simulation,
 * including roads, lane markings, traffic lights, and cars.
 */

package cmsc_335_project3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.util.*;

public class Drawings extends JPanel
{
	private List<Car> cars;
	private List<TrafficLight> lights;
	private Color dimRed = Color.RED.darker().darker();
	private Color dimYellow = Color.YELLOW.darker().darker();
	private Color dimGreen = Color.GREEN.darker().darker();
	
	// Paints the simulation elements on the panel.
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// Use Graphics2D for better rendering control.
		Graphics2D g2d = (Graphics2D) g;
		
		// Enable anti-aliasing for smoother shapes.
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Draw the road background.
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 75, getWidth(), 225);
		
		// Draw the lane markings (yellow borders and white dashed lines).
		for(int i = 0; i < getWidth(); i += 40)
		{
			for(int j = 0; j < 4; j++)
			{
				if(j == 0 || j == 3)
				{
					g2d.setColor(Color.YELLOW);
					g2d.fillRect(i, (250 - (j * 45)), 1000, 5);
				}
				else
				{
					g2d.setColor(Color.WHITE);
					g2d.fillRect(i, (250 - (j * 45)), 20, 5);
				}
			}
		}
		
		// Draw vertical intersection markers.
		g2d.setColor(Color.WHITE);
		for(int i = 250; i < getWidth(); i += 250)
		{
			g2d.fillRect(i, 75, 10, 225);
		}
		
		// Draw traffic lights if available.
		if(lights != null)
		{
			for(TrafficLight t : lights)
			{
				int lightX = (int) t.getX();
				
				// Pole.
				g2d.setColor(Color.DARK_GRAY);
				g2d.fillRect(lightX, 80, 5, 30);
				
				// Light housing.
				g2d.setColor(Color.BLACK);
				g2d.fillRect(lightX - 5, 55, 15, 25);
				
				// Draw light signals based on current state.
				switch(t.getColor())
				{
					case RED:
						g2d.setColor(dimGreen);
						g2d.fillOval(lightX - 1, 72, 5, 5);
						g2d.setColor(dimYellow);
						g2d.fillOval(lightX - 1, 66, 5, 5);
						g2d.setColor(Color.RED.brighter().brighter());
						g2d.fillOval(lightX - 1, 60, 5, 5);
						break;
					case YELLOW:
						g2d.setColor(dimGreen);
						g2d.fillOval(lightX - 1, 72, 5, 5);
						g2d.setColor(Color.YELLOW.brighter().brighter());
						g2d.fillOval(lightX - 1, 66, 5, 5);
						g2d.setColor(dimRed.darker());
						g2d.fillOval(lightX - 1, 60, 5, 5);
						break;
					case GREEN:
						g2d.setColor(Color.GREEN.brighter().brighter());
						g2d.fillOval(lightX - 1, 72, 5, 5);
						g2d.setColor(dimYellow);
						g2d.fillOval(lightX - 1, 66, 5, 5);
						g2d.setColor(dimRed);
						g2d.fillOval(lightX - 1, 60, 5, 5);
						break;
				}				
			}
		}
		
		// Draw cars if available
		if(cars != null)
		{
			for(Car c : cars)
			{
				int carX = (int) c.getX();
				int carY = (int) c.getY();
				
				// Body.
				g2d.setColor(c.getColor());
				g2d.fillRect(carX, (carY + 90), 30, 10);
				
				// Roof.
				int[] xPoints = {(carX + 10), (carX + 20), (carX + 25), (carX + 5)};
				int[] yPoints = {(carY + 85), (carY + 85), (carY + 90), (carY + 90)};
				g2d.fillPolygon(xPoints, yPoints, 4);;
				
				// Wheels.
				g2d.setColor(Color.BLACK);
				g2d.fillOval((carX + 5), (carY + 100), 5, 5);
				g2d.fillOval((carX + 20), (carY + 100), 5, 5);
			}
		}
	}
	
	// Sets the list of cars to be drawn.
	public void setCars(List<Car> cars)
	{
		this.cars = cars;
	}
	
	// Sets the list of traffic lights to be drawn.
	public void setLights(List<TrafficLight> lights)
	{
		this.lights = lights;
	}
}
