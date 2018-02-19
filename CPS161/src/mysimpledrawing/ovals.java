package mysimpledrawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ovals extends JFrame 

{

	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	ovals()
	{
		super("My Ovals");
		setSize(screenSize);
		setVisible(true);
		this.setBackground(Color.black);
		repaint();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics g)
	{
		int xSize = (int)screenSize.getWidth();
		int ySize = (int)screenSize.getHeight();
		int xPosition = 0;
		int yPosition = 0;
		
		g.setColor(Color.magenta);
		
		while (xSize > 0 && ySize > 0)
		{
			
			g.fillOval(xPosition, yPosition, xSize, ySize);
			
			if (g.getColor() == Color.magenta)
				g.setColor(Color.blue);
			else 
				g.setColor(Color.magenta);
			
			xPosition+=5;
			yPosition+=5;
			xSize-=10;
			ySize-=10;
		}
			
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ovals myOvals = new ovals();

	}

}
