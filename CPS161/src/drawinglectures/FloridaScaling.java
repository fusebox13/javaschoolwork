package drawinglectures;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;

import javax.swing.JFrame;


public class FloridaScaling extends JFrame {

    public FloridaScaling (String name)
    {
        super(name);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    int max(int[] x)
    {
        int maxVal=-1;
        for (int i=0; i < x.length; i++)
        {
            if (x[i] > maxVal)
                maxVal = x[i];
        }
        return maxVal;
    }
    public void paint(Graphics screen) {
        super.paint(screen);
        Dimension d = getSize();
        System.out.println(" Dimension=" + d);
       
        Insets insets = getInsets();
        int top = insets.top;
        int bottom = insets.bottom;
        int left = insets.left;
        int right = insets.right;
     
        
        // Draw Florida Boundary
        int x[] = { 10, 234, 253, 261, 344, 336, 295, 259, 205, 211,
            195, 191, 120, 94, 81, 12, 10 };
        int y[] = { 12, 15, 25, 71, 209, 278, 310, 274, 188, 171, 174,
            118, 56, 68, 49, 37, 12 };
        
        int xMax = max(x);
        int yMax = max(y);
        double xScale = (d.width-left-right) / (double)xMax;
        double yScale = (d.height-top-bottom)/ (double)yMax;
        double scale = Math.min(xScale, yScale); // In order to maintain the aspect ratio
        
        for (int i=0; i < x.length; i++)
        {
            x[i] = left + (int)(scale * x[i]);
            y[i] = top + (int)(scale * y[i]);
        }
        
        int pts = x.length;
        Polygon poly = new Polygon(x, y, pts);
        screen.drawPolygon(poly);
        
        
    }
    
    public static void main(String[] args)
    {
        FloridaScaling florida = new FloridaScaling("My Florida map");
    }
}
