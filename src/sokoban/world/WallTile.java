package sokoban.world;

import java.awt.Color;

public class WallTile extends Tile {

  public WallTile(int x, int y) {
    super(x, y);
  }

  public boolean isAccessible() {
    return false;
  }
  
  public Color getColor() {
    return Color.GRAY;
  }

  public char getChar() {
    return '#';
  }
}
