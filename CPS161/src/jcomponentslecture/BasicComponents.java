package jcomponentslecture;

import java.awt.*;
import javax.swing.*;

public class BasicComponents extends JFrame {
 
	BasicComponents(String name){
        super(name);
        setSize(600,400);
        // Construct a Label and add it with one command
        setLayout(new FlowLayout());   
        add(new JLabel("This is a long label ........."));
        
        // Single Line Input/Output Field
        JTextField t = new JTextField(40); 
        add(t); 
        
        // Button
        JButton b = new JButton("Click here to get something done");        
        add(b);
        
        // Multple Line Input/Output Field
        JTextArea toutput = new JTextArea(4,40);
        add(toutput);  

        // Print out the Java Version you are using

         String javaVersion = System.getProperty("java.version");
        toutput.append(javaVersion);  

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     }
 
  public static void main(String[] args) { 
    BasicComponents basic = new BasicComponents("basic components"); 
  } // end of main
}