/**
 * Robot
 * ---
 * Define the properties and behaviours of a robot within the simulation.
 * (i.e., movements, actions, etc.)
 */

enum Direction{
  U, D, L, R;
}

public class Robot {  // make this robot implement threads
  private int x;          // x-axis position
  private int y;          // y-axis position 
  private Direction dir;  // direction
  private boolean active; // true if robot is active
  
  public Robot(int x, int y, Direction dir) {
    this.x = x;
    this.y = y;
    this.dir = dir;
    this.active = false; // robot inactive at start
  }

  public void moveInSpiral(Room room) {
    int size = room.getSize();
    int maxSteps = (size + 1) / 2;
    int steps = 0;
    boolean atEdge = false;
    
    boolean[][] visited = new boolean[size][size];
    boolean completedCycle = false;


    while (steps <= maxSteps) {
      for (int i = 0; i < steps; i++) {
        move(Direction.U);
        cleanCurrentCell(room);
        if (atEdge(size)) {
          visited[x][y] = true;
          completedCycle = true;
        }
        updateRoomState(room);
      }
      for (int i = 0; i < steps; i++) {
        move(Direction.L);
        cleanCurrentCell(room);
        if (atEdge(size)) {
          visited[x][y] = true;
          completedCycle = true;
        }
        updateRoomState(room);
      }
      for (int i = 0; i < steps + 1; i++) {
        move(Direction.D);
        cleanCurrentCell(room);
        if (atEdge(size)) {
          visited[x][y] = true;
          completedCycle = true;
        }
        updateRoomState(room);
      }
      for (int i = 0; i < steps + 1; i++) {
        move(Direction.R);
        cleanCurrentCell(room);
        if (atEdge(size)) {
          visited[x][y] = true;
          completedCycle = true;
        }
        updateRoomState(room);
      }
      steps += 2;
      if (completedCycle) {
        boolean allCellsClean = checkAllCellsClean(visited);
        if (allCellsClean) {
          System.out.println("Room is clean!");
          return;
        }
      }
    }

  System.out.println("Cannot clean all edge cells.");
  }

  private void move(Direction dir) {
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
  }

  private void cleanCurrentCell(Room room) {
    int cellValue = room.getCell()[x][y];
    if (cellValue == 1) {
      room.getCell()[x][y] = 0;
    }
  }
  
  private void updateRoomState(Room room) {
    System.out.println("Updated Room State:");
    int[][] cell = room.getCell();
    for (int i = 0; i < cell.length; i++) {
      for (int j = 0; j < cell[i].length; j++) {
        if (i == x && j == y) {
          switch (dir) {
            case U:
              System.out.print("↑ ");
              break;
            case D:
              System.out.print("↓ ");
              break;
            case L:
              System.out.print("← ");
              break;
            case R:
              System.out.print("→ ");
              break;
          }
        } else {
          System.out.print(cell[i][j] + " ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  private boolean checkAllCellsClean(boolean[][] visited) {
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited[0].length; j++) {
        if (!visited[i][j]) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean atEdge(int size) {
    return (x == 0 || x == size - 1 || y == 0 || y == size - 1);
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

  public boolean isActive() {
    return active;
  }

  // Setters
  public void setX(int x){
    this.x = x;
  }

  public void setY(int y){
    this.y = y;
  }
  public void moveUp() {
    setX(x - 1);
    dir = Direction.U;
  }
  public void moveDown() {
    setX(x + 1);
    dir = Direction.D;
  }

  public void moveRight() {
    setY(y + 1);
    dir = Direction.R;
  }

  public void moveLeft() {
    setY(y - 1);
    dir = Direction.L;
  }

  public void setDir(Direction dir) {
    this.dir = dir;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}