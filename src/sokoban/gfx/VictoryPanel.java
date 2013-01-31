package sokoban.gfx;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class VictoryPanel extends JPanel {
  Image img;
  final int W;
  final int H;

  public VictoryPanel(int width, int height) {
    this.W = width;
    this.H = height;

    try {
      img = ImageIO.read(getClass().getResourceAsStream("victory.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public Dimension getPreferredSize() {
    // return a new instances to preserve field
    return new Dimension(W, H);
  }

  public void paint(Graphics g) {
    g.drawImage(img, 0, 0, W, H, null);
  }
}
