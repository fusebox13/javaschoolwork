package imagelecture;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class ImageStuff2 extends JFrame
{
   Image player ;
   private Image loadImage(String fileName) 
        {
          return new ImageIcon(fileName).getImage();
        }
    
    public ImageStuff2(String name)
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
       g.drawString("natural: 20,20", 20, 270);
       
       g.drawImage(player, 350,20, 150,200, null); 
       g.drawString("scaled: 350,20,150,200", 320, 270);  
       //********************************************************
       
       g.drawImage(player, 20, 280, 320, 530, 0, 0, 300, 250, null);
       g.drawString("natural: 20, 280, 320, 530, 0, 0, 300, 250", 20, 530); 
           
       g.drawImage(player, 350, 530, 650, 280, 0, 0, 300, 250, null);
       g.drawString("v flipped: 350, 530, 650, 280, 0, 0, 300, 250", 320, 530); 
       
       g.drawImage(player, 670, 280, 970, 405, 0, 0, 300, 125, null);
       g.drawString("crop y: 670, 280, 970, 405, 0, 0, 300, 125", 670, 530);
       
       //********************************************************
       
       g.drawImage(player, 320, 560, 20, 810, 0, 0, 300, 250, null);
       g.drawString("h flipped: 320, 560, 20, 810, 0, 0, 300, 250", 20, 810); 
           
       g.drawImage(player, 650, 810, 350, 560, 0, 0, 300, 250, null);
       g.drawString("v,h flipped: 650, 810, 350, 560, 0, 0, 300, 250", 320, 810); 
       
       g.drawImage(player, 670, 560, 820, 810, 0, 0, 150, 250, null);
       g.drawString("crop x: 670, 560, 820, 810, 0, 0, 150, 250", 670, 810);
       
    }

    public static void main(String[] args) 
    { 
        ImageStuff2 imageStuff = new ImageStuff2("Image Drawing"); 
    } // end of main


}