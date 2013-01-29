package sokoban;

import sokoban.entity.Entity;

public class Tile {
  public final boolean isStorage;
  public final boolean isWall;
  private Entity occupant;

  public Tile() {
    isStorage = false;
    isWall = false;
  }

  public Tile(final boolean isStorage, final boolean isWall) {
    this.isStorage = isStorage;
    this.isWall = isWall;
  }
  
  public Entity getOccupant() {
	  return this.occupant;
  }
  
  public boolean isOccupied() {
	  return occupant != null;
  }
  
  /* Returns true if entity is able to be
   * be placed here. Returns false if already
   * occupied.
   */
  public boolean occupyBy(Entity e){
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
}
