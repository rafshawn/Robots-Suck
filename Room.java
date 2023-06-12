import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Room
 */

public class Room {
  private int size;
  private int[][] cell;
  

  public Room(int size) {
    this.size = size;
    cell = new int[size][size];
    initializeRoom();
    // generateDirt();
  }

  private void initializeRoom() {
    System.out.println("Initializing room...");
    for (int i = 0; i < size; i++) {      // iterate through rows
      for (int j = 0; j < size; j++) {    // iterate through columns
        cell[i][j] = 0;                   // sets current cell to 0 (clean)
        System.out.print(cell[i][j] + " ");
      }
      System.out.println(); 
    }
    System.out.println();
  }

  static int getRoomSize(String fileName) throws FileNotFoundException {
    // Takes the size of the room from the file `room.txt`
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int roomSize = sc.nextInt();
    sc.close();

    // If integer in room file is not an odd number, terminate
    if (roomSize % 2 == 0) {
      System.out.println("Error: Room size must be an odd number.");
      System.exit(0);
    }

    int rows = roomSize;
    int cols = rows;

    System.out.println("Input File: " + fileName);
    System.out.println("Room size: " + rows + "x" + cols);
    System.out.println("Total number of cells: " + (rows * cols));
    System.out.println();

    return roomSize;
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
}