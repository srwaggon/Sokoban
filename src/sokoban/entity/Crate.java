package sokoban.entity;

import java.awt.Color;
import java.awt.Graphics;


public class Crate extends Entity {

  public void paint(Graphics g, int x, int y, int tileSize) {
    int size = (int) (tileSize * .9);

    int drawX = x + (tileSize / 2) - (size / 2);
    int drawY = y + (tileSize / 2) - (size / 2);

    g.setColor(Color.YELLOW);
    g.fillRoundRect(drawX, drawY, size, size, 16, 16);

    g.setColor(Color.BLACK);
    g.drawRoundRect(drawX, drawY, size, size, 16, 16);
  }

  public String toString() {
    return "o";
  }
}
