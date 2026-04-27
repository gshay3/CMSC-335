/*
 * File Name: Cylinder.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a cylinder and provides a method to calculate its volume based on its radius and height.
 */

package cmsc335_project1;

public class Cylinder extends ThreeDimensionalShape
{
	//Radius and height of the cylinder
	double radius, height;
	
	//Constructor to initialize the cylinder with a given radius and height
	public Cylinder(double radius, double height)
	{
		this.radius = radius;
		this.height = height;
	}
	
	//Method to calculate the volume of the cylinder
	public double getVolume()
	{
		return Math.PI * Math.pow(radius, 2) * height;
	}
}
