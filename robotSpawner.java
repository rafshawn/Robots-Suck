import java.io.FileReader;
import java.util.ArrayList;

public class robotSpawner {
  ArrayList<Robot> robots;

  public robotSpawner() {
    // readRobotFile();
    spawnRobots();
  }

  private void readRobotFile() throws Exception {
    // Read the robots from the file `robots.txt`
    FileReader fr = new FileReader("./Text-Files/robots.txt");
  }

  public void spawnRobots() {
    // TODO: Add created robots into the robots list

  }

  public ArrayList<Robot> getRobots() {
    return robots;
  }
}
