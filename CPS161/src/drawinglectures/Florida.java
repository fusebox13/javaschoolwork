package drawinglectures;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;

import javax.swing.JFrame;


public class Florida extends JFrame {
	
	int count = 0;
	public Florida (String name)
	{
        super(name);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

	}
    public void paint(Graphics screen) {
        super.paint(screen);
    
        System.out.println("Paint: " + count++);
        
        Insets insets = getInsets();
        int top = insets.top;
        int bottom = insets.bottom;
        int left = insets.left;
        int right = insets.right;
        
        // Draw the Florida text with a line under it and
        // surrounded by a rounded rectangle
        
        screen.drawString("Florida", 185, 75);
        screen.drawLine(185,80,222,80);
        screen.drawRoundRect(182,61,43,24,10,8);
        
        // Draw Florida Boundary
        int x[] = { 10, 234, 253, 261, 344, 336, 295, 259, 205, 211,
            195, 191, 120, 94, 81, 12, 10 };
        int y[] = { 12, 15, 25, 71, 209, 278, 310, 274, 188, 171, 174,
            118, 56, 68, 49, 37, 12 };
        int pts = x.length;
        
        for (int i=0; i < pts; i++)
        {
        	x[i]+=left;
        	y[i]+=top;
        }
        Polygon poly = new Polygon(x, y, pts);
        screen.drawPolygon(poly);
        
        // Mickey Mouse
        screen.fillOval(235,140,15,15);
        screen.fillOval(225,130,15,15);
        screen.fillOval(245,130,15,15);
        
        // Draw the Waves
        for (int ax = 50; ax < 150; ax += 10)
            for (int ay = 120; ay < 320 ; ay += 10)
                screen.drawArc(ax, ay, 10, 10, 0, -180);
    }
    
    public static void main(String[] args)
    {
    	Florida florida = new Florida("My Florida map");
    }
}