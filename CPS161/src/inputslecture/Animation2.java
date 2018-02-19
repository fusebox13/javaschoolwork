//Gets rid of flicker

package inputslecture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Animation2 extends JFrame
        implements Runnable{
    //String[] fileNames = {"j0.gif", "j1.gif", "j2.gif", "j3.gif", "j4.gif"};
   String[] fileNames = {"T0.gif", "T1.gif", "T2.gif", "T3.gif", 
            "T4.gif", "T5.gif", "T6.gif", "T7.gif", "T8.gif"};
    
    Image[] images;
    int index = 0;
    int next=0;
    Image offScreenImage = null;
    Dimension screenDimension = null;
            
  
    public Animation2(String name)
    {
        super(name);
        loadImages();
        setSize(800, 400);
        setVisible(true);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread thread = new Thread(this);
        thread.start();        
    }
    public void paint(Graphics screen)
    {  
        Dimension dimen = getSize();
        if (offScreenImage==null || !dimen.equals(screenDimension))
        {
            screenDimension = dimen;
            offScreenImage = createImage(dimen.width, dimen.height);
        }
        Graphics g = offScreenImage.getGraphics();
        
        next = index % fileNames.length;
        index += 1;
        g.setColor(Color.white);
        g.fillRect(0, 0, dimen.width, dimen.height);
        g.drawImage(images[next], 50,50,null);   
        g.drawString(fileNames[next], 50, 250);
        
        screen.drawImage(offScreenImage, 0,0,this);
    }    
    
    public void run()
    {
        while(true)
        {
           try
           {
                Thread.sleep( 50); // Sleep for 1 second
                repaint();
           }
           catch (InterruptedException e)
           {}
        }

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
        Animation2 t = new Animation2("Movie Time");
        System.out.println("Exitting main thread");
    } // end of main


}
