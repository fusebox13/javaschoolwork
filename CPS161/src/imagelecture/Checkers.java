package imagelecture;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Checkers extends JFrame
{
   Image redChecker, blackChecker ;
   private Image loadImage(String fileName) 
        {
          return new ImageIcon(fileName).getImage();
        }
    
    public Checkers(String name)
    {
        super(name);
        setSize(800, 600);
        redChecker = loadImage("redChecker.png");
        blackChecker = loadImage("blackChecker.png");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    void drawInBox(Graphics g, Image img, int x, int y, int w, int h)
    {
        int ih = img.getHeight(null);
        int iw  = img.getWidth(null);
        
        double scale_width = (double)w/iw;
        double scale_height = (double)h/ih;
        
        double scale = Math.min(scale_width, scale_height);
        int newHeight = (int)(ih*scale);
        int newWidth = (int)(iw*scale);
        int newX = x + w/2 - newWidth/2;
        int newY = y + h/2 - newHeight/2;
        
        g.drawImage(img, newX, newY, newWidth, newHeight, null);
    }

    public void paint(Graphics g)
    {      
       super.paint(g);
       Insets insets = getInsets();
       int top = insets.top;
       int bottom = insets.bottom;
       int left = insets.left;
       int right = insets.right;
       
       int height = getHeight();
       int width = getWidth();
       
       int cell_h = (height-top-bottom)/8;
       int cell_w = (width-left-right)/8;
      
       int x,y;
       
       for (int row=0; row < 8; row++)
       {
           y = top + row*cell_h;
           for (int col=0; col < 8; col++)
           {
               x = left + col*cell_w;
               boolean greenColor = (row+col) %2 == 1;
               if (greenColor)
               {
                   g.setColor(Color.green);
               }
               else
               {
                   g.setColor(Color.white);
               }
               g.fillRect(x, y, cell_w, cell_h);
               if (greenColor)
               {
                   Image img = null;
                   if (row <= 2)
                   {
                       img = redChecker;
                   }
                   else if (row >= 5)
                   {
                       img = blackChecker;
                   }
                   if (img != null)
                       drawInBox(g, img, x, y,
                           cell_w, cell_h);
               }
           }
       }
       
      
     
    
       
    }

    public static void main(String[] args) 
    { 
        Checkers imageStuff = new Checkers("Image Drawing"); 
    } // end of main


}