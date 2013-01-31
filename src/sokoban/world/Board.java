package sokoban.world;

import java.awt.Graphics;


public class Board {
  final int HEIGHT;
  final int WIDTH;
  Tile[][] tiles;

  public Board(Tile[][] board) {
    tiles = board;
    WIDTH = tiles.length;
    HEIGHT = tiles[0].length;
  }

  public Board(final int WIDTH, final int HEIGHT) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;

    tiles = new Tile[WIDTH][HEIGHT];
  }

  public Tile getTile(int x, int y) {
    Tile tile = null;

    if (isValidLoc(x, y)) {
      tile = tiles[x][y];
    }
    return tile;
  }

  public int getWidth() {
    return WIDTH;
  }

  public int getHeight() {
    return HEIGHT;
  }

  public boolean isValidLoc(int x, int y) {
    return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
  }

  public void paint(Graphics g, int xOffset, int yOffset, int tileSize) {
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        tiles[x][y].paint(g, xOffset, yOffset, tileSize);
      }
    }
  }

  public String toString() {
    String result = "";
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        result += tiles[x][y].toString() + " ";
      }
      result += "\n";
    }
    return result;
  }
}
