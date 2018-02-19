package inputslecture;

import java.awt.*;
import javax.swing.*;

public class BasicFrame extends JFrame{
    BasicFrame(String name)
    {
       super(name); // invoke Frame constructor that has a name
       
       setLayout(new FlowLayout());   
       setSize(600,150);
       add(new JButton("HI There")); 
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
     }
 
  public static void main(String[] args) {
    BasicFrame aFrame = new BasicFrame("BasicFrame"); 
  } // end of main    
}