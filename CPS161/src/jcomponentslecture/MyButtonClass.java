package jcomponentslecture;

import java.awt.*;  
import java.awt.event.*;
// Note NO SWING import

class MyButtonClass extends Canvas implements MouseListener { 
 
    static final int    GC_BUTTON_BORDER_THICKNESS=8; 
    static final int    GC_BUTTON_HORIZ_PAD=3;
    static final int    GC_BUTTON_VERT_PAD=2;
    
    static final int    GC_CANVAS_HORIZ_GAP=10;
    static final int    GC_CANVAS_VERT_GAP=10;

    String ButtonName;
    Color ButtonColor=Color.yellow;
    boolean raised=true;
    int    fontMaxAscent;
    Rectangle gRectangle=new Rectangle();
    Font                buttonFont ;
    ActionListener   actionListener=null;
    
    
//Constructor:

public MyButtonClass(String name)
{
    ButtonName = name;
    int nameTextWidth, nameTextHeight;    
    FontMetrics            buttonFontMetrics; 
     
    buttonFont = new Font("Courier", Font.BOLD, 12); 
    System.out.println("Default font= " +buttonFont);
    buttonFontMetrics = getFontMetrics(buttonFont); 
    nameTextWidth = buttonFontMetrics.stringWidth(name) ;
    nameTextHeight=buttonFontMetrics.getHeight() ;
    fontMaxAscent = buttonFontMetrics.getMaxAscent();

// Create a Rectangle with the size of the Center Text Area
    gRectangle.setBounds(GC_CANVAS_HORIZ_GAP, GC_CANVAS_VERT_GAP,
            nameTextWidth+2*(GC_BUTTON_HORIZ_PAD + GC_BUTTON_BORDER_THICKNESS),
            nameTextHeight+2*(GC_BUTTON_VERT_PAD + GC_BUTTON_BORDER_THICKNESS));
    
    addMouseListener(this);

}

// Need to tell the layout manager how big our button is

public Dimension getPreferredSize()
{    
    Dimension d=new Dimension(gRectangle.width+2*GC_CANVAS_HORIZ_GAP,
        gRectangle.height+2*GC_CANVAS_VERT_GAP);
    return d;
}

public Dimension getMinimumSize()
{
    Dimension d=new Dimension(gRectangle.width, gRectangle.height);
    return d;
}

public void mouseEntered(MouseEvent e) { 
    } 
    public void mouseExited(MouseEvent e) { 
    } 
    public void mouseClicked(MouseEvent e) { 
    } 
    public void mouseReleased(MouseEvent e) { 
    }
public void mousePressed(MouseEvent e) { 
    e.consume(); 
    int x= e.getX(); 
    int y=e.getY(); 
    System.out.println("MouseDown x = "+ x + " y= " + y); 

    if (gRectangle.contains(x,y))
        {
             System.out.println("Click inside " + ButtonName);
             if (raised)
                 raised = false;
              else
                  raised = true;
             
             if (actionListener!=null)
                actionListener.actionPerformed(new ActionEvent(this, 1, ButtonName));
            repaint();
         }
        else
            {
            System.out.println("Click NOT inside " + ButtonName);
            }
    
} 
public void addActionListener(ActionListener actionListener)
{
    this.actionListener = actionListener;
}
// -------------------------------------------------------------------------- 
// The following routine draws a 3D button.  Normal Java 3D buttons 
// only have borders of 1 pixel.  This routine uses brute force to make 
// a larger border by drawing multiple rectangles to get the big 3D effect. 
// -------------------------------------------------------------------------- 
public void paint(Graphics g) 
{ 
    int i; 
    int x=gRectangle.x;
    int y = gRectangle.y;
    int width=gRectangle.width;
    int height=gRectangle.height;
    
    g.setColor(ButtonColor); 
   // Clickable Button 
       // Unfortunately Java doesn't seem to have the concept of thickness 
       // for borders.  To get a border of a certain thickness, we have to 
       // draw multiple rectangles having slightly different sizes 
 
       for (i=0; i < GC_BUTTON_BORDER_THICKNESS; i++) 
       { 
          g.draw3DRect(x+i, y+i, width - 2*i+1, height - 2*i+1, raised); 
       } 
       g.fillRect(x+GC_BUTTON_BORDER_THICKNESS, 
                   y+GC_BUTTON_BORDER_THICKNESS, 
                   width -2* GC_BUTTON_BORDER_THICKNESS+2, 
                   height - 2*GC_BUTTON_BORDER_THICKNESS+2); 
    
    // Put the label on the button 
 
    g.setColor(Color.black); 
    g.setFont(buttonFont);
    g.drawString(ButtonName, x+GC_BUTTON_BORDER_THICKNESS+GC_BUTTON_HORIZ_PAD,
          y+GC_BUTTON_BORDER_THICKNESS+GC_BUTTON_VERT_PAD+fontMaxAscent);
          
          
    // The following was added to see how big the alloted Canvas area was that was 
    // made available to our MyButtonClass 

    g.drawRect(0,0, gRectangle.width+2*GC_CANVAS_HORIZ_GAP-1,
         gRectangle.height+2*GC_CANVAS_VERT_GAP-1);

   } 
	 
   class Rectangle
   {
    int x, y, width, height;
    
    void setBounds(int x, int y, int width, int height)
    {
        this.x =x;
        this.y =y;
        this.width = width;
        this.height = height;
    }
    boolean contains(int px, int py)
    {
        if (px >= x && px <= (px+width) && py >= y && py <= (y+height))
            return true;
        else
            return false;
    }
  }
 }
 