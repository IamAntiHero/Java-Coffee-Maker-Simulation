# Java Coffee Maker Simulation

A console-based Java application that simulates a coffee maker, demonstrating Object-Oriented Programming concepts and multithreading. This project was developed as part of a Software Engineering course assignment.

## Project Overview

This application models a coffee maker with various components and features. Users can:
- Turn the coffee maker on and off
- Fill the water tank
- Select coffee strength (mild, medium, strong)
- Brew coffee
- View system status

## OOP Concepts Demonstrated

- **Inheritance**: Coffee maker extends base Appliance class
- **Polymorphism**: The operate() method is overridden in derived class
- **Composition**: Coffee maker has a heating element (tightly coupled)
- **Aggregation**: Coffee maker has a removable water tank (loosely coupled)
- **Encapsulation**: Private attributes with getters/setters

## Threading Implementation

- **BrewingThread**: Handles the coffee brewing process
- **MonitoringThread**: Monitors temperature during brewing
- **Synchronization**: Uses synchronized methods and blocks for thread safety

## Features

- Console-based user interface
- Coffee strength selection (mild, medium, strong)
- Brewing simulation with appropriate timing
- Temperature monitoring
- Operation logging to text file

## How to Run

1. Compile all Java files:
```
javac CoffeeMakerApp.java
```

2. Run the application:
```
java CoffeeMakerApp
```

3. Follow the on-screen menu to interact with the coffee maker

## Project Structure

- `Appliance.java` - Base class
- `HeatingElement.java` - Component class (composition)
- `WaterTank.java` - Component class (aggregation)
- `BrewingThread.java` - Thread for brewing coffee
- `MonitoringThread.java` - Thread for monitoring temperature
- `CoffeeMaker.java` - Main appliance class
- `Logger.java` - Logging functionality
- `CoffeeMakerApp.java` - Main application class with UI

## Course Information

- **Course**: Object-Oriented Programming
- **Year/Semester**: Year 1, Second Semester
- **Program**: Software Engineering

## Author

Name : Hussam and Javeria
Roll no : 24SW023 and 24SW117

