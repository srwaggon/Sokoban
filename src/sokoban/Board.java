package sokoban;


public class Board {
  final int HEIGHT;
  final int WIDTH;
  Tile[][] tiles;

  public Board(String[] board) {
    tiles = parseBoard(board);
    WIDTH = tiles.length;
    HEIGHT = tiles[0].length;
  }

  public Board(final int WIDTH, final int HEIGHT) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;

    tiles = new Tile[WIDTH][HEIGHT];
  }

  private static Tile[][] parseBoard(String[] board) {
    Tile[][] tiles;

    final int W = board.length;
    assert W > 0;

    final int H = board[0].length();
    assert H > 0;

    tiles = new Tile[W][H];

    for (int y = 0; y < H; y++) {
      for (int x = 0; x < W; x++) {
        tiles[x][y] = parseTile(board[y].charAt(x));
      }

    }

    return tiles;
  }

  /*
   * Return a new Tile of appropriate type 
   * '#' = wall tile 
   * 'o' = tile with container 
   * '.' = storage tile 
   * ' ' = normal tile 
   * '@' = character tile
   */
  private static Tile parseTile(char c) {
    Tile tile = null;

    if (c == '#') {
      tile = new Tile(false, true);
    } else if (c == 'o') {
      tile = new Tile(false, false);
    } else if (c == '.') {
      tile = new Tile(true, false);
    } else if (c == '@') {
      tile = new Tile(false, false);
    } else {
      tile = new Tile(false, false);
    }
    return tile;
  }

  public Tile getTile(int x, int y) {
    Tile tile = null;

    if (isValidLoc(x, y)) {
      tile = tiles[x][y];
    }
    return tile;
  }

  public boolean isValidLoc(int x, int y) {
    return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
  }

  public String toString() {
    String result = "";
    for (int y = 0; y < HEIGHT; y++) {
      for (int x = 0; x < WIDTH; x++) {
        result += tiles[x][y].toString();
      }
      result += "\n";
    }
    return result;
  }
}
