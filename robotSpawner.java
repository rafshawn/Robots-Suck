import java.io.FileReader;
import java.util.ArrayList;

public class RobotSpawner {
  ArrayList<Robot> robots;

  public RobotSpawner() {
    // readRobotFile();
    spawnRobots();
  }

  private void readRobotFile() throws Exception {
    // Read the robots from the file `robots.txt`
    FileReader fr = new FileReader("./txt/robots.txt");
  }

  public void spawnRobots() {
    // TODO: Add created robots into the robots list

  }

  public ArrayList<Robot> getRobots() {
    return robots;
  }
}
