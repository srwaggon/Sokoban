package sokoban.gfx;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import sokoban.Sokoban;

public class GUI extends JFrame implements KeyListener {

  protected Sokoban game;
  protected JPanel boardView;
  protected JPanel view;

  public GUI(Sokoban game) {
    this.game = game;
    this.view = new BoardView(game.getBoard(), 32);
    this.setContentPane(view);
    this.addKeyListener(this);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.setResizable(false);
    this.pack();
    this.setVisible(true);
    requestFocus();
  }

  public void keyTyped(KeyEvent keyEvent) {
  }
  

  public void keyPressed(KeyEvent keyEvent) {
    game.handleInput(keyEvent.getKeyChar());

    if (game.isSolved()) {
      System.out.println("Solved");
      view = new VictoryPanel(view.getPreferredSize().width,
          view.getPreferredSize().height);
      this.setContentPane(view);
      pack();
      this.removeKeyListener(this);
    }
    view.repaint();
  }

  public void keyReleased(KeyEvent keyEvent) {
  }

}
