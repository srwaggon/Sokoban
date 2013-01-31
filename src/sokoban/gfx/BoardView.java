package sokoban.gfx;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import sokoban.world.Board;

public class BoardView extends JPanel {
  protected Board board;
  protected int tileSize;

  public BoardView(Board board, int tileSize) {
    this.board = board;
    this.tileSize = tileSize;
  }

  public void setBoard(Board b) {
    board = b;
  }

  public Dimension getPreferredSize() {
    return new Dimension(tileSize * board.getWidth(), tileSize
        * board.getHeight());
  }
  
  public void paint(Graphics g) {
    board.paint(g, 0, 0, tileSize);
  }
}
