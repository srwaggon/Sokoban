package sokoban;

public class Tile {
  final boolean isStorage;
  final boolean isWall;

  public Tile() {
    isStorage = false;
    isWall = false;
  }

  public Tile(final boolean isStorage, final boolean isWall) {
    this.isStorage = isStorage;
    this.isWall = isWall;
  }

}
