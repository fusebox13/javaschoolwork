import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawSquare extends JPanel {

  public static void main(String[] a) {
    JFrame f = new JFrame();
    f.setSize(400, 400);
    f.add(new drawSquare());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  public void paint(Graphics g) {
    g.setColor (Color.yellow);  
    g.fillOval (5, 15, 50, 75);    
  }
}