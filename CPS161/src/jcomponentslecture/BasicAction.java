package jcomponentslecture;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// New Import for Events

public class BasicAction extends JFrame 
{
   JTextField tinput = new JTextField("Hi", 60); 
   JButton firstButton, secondButton;
   String endline= System.getProperty("line.separator");  
   JTextArea toutput = new JTextArea("TextArea class"+endline, 4, 60);
   
   // **** Inner Class
   class MyAction implements ActionListener
   {
	   public void actionPerformed(ActionEvent e) {
	        String str = tinput.getText();
	        
	        Object source = e.getSource();
	        String label="";
	        if(source == firstButton)
	        	label = "firstButton";
	        else
	        	label = "secondButton";
	        
	        if(source == tinput)
	        	label = "textField";
	        
	        toutput.append(label + " " + str + endline);
	        
	        System.out.println(str);
	       }
	   
   }
   
   // **** end Inner Class
 
   public BasicAction(String name) { 
        super(name);
        setSize(800,400);
        MyAction m = new MyAction();
		
        // Construct a Label and add it with one command
       
        setLayout(new FlowLayout());   
        add(new JLabel("This is a long label ........."));
        
        add(tinput);
        tinput.addActionListener(m);
        
        firstButton = new JButton("Click here to get something done");        
        add(firstButton);
        firstButton.addActionListener(m);
        add(toutput);    
        
 
        
        secondButton = new JButton("Another Button");
        add(secondButton);
        secondButton.addActionListener(m);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
     }
     
   
 
  public static void main(String[] args) { 
    BasicAction basicAction = new BasicAction("Basic Action");
  } // end of main
}
