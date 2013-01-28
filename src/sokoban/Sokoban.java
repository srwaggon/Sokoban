package sokoban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;

import sokoban.gfx.GUI;

public class Sokoban {

  Board board;
  Player player;
  List<Box> boxes;

  GUI gui;
  
  public Sokoban(String[] levelData, boolean gfx) {
    player = new Player();
    board = new Board(levelData);
    boxes = new ArrayList<Box>();
    
    if (gfx) {
      gui = new GUI();
    }
  }

  public boolean handleInput(char input) {
    boolean inputValid = true;
    switch (input) {
    case 'w':
      break;
    case 'a':
      break;
    case 's':
      break;
    case 'd':
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
