package jcomponentslecture;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CalcGridBag extends JFrame
        implements ActionListener {
    JButton bdigit[] = new JButton[10];
    JButton clear = new JButton("clear");
    JButton minus = new JButton("   -   ");
    JButton plus =  new JButton("   +   ");

    JButton equals = new JButton("   =   ");

    JTextField display = new JTextField(30);
    GridBagLayout gblay = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    final int numCols = 4;
    int colCount = 0;   
//****************************************** 
    
    // GridBag add routine to take care
    // of some of the ugly details.
      
    void gbAdd(Component c, int width)
    {
        if (width < 0)
        {
            // Make this component the end of the row
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            colCount = 0;
        }
        else 
        {
            colCount += width;
            if (colCount >= numCols)
            {
                // Make this component the end of the row
                gbc.gridwidth =  GridBagConstraints.REMAINDER;
                colCount = 0;
            }
            else
            {
                // Provide the requested Width
                gbc.gridwidth = width;
            }
        }
        
        // Finally tell Gridbaglayout about the constraints
        // associated with this Component
        gblay.setConstraints(c, gbc);
        
        add(c); // add to the container
    } 
  //**************************************  
    
    public CalcGridBag() { 
        super("Grid Bag Layout");
        setSize(300,250); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Fill in a few constraints     
        gbc.weightx = gbc.weighty =1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(3,3,3,3);

        setLayout(gblay);
        setBackground(Color.yellow);
        
        gbAdd(display, -1); // Line by itself   

        Color buttonColor = new Color(180,180,255);
        for (int i=0; i < bdigit.length; i++)
        {
            bdigit[i] = new JButton("" + i);
            bdigit[i].addActionListener(this);
            bdigit[i].setBackground(buttonColor);
            gbAdd(bdigit[i], 1); // normal button size
        }
        
        clear.addActionListener(this);
        gbAdd(clear, 1); // normal button size
        
        minus.addActionListener(this);
        gbAdd(minus, 1); // normal button size
        
        gbAdd(plus, 2); // double  button size
        plus.addActionListener(this);
        
        gbAdd(equals, 2); // double  button size
        equals.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == clear)
       {
            display.setText("");
       }
       else if (e.getSource() == plus)
       {
       
       }
       else if (e.getSource() == minus)
       {
       
       }

       else if (e.getSource() == equals)
       {
       
       }

       else
       {    // Must be a digit
            String str = e.getActionCommand();
            String str_display = display.getText();
            display.setText( str_display + str);
       }
        
    }
        
 
  public static void main(String[] args) { 
    CalcGridBag calc = new CalcGridBag(); 
    calc.setVisible(true);
  } // end of main
}
