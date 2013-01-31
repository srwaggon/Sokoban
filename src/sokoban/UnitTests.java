package sokoban;

import sokoban.entity.Player;
import sokoban.world.Board;
import sokoban.world.Tile;

public class UnitTests {

  public static void main(String[] args) {
    Sokoban game = new Sokoban(new String[] {
        "######",
        "#    #",
        "# @  #",
        "#.o  #",
        "#.o  #",
        "######"
    }, false);

    // assert game exists.
    assert game != null;

    // assert board exists.
    Board board = game.getBoard();
    assert board != null;

    // assert player exists.
    Player player = game.getPlayer();
    assert player != null;

    // assert tile exists.
    Tile playerTile = player.getTile();
    assert playerTile != null;

    // assert player is at proper location.
    assert playerTile.X == 3;
    assert playerTile.Y == 3;

    // assert toString works.
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#   @     # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // don't handle bad input
    game.handleInput('0');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#   @     # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test up
    game.handleInput('w');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#   @     # \n" +
            "#         # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // can't walk through walls
    game.handleInput('w');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#   @     # \n" +
            "#         # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test left
    game.handleInput('a');
    assert game.toString().equals(
        "# # # # # # \n" +
            "# @       # \n" +
            "#         # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test down
    game.handleInput('s');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "# @       # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test walking on storage
    game.handleInput('s');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# @ o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test that player's tile is still storage.
    assert player.getTile().getChar() == '.';
    assert game.getBoard().getTile(1, 3).getChar() == '.';

    // assert same tile
    assert player.getTile() == game.getBoard().getTile(1, 3);

    game.handleInput('a');
    assert game.isSolved() == true;

    System.out.println("Passed.");
  }
}
