import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Simulation
 */
public class Simulation {
  String roomFile = "./txt/room.txt";
  String robotFile = "./txt/robots.txt";

  Room room;
  ArrayList<Dirt> dirts;
  ArrayList<Robot> robots;
  // robotSpawner roboSpawner;
  
  public Simulation() throws FileNotFoundException {
    // initialize simulation objects
    room = new Room(Room.getRoomSize(roomFile));
    dirts = new ArrayList<Dirt>();
    robots = new ArrayList<Robot>();
    // roboSpawner = new robotSpawner();

    // spawn robots
    // robotSpawner.spawnRobots();

    // start simulation
    startSimulation();
  }

  private void startSimulation() {
    // TODO: start simulation
    for (Robot robot : robots) {
      robot.moveInSpiral(room);
    }
  }

  public static void main(String[] args) throws FileNotFoundException {
    Simulation sim = new Simulation();
  }

}