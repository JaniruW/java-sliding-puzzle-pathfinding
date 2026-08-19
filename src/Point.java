

import java.util.Objects;

public class Point {
    private int x; //to store the x coordinate
    private int y; //to store the y coordinate

    public Point(int x, int y) { //constructor to initialize the point with x and y coordinates
        this.x = x;
        this.y = y;
    }

    public int getX() { //get method for x coordinate
        return x;
    }

    public int getY() {  //get method for y coordinate
        return y;
    }

    @Override
    public boolean equals(Object obj) { //compare two point objects for equality
        if (this == obj) return true;// Check if the compared object is the same instance
        if (!(obj instanceof Point)) return false;// Check if the compared object is not an instance of Point class
        Point otherPoint = (Point) obj;// Cast the compared object to Point type
        return x == otherPoint.x && y == otherPoint.y;// Compare the x and y coordinates of both Point objects
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);// Generate a hash code based on the x and y coordinates
    }
}
