package JH3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;


enum ToolType {scribble, oval, rectangle, polygon, line};

class ToolProperties
{
	ToolType toolType;
	boolean filled;
	Color color;
	int brushSize;
	
	ToolProperties(ToolType t, Color c, boolean filled)
	{
		this.toolType = t;
		this.color = c;
		this.filled = filled;
		brushSize = 1;
	}
	
	public String instructions()
	{
		String instructions = "";
		
		switch(toolType)
		{
		case scribble:
			instructions = "Click and hold to scribble. Use +/- to change the brush size.";
			break;
		case oval:
		case rectangle:
		case line:
			instructions = "Click and drag between two points.";
			break;
		case polygon:
			instructions = "Click to create a new point, press enter when done.";
		
		}
		return instructions;
	}
	
	public String toString()
	{
		String ToolInfo = "Tool: " +  toolType + " Color: " + color + " Fill: " + filled + " Brush Size: " + brushSize;


		return ToolInfo;
	}
}

abstract class Shape
{
	Color color;
	int brushSize;
	
	Shape(Color c, int brushSize)
	{
		this.color = c;
		this.brushSize = brushSize;
	}
	
	
	abstract void firstPoint(Point p);
	abstract void draw(Graphics g);
	abstract void nextPoint(Point p);
}

class Rectangle extends Shape
{
	boolean filled = false;
	Point firstPoint;
	Point nextPoint;
	
	Rectangle(Color c, int brushSize, boolean f)
	{
		super(c, brushSize);
		nextPoint = firstPoint;
		this.filled = f;
		
	}
	
	void firstPoint(Point p)
	{
		firstPoint = p;
		nextPoint = p;
	}
	
	void nextPoint(Point p)
	{
		nextPoint = p;
	}
	
	void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(brushSize));
		g2.setColor(color);
		int x = Math.min(firstPoint.x, nextPoint.x);
		int y = Math.min(firstPoint.y, nextPoint.y);
		int width = Math.abs(firstPoint.x - nextPoint.x);
		int height = Math.abs(firstPoint.y - nextPoint.y);
		
		if (filled)
			g2.fillRect(x, y, width, height);
		else
			g2.drawRect(x, y, width, height);
	}
	
}


class Poly extends Shape
{
	ArrayList<Point> points = new ArrayList<Point>();
	int[] x;
	int[] y;
	Point firstPoint;
	boolean filled;
	
	Poly(Color c, int brushSize, boolean f)
	{
		super(c, brushSize);
		this.filled = f;
	}
	
	void firstPoint(Point p)
	{
		this.firstPoint = p;
	}
	
	void nextPoint(Point p)
	{
		points.add(p);
	}
	
	
	void draw(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(brushSize));
		g2.setColor(super.color);
		x = new int[points.size()];
		y = new int[points.size()];
		
		for (int i = 0; i < points.size(); i++)
		{
			Point p = points.get(i);
			x[i] = p.x;
			y[i] = p.y;
			
		}
		if (filled)
			g2.fillPolygon(x, y, x.length);
		else
			g2.drawPolygon(x, y, x.length);
	}
}
class Scribble extends Shape
{
	ArrayList<Point> points = new ArrayList<Point>();
	
	
	Scribble(Color c, int brushSize)
	{
		super(c, brushSize);
	}
	
	void firstPoint(Point p)
	{
		points.add(p);
	}
	
	void nextPoint(Point p)
	{
		points.add(p);
	}
	
	void draw(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(brushSize));
		g2.setColor(super.color);
		
		for (int i = 1; i < points.size(); i++)
		{
			Point first = points.get(i-1);
			Point next = points.get(i);
			
			g2.drawLine(first.x, first.y, next.x, next.y);
		}
	}	
}

class Oval extends Shape
{
	boolean filled = false;
	Point firstPoint;
	Point nextPoint;
	
	Oval(Color c, int brushSize, boolean f)
	{
		super(c, brushSize);
		nextPoint = firstPoint;
		this.filled = f;
	}

	void firstPoint(Point p)
	{
		firstPoint = p;
		nextPoint = p;	
	}
	
	void nextPoint(Point p) 
	{
		nextPoint = p;	
	}

	@Override
	void draw(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(brushSize));
		g2.setColor(color);
		int x = Math.min(firstPoint.x, nextPoint.x);
		int y = Math.min(firstPoint.y, nextPoint.y);
		int width = Math.abs(firstPoint.x - nextPoint.x);
		int height = Math.abs(firstPoint.y - nextPoint.y);
		
		if (filled)
			g2.fillOval(x, y, width, height);
		else
			g2.drawOval(x, y, width, height);
		
	}	
}

class Line extends Shape
{
	Point firstPoint;
	Point nextPoint;
	
	Line(Color c, int brushSize)
	{
		super(c, brushSize);
		firstPoint = nextPoint;
		
	}
	@Override
	void firstPoint(Point p) 
	{
		firstPoint = p;
		nextPoint = p;
		
	}
	
	@Override
	void nextPoint(Point p) 
	{
		nextPoint = p;
		
	}
	
	void draw(Graphics g) 
	{
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(brushSize));
		g2.setColor(color);
		//int x = Math.min(firstPoint.x, nextPoint.x);
		//int y = Math.min(firstPoint.y, nextPoint.y);
		g2.drawLine(firstPoint.x, firstPoint.y, nextPoint.x, nextPoint.y);
		
	}
	
}


public class Canvas 
{
	ToolProperties toolProperties = new ToolProperties(ToolType.rectangle, Color.blue, false);
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	Shape currentShape = null;
	
	public String toString()
	{
		return toolProperties.toString();
	}
	
	public void setColor(Color c)
	{
		toolProperties.color = c;
	}
	
	public void setFilled(boolean f)
	{
		toolProperties.filled = f;
	}
	
	public void setToolType(ToolType t)
	{
		toolProperties.toolType = t;
	}
	
	public void increaseBrushSize()
	{
		toolProperties.brushSize++;
	}
	
	public void decreaseBrushSize()
	{
		if(toolProperties.brushSize < 2)
			toolProperties.brushSize = 1;
		else
			toolProperties.brushSize--;
	}
	
	public void mouseWheelUp()
	{
		//Still todo
	}
	
	public void mouseWheelDown()
	{
		
	}
	
	public void mousePressed(Point p)
	{
		switch(toolProperties.toolType)
		{
		case rectangle:
			currentShape = new Rectangle(toolProperties.color, toolProperties.brushSize, toolProperties.filled);
			break;
		case oval:
			currentShape = new Oval(toolProperties.color, toolProperties.brushSize, toolProperties.filled);
			break;
		case line:
			currentShape = new Line(toolProperties.color, toolProperties.brushSize);
			break;
		case scribble:
			currentShape = new Scribble(toolProperties.color, toolProperties.brushSize);
			break;
		case polygon:
			if (currentShape == null)
				currentShape = new Poly(toolProperties.color, toolProperties.brushSize, toolProperties.filled);
			break;
		default:
			break;		
		}
		currentShape.firstPoint(p);
	}
	
	
	public void mouseDragged(Point p)
	{
		switch(toolProperties.toolType)
		{
		case rectangle:
		case oval:
		case scribble:
		case line:
			currentShape.nextPoint(p);
			break;	
		}
	}
	
	public void keyPressed()
	{
		if (currentShape != null)
		{
			System.out.println(currentShape);
			shapes.add(currentShape);
			currentShape = null;
		}
	}
	
	public void mouseReleased(Point p)
	{
		switch (toolProperties.toolType)
		{
		case polygon:
			System.out.println("Added point at:  " + p);
			currentShape.nextPoint(p);
			break;
		default:
			currentShape.nextPoint(p);
			shapes.add(currentShape);
			currentShape = null;
		}
	}
	
	public void draw(Graphics g)
	{
		for (int i = 0; i < shapes.size(); i++)
		{
			Shape s = shapes.get(i);
			s.draw(g);
		}
		if (currentShape != null)
			currentShape.draw(g);
	}
	
	public void clear()
	{
		shapes.clear();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
