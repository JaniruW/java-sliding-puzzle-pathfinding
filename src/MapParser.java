

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapParser {
    public static Map parseMap(String mapFile) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(mapFile));//create a scanner to read the text file which carries the map
        List<String> textLines = new ArrayList<>();//list to store each line of the text file

        //variables to track height and the width of the map
        int mapWidth = 0;
        int mapHeight = 0;

        while (scanner.hasNextLine()) { //while loop to read each line of the map
            String textLine = scanner.nextLine().trim(); // read the next line and remove any white space.

            if (textLine.isEmpty()) { //condition to skip empty line
                continue;
            }

            if (mapWidth == 0) {
                mapWidth = textLine.length();
            } else if (textLine.length() != mapWidth) {
                System.err.println("Error: Inconsistent line width in map file.");
                scanner.close();
                return null; // Abort parsing if line widths are inconsistent
            }

            textLines.add(textLine);//add the trimmed text line to the array
            mapHeight++; //increment the height
        }

        scanner.close();

        Map map = new Map(mapWidth, mapHeight);//creating a map object with the width and height of the map

        for (int y = 0; y < mapHeight; y++) { //iterates through each line of text in the list
            String line = textLines.get(y);//get the text line
            for (int x = 0; x < mapWidth; x++) { //iterates through the characters in the text line
                map.setCell(x, y, line.charAt(x)); // Set the cell to a character.
            }
        }

        return map;
    }
}