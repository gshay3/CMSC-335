/*
 * File Name: Shape.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This class represents a generic shape and stores the number of dimensions associated with it.
 */

package application;

public class Shape 
{
	//Stores the number of dimensions for the shape
	protected int numberOfDimensions;
	
	//Constructor to initialize the shape with a given number of dimensions
	public Shape(int numberOfDimensions)
	{
		this.numberOfDimensions = numberOfDimensions;
	}
	
	//Method to return the number of dimensions of the shape
	public int getNumDimensions()
	{
		return numberOfDimensions;
	}
}