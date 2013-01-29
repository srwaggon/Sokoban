package sokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;

import sokoban.entity.Player;
import sokoban.gfx.GUI;

public class Sokoban {

  Board board;
  Player player;
  List<Box> boxes;

  GUI gui;
  
  public Sokoban(String[] levelData, boolean gfx) {
	board = new Board(levelData);
	boxes = new ArrayList<Box>();
	
    player = new Player(board);
    
    
    if (gfx) {
      gui = new GUI();
    }
  }

  public boolean handleInput(char input) {
    boolean inputValid = true;
    switch (input) {
    case 'w':
    	player.move(-1, 0);
      break;
    case 'a':
    	player.move(0, -1);
      break;
    case 's':
    	player.move(0, 1);
      break;
    case 'd':
    	player.move(1, 0);
      break;

    default:
      return false; // input was bad and was not processed.
    }

    return true; // input was valid and was processed.
  }

  public void start() {
    Scanner s = null;
    if (gui == null) {
      s = new Scanner(System.in);
    }

    while (!isSolved()) {
      String input = s.next();

      for (int i = 0; i < input.length(); i++) {
        handleInput(input.charAt(i));
      }

    }
  }

  public boolean isSolved() {
    return false;
  }


  public static void main(String[] args) {
    String[] level = {
        "#####",
        "#.o@#",
        "#####"
    };

    new Sokoban(level, false);
  }
}
