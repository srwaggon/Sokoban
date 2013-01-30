package sokoban.entity;

import sokoban.world.Tile;

public abstract class Entity {
  Tile tile;

  public boolean moveTo(Tile nextTile) {

    // Neither wall nor occupied
    if (!nextTile.isAccessible() && !nextTile.isOccupied()) {
      nextTile.setOccupant(this);
      return true;
    }
    return false;
  }

  public Tile getTile() {
    return tile;
  }
}
