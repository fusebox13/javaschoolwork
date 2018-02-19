package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Simple extends JFrame 
{
	Simple()
	{
		super("Simple Drawing");
		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		Dimension d = getSize();
		g.setColor(Color.yellow);
		g.fillRect(0,0,d.width,d.height);
		System.out.println("Width = " + d.width + "Height =" + d.height);
		
		g.setColor(Color.RED);
		g.fillOval(110, 35, 400, 150);
		g.drawLine(50, 50, 70, 800);
		
		g.setColor(Color.green);
		g.drawRoundRect(160, 60, 100, 50, 20, 40);
		
		g.setColor(Color.black);
		g.drawString("Yo yo yo dawg!", 100, 300);
		
		
		
	}
	
	public static void main(String[] args)
	{
		Simple s = new Simple();
	}

}
