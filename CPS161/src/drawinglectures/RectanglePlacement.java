package drawinglectures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;

public class RectanglePlacement extends JFrame {

    RectanglePlacement(String name)
    {
        super(name);
        setSize(600,600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void paint(Graphics g) {       
        super.paint(g);
        
        Dimension d = getSize();
        Insets insets = getInsets();
        int top = insets.top;
        int bottom = insets.bottom;
        int left = insets.left;
        int right = insets.right;
        
        int w=300;
        int h = 200;
        int x_center = left + (d.width - left -right)/2;
        int y_center = top + (d.height -top - bottom)/2;
        
        //Center Rectangle
        g.setColor(Color.red);
        g.drawRect(x_center -w/2, y_center - h/2, w, h);
        
        //Lower Right
        g.setColor(Color.green);    
        g.drawRect(d.width-right-w -1, d.height-bottom-h-1, w, h);
           
        //Upper Left
        g.setColor(Color.green);    
        g.drawRect(left, top, w, h);
    }
    public static void main(String[] args)
    {
        RectanglePlacement s = new RectanglePlacement("Rectangle Placement");
    }
} 