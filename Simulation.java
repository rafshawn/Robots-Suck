import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Simulation
 * ---
 * @author Shawn Adrian
 * 
 * Compile with: javac -d out *.java
 * Run with: java -cp out Simulation
 * 

 * TODO: Get robot to spawn before dirt gets generated
 */
public class Simulation {
  String roomFile = "./txt/room.txt";
  String robotFile = "./txt/robots.txt";

  Room room;
  ArrayList<Dirt> dirts;
  ArrayList<Robot> robots;
  RobotSpawner robotSpawner;
  GetDirty getDirty;
  
  public Simulation() throws FileNotFoundException {
    // initialize simulation objects
    room = new Room(Room.getRoomSize(roomFile));
    robotSpawner = new RobotSpawner();
    getDirty = new GetDirty();
    robots = new ArrayList<Robot>();

    // spawn robots
    robots = robotSpawner.spawnRobots(robotFile, room);

    // generate dirt
    dirts = getDirty.generateDirt(room, robots);

    // start simulation
    startSimulation();
  }

  private void startSimulation() {
    // TODO: start simulation

    // Create a new instance of RobotSpawner
    RobotSpawner robotSpawner = new RobotSpawner();
    
    /*
    for (Robot robot : robots) {
      robot.moveInSpiral(room);
    }
     */
  }

  public static void main(String[] args) throws FileNotFoundException {
    Simulation sim = new Simulation();
  }

}