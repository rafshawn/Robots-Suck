/**
 * Dirt
 */
public class Dirt {
  private int x;
  private int y;
  private boolean cleaned;

  public Dirt(int x, int y) {
    this.x = x;
    this.y = y;
    cleaned = false;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isCleaned() {
    return cleaned;
  }

  public void clean() {
    cleaned = true;
  }
  
}