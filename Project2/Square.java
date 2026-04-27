/*
 * File Name: Square.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This class represents a square and provides a method to calculate its area based on the length of one side.
 */

package application;


public class Square extends TwoDimensionalShape 
{
	//Length of the square
	double length;
	
	//Constructor to initialize the square with a given length
	public Square(double length)
	{
		this.length = length;
	}
	
	//Method to calculate the area of the square
	public double getArea()
	{
		return Math.pow(length, 2);
	}
}
