package sokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sokoban.entity.Crate;
import sokoban.entity.Entity;
import sokoban.entity.Player;
import sokoban.gfx.GUI;
import sokoban.world.Board;
import sokoban.world.Tile;

public class Sokoban {

  public static List<String[]> levels = new ArrayList<String[]>();

  Board board;
  List<Crate> crates;
  Player player;
  GUI gui;

  public Sokoban(int levelNum, boolean gfx) {
    this(levels.get(levelNum), gfx);
  }

  public Sokoban(String[] levelData, boolean gfx) {
    crates = new ArrayList<Crate>();
    player = new Player();
    board = new Board(parseBoard(levelData));

    if (gfx) {
      gui = new GUI(this);
    }
  }

  public Board getBoard() {
    return board;
  }

  public Player getPlayer() {
    return player;
  }

  public boolean handleInput(char input) {
    // w = up
    // a = left
    // s = down
    // d = right
    switch (input) {
    case 'w':
      return tryMove(0, -1, player);

    case 'a':
      return tryMove(-1, 0, player);

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

    if (nextTile.isOccupied()) {

      // only Player can push a single crate
      if (movingEntity.toString().equals("@")) {

        // if crate push succeeds, move entity
        if (tryMove(dx, dy, nextTile.getOccupant())) {
          return movingEntity.moveTo(nextTile);
        }
      }
      return false;
    }
    return movingEntity.moveTo(nextTile);
  }

  public void start() {
    if (gui == null) {
      Scanner s = new Scanner(System.in);

      while (!isSolved()) {
        System.out.println(this);
        System.out.print("[WASD to Move]> ");
        String input = s.next();

        for (int i = 0; i < input.length(); i++) {
          handleInput(input.charAt(i));
        }
      }
      System.out.println(this);
      System.out.println("Puzzle solved.");
    }
  }

  public boolean isSolved() {
    // Check that each crate is on a storage tile.
    for (Crate c : crates) {
      if (c.getTile().getChar() != '.') {
        return false;
      }
    }
    return true;
  }

  public String toString() {
    return this.board.toString();
  }

  private Tile[][] parseBoard(String[] board) {
    Tile[][] tiles;

    final int H = board.length;
    assert H > 0;

    final int W = board[0].length();
    assert W > 0;

    tiles = new Tile[W][H];

    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        char c = board[y].charAt(x);
        Tile newTile = Tile.parseTile(x, y, c);
        tiles[x][y] = newTile;

        if (c == '@') {
          player.moveTo(newTile);
        }

        if (c == 'o') {
          Crate crate = new Crate();
          crate.moveTo(newTile);
          crates.add(crate);
        }
      }
    }
    return tiles;
  }


  public static void main(String[] args) {
    levels.add(new String[] {
        "#####",
        "#.o@#",
        "#####",
    });

    levels.add(new String[] {
        "#######",
        "#@    #",
        "#.  o #",
        "#.  o #",
        "#######",
    });

    levels.add(new String[]{
        "    #####          ",
        "    #   #          ",
        "    #o  #          ",
        "  ###  o##         ",
        "  #  o o #         ",
        "### # ## #   ######",
        "#   # ## #####  ..#",
        "# o  o          ..#",
        "##### ### #@##  ..#",
        "    #     #########",
        "    #######        "
    });

    levels.add(new String[] {
        "############  ",
        "#..  #     ###",
        "#..  # o  o  #",
        "#..  #o####  #",
        "#..    @ ##  #",
        "#..  # #  o ##",
        "###### ##o o #",
        "  # o  o o o #",
        "  #    #     #",
        "  ############"
    });

    levels.add(new String[] {
        "        ######## ",
        "        #     @# ",
        "        # o#o ## ",
        "        # o  o#  ",
        "        ##o o #  ",
        "######### o # ###",
        "#....  ## o  o  #",
        "##...    o  o   #",
        "#....  ##########",
        "########         "
        });

    new Sokoban(2, true).start();
  }

}
