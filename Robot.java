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
  
  // Getters
  public Robot(int x, int y, Direction dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Direction getDir() {
    return dir;
  }

  public void moveInSpiral() {
    // TODO: Move in spiral

    // TODO: Move in circular motion
    
  }

  private boolean atEdge() {
    //check if the robot is beyond room's border
    return false;
  }

  // Setters
  public void moveUp() {
    setY(y - 1);
  }
  public void moveDown() {
    setY(y + 1);
  }

  public void moveRight() {
    setX(x + 1);
  }

  public void moveLeft() {
    setX(x - 1);
  }

  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }
}