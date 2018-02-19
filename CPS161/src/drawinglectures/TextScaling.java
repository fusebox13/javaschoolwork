package drawinglectures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JFrame;

public class TextScaling extends JFrame {

    static final int WIDTH_STARTING=600;
    static final int HEIGHT_STARTING=600;
    
    TextScaling(String name)
    {
        super(name);
        setSize(WIDTH_STARTING,HEIGHT_STARTING);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void paint(Graphics g) {       
        super.paint(g);
        
        Dimension dimen = getSize();
        Insets insets = getInsets();
        int top = insets.top;
        int bottom = insets.bottom;
        int left = insets.left;
        int right = insets.right;
        
        Font font = new Font("SansSerif", Font.BOLD, 72);
        g.setFont(font);
        String text = "Are you going?";
        
        FontMetrics fm = getFontMetrics(font);
        int fontHeight = fm.getHeight();
        int maxAscent = fm.getMaxAscent();
        int strWidth = fm.stringWidth(text);
        
        int x_center = left + (dimen.width - left -right)/2;
        int y_center = top + (dimen.height -top - bottom)/2;
        
        // Center Text
        g.drawString(text, x_center - strWidth/2, y_center - fontHeight/2 + maxAscent);
        g.drawRect(x_center - strWidth/2, y_center- fontHeight/2, strWidth, fontHeight);
        
        // Changing Font
        font = new  Font("SansSerif", Font.BOLD, 12);
        g.setFont(font);

        fm = getFontMetrics(font);
        fontHeight = fm.getHeight();
        maxAscent = fm.getMaxAscent();
        strWidth = fm.stringWidth(text);
        
        //Upper Left Corner
        g.drawString(text, left, top+ maxAscent);
        
        //Upper Right Corner
        g.drawString(text, dimen.width - right - strWidth, top+ maxAscent);

        //Lower Left Corner
        g.drawString(text, left, dimen.height - bottom - fontHeight + maxAscent);
        

        //Lower Right Corner
        g.drawString(text, dimen.width - right - strWidth, dimen.height - bottom - fontHeight + maxAscent);
        

    }
    public static void main(String[] args)
    {
        TextScaling s = new TextScaling("Text Scaling");
    }
}