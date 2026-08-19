

public class Node {
    private Point point; //represent the coordinates of the node in the grid
    private Node parent; //represent the parent node
    private int f; //represent the total cost from start to finish node
    private int g; //represent the cost from start node to this node

    public Node(Point point, Node parent, int g, int h) { //constructor for creating a node with its coordinates, parent and cost
        this.point = point;
        this.parent = parent;
        this.g = g;
        this.f = g + h;
    }

    public Point getPoint() { //get method to retrieve the coordinates of the node
        return point;
    }

    public Node getParent() { //get method to retrieve the parent node
        return parent;
    }

    public int getF() { //get method to retrieve total estimated cost of the node
        return f;
    }

    public int getG() {
        return g;
    }
}

