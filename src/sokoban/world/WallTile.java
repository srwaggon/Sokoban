package sokoban.world;

public class WallTile extends Tile {

  public WallTile(int x, int y) {
    super(x, y);
  }

  public boolean isAccessible() {
    return false;
  }

  public char getChar() {
    return '#';
  }
}
