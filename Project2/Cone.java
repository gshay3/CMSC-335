/*
 * File Name: Cone.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This class represents a cone and provides a method to calculate its volume based on its radius and height.
 */

package application;


public class Cone extends ThreeDimensionalShape
{
	//Radius and height of the cone
	double radius, height;
	
	//Constructor to initialize the cone with a given radius and height
	public Cone(double radius, double height)
	{
		this.radius = radius;
		this.height = height;
	}
	
	//Method to calculate the volume of the cone
	public double getVolume()
	{
		return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
	}
}
