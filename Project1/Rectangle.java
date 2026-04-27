/*
 * File Name: Rectangle.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a rectangle and provides a method to calculate its area based on its length and width.
 */

package cmsc335_project1;

public class Rectangle extends TwoDimensionalShape 
{
	//Length and Width of the rectangle
	double length, width;
	
	//Constructor to initialize the rectangle with a given length and width
	public Rectangle(double length, double width)
	{
		this.length = length;
		this.width = width;
	}
	
	//Method to calculate the area of the rectangle
	public double getArea()
	{
		return length * width;
	}
}
