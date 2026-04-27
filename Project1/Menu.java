/*
 * File Name: Menu.java
 * Date: 03/24/2026
 * Author: Griffin Shay
 * This class provides a menu interface that allows the user to create shapes and their area or volume.
 */

package cmsc335_project1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Menu 
{	
	//Scanner object for reading user input
	static Scanner input = new Scanner(System.in);
	
	public static void main(String args[])
	{
		//Double variables to store user input and Boolean to determine whether program should continue to loop
		double num1, num2;
		boolean program = true;
		
		System.out.println("*********Welcome to the Java OO Shapes Program **********");
		
		//Main program loop
		while(program)
		{
			System.out.println("Select from the menu below: \n"
					+ "1.	Construct a Circle\n"
					+ "2.	Construct a Rectangle\n"
					+ "3.	Construct a Square\n"
					+ "4.	Construct a Triangle\n"
					+ "5.	Construct a Sphere\n"
					+ "6.	Construct a Cube\n"
					+ "7.	Construct a Cone\n"
					+ "8.	Construct a Cylinder\n"
					+ "9.	Construct a Torus\n"
					+ "10.	Exit the program");
			
			int val;
			
			//Input validation loop for menu selection
			while(true)
			{
				String choice = input.nextLine();
				try
				{
					val = Integer.parseInt(choice);
					if (val < 1 || val > 10)
					{
						System.out.println("Invalid Selection. Please enter a number listed on the menu");	
					}
					else
					{
						break;
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Invalid Selection. Please enter a number listed on the menu.");
				}
			}
			
			//Based on user choice 1-9 are the available shapes, prompts for their respective dimensions, 
			//and call to calculate the area/volume. While choice 10 exits the program.
			switch(val)
			{
				case 1:
					System.out.println("You have selected a Circle");
					num1 = isNum("What is the radius?");
					Circle circle = new Circle(num1);
					System.out.println("The area of the Circle is " + circle.getArea());
					break;
				case 2:
					System.out.println("You have selected a Rectangle");
					num1 = isNum("What is the length?");
					num2 = isNum("What is the width?");
					Rectangle rectangle = new Rectangle(num1, num2);
					System.out.println("The area of the Rectangle is " + rectangle.getArea());
					break;
				case 3:
					System.out.println("You have selected a Square");
					num1 = isNum("What is the length?");
					Square square = new Square(num1);
					System.out.println("The area of the Square is " + square.getArea());
					break;
				case 4:
					System.out.println("You have selected a Triangle");
					num1 = isNum("What is the base?");
					num2 = isNum("What is the height?");
					Triangle triangle = new Triangle(num1, num2);
					System.out.println("The area of the Triangle is " + triangle.getArea());
					break;
				case 5:
					System.out.println("You have selected a Sphere");
					num1 = isNum("What is the radius?");
					Sphere sphere = new Sphere(num1);
					System.out.println("The volume of the Sphere is " + sphere.getVolume());
					break;
				case 6:
					System.out.println("You have selected a Cube");
					num1 = isNum("What is the length?");
					Cube cube = new Cube(num1);
					System.out.println("The volume of the Cube is " + cube.getVolume());
					break;
				case 7:
					System.out.println("You have selected a Cone");
					num1 = isNum("What is the radius?");
					num2 = isNum("What is the height?");
					Cone cone = new Cone(num1, num2);
					System.out.println("The volume of the Cone is " + cone.getVolume());
					break;
				case 8:
					System.out.println("You have selected a Cylinder");
					num1 = isNum("What is the radius?");
					num2 = isNum("What is the height?");
					Cylinder cylinder = new Cylinder(num1, num2);
					System.out.println("The volume of the Cylinder is " + cylinder.getVolume());
					break;
				case 9:
					System.out.println("You have selected a Torus");
					num1 = isNum("What is the inner radius?");
					num2 = isNum("What is the outer radius?");
					Torus torus = new Torus(num1, num2);
					System.out.println("The volume of the Torus is " + torus.getVolume());
					break;
				case 10:
					System.out.println("Thank you for using the program. Today is " 
							+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM d 'at' hh:mm a")));
					program = false;
					break;
			}
			
			//Prompt user if they would like to continue
			if(program)
			{
				System.out.println("Would you like to continue? (Y or N)");
			}
			
			//Validate continue/exit input
			while(program)
			{
				String answer = input.nextLine();
				if(answer.length() != 1 || (answer.charAt(0) != 'Y' && answer.charAt(0) != 'N'))
				{
					System.out.println("Sorry, I do not understand. Enter Y or N");
				}
				else if(answer.charAt(0) == 'N')
				{
					System.out.println("Thank you for using the program. Today is " 
							+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM d 'at' hh:mm a")));
					program = false;
				}
				else if(answer.charAt(0) == 'Y')
				{
					break;
				}
					
			}
		}
	}
	
	//Helper method to validate that input is numeric and positive
	public static double isNum(String prompt)
	{
		System.out.println(prompt);
		double num;
		while(true)
		{
			try
			{
				num = Double.parseDouble(input.nextLine());
				if(num <= 0)
				{
					System.out.println("Invalid input. Please enter a positive number");
				}
				else
				{
					break;
				}
				
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid input. Please enter a positive number");
			}
		}
		return num;
	}
}
