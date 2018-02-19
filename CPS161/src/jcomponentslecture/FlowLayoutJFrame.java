package jcomponentslecture;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class FlowLayoutJFrame extends JFrame
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public FlowLayoutJFrame( )
    {
        super( );
        setSize(WIDTH, HEIGHT);
        setTitle("Layout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton button1 = new JButton("First button");
        add(button1);

        JButton button2 = new JButton("Second button");
        add(button2);

        JButton button3 = new JButton("Third button");
        add(button3);
    }
}
