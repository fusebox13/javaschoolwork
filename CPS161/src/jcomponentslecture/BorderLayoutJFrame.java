package jcomponentslecture;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class BorderLayoutJFrame extends JFrame
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public BorderLayoutJFrame( )
    {
        super("BorderLayout Demonstration" );
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout( ));

        JButton button1 = new JButton("First button");
        add(button1, BorderLayout.NORTH); 

        JButton button2 = new JButton("Second button");
        add(button2, BorderLayout.SOUTH); 

        JButton button3 = new JButton("Third button");
        add(button3, BorderLayout.CENTER); 

        
        JButton button4 = new JButton("Fourth button");
        add(button4, BorderLayout.EAST); 

        JButton button5 = new JButton("Fifth button");
        add(button5, BorderLayout.WEST);
         
    }
}
