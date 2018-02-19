package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

public class MyDrawing extends JFrame{

    Shape[] shapeArr = new Shape[1000]; // base class can have things derived in it, in the array, but not itself
    int count =0;
    
    public void addShape(Shape s) // can pass a rectangle or an oval, anything that's a shape
    {
        shapeArr[count++] = s;
        repaint();
    }
    MyDrawing()
    {
        super("My First GUI Example");
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, 500, 500);
        
        
        for (int i=0; i < count; i++)
        {
            shapeArr[i].draw(g);//System will know what kind of shape needs to be draws, and what methods need to be called because polymorphism
        }
        String countStr = "#Shapes =" + Shape.getCount() + " #Rectangles="+ Rectangle.getCount() +
                " #Ovals="+ Oval.getCount();
        
        g.setColor(Color.black);
        g.drawString(countStr, 50 , 100);
    }
    public static void main(String[] args) {
        MyDrawing md = new MyDrawing();
        md.addShape( new Rectangle(100,200, "red", 40,50) );
        md.addShape( new Oval(300,400, "red", 60,80));
        md.addShape( new Rectangle(100,120, "blue", 60,80));
        md.addShape( new Oval(100,120, "blue", 60,80));
        
        Scanner keyboard = new Scanner(System.in);
        
        while (true)
        {
            System.out.println("Enter object to draw [r/o] color, x, y, width, height");
            String type = keyboard.next();
            String color = keyboard.next();
            int x = keyboard.nextInt();
            int y = keyboard.nextInt();
            int width= keyboard.nextInt();
            int height = keyboard.nextInt();
            if ("r".equals(type))
                md.addShape(new Rectangle(x,y, color, width, height));
            else if ("o".equals(type))
                md.addShape(new Oval(x,y, color, width, height));
            
        }
        

    }

}