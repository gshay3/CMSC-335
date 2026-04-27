/*
 * File Name: Sphere.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a sphere and provides a method to calculate its volume based on its radius.
 */

package cmsc335_project1;

public class Sphere extends ThreeDimensionalShape
{
	//Radius of the sphere
	double radius;
	
	//Constructor to initialize the sphere with a given radius
	public Sphere(double radius)
	{
		this.radius = radius;
	}
	
	//Method to calculate the volume of the sphere
	public double getVolume()
	{
		return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
	}
}
