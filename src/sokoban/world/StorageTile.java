package sokoban.world;

import java.awt.Color;

public class StorageTile extends Tile {

  public StorageTile(int x, int y) {
    super(x, y);
  }

  @Override
  public boolean isAccessible() {
    return true;
  }

  public Color getColor() {
    return new Color(0, 196, 255);
  }

  public char getChar() {
    return '.';
  }

}
