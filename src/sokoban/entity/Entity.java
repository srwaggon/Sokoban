package sokoban.entity;

import sokoban.Board;
import sokoban.Tile;

public class Entity {
	
	int x;
	int y;
	
	Board board;
	Tile tile;
	
	public Entity(Board board) {
		this.board = board;
	}

	
	public boolean move(int dx, int dy) {
		  
		  int rx = x + dx; // resulting x
		  int ry = y + dy; // resulting y
		  
		  if (board.isValidLoc(rx, ry)) {
			  Tile nextTile = board.getTile(rx,  ry);
			  
			  // Neither wall nor occupied
			  if (!nextTile.isWall && !nextTile.isOccupied()) { 
				  return true;
			  }
		  }
		  return false;
	}
}
