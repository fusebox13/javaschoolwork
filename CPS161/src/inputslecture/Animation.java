package inputslecture;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Animation extends JFrame
        implements Runnable{
    //String[] fileNames = {"j0.gif", "j1.gif", "j2.gif", "j3.gif", "j4.gif"};
    String[] fileNames = {"T0.gif", "T1.gif", "T2.gif", "T3.gif", 
            "T4.gif", "T5.gif", "T6.gif", "T7.gif", "T8.gif"};
    
    Image[] images;
    int index = 0;
    int next=0;
  
    public Animation(String name)
    {
        super(name);
        loadImages();
        setSize(800, 400);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread thread = new Thread(this);
        thread.start();        
    }
    public void run()
    {
        while(true)
        {
           try
           {
// Try changing this number to something smaller, like 200 milliseconds
                Thread.sleep(150); // Sleep for 1 second
                repaint();
           }
           catch (InterruptedException e)
           {}
        }

    }

    public void paint(Graphics g)
    {  
        super.paint(g);
        
        next = index % fileNames.length;
        index += 1;
        g.drawImage(images[next], 50,50,null);   
        g.drawString(fileNames[next], 50, 250);
    }  
  
    private void loadImages()
    {
        int len = fileNames.length;
        images = new Image[len];
        
        for (int i=0; i < fileNames.length; i++)
        {
            images[i] = loadImage(fileNames[i]);
        }
    }
    private Image loadImage(String fileName) 
    {
      return new ImageIcon(fileName).getImage();
    }

    public static void main(String[] args) { 
        Animation t = new Animation("Movie Time");
        System.out.println("Exitting main thread");
    } // end of main


}