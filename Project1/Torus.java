/*
 * File Name: Torus.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a torus and provides a method to calculate its volume based on its inner radius and outer radius.
 */

package cmsc335_project1;

public class Torus extends ThreeDimensionalShape
{
	//Inner radius and outer radius of the torus
	double innerRadius, outerRadius;
	
	//Constructor to initialize the torus with a given inner radius and outer radius
	public Torus(double innerRadius, double outerRadius)
	{
		this.innerRadius = innerRadius;
		this.outerRadius = outerRadius;
	}
	
	//Method to calculate the volume of the torus
	public double getVolume()
	{
		return 2.0 * Math.pow(Math.PI, 2) * Math.pow(outerRadius, 2) * innerRadius;
	}
}
