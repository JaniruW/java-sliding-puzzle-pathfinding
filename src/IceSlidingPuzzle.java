
import java.io.FileNotFoundException;
import java.util.List;

public class IceSlidingPuzzle {
    public static void main(String[] args) {

        try {
            Map map = MapParser.parseMap("puzzle_40.txt");//parse the map from the file

            long timeStart=System.currentTimeMillis();
            List<Point> shortestPath = AStar.shortestPathFinderOnIce(map);//use A* to find the shortest path
            long timeNow = System.currentTimeMillis();

            if (shortestPath != null) { //if path is found print the path
                printShortestPath(shortestPath);
            } else {
                System.out.println("No solution found.");
            }

            double timeTaken= (timeNow-timeStart)/ 1000.0;
            System.out.println();
            System.out.println("Elapsed Time = "+timeTaken+" Seconds.");

        } catch (FileNotFoundException e) { //error handling if the file is not found
            System.err.println("File not found: " + e.getMessage());
        }

    }

    private static void printShortestPath(List<Point> shortestPath) {
        System.out.println("1. Start at (" + (shortestPath.get(0).getX() + 1) + "," + (shortestPath.get(0).getY() + 1) + ")");
        int lastIndex=0;
        for (int i = 1; i < shortestPath.size(); i++) { //iterate over the path and print each element
            Point previousPoint = shortestPath.get(i - 1);
            Point currentPoint = shortestPath.get(i);
            String direction = getDirection(previousPoint, currentPoint);
            System.out.println((i + 1) + ". Move " + direction + " to (" + (currentPoint.getX() + 1) + "," + (currentPoint.getY() + 1) + ")");
            lastIndex++;
        }
        System.out.println(lastIndex+2 +". Done!");
    }

    private static String getDirection(Point previousPoint, Point currentPoint) { //get the direction according to previousPoint and the currentPoint
        if (currentPoint.getX() > previousPoint.getX()) {
            return "right";
        } else if (currentPoint.getX() < previousPoint.getX()) {
            return "left";
        } else if (currentPoint.getY() > previousPoint.getY()) {
            return "down";
        } else if (currentPoint.getY() < previousPoint.getY()) {
            return "up";
        } else {
            return "stay";
        }
    }
}
