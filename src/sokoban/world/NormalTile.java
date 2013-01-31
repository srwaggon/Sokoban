package sokoban.world;

import java.awt.Color;

public class NormalTile extends Tile {

  public NormalTile(int x, int y) {
    super(x, y);
  }

  public boolean isAccessible() {
    return true;
  }

  public Color getColor() {
    return Color.WHITE;
  }

  public char getChar() {
    return ' ';
  }

}
