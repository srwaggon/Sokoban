package sokoban.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

  public void paint(Graphics g, int x, int y, int tileSize) {
    int size = (int) (tileSize * .9);

    int drawX = x + (tileSize / 2) - (size / 2);
    int drawY = y + (tileSize / 2) - (size / 2);

    g.setColor(Color.RED);
    g.fillOval(drawX, drawY, (int) (tileSize * .8), (int) (tileSize * .8));

    g.setColor(Color.BLACK);
    g.drawOval(drawX, drawY, (int) (tileSize * .8), (int) (tileSize * .8));
  }

  public String toString() {
    return "@";
  }
}
