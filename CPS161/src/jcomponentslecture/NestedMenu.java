package jcomponentslecture;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NestedMenu extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JPanel redPanel;
    private JPanel whitePanel;
    private JPanel bluePanel;

    public static void main(String[] args)
    {
        NestedMenu gui = new NestedMenu();
        gui.setVisible(true);
    }

    public NestedMenu()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Menu Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        redPanel = new JPanel();
        redPanel.setBackground(Color.LIGHT_GRAY);
        add(redPanel);

        whitePanel = new JPanel();
        whitePanel.setBackground(Color.LIGHT_GRAY);
        add(whitePanel);

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.LIGHT_GRAY);
        add(bluePanel);

        JMenu outerMenu = new JMenu("Actions");

        JMenu colorMenu = new JMenu("Add Colors");

        JMenuItem redChoice = new JMenuItem("Red");
        redChoice.addActionListener(this);
        colorMenu.add(redChoice);

        JMenuItem whiteChoice = new JMenuItem("White");
        whiteChoice.addActionListener(this);
        colorMenu.add(whiteChoice);

        JMenuItem blueChoice = new JMenuItem("Blue");
        blueChoice.addActionListener(this);
        colorMenu.add(blueChoice);

        outerMenu.add(colorMenu);  // Adding a JMenu to a JMenu !!!!!!!!!!!!

        JMenuItem exitChoice = new JMenuItem("Exit");
        exitChoice.addActionListener(this);
        outerMenu.add(exitChoice);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(new JMenuItem("Copy"));
        editMenu.add(new JMenuItem("Cut"));
        editMenu.add(new JMenuItem("Paste"));

        JMenuBar bar = new JMenuBar();
        bar.add(outerMenu);
        bar.add(editMenu);
        setJMenuBar(bar);

       // JMenuBar bar = new JMenuBar();
        bar.add(outerMenu);
        setJMenuBar(bar);
    }

    public void actionPerformed(ActionEvent e)
    {
        String buttonString = e.getActionCommand( );

        if (buttonString.equals("Red"))
             redPanel.setBackground(Color.RED);
        else if (buttonString.equals("White"))
            whitePanel.setBackground(Color.WHITE);
        else if (buttonString.equals("Blue"))
            bluePanel.setBackground(Color.BLUE);
        else if (buttonString.equals("Exit"))
            System.exit(0);
        else
            System.out.println("Unexpected error.");
    }
}