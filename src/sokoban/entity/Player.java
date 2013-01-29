package sokoban.entity;

import sokoban.Board;
import sokoban.Tile;

public class Player extends Entity {


  public Player(Board board)  {
	  super(board);
  }
  
	public boolean move(int dx, int dy) {
		  
		int rx = x + dx; // resulting x
		int ry = y + dy; // resulting y
		  
		/* If the desired tile is occupied, try to
		* push the occupant. If successful,
		* move, otherwise, don't.
		*/
		Tile nextTile = board.getTile(rx, ry);
		
		  if (nextTile.isOccupied()) {
			if (nextTile.getOccupant().move(dx,  dy)) {
			  if (nextTile.occupyBy(this)) {
				tile.vacate();
				tile = nextTile;
				return super.move(dx, dy);
			  }				  
			}
		 }
	   return false;
	}

}
