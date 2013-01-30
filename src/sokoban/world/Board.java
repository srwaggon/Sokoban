package sokoban.world;


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
      }
    }

    return tiles;
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
