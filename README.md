📘 CMSC-335 Java Shape Applications Collection

This repository contains programming assignments completed for CMSC 335 (Object-Oriented and Event-Driven Programming). The projects focus on object-oriented design, geometric modeling, and graphical user interface development using Java and JavaFX.

Each project builds on core OOP principles while introducing user interaction, input validation, and visual rendering of shapes.
 <br> <br> <br>
📂 Projects Overview

🔹 Project 1: Object-Oriented Shape Calculator (Console-Based)
A Java application that models 2D and 3D shapes and calculates their area or volume through a menu-driven console interface.

Features:

- Implements multiple 2D shapes (Circle, Rectangle, Square, Triangle) <br>
- Implements multiple 3D shapes (Sphere, Cube, Cone, Cylinder, Torus) <br>
- Uses abstract base classes for shape hierarchies <br>
- Provides a menu-driven user interface for shape selection <br>
- Validates user input for numeric and positive values <br>
- Calculates and displays area or volume dynamically <br>
- Allows continuous execution with user-controlled exit <br>

Concepts Covered:

- Object-oriented programming (inheritance and abstraction) <br>
- Abstract classes and method overriding <br>
- Class hierarchies (Shape → 2D/3D shapes) <br>
- Mathematical computations (area and volume formulas) <br>
- User input handling and validation <br>
- Console-based UI design <br>

 <br>
🔹 Project 2: JavaFX Shape Drawing Application
A graphical JavaFX application that allows users to select, customize, and visually render shapes on a canvas.
 <br> <br>
  
Features:

- Interactive GUI with dropdown menus and color picker <br>
- Supports drawing of 2D and 3D shapes (Circle, Square, Triangle, Rectangle, Sphere, Cube, Cone, Cylinder, Torus) <br>
- Dynamically renders shapes centered on a canvas <br>
- Simulates 3D objects using layered and wireframe drawing techniques <br>
- Displays calculated area or volume alongside the drawn shape <br>
- Validates user input (numeric range and logical constraints) <br>
- Adjusts input fields dynamically based on selected shape <br>

Concepts Covered:

- JavaFX GUI development (Stage, Scene, Controls, Layouts) <br>
- Event-driven programming <br>
- Canvas-based graphics rendering <br>
- Input validation and user interaction handling <br>
- Reuse of object-oriented shape classes <br>
- Visual simulation of 3D objects in 2D space <br>

 <br>
🔹 Project 3: Multithreaded Traffic Simulator (Swing-Based)
A Java Swing application that simulates moving traffic using multithreading, animated graphics, and event-driven controls. The simulation models cars traveling across multiple lanes while interacting with dynamically changing traffic lights.
 <br> <br>
Features: <br> <br>

- Real-time animated traffic simulation using Java Swing
- Multithreaded cars and traffic lights implemented with Runnable
- Cars move at randomized speeds and stop at red lights
- Traffic lights cycle between RED, YELLOW, and GREEN states
- Interactive GUI controls for:
  - Start/Resume simulation
  - Pause simulation
  - Stop simulation
  - Add new cars dynamically
  - Add new intersections dynamically
- Live simulation timer displayed with JLabel
- Continuous rendering using Swing Timer
- Custom road, vehicle, and traffic light graphics drawn with Graphics2D
- Anti-aliased rendering for smoother visuals
- Dynamic lane assignment and intersection spacing
- Thread-safe pause, resume, and stop functionality using volatile state flags

Concepts Covered:

- Multithreading and concurrency in Java <br>
- Thread lifecycle management <br>
- Synchronization and shared resource coordination <br>
- Swing GUI development <br>
- Event-driven programming with action listeners <br>
- Custom graphics rendering using Graphics2D <br>
- Animation using Swing timers <br>
- Object-oriented system design <br>
- Real-time simulation logic <br>
- MVC-style separation of responsibilities (Controller, Model, View) <br>
