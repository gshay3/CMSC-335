/*
 * File Name: Circle.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This class represents a circle and provides a method to calculate its area based on its radius.
 */

package application;


public class Circle extends TwoDimensionalShape 
{
	//Radius of the circle
	double radius;
	
	//Constructor to initialize the circle with a given radius
	public Circle(double radius)
	{
		this.radius = radius;
	}
	
	//Method to calculate the area of the circle
	public double getArea()
	{
		return Math.PI * Math.pow(radius, 2);
	}
}
