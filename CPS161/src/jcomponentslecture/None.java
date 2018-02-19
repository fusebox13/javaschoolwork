package jcomponentslecture;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class None extends JFrame { 
    private JButton b1, b2, b3; 
    int count = 0;
 
    public None() { 
        super("None");
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); 
        
        b1 = new JButton("one"); 
        add(b1); 
        b2 = new JButton("two"); 
        add(b2); 
        b3 = new JButton("three"); 
        add(b3);        
      
        b1.setBounds(50,  5,  100, 20); 
        b2.setBounds(70,  35, 100, 20); 
       // b3.setBounds(130, 45, 100, 50);          
    } 
 
    public void paint(Graphics g) {   
         super.paint(g);
         // Note that I can also do the setBounds in the paint method. 
         b3.setBounds(130, 45, 100, 50); 
         System.out.println("paint called, count = " + count++); 
    }
    public static void main(String[] args)
    {
        None none = new None();
        none.setVisible(true);
    }
 
}