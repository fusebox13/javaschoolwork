package jcomponentslecture;

import java.awt.*;
import java.awt.event.*; // New Import for Events
import javax.swing.*;

public class Check extends JFrame 
    implements ActionListener
{
   JTextArea toutput = new JTextArea(6,40);
   
   // Regular Check Boxes
   JCheckBox chkCar = new JCheckBox("Own Car?");
   JCheckBox chkStudent = new JCheckBox("Student at WCC?");
   
   // Radio Button Classes
   ButtonGroup generation = new ButtonGroup();
   JRadioButton[] genChk= new JRadioButton[5]; 
      
   String endline; 
   String genName[] = {"Senior", "Boomer", "X", "Adolescent", "Infant"};
 
   public Check(String name) {   
        super(name);
        // Default the following checkbox to checked
        setLayout(new FlowLayout());
        chkStudent.setSelected(true);
        add(chkCar);
        add(chkStudent);
        chkCar.addActionListener(this);
        chkStudent.addActionListener(this);       
   
        for (int i=0; i < genName.length; i++)
        {
            JRadioButton rb = new JRadioButton(genName[i],false);
            genChk[i] = rb;
            generation.add(rb); // Add radio button to the generation grouping
            add(rb);
            rb.addActionListener(this);
        }
        // Set default radio button selection
        genChk[2].setSelected(true); // Set generation X by default
           
       
        add(toutput);    
        
        endline= System.getProperty("line.separator");    
     }
     
    public void actionPerformed(ActionEvent evt) {
        
        toutput.append("**********************************" + endline);
        toutput.append("Student at WCC? " + 
            chkStudent.isSelected()  + endline);
        toutput.append("Own Car? " + 
            chkCar.isSelected()  + endline);
            
        for (int i=0; i < genChk.length; i++)
            if (genChk[i].isSelected())
            {
                toutput.append("generation: " + genName[i] + endline);
                // Could put a break here and get the same answer
            }
       
       
       }
   
 
  public static void main(String[] args) { 
    Check aFrame = new Check("Check Boxes"); 
   
    aFrame.setSize(600,380); 
    aFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);    
    aFrame.setVisible(true); 
  } // end of main
}