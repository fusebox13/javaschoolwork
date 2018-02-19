package mysimpledrawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class drawStickFigure extends JFrame 
{
	private static final long serialVersionUID = 1;
	private Dimension screenSize = new Dimension(400,400);
	
	Color stickmanColor;
	
	drawStickFigure(Color c)
	{
		super("My Stick Figure");
		stickmanColor = c;
		setSize(screenSize);
		setVisible(true);
		repaint();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		//Head and hat
		g.setColor(stickmanColor);
		g.fillRect(175, 50, 50, 50);
		g.drawLine(150, 90, 250, 90);
		g.fillOval(175, 75, 50, 50);
		
		//Face Detail
		g.setColor(Color.white);
		g.fillOval(180, 100, 10, 10);
		g.drawLine(215, 105, 220, 105);
		g.fillRect(197, 115, 6, 2);
		
		//Body and legs
		g.setColor(stickmanColor);
		g.fillRect(175, 125, 50, 100);
		g.fillRect(175, 225, 15, 150);
		g.fillRect(210, 225, 15, 150);
		
		//Arms
		g.fillRect(170, 125, 5, 15);
		g.fillRect(155, 125, 15, 100);
		g.fillRect(225, 125, 5, 15);
		g.fillRect(230, 125, 15, 100);
		
		//buttons
		g.setColor(Color.white);
		int topButtonHeight = 140;
		for(int count = 0; count < 4; count++)
		{	
			g.fillOval(196, topButtonHeight, 8, 8);
			topButtonHeight+=20;
		}
	}
	
	public void setColor(Color c)
	{
		stickmanColor = c;
		repaint();
	}
	
	


	public static void main(String[] args) 
	{
		drawStickFigure stickFigure = new drawStickFigure(Color.black);	
	}

}
