/*
 * File Name: Triangle.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class represents a isosceles triangle and provides a method to calculate its area based on its base and height.
 */

package cmsc335_project1;

public class Triangle extends TwoDimensionalShape 
{
	//Base and height of the triangle
	double base, height;
	
	//Constructor to initialize the triangle with a given base and height
	public Triangle(double base, double height)
	{
		this.base = base;
		this.height = height;
	}
	
	//Method to calculate the area of the triangle
	public double getArea()
	{
		return (base * height) / 2.0;
	}
}
