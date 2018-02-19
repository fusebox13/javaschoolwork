package jcomponentslecture;

import javax.swing.*;  



public class CustomLayout extends JFrame {
  public CustomLayout() {
    super("CustomLayout");
    setSize(400, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new DiagonalLayout());
    add (new JButton ("Button 1"));
    add (new JButton ("Button 2"));
    add (new JButton ("Extra Long Long Button 3"));
    add (new JButton ("Button 4"));
    add (new JButton ("Button 5"));
    add (new JButton ("Button 6"));
    add (new JButton ("Button 7"));
    add (new JButton ("Button 8"));
    add (new JButton ("Button 9"));
    }
    

// A main() for the application:   
  public static void main(String[] args) {   
    CustomLayout cl = new CustomLayout(); 
    cl.setVisible(true);
  }   
 
} 
 