import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RobotSpawner {
  private static ArrayList<Robot> robots;

  public RobotSpawner() {
    robots = new ArrayList<Robot>();
  }

  public void getRobotSpawn(String fileName) throws FileNotFoundException {
    // Read the robots from the file `robots.txt`
    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    if (sc.hasNextInt()){
      int numRobots = sc.nextInt();
      sc.nextLine();

      // Checks each line to make sure input is correct
      for (int i = 0; i < numRobots; i++) {
        if(sc.hasNextInt()){
          int x = sc.nextInt();
          if(sc.hasNextInt()){
            int y = sc.nextInt();
            if(sc.hasNext()){
              String dirString = sc.next();
              Direction dir = Direction.valueOf(dirString);

              // If all conditions met, add robot to ArrayList
              robots.add(new Robot(x, y, dir));
            } else {
              System.out.println("Error: Direction must be a string or is missing.");
              System.exit(0);
            }
          } else {
            System.out.println("Error: Y coordinate must be an integer or is missing.");
            System.exit(0);
          }
        } else {
          System.out.println("Error: X coordinate must be an integer or is missing.");
          System.exit(0);
        }
      }
    } else {
      System.out.println("Error: Number of robots must be an integer or is missing.");
    }
    
    sc.close();

    System.out.println("Input File: " + fileName);
    System.out.println("Total number of robots: " + robots.size());
    // print position of each robot
    for (Robot robot : robots) {
      System.out.println("Position: (" + robot.getX() + ", " + robot.getY() + ")");
      System.out.println("Direction: " + robot.getDir());
      System.out.println();
    }
  }

  public ArrayList<Robot> spawnRobots(String robotFile, Room room) throws FileNotFoundException {
    getRobotSpawn(robotFile);
  
    // TODO: if only one robot, second line scanned is the coordinates

    // Spawn the first robot at the center of the room
    int centerX = room.getSize() / 2;
    int centerY = room.getSize() / 2;
    robots.get(0).setX(centerX);
    robots.get(0).setY(centerY);
    robots.get(0).setActive(true);  // TODO: Remove after robot spawn fixed
  
    // spawn every subsequent robot given that # of robots > 1
    for (int i = 1; i < robots.size(); i++) {
      // Set the position of the i-th robot using the coordinates from the file
      int x = robots.get(i).getX();
      int y = robots.get(i).getY();
      robots.get(i).setX(x);
      robots.get(i).setY(y);
      robots.get(0).setActive(true);  // TODO: Remove after robot spawn fixed
    }
  
    return robots;
  }

  /**
   * Getters
   */
  public ArrayList<Robot> getRobots() {
    return robots;
  }

  // getter for numRobots
  public int getNumRobots() {
    return robots.size();
  }
}
