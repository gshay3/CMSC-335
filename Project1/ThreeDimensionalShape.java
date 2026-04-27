/*
 * File Name: ThreeDimensionalShape.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This abstract class represents a three-dimensional shape and defines a method for calculating volume.
 */

package cmsc335_project1;

public abstract class ThreeDimensionalShape extends Shape 
{
	//Constructor sets the number of dimensions to 3
	public ThreeDimensionalShape()
	{
		super(3);
	}
	
	//Abstract method that must be implemented to calculate volume
	public abstract double getVolume();
}
