package drawinglectures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;

public class RectangleScaling extends JFrame {

    static final int WIDTH_STARTING=600;
    static final int HEIGHT_STARTING=600;
    
    RectangleScaling(String name)
    {
        super(name);
        setSize(WIDTH_STARTING,HEIGHT_STARTING);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void paint(Graphics g) {       
        super.paint(g);
        
        Dimension dimen = getSize();
        Insets insets = getInsets();
        int top = insets.top;
        int bottom = insets.bottom;
        int left = insets.left;
        int right = insets.right;
        
        int w=300;
        int h = 200;
        int x_center = left + (dimen.width - left -right)/2;
        int y_center = top + (dimen.height -top - bottom)/2;
        
        //Center Rectangle
        g.setColor(Color.red);
        g.drawRect(x_center -w/2, y_center - h/2, w, h);
              
        double scale_w = dimen.width/(double)WIDTH_STARTING; 
        double scale_h = dimen.height/(double)HEIGHT_STARTING; 
        int w_new = (int)(w * scale_w);
        int h_new = (int)(h * scale_h);
        
        //Scaled Centered Rectangle (NOT maintaining aspect ratio)
        g.setColor(Color.green);           
        g.drawRect(x_center -w_new/2, y_center - h_new/2, w_new, h_new);
        

        //Scaled Centered Rectangle (Maintaining aspect ratio)
        double scale = Math.min(scale_w, scale_h);

        w_new = (int)(w * scale);
        h_new = (int)(h * scale);
        g.setColor(Color.blue);           
        g.drawRect(x_center -w_new/2, y_center - h_new/2, w_new, h_new);
    }
    public static void main(String[] args)
    {
        RectangleScaling s = new RectangleScaling("Rectangle Scaling");
    }
}