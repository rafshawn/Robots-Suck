/**
 * Robot
 * ---
 * Define the properties and behaviours of a robot within the simulation.
 * (i.e., movements, actions, etc.)
 */

enum Direction{
  // Up, Down, Left, Right
  U, D, L, R;
}

public class Robot {  // make this robot implement threads
  private int x;      // x-axis position
  private int y;      // y-axis position 
  Direction dir;      // direction
  
  public Robot(int x, int y, Direction dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }

  // Getters
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Direction getDir() {
    return dir;
  }

  // Setters
  public void moveUp() {
    setY(y - 1);
    dir = Direction.U;
  }
  public void moveDown() {
    setY(y + 1);
    dir = Direction.D;
  }

  public void moveRight() {
    setX(x + 1);
    dir = Direction.R;
  }

  public void moveLeft() {
    setX(x - 1);
    dir = Direction.L;
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }

  public void moveInSpiral(Room room) {
    /** Logic behind method:
     * Assuming there is always a robot starting in the centre cell
     * The robot travels in a counter-clockwise spiral pattern
     * until it reaches the edge of the room.
     * The initial direction of travel is up by default.
     * TODO: Move in spiral
     */

    int size = room.getSize();
    int maxSteps = (size - 1) / 2;
    int steps = 0;                  // steps taken (0 at start)
    boolean atEdge = false;

    // TODO: While not in room edge and still has steps, move in spiral
    while (!atEdge && steps < maxSteps) {
      while (!atEdge && room.getCell()[x][y] == 0) {
      // move the robot direction
      switch (dir) {
        case U:
          moveUp();
          break;
        case D:
          moveDown();
          break;
        case L:
          moveLeft();
          break;
        case R:
          moveRight();
          break;
      }

      // Clean cell if dirty
      if (room.getCell()[x][y] == 1) {
        room.getCell()[x][y] = 0;
      }

      // Check if robot is at edge
      atEdge = atEdge();

      /** Robot should not move beyond room's border.
       * Once the robot reaches edge, move in circular motion.
       * TODO: Move in circular motion
       */
      switch (dir) {
        case U:
          moveUp();
          break;
        case D:
          moveDown();
          break;
        case L:
          moveLeft();
          break;
        case R:
          moveRight();
          break;
      }

      // Increment steps
      steps++;
      }
    }
  }

  private boolean atEdge() {
    //check if the robot is beyond room's border
    return false;
  }
}