
import java.util.*;

public class AStar {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //define the possible movement directions
    public static List<Point> shortestPathFinderOnIce(Map map) {
        List<Point> shortestPath = new ArrayList<>();//list to store the shortest path
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(Node::getF));//Priority queue to store nodes with lowest f score
        Set<Point> closedSet = new HashSet<>(); //set to store visited points
        java.util.Map<Point, Integer> gScore = new HashMap<>(); //map to store the cost for each point
        java.util.Map<Point, Node> parent = new HashMap<>();//map to store the parent node

        //get the starting and the finishing points from the map
        Point startPoint = map.getStartPoint();
        Point finishPoint = map.getFinishPoint();

        openSet.add(new Node(startPoint, null, 0, heuristic(startPoint, finishPoint)));//add the staring point to the priority queue with cost 0
        gScore.put(startPoint, 0);

        while (!openSet.isEmpty()) {
            //retrieving the node with the lowest cost
            Node current = openSet.poll();
            Point currentPoint = current.getPoint();

            //if the current point is the finishing point creating the path
            if (currentPoint.equals(finishPoint)) {
                while (current != null) {
                    shortestPath.add(current.getPoint());
                    current = current.getParent();
                }
                Collections.reverse(shortestPath);
                return shortestPath;
            }

            closedSet.add(currentPoint); //add the current point to the visited pints set

            for (int[] dir : DIRS) {  //exploring the neighbors with the possible directions
                int nextX = currentPoint.getX();
                int nextY = currentPoint.getY();

                //  sliding to a direction until a rock is hit
                while (validMoveOnIce(new Point(nextX + dir[0], nextY + dir[1]), map)) {
                    nextX += dir[0];
                    nextY += dir[1];

                    //if the neighbor is the finish point update the coordinates
                    if (map.getGrid()[nextY][nextX] == 'F') {
                        nextX = finishPoint.getX();
                        nextY = finishPoint.getY();
                        break; // Stop sliding loop
                    }
                }


                Point neighbor = new Point(nextX, nextY); //create the neighbor point

                if (!closedSet.contains(neighbor)) { //if the neighbour is not visited
                    int newGScore = gScore.getOrDefault(currentPoint, Integer.MAX_VALUE) + 1; //calculate the g score

                    if (newGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) { //if the newG score is better than the current
                        Node neighborNode = new Node(neighbor, current, newGScore, heuristic(neighbor, finishPoint));//create a new instance of neighbor
                        openSet.add(neighborNode); //add the neighbor to the priority queue
                        parent.put(neighbor, current); //update the parent node and the g score
                        gScore.put(neighbor, newGScore);
                    }
                }
            }
        }
        return null; // No path found
    }
    private static int heuristic(Point a, Point b) { // heuristic function to estimate the cost from a point to the finish point
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    private static boolean validMoveOnIce(Point point, Map map) { //function to check the valid move
        int coordinateX = point.getX();
        int coordinateY = point.getY();
        return coordinateX >= 0 && coordinateX < map.getWidth() && coordinateY >= 0 && coordinateY < map.getHeight() &&
                (map.getGrid()[coordinateY][coordinateX] == '.' || map.getGrid()[coordinateY][coordinateX] == 'F'||map.getGrid()[coordinateY][coordinateX] == 'S'); // Valid move on ice or finish
    }
}