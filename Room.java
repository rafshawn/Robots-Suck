/**
 * Room
 */

public class Room {
  private int[][] grid;   // number of grids (horizontal, vertical)
  private int size;       // room size
  private int[][] dirts;  // dirts (horizontal, vertical)

  // initialise room inside constructor
  public Room(int size) {
    this.size = size;
    grid = new int[size][size];
    initializeRoom();
  }

  private void initializeRoom() {
    // TODO: Initialize the room
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        grid[i][j] = 0;
      } 
    }

  }

  public int[][] getGrid(){
    return grid;
  }

  private void generateDirt() {
    // TODO: Generate dirt
    
  }

  public int[][] getDirtArrays() {
    // TODO: Generate dirt
    return dirts;
  }

  private void readRoomFile(){
    // takes the size of the room from the file `room.txt`
  }

  // TODO: Add necessary methods

  // TODO: Implement additional functionality

  // TODO: Add any other required methods
}
