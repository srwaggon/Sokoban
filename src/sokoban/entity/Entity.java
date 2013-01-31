package sokoban.entity;

import java.awt.Graphics;

import sokoban.world.Tile;

public abstract class Entity {
  Tile tile;

  public boolean moveTo(Tile nextTile) {

    // Neither wall nor occupied
    if (nextTile.isAccessible() && !nextTile.isOccupied()) {

      // if successfully able to occupy the tile
      if (nextTile.setOccupant(this)) {

        // leave old tile
        if (tile != null) {
          tile.vacate();
        }

        // move to new one
        tile = nextTile;
        return true;
      }
    }
    return false;
  }
  
  public abstract void paint(Graphics g, int x, int y, int tileSize);

  public Tile getTile() {
    return tile;
  }
}
