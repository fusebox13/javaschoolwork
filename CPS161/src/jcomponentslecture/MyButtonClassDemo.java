package jcomponentslecture;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyButtonClassDemo extends JFrame implements ActionListener{
    MyButtonClass b1 , b2;
    MyButtonClassDemo()
    { 
        setLayout(new FlowLayout());
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        b1 = new MyButtonClass("A long string to place on a button");
        b2 = new MyButtonClass("Somewhat long string");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1); 
        add(b2); 
    }
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("actionPerformed called: "+ e.getActionCommand());
        if (e.getSource() == b1)
            System.out.println("b1 is the source");
        if (e.getSource() == b2)
            System.out.println("b2 is the source");
    }
    public static void main(String[] args)
    {
        MyButtonClassDemo mb = new MyButtonClassDemo();
        mb.setVisible(true);
    }

}