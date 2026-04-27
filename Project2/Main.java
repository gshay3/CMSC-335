/*
 * File Name: Main.java
 * Date: 04/07/2026
 * Author: Griffin Shay
 * This Main class is a JavaFX application that provides a user interface for selecting, customizing, and drawing different
 * shapes on a canvas. It handles user input, validates dimensions, and uses the DrawShape class to render shapes and
 * display their corresponding area or volume information.
 */

package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("JavaFX Draw Shape");
			
			//Makes dropdown menus for selecting a shape and color
			ComboBox<String> shapeSelect = new ComboBox<>();
			shapeSelect.getItems().addAll("Circle", "Square", "Triangle", "Rectangle", "Sphere", 
					"Cube", "Cone", "Cylinder", "Torus");
			ColorPicker colorSelect = new ColorPicker(Color.BLUE);
			
			HBox selectors = new HBox(10, shapeSelect, colorSelect);
			
			Button draw = new Button("Draw Shape");
			
			final TextField dimension1 = new TextField();
			final TextField dimension2 = new TextField();
			final Label label1 = new Label();
			final Label label2 = new Label();
			final Label label3 = new Label();
			final Label confirmation = new Label();
			final Label info = new Label();
			
			//Creates a canvas to draw shapes on
			Canvas canvas = new Canvas(505, 505);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			
			//Event handler to disable/enable textfields or change their prompt text when a shape is selected
			shapeSelect.setOnAction(event ->
			{
				dimension1.setText(null);
				dimension2.setText(null);
				String shape = shapeSelect.getSelectionModel().getSelectedItem();
				
				if(shape.equals("Circle") || shape.equals("Square") || shape.equals("Sphere") || shape.equals("Cube"))
				{
					dimension2.setPromptText("");
					dimension2.setDisable(true);
				}
				else
				{
					dimension2.setDisable(false);
				}
				
				switch(shape)
				{
					case "Circle":
						dimension1.setPromptText("Enter the radius");
						break;
					case "Square":
						dimension1.setPromptText("Enter the length");
						break;
					case "Triangle":
						dimension1.setPromptText("Enter the base");
						dimension2.setPromptText("Enter the height");
						break;
					case "Rectangle":
						dimension1.setPromptText("Enter the width");
						dimension2.setPromptText("Enter the height");
						break;
					case "Sphere":
						dimension1.setPromptText("Enter the radius");
						break;
					case "Cube":
						dimension1.setPromptText("Enter the length");
						break;
					case "Cone":
						dimension1.setPromptText("Enter the radius");
						dimension2.setPromptText("Enter the height");
						break;
					case "Cylinder":
						dimension1.setPromptText("Enter the base");
						dimension2.setPromptText("Enter the height");
						break;
					case "Torus":
						dimension1.setPromptText("Enter the inner radius");
						dimension2.setPromptText("Enter the outer radius");
						break;
				}
			});
			
			/*
			 * Event handler that resets the canvas, validates the user input, draws a shape, and displays the shape info
			 * when the "Draw Shape" button is pressed
			 */
			
			draw.setOnAction(event ->
			{
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				label1.setText(null);
				label2.setText(null);
				label3.setText(null);
				String shape = shapeSelect.getSelectionModel().getSelectedItem();
				Color color = colorSelect.getValue();
				double val1, val2;
				DrawShape drawing = new DrawShape();
				
				String input1 = dimension1.getText();
				String input2 = dimension2.getText();
				
				if(shape == null)
				{
					label3.setText("You must select a shape.");
				}
				else
				{
					if(dimension2.isDisabled())
					{
						if(input1 == null || input1.isEmpty() || !validInput(input1))
						{
							label1.setText("You need to enter a positive number not exceeding 250.");
							
						}
						else
						{
							val1 = Double.parseDouble(input1);
							info.setText(drawing.drawShape(color, canvas, shape, val1, val1));
							confirmation.setText("Drawing a " + shape);
						}
					}
					else if(!dimension2.isDisabled())
					{
						if(input1 == null || input1.isEmpty() || !validInput(input1))
						{
							label1.setText("You need to enter a positive number not exceeding 250.");
							if(input2 == null || input2.isEmpty() || !validInput(input2))
							{
								label2.setText("You need to enter a positive number not exceeding 250.");
							}
						}
						else if(input2 == null || input2.isEmpty() || !validInput(input2))
						{
							label2.setText("You need to enter a positive number not exceeding 250.");
						}
						else if(validInput(input1) && validInput(input2))
						{
							val1 = Double.parseDouble(input1);
							val2 = Double.parseDouble(input2);
							if(shape.equals("Torus") && val2 <= val1)
							{
								label1.setText("The inner radius must be smaller than the outer radius.");
							}
							else
							{
								info.setText(drawing.drawShape(color, canvas, shape, val1, val2));
								confirmation.setText("Drawing a " + shape);
							}
						}
					}
				}
			});
			
			//Layout for input and output dropdown menus, labels, and textfields
			VBox input = new VBox(10, label3, selectors, label1, dimension1, label2, dimension2, draw, confirmation);
			VBox output = new VBox(10, info);
			
			//Root layout
			BorderPane root = new BorderPane(); 
			root.setPadding(new Insets(15));
			root.setTop(input);
			root.setCenter(canvas);
			root.setBottom(output);
			
			//Create and set scene
			Scene scene = new Scene(root,1000, 900);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Validates that input is a number between 0 and 250
	public boolean validInput(String dimension)
	{
		try
		{
			Double val = Double.parseDouble(dimension);
			if(val <= 0 || val > 250)
			{
				return false;
			}
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	//Main method to launch JavaFX application
	public static void main(String[] args) 
	{
		launch(args);
	}
}
