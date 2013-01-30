package sokoban.world;

public class NormalTile extends Tile {

  public NormalTile(int x, int y) {
    super(x, y);
  }

  public boolean isAccessible() {
    return true;
  }

  public String toString() {
    return " ";
  }

}
