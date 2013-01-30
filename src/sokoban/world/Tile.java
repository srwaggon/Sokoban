package sokoban.world;

import sokoban.entity.Entity;

public abstract class Tile {
  public final int X;
  public final int Y;
  protected Entity occupant;

  public Tile(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  public abstract boolean isAccessible();

  public Entity getOccupant() {
    return this.occupant;
  }

  public boolean isOccupied() {
    return occupant != null;
  }

  /*
   * Returns true if entity is able to be be placed here. Returns false if
   * already occupied.
   */
  public boolean setOccupant(Entity e) {
    if (occupant != null) {
      return false;
    }
    occupant = e;
    return true;
  }

  /*
   * Returns null if already vacated
   */
  public Entity vacate() {
    Entity entity = occupant;
    occupant = null;
    return entity;
  }

  /*
   * Return a new Tile of appropriate type '#' = wall tile 'o' = tile with
   * container '.' = storage tile ' ' = normal tile '@' = character tile
   */
  public static Tile parseTile(int x, int y, char c) {
    Tile tile = null;

    if (c == '#') {
      tile = new WallTile(x, y);
    } else if (c == '.') {
      tile = new StorageTile(x, y);
    } else {
      tile = new NormalTile(x, y);
    }
    return tile;
  }

  public abstract char getChar();

  public String toString() {
    return isOccupied() ? occupant.toString() : "" + getChar();
  }

}
