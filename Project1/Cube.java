/*
 * File Name: Cube.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a cube and provides a method to calculate its volume based on the length of one side.
 */

package cmsc335_project1;

public class Cube extends ThreeDimensionalShape 
{
	//Length of the cube
	double length;
	
	//Constructor to initialize the cube with a given length
	public Cube (double length)
	{
		this.length = length;
	}
	
	//Method to calculate the volume of the cube
	public double getVolume()
	{
		return Math.pow(length, 3);
	}
}
