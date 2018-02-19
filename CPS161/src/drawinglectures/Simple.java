package drawinglectures;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

public class Simple extends JFrame{
	
	Simple()
	{
		//the next methods are inherited from JFrame
		setSize(600,400);
		setVisible(true); //must switch this or the frame won't show.
		setDefaultCloseOperation(EXIT_ON_CLOSE); //close the program when the x button is pressed
	}
	
	public void paint(Graphics g)
	{
		//Paint overrides Jframe, for some reason we must call the paint method that we're overriding.
		super.paint(g);
		
		//Color color = Color.red;
		//Color color = Color(255, 80, 80);
		//Color color = new Color(1.0f, 0.4f, 0.4f);
		String s = "FF8080";
		int c = Integer.parseInt(s, 16); //The 16 denotes that we are parsing a hexadecimal number
		Color color = new Color(c);
		g.setColor(color);
		
		//Ovals
		g.drawOval(10, 35, 400, 150);
		g.fillOval(10, 200, 400, 150);
		
		//Lines and Text
		g.drawLine(10, 35, 10, 200);
		g.drawString("Dan's artwork", 50, 100);
		color = Color.green;
		g.setColor(color);
		
		//Round Rectangles
		g.drawRoundRect(110, 55, 200, 100, 45, 15); 
		g.fillRoundRect(110, 255, 200, 100, 15, 45);
		
		
		//3d Rectangles
		g.draw3DRect(110, 55, 200, 100, false); 
		g.draw3DRect(350, 55, 200, 100, true);
		g.fill3DRect(110, 200, 200, 100, false); 
		g.fill3DRect(350, 200, 200, 100, true);
		
		//Thick 3d Rectangles
		g.setColor(Color.pink);
	    button(g,110, 55, 200, 100, 10, true);
	    button(g,110, 200, 200, 100, 10, false);
		
	    
	    //using arcs
	    g.setColor(Color.red);
	    //x,y,width,height, starting angle, ending angle (draws a partial circle
        g.drawArc(100, 100, 180, 180, 20, 180);
        g.fillArc(300, 100, 180, 180, 20, 60);
        
        g.setColor(Color.blue);
        g.drawRect(100, 100, 180, 180);
        g.drawRect(300, 100, 180, 180);
        
        
        //using polygons
        int[] x={100, 200, 300};
        int[] y={50, 150, 90};
        int[] x2={100, 200, 300, 250, 150};
        int[] y2={300, 200, 300, 380, 380};
        
        Polygon p = new Polygon(x, y, x.length);
        Polygon p2 = new Polygon(x2, y2, x2.length);
        g.drawPolygon(p);
        g.fillPolygon(p2);
        
        //using fonts
        Font font = new Font(Font.SERIF, Font.BOLD, 16);
        g.setFont(font);
        g.drawString("SERIF", 30, 80);

        font = new Font("SansSerif", Font.BOLD, 16);
        g.setFont(font);
        g.drawString("SansSerif", 30,130);

        font = new Font(Font.MONOSPACED, Font.BOLD, 16);
        g.setFont(font);
        g.drawString("MONOSPACED", 30,180);

        font = new Font("Poor Richard", Font.BOLD, 16);
        g.setFont(font);
        g.drawString("Poor Richard", 30,230);
        
        
  
	}
	
	void button(Graphics g, int x, int y, int w, int h, int thickness, boolean raised)
    {
        for (int i=0; i < thickness; i++)
        {
            g.fill3DRect(x+i, y+i, w-2*i, h-2*i, raised);
        }
    }
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simple f = new Simple();

	}

}
