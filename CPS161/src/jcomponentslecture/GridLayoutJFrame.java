package jcomponentslecture;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class GridLayoutJFrame extends JFrame
{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public static void main(String[] args)
    {
        GridLayoutJFrame gui = new GridLayoutJFrame(2, 3);
        gui.setVisible(true);
    }

    public GridLayoutJFrame(int rows, int columns )
    {
        super( );
        setSize(WIDTH, HEIGHT);
        setTitle("GridLayout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(rows, columns ));

        JButton button1 = new JButton("First button");
        add(button1);

        JButton button2 = new JButton("Second button");
        add(button2);

        JButton button3 = new JButton("Third button");
        add(button3);

        JButton button4 = new JButton("Fourth button");
        add(button4);

        JButton button5 = new JButton("Fifth button");
        add(button5);
    }
}