package shapes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    private int x, y;
    private String color;
    private static int shapeCount= 0;
    
    public abstract double area();
    public abstract void draw(Graphics g);
    
    public void setColor(Graphics g)
    {
        if (color.equals("red"))
            g.setColor(Color.red);
        else if (color.equals("blue"))
            g.setColor(Color.blue);
        else if (color.equals("green"))
            g.setColor(Color.green)
;    }
    
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    
    public Shape(int x, int y, String color)
    {
        shapeCount+= 1;
        this.x = x;
        this.y =y;
        this.color = color;
    }
    
    public static int getCount()
    {
        return shapeCount;
    }
    
    public String toString()
    {
        return "   Shape x=" + x + " y="+y + " color="+ color;
    }

}

class Rectangle extends Shape
{
    private int width, height;
    private static int rectangleCount=0;
    
   
    public Rectangle(int x, int y, String color, int width, int height)
    {
        super(x,y,color);
        this.width = width;
        this.height = height;
        rectangleCount +=1;
    }
    
    public void draw(Graphics g)
    {
        setColor(g);
        g.drawRect(getX(), getY(), width, height);
    }
    public double area()
    {
    	System.out.println("Rectangle area() is called");
        return width * height;
    }

    public String toString()
    {
        return "Rectangle width=" + width + " height="+height + super.toString();
    }
    public static int getCount()
    {
        return rectangleCount;
    }
}

class Oval extends Shape
{
    private int width, height;
    private static int ovalCount=0;
    
    public Oval(int x, int y, String color, int width, int height)
    {
        super(x,y,color);
        this.width = width;
        this.height = height;
        ovalCount +=1;
    }
    public double area()
    {
    	System.out.println("Oval area() is called");
        return Math.PI * width * height/4;
    }
    public void draw(Graphics g)
    {
        setColor(g);
        g.drawOval(getX(), getY(), width, height);
    }

    public String toString()
    {
        return "Oval width=" + width + " height="+height + super.toString();
    }
    public static int getCount()
    {
        return ovalCount;
    }
}