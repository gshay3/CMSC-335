/*
 * File Name: TwoDimensionalShape.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This abstract class represents a two-dimensional shape and defines a method for calculating area.
 */

package cmsc335_project1;

public abstract class TwoDimensionalShape extends Shape 
{
	//Constructor sets the number of dimensions to 2
	public TwoDimensionalShape()
	{
		super(2);
	}
	
	//Abstract method that must be implemented to calculate area
	public abstract double getArea();
}
