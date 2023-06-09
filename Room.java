import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Room
 */

public class Room {
  private int size;
  private int[][] cell;
  private ArrayList<Dirt> dirts;

  // initialise room inside constructor
  public Room(int size) {
    this.size = size;
    cell = new int[size][size];
    initializeRoom();
    generateDirt();
  }

  private void initializeRoom() {
    for (int i = 0; i < size; i++) {      // iterate through rows
      for (int j = 0; j < size; j++) {    // iterate through columns
        cell[i][j] = 0;                   // sets current cell to 0 (dirty)
      } 
    }
  }

  static int getRoomSize(String fileName) throws FileNotFoundException {
    // takes the size of the room from the file `room.txt`
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int roomSize = sc.nextInt();
    sc.close();

    // if integer in room file is not an odd number, terminate
    if (roomSize % 2 != 0) {
      System.out.println("Error: Room size must be an odd number.");
      System.exit(0);
    }

    // Since the room is a square, rows = cols
    int rows = roomSize / 2 + 1;
    int cols = rows;

    System.out.println("Input File: " + fileName);
    System.out.println("Room size: " + roomSize);
    System.out.println("Grid dimensions: " + rows + "x" + cols);

    return roomSize;
  }

  /**
   * Generates dirt objects within the constraints of the room and never occupying spaces a robot has occupied.
   * i.e., no. of dirt < (no. of available cells - no. of robot occupied cells)
   */
  public void generateDirt() {
    dirts = new ArrayList<Dirt>();

    Random rand = new Random();
    int maxOccupiable = (size) - 1;
    int maxDirts = rand.nextInt(maxOccupiable) + 1;

    while (dirts.size() < maxDirts) {
      int x = (int) (Math.random() * size);
      int y = (int) (Math.random() * size);
      if (cell[x][y] == 0) {
        dirts.add(new Dirt(x, y));
        cell[x][y] = 1;
      }
    }

    System.out.println("Dirt generated: " + dirts.size());
  }

  /**
  * Getters
  */

  public int getSize() {
    return size;
  }

  public int[][] getCell(){
    return cell;
  }

  public ArrayList<Dirt> getDirtArrays() {
    return dirts;
  }
}
