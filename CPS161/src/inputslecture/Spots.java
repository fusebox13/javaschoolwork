package inputslecture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Spots extends JFrame
        implements MouseListener{
    Point clickPoint=new Point(-1,-1);
    int radius = 7;
    boolean first = true;

    public Spots(String name)
    {
        super(name);
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
    // Our JFrame is a Component.  We want to register it to
    // fire MouseEvents according to the MouseListener interface
    // The class which will handle this interface in the JFrame itself.
    // This implies our JFrame must implement the MouseListener interface.

       addMouseListener(this);
    }

    public void paint(Graphics g)
    {
    	if (first)
    	{
    		super.paint(g);
    		first = false;
    	}
       
       //Color color = new Color(1.0f, 0.0f, 0.0f);
    	Color color = new Color( (float)Math.random(), (float)Math.random(), (float)Math.random());
       if (clickPoint.x >= 0)
       {
          g.setColor(color);
          g.fillOval(clickPoint.x - radius,    clickPoint.y - radius,
                    2*radius, 2*radius);
       }
    }    
    public void mousePressed(MouseEvent e)
    {
       clickPoint.x = e.getX();
       clickPoint.y = e.getY();
       // Note that nothing happens unless I tell java to repaint my screen
       repaint();
    }
    
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    
    public static void main(String[] args) { 
        Spots spots = new Spots("My Spots Program");
        spots.setVisible(true);
    } // end of main


}