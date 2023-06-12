import java.util.ArrayList;
import java.util.Random;

/**
   * Generates dirt objects within the constraints of the room and never occupying spaces a robot has occupied.
   * i.e., no. of dirt < (no. of available cells - no. of robot occupied cells)
   * We assume that by default, a robot occupies the centre of the room.
   */
public class GetDirty {
  ArrayList<Dirt> dirts;
  
  public ArrayList<Dirt> generateDirt(Room room, ArrayList<Robot> robots) {
    int size = room.getSize();
    int[][] cell = room.getCell();

    dirts = new ArrayList<Dirt>();

    Random rand = new Random();
    int maxOccupiable = (size * size) - robots.size();
    int generatedDirts = 0;
    int maxDirts = rand.nextInt(maxOccupiable) + 1;

    while (generatedDirts < maxDirts) {
      int x = rand.nextInt(size);
      int y = rand.nextInt(size);
      if (cell[x][y] == 0 && !isOccupied(x, y, robots)) {
        dirts.add(new Dirt(x, y));
        cell[x][y] = 1;    // sets current cell to 1 (dirty)
        generatedDirts++;
      }
    }

    System.out.println("Dirt generated: " + dirts.size());
    // print new grid with dirt
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(cell[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();

    return dirts;
  }

  private boolean isOccupied(int x, int y, ArrayList<Robot> robots) {
    for (Robot robot : robots) {
      if (robot.getX() == x && robot.getY() == y && robot.isActive()) {
        return true;
      }
    }
    return false;
  }
}
