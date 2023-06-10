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
    int numRobots = sc.nextInt();
    sc.nextLine();
    // TODO: If robots > 1, first robot will default to spawning at the center and the direction of travel being UP
    for (int i = 0; i < numRobots; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      String dirString = sc.next();
      Direction dir = Direction.valueOf(dirString);
      // TODO: If statement to check if the parameters set in the text file are correct

      // Add robot to ArrayList
      robots.add(new Robot(x, y, dir));
    }
    sc.close();

    System.out.println("Input File: " + fileName);
    System.out.println("Total number of robots: " + numRobots);
    // print position of each robot
    for (Robot robot : robots) {
      System.out.println("Position: (" + robot.getX() + ", " + robot.getY() + ")");
      System.out.println("Direction: " + robot.getDir());
      System.out.println();
    }
  }

  public ArrayList<Robot> spawnRobots(String robotFile) throws FileNotFoundException {
    // TODO: Add created robots into the robots list
    
    // spawn first robot at the center
    // spawned.add(new Robot(0, 0, Direction.U));

    // Call getRobotSpawn to read robots from the file and add them to the robots list
    getRobotSpawn(robotFile);

    // TODO: spawn every subsequent robot given that # of robots > 1

    return robots;
  }

  public ArrayList<Robot> getRobots() {
    return robots;
  }
}