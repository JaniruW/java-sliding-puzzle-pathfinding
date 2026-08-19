# Java Sliding Puzzle Pathfinding

A Java-based path-finding project developed as part of the **Algorithms** module at the University of Westminster.

The project focuses on solving grid-based sliding puzzles where a player moves across an ice-covered map. When the player moves in one of the four cardinal directions, they continue sliding until they encounter a wall or a rock.

The objective is to find a path from the starting position **S** to the finishing position **F**.

## Overview

The application processes puzzle maps represented using a simple text-based format.

The map contains:

* **`.`** — Empty ice square
* **`0`** — Rock / obstacle
* **`S`** — Starting position
* **`F`** — Finishing position

The program reads a map from an input file, determines the map dimensions and relevant positions, represents the problem using an appropriate data structure, and searches for a shortest path from the start to the finish.

The coursework required the implementation to produce the sequence of movements required to reach the finish when a solution exists.

## Features

### Map Parsing

The application includes functionality to read puzzle maps from input files.

The parser identifies:

* Map width
* Map height
* Starting position
* Finishing position
* Rock locations
* Empty ice squares

The parser is designed to work with map files following the required `.`, `0`, `S`, and `F` format.

### Path Finding

The project implements a path-finding solution for determining a shortest route from the starting position to the finishing position.

The movement system accounts for the sliding behaviour of the puzzle, where the player continues moving in the selected direction until reaching an obstacle or boundary.

### Solution Output

When a solution is found, the application outputs the sequence of movements required to reach the finish.

The output identifies the movement direction and the resulting position after each step.

### Data Structure

A dedicated data structure is used to represent the puzzle map and provide the necessary infrastructure for path finding.

The data structure allows the map, obstacles, start position and finish position to be represented and processed by the path-finding algorithm.

### Performance Analysis

The project also considers the performance of the implemented algorithm and data structure.

The analysis includes consideration of algorithmic complexity and Big-O notation.

## How the Puzzle Works

The player starts at the position marked **S** and needs to reach **F**.

The player can move in four directions:

* Up
* Down
* Left
* Right

Unlike a traditional grid where the player moves one square at a time, the puzzle uses frictionless ice.

When a direction is selected, the player continues sliding in that direction until:

* A rock is reached
* The boundary of the map is reached

The path-finding algorithm must therefore consider the resulting position after each slide rather than treating every adjacent square as a normal movement.

## Example Map

The puzzle maps use a text-based representation containing empty squares, rocks, a start position and a finish position.

The application reads these maps from input files and processes them to determine a valid shortest path.

## Project Structure

The project contains the Java source code required to:

* Represent the puzzle
* Parse input maps
* Store map information
* Perform path finding
* Generate the solution path
* Analyse algorithm performance

The repository also contains the required input files used for testing the implementation.

## Technologies Used

* **Java**
* **Data Structures**
* **Path-Finding Algorithms**
* **Graph / Search Concepts**
* **File I/O**
* **IntelliJ IDEA**
* **Git**
* **GitHub**

## Algorithms and Data Structures

The project demonstrates practical application of algorithms and data structures to a path-finding problem.

Key areas include:

* Map representation
* Search space representation
* Path finding
* State exploration
* Shortest-path calculation
* Input parsing
* Algorithmic complexity analysis

The coursework required selecting and implementing an appropriate data structure and an algorithm capable of finding a shortest path between the start and finish positions.

## Performance Analysis

Algorithmic performance is an important part of this project.

The implementation can be evaluated based on:

* Number of states explored
* Number of movements required
* Map size
* Time required to find a solution
* Memory usage
* Growth of the search space

The coursework specifically required a performance analysis and a suggested **Big-O classification** for the implemented design.

## Testing

Testing can be performed using different puzzle maps to verify that:

* Maps are parsed correctly
* Start and finish positions are identified correctly
* Rocks are represented correctly
* Valid movements are generated
* A shortest path is found when one exists
* The generated movement sequence reaches the destination
* Different map sizes can be processed

The coursework also provided benchmark examples for evaluating the performance of the implementation.

## How to Run

1. Clone the repository from GitHub.
2. Open the project in **IntelliJ IDEA**.
3. Configure a compatible **Java JDK**.
4. Open the main Java class of the application.
5. Run the application.
6. Provide or load a valid puzzle map.
7. The application processes the map and searches for a path from **S** to **F**.
8. The resulting movement sequence is displayed when a solution is found.


## Academic Context

**Module:** Algorithms
**Module Code:** 5SENG003W
**Institution:** University of Westminster
**Academic Year:** 2023/24

This project was developed as part of university coursework.


