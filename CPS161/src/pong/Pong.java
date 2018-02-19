 package pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Pong extends JFrame
        implements Runnable{
    
    Box box = null;
    int PAD=20;
    Image offScreenImage = null;
    Dimension screenDimension = null;
    
    // ****   INNER CLASS
    class Mouser extends MouseAdapter
    {
        public void mouseMoved(MouseEvent e)
        {
            int y= e.getY();            
            if (box != null)
            {
                box.setPaddleY(y);
            }            
            repaint();
        }
        public void mousePressed(MouseEvent e)
        {
           box = null;
           repaint();
        }  

    }

    
    // ****   END OF INNER CLASS
    
    public Pong(String name)
    {
        super(name);
        setSize(800, 400);
        setResizable(false);  // We don't want this window resized
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread thread = new Thread(this);
        thread.start();  
        Mouser m = new Mouser();
        addMouseMotionListener(m);
        addMouseListener(m);
        setVisible(true);
    }
    public void run()
    {
        while(true)
        {
           try
           {
                Thread.sleep( 10); // Sleep for 0.1 second
                if (box !=null)
                    box.update();
                repaint();
           }
           catch (InterruptedException e)
           {}
        }

    }

    public void paint(Graphics screen)
    {  
        Dimension d = getSize();
        if (offScreenImage==null || !d.equals(screenDimension))
        {
            screenDimension = d;
            offScreenImage = createImage(d.width, d.height);
        }
        Graphics g = offScreenImage.getGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0,0, d.width, d.height);
        g.setColor(Color.black);
        
        Insets insets = getInsets();
        
        if (box == null)
            box = new Box(insets.top+PAD, d.height - insets.bottom-2*PAD,
                    insets.left+PAD, d.width-insets.right-2*PAD);
        if (!box.bouncing)
        {
            String str ="You missed, your success count="+
                box.successCount+ " Click Mouse to restart";
            g.drawString(str, 100, 100);            
        }
        
        Point bur = box.boxUpperRight;
        Point bul = box.boxUpperLeft;
        Point blr = box.boxLowerRight;
        Point bll = box.boxLowerLeft;
        Point hu  = box.holeUpper;
        Point hl  = box.holeLower;
        g.drawLine(bll.x, bll.y, blr.x, blr.y); // lower line
        g.drawLine(bll.x, bll.y, bul.x, bul.y); // left side
        g.drawLine(bul.x,bul.y, bur.x, bur.y);  // top side
        g.drawLine(bur.x, bur.y, hu.x, hu.y);   // above hole on right
        g.drawLine(blr.x, blr.y, hl.x, hl.y);   // below hole on right
              
        Point pball = box.ballLoc;
        int r = box.ballRadius;
        g.fillOval(pball.x-r, pball.y-r, 2*r, 2*r);
            
        Point pPaddle = box.paddleLoc;
        int w = box.paddleWidth;
        g.setColor(Color.red);
        int x= pPaddle.x ;           
        g.drawLine(x, pPaddle.y-w/2, x, pPaddle.y+w/2);
        
        screen.drawImage(offScreenImage, 0,0, this);
    }    
    
    
    public static void main(String[] args) { 
        Pong p = new Pong("Pong game");
    } // end of main
    
    

}