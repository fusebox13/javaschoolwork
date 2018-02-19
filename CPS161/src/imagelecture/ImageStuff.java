package imagelecture;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class ImageStuff extends JFrame
{
   Image player ;
   private Image loadImage(String fileName) 
        {
          return new ImageIcon(fileName).getImage();
        }
    
    public ImageStuff(String name)
    {
        super(name);
        setSize(1000, 1000);
        player = loadImage("player1.png");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }

    public void paint(Graphics g)
    {      
       super.paint(g);
       int h = getHeight();
       int w = getWidth();
       int ih = player.getHeight(null);
       int iw  = player.getWidth(null);
       System.out.println("Image width="+iw + " Image height="+ ih);
     
       
       g.drawImage(player, 20, 20, null);
       g.drawString("natural: 20,20", 20, 300);
       
       g.drawImage(player, 350,20, 150,200, null); //150,200 scales the image
       g.drawString("scaled: 350,20,150,200", 350, 300);  
       //********************************************************
       
       g.drawImage(player, 20, 320, 320, 570, 0, 0, 300, 250, null);
       g.drawString("natural: 20, 320, 320, 570, 0, 0, 300, 250", 20, 570); 
           
       g.drawImage(player, 350, 320, 650, 570, 0, 0, 300, 250, null);
       g.drawString("natural: 350, 320, 650, 570, 0, 0, 300, 250", 350, 570); 
       

       g.drawImage(player, 20, 620, 320, 870, 0, 0, 300, 250, null);
       g.drawString("natural: 20, 620, 320, 870, 0, 0, 300, 250", 20, 870); 
           
       g.drawImage(player, 350, 620, 650, 870, 0, 0, 300, 250, null);
       g.drawString("natural: 350, 320, 650, 570, 0, 0, 300, 250", 350, 870); 
       
    }

    public static void main(String[] args) 
    { 
        ImageStuff imageStuff = new ImageStuff("Image Drawing"); 
    } // end of main


}