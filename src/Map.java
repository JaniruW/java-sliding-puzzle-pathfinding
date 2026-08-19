

import java.util.*;

public class Map {
    private char[][] grid; //2D array for represent characters in a grid.
    private int width;
    private int height;
    private Point startPoint;
    private Point finishPoint;
    private List<Point> rocks;

    public Map(int width, int height) { //Constructor initialize the map.
        this.width = width;
        this.height = height;
        this.grid = new char[height][width]; //initialize the grid with the passed values.
        this.rocks = new ArrayList<>();
    }

    public char[][] getGrid() {  //get method for grid
        return grid;
    }

    public int getWidth() { //get method for width
        return width;
    }

    public int getHeight() { //get method for height
        return height;
    }

    public Point getStartPoint() { //get method for start point
        return startPoint;
    }

    public Point getFinishPoint() { //get method for end point
        return finishPoint;
    }

    public List<Point> getRocks() {
        return rocks;
    }

    public void setStartPoint(Point startPoint) { //set method for set the start point
        this.startPoint = startPoint;
    }

    public void setFinishPoint(Point finishPoint) { //set method for set the end point
        this.finishPoint = finishPoint;
    }

    public void setCell(int x, int y, char value) { //method to set cell values in the grid accordingly
        grid[y][x] = value;
        if (value == 'S') { //if the value is S set to the start point
            setStartPoint(new Point(x, y));
        } else if (value == 'F') { //if the value is F set to the finish point
            setFinishPoint(new Point(x, y));
        } else if (value == '0') {//if the value is 0 add to the list of rocks
            rocks.add(new Point(x, y));
        }
    }
}
