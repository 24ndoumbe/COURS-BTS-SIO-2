package fr.pgah;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Composant graphique qui affiche l'écosystème.
 */
public class BestiolePanel extends JPanel {
  // private static final long serialVersionUID = -2894195307394787789L;
  private BestioleModel myModel;
  private Font myFont;
  private static boolean created;

  public static final int FONT_SIZE = 12;

  public BestiolePanel(BestioleModel model) {
    if (created)
      throw new RuntimeException("Un seul écosystème");
    created = true;

    myModel = model;
    myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE + 4);
    setBackground(Color.CYAN);
    setPreferredSize(
        new Dimension(FONT_SIZE * model.getWidth() + 20, FONT_SIZE * model.getHeight() + 20));
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(myFont);
    Iterator<Bestiole> i = myModel.iterator();
    while (i.hasNext()) {
      Bestiole next = i.next();
      Point p = myModel.getPoint(next);
      String appearance = myModel.getAppearance(next);
      g.setColor(Color.BLACK);
      g.drawString("" + appearance, p.x * FONT_SIZE + 11, p.y * FONT_SIZE + 21);
      g.setColor(myModel.getColor(next));
      g.drawString("" + appearance, p.x * FONT_SIZE + 10, p.y * FONT_SIZE + 20);
    }
  }
}
