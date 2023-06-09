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
  }

  private void initializeRoom() {
    for (int i = 0; i < size; i++) {      // iterate through rows
      for (int j = 0; j < size; j++) {    // iterate through columns
        cell[i][j] = 0;                   // sets current cell to 0 (dirty)
      } 
    }
  }

  private static int getRoomSize(String filename) throws FileNotFoundException {
    // takes the size of the room from the file `room.txt`
    filename = "./Text-Files/room.txt";
    File file = new File(filename);
    Scanner sc = new Scanner(file);
    int i = sc.nextInt();
    sc.close();

    System.out.println("Input File: " + filename);
    System.out.println("Room size: " + i + "x" + i);

    return i;
  }

  private void generateDirt() {
    // Logic to generate dirt:
    // We know we have the room size, we want to randomly generate dirts
    // within the constraints of the room and never occupying spaces a robot has occupied.
    // i.e., no. of dirt < no. of available cells - no. of robot occupied cells.
    // Since there has to be at least one robot, we can use a while loop to generate dirts < no. of available cells.

    dirts = new ArrayList<Dirt>();

    Random rand = new Random();
    int maxOccupiable = (size * size) - 1;
    int maxDirts = rand.nextInt(maxOccupiable) + 1;

    while (dirts.size() < maxDirts) {
      int x = (int) (Math.random() * size);
      int y = (int) (Math.random() * size);
      if (cell[x][y] == 0) {
        dirts.add(new Dirt(x, y));
      }
    }

    System.out.println("Dirt generated: " + dirts.size());
  }

  public int[][] getCell(){
    return cell;
  }

  public ArrayList<Dirt> getDirtArrays() {
    return dirts;
  }
}
