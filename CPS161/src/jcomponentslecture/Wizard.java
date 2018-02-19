package jcomponentslecture;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;      


public class Wizard extends JFrame
                        implements ActionListener {
       
   CardLayout cardLayoutMgr = new CardLayout();
   JPanel panelForText = new JPanel();
   Panel panelFor3Buttons = new Panel();
   String BUTTONPANEL="ButtonPanel";
   String TEXTPANEL="TextPanel";
   String SINGLE_BUTTON="ButtonComponent";
   
   JButton next1 = new JButton("Next 1");
   JButton next2 = new JButton("Next 2");
   JButton next3 = new JButton("Next 3");

  public Wizard() {
       super("Wizard");
       setSize(300,150); 
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(cardLayoutMgr);
       setBackground(Color.yellow);
       
       next1.setBackground(Color.red);
       next2.setBackground(Color.red);
       next3.setBackground(Color.red);
                      
       next1.addActionListener(this);
       next2.addActionListener(this);
       next3.addActionListener(this);

   // Build up Panel : panelFor3Buttons
       panelFor3Buttons.add(new JButton("Button 1"));
       panelFor3Buttons.add(new JButton("Button 2"));
       panelFor3Buttons.add(next1);
       panelFor3Buttons.setBackground(Color.green);
        
   // Build up Panel : panelForText    
       panelForText.add(new JTextField("TextField", 20));
       panelForText.add(next2);
       panelForText.setBackground(Color.orange);

     // Finally add the 3 "Cards" to the CardLayout Manager
     // Note that each card only needs to be a Component.
     // A Button is OK, and a Panel is OK too.
     
       add(BUTTONPANEL, panelFor3Buttons);
       add(TEXTPANEL, panelForText);
       add(SINGLE_BUTTON, next3);

       setBackground(Color.pink);
       
       // Tell the cardLayout Manager to start with the 3 button panel
       cardLayoutMgr.show(this.getContentPane(), BUTTONPANEL);
       
    }

  public void actionPerformed(ActionEvent evt) {
       if (evt.getSource() == next1)
           cardLayoutMgr.show(this.getContentPane(), TEXTPANEL);
        if (evt.getSource() == next2)
                cardLayoutMgr.show(this.getContentPane(), SINGLE_BUTTON);
        if (evt.getSource() == next3) 
                cardLayoutMgr.show(this.getContentPane(), BUTTONPANEL);

            
    } 
    
  public static void main(String[] args) { 
    Wizard w = new Wizard();    
    w.setVisible(true); 
  } // end of main

   
}  