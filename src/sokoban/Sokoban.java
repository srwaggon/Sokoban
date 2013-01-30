package sokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;

import sokoban.entity.Entity;
import sokoban.entity.Player;
import sokoban.gfx.GUI;
import sokoban.world.Board;
import sokoban.world.Tile;

public class Sokoban {

  Board board;
  Player player;
  List<Box> boxes;

  GUI gui;

  public Sokoban(String[] levelData, boolean gfx) {
    board = new Board(levelData);
    boxes = new ArrayList<Box>();

    if (gfx) {
      gui = new GUI();
    }
  }

  public boolean handleInput(char input) {
    switch (input) {
    case 'w':
      return tryMove(-1, 0, player);

    case 'a':
      return tryMove(0, -1, player);

    case 's':
      return tryMove(0, 1, player);

    case 'd':
      return tryMove(1, 0, player);

    default:
      return false; // input was bad and was not processed.
    }
  }

  public boolean tryMove(int dx, int dy, Entity movingEntity) {
    if (dx != 0 && dy != 0) {
      System.out.println("Invalid Move attempted by " + movingEntity);
      return false;
    }

    Tile lastTile = movingEntity.getTile();
    Tile nextTile = board.getTile(lastTile.X + dx, lastTile.Y + dy);

    // If the tile is occupied, try to push its occupant.
    if (nextTile.isOccupied()) {
      if (tryMove(dx, dy, nextTile.getOccupant())) {
        return movingEntity.moveTo(nextTile);
      }
    }

    return false;
  }

  public void start() {
    Scanner s = null;
    if (gui == null) {
      s = new Scanner(System.in);

      while (!isSolved()) {
        System.out.println(this);
        System.out.print("[WASD to Move]> ");
        String input = s.next();

        for (int i = 0; i < input.length(); i++) {
          handleInput(input.charAt(i));
        }
      }
    } else {

    }
  }

  public boolean isSolved() {
    return false;
  }

  public String toString() {
    return this.board.toString();
  }

  public static void main(String[] args) {
    String[] level = { "#####", "#.o@#", "#####" };

    new Sokoban(level, false).start();
  }
}
