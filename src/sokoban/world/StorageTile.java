package sokoban.world;

public class StorageTile extends Tile {

  public StorageTile(int x, int y) {
    super(x, y);
  }

  @Override
  public boolean isAccessible() {
    return isOccupied();
  }

  public String toString() {
    return isOccupied() ? occupant.toString() : ".";
  }

}
