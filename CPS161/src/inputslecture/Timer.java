package inputslecture;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Timer extends JFrame
        implements Runnable{
    
  
    public Timer(String name)
    {
        super(name);
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
                Thread.sleep( 1000); // Sleep for 1 second
                repaint();
           }
           catch (InterruptedException e)
           {}
        }

    }

    public void paint(Graphics g)
    {  
        super.paint(g);
        
        Date date = new Date();
        g.drawString(date.toString(), 50,50);        
    }    
    
    
    public static void main(String[] args) { 
        Timer t = new Timer("What time is it??");
        System.out.println("Exitting main thread");
    } // end of main


}