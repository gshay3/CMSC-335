/*
 * File Name: DrawShape.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This DrawShape class extends Canvas and provides a method to draw various 2D and 3D shapes centered on the canvas
 * using JavaFX, based on user specified dimensions and color. It also calculates and returns descriptive information
 * about each shape, such as its area or volume, using corresponding shape classes.
 */

package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class DrawShape extends Canvas {
	
	//Draws a shape based on the user input and returns a description of the shape
	public String drawShape(Color color, Canvas canvas, String shape, double dimension1, double dimension2)
	{
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(5);
		gc.setFill(color);
		double centerX = canvas.getWidth() / 2;
		double centerY = canvas.getHeight() / 2;
		double halfDim1 = dimension1 / 2;
		double halfDim2 = dimension2 / 2;
		double radius = dimension1 * 2;
		double radius2 = dimension2 * 2;
		String info = "";
		
		
		//Determines which shape to draw, creates and Object of the chosen shape, and stores the shape's details
		switch(shape)
		{
			case "Circle":
				Circle circle = new Circle(dimension1);
				gc.fillOval((centerX - dimension1), (centerY - dimension1), radius, radius);
				info = ("You have drawn a Circle with a radius of: " + dimension1 + 
						"\nThe area of your Circle is: " + circle.getArea());
				break;
			case "Square":
				Square square = new Square(dimension1);
				gc.fillRect((centerX - halfDim1), (centerY - halfDim1), dimension1, dimension1);
				info = ("You have drawn a Square with a length of: " + dimension1 + 
						"\nThe area of your Square is: " + square.getArea());
				break;
			case "Triangle":
				Triangle triangle = new Triangle(dimension1, dimension2);
				gc.fillPolygon(new double []{centerX, centerX, (centerX + dimension1)}, 
						new double []{(centerY - halfDim2), (centerY + halfDim2), (centerY + halfDim2)}, 3);
				info = ("You have drawn a Triangle with a base of: " + dimension1 + " and a height of: " + dimension2 + 
						"\nThe area of your Triangle is: " + triangle.getArea());
				break;
			case "Rectangle":
				Rectangle rectangle = new Rectangle(dimension1, dimension2);
				gc.fillRect((centerX - halfDim1), (centerY - halfDim2), dimension1, dimension2);
				info = ("You have drawn a Rectangle with a width of: " + dimension1 + " and a height of: " + dimension2 + 
						"\nThe area of your circle is: " + rectangle.getArea());
				break;
			case "Sphere":
				Sphere sphere = new Sphere(dimension1);
				//Draws outline and grid like lines to simulate a 3D sphere
				gc.fillOval((centerX - dimension1), (centerY - dimension1), radius, radius);
				gc.strokeOval((centerX - dimension1), (centerY - dimension1), radius, radius);
				gc.strokeOval((centerX - (dimension1 * 0.25)), (centerY - dimension1), (radius * 0.25), radius);
				gc.strokeOval((centerX - (dimension1 * 0.5)), (centerY - dimension1), (radius * 0.5), radius);
				gc.strokeOval((centerX - (dimension1 * 0.75)), (centerY - dimension1), (radius * 0.75), radius);
				gc.strokeOval((centerX - (dimension1 * 0.87)), (centerY - dimension1), (radius * 0.87), radius);
				gc.strokeOval(centerX, (centerY - dimension1), 0, radius);
				gc.strokeOval((centerX - dimension1), (centerY - (dimension1 * 0.25)), radius, (radius * 0.25));
				gc.strokeOval((centerX - dimension1), (centerY - (dimension1 * 0.5)), radius, (radius * 0.5));
				gc.strokeOval((centerX - dimension1), (centerY - (dimension1 * 0.75)), radius, (radius * 0.75));
				gc.strokeOval((centerX - dimension1), (centerY - (dimension1 * 0.87)), radius, (radius * 0.87));
				gc.strokeOval((centerX - dimension1), centerY, radius, 0);
				info = ("You have drawn a Sphere with a radius of: " + dimension1 + 
						"\nThe volume of your Sphere is: " + sphere.getVolume());
				break;
			case "Cube":
				Cube cube = new Cube(dimension1);
				//Draws two offset boxes and connects with lines to make a wireframe cube
				gc.strokeRect((centerX - halfDim1), (centerY - halfDim1), dimension1, dimension1);
				gc.strokeRect(centerX, (centerY - dimension1), dimension1, dimension1);
				gc.strokeLine((centerX - halfDim1), (centerY - halfDim1), centerX, (centerY - dimension1));
				gc.strokeLine((centerX + halfDim1), (centerY - halfDim1), (centerX + dimension1), (centerY - dimension1));
				gc.strokeLine((centerX - halfDim1), (centerY + halfDim1), centerX, centerY);
				gc.strokeLine((centerX + halfDim1), (centerY + halfDim1), (centerX + dimension1), centerY);
				info = ("You have drawn a Cube with a length of: " + dimension1 + 
						"\nThe volume of your circle is: " + cube.getVolume());
				break;
			case "Cone":
				Cone cone = new Cone(dimension1, dimension2);
				gc.fillOval((centerX - dimension1), (centerY + halfDim2 - (dimension1 * 0.25)), radius, (radius * 0.25));
				gc.fillPolygon(new double []{centerX, (centerX - dimension1), (centerX + dimension1)}, 
						new double []{(centerY - halfDim2), (centerY + halfDim2), (centerY + halfDim2)}, 3);
				info = ("You have drawn a Cone with a radius of: " + dimension1 + " and a height of: " + dimension2 +
						"\nThe volume of your Cone is: " + cone.getVolume());
				break;
			case "Cylinder":
				Cylinder cylinder = new Cylinder(dimension1, dimension2);
				//Draws two ovals and a rectangle to make the body of the cylinder
				gc.fillOval((centerX - dimension1), (centerY - (dimension1 * 0.25) + halfDim2), radius, (radius * 0.25));
				gc.fillOval((centerX - dimension1), (centerY - (dimension1 * 0.25) - halfDim2), radius, (radius * 0.25));
				gc.fillRect((centerX - dimension1), (centerY - halfDim2), radius, dimension2);
				//Draws outlines of the cylinder for a 3D effect
				gc.strokeArc((centerX - dimension1), (centerY - (dimension1 * 0.25) + halfDim2), radius, (dimension1 * 0.5), 0, (-180), ArcType.OPEN);
				gc.strokeOval((centerX - dimension1), (centerY - (dimension1 * 0.25) - halfDim2), radius, (radius * 0.25));
				gc.strokeLine((centerX - dimension1), (centerY + halfDim2), (centerX - dimension1), (centerY - halfDim2));
				gc.strokeLine((centerX + dimension1), (centerY + halfDim2), (centerX + dimension1), (centerY - halfDim2));
				info = ("You have drawn a Cylinder with a radius of: " + dimension1 + " and a height of: " + dimension2 + 
						"\nThe volume of your Cylinder is: " + cylinder.getVolume());
				break;
			case "Torus":
				Torus torus = new Torus(dimension1, dimension2);
				//Draws the outer circle and grid lines for a 3D effect
				gc.fillOval((centerX - dimension2), (centerY - dimension2), radius2, radius2);
				gc.strokeOval((centerX - dimension2), (centerY - dimension2), radius2, radius2);
				gc.strokeOval((centerX - (dimension2 * 0.25)), (centerY - dimension2), (radius2 * 0.25), radius2);
				gc.strokeOval((centerX - (dimension2 * 0.5)), (centerY - dimension2), (radius2 * 0.5), radius2);
				gc.strokeOval((centerX - (dimension2 * 0.75)), (centerY - dimension2), (radius2 * 0.75), radius2);
				gc.strokeOval((centerX - (dimension2 * 0.87)), (centerY - dimension2), (radius2 * 0.87), radius2);
				gc.strokeOval(centerX, (centerY - dimension2), 0, radius2);
				gc.strokeOval((centerX - dimension2), (centerY - (dimension2 * 0.25)), radius2, (radius2 * 0.25));
				gc.strokeOval((centerX - dimension2), (centerY - (dimension2 * 0.5)), radius2, (radius2 * 0.5));
				gc.strokeOval((centerX - dimension2), (centerY - (dimension2 * 0.75)), radius2, (radius2 * 0.75));
				gc.strokeOval((centerX - dimension2), (centerY - (dimension2 * 0.87)), radius2, (radius2 * 0.87));
				gc.strokeOval((centerX - dimension2), centerY, radius2, 0);
				//Draws a white circle for the inner empty space
				gc.setFill(Color.WHITE);
				gc.fillOval((centerX - dimension1), (centerY - dimension1), radius, radius);
				gc.strokeOval((centerX - dimension1), (centerY - dimension1), radius, radius);
				info = ("You have drawn a Torus with a inner radius of: " + dimension1 + " and a outer radius of: " + dimension2 +
						"\nThe volume of your Torus is: " + torus.getVolume());
				break;
		}
		return info;
	}

}
