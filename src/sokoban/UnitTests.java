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
    assert playerTile.X == 2;
    assert playerTile.Y == 2;

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

    // test right
    game.handleInput('d');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#   @     # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test walking on storage
    game.handleInput('a');
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

    // test moving container

    game.handleInput('d');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# . @ o   # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test pushing container into wall -- should do nothing
    game.handleInput('s');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# . @ o   # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // put crate back.
    game.handleInput('w');
    game.handleInput('d');
    game.handleInput('d');
    game.handleInput('s');
    game.handleInput('a');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# . o @   # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // can't push crate into other crate.
    game.handleInput('w');
    game.handleInput('a');
    game.handleInput('s');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#   @     # \n" +
            "# . o     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );
    
    // test crate on storage tile
    game.handleInput('d');
    game.handleInput('s');
    game.handleInput('a');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# * @     # \n" +
            "# . o     # \n" +
            "# # # # # # \n"
        );

    // test solved
    game.handleInput('d');
    game.handleInput('s');
    game.handleInput('a');
    assert game.toString().equals(
        "# # # # # # \n" +
            "#         # \n" +
            "#         # \n" +
            "# *       # \n" +
            "# * @     # \n" +
            "# # # # # # \n"
        );

    assert game.isSolved() == true;

    System.out.println("Passed.");
  }
}
