package jcomponentslecture;

import java.awt.*;
import java.awt.event.*; // New Import for Events
import javax.swing.*;

public class Selection extends JFrame 
    implements ActionListener
{
   JTextArea toutput = new JTextArea(4,40);
   JTextField tadd = new JTextField(40);
      
   // Selection List allowing only one selection
   java.util.Vector<String> vList = new java.util.Vector<String>();
   JList myList;
   
   // Selection List allowing multiple selections
   JList myMultList ;
   
   String endline; 
   String strlist[] ={"zero", "one", "two", "three", "four", "five"};
 
   public  Selection(String name) { 
        super(name);
        setLayout(new FlowLayout());
        for (int i = 0; i < strlist.length; i++)
            vList.add(strlist[i]);
        
        myList= new JList(vList);
        myList.setVisibleRowCount(3);
        myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(myList);
        myMultList = new JList(vList);
           
        add (scrollPane);        

        add (myMultList);     
       
        add(new Label("********String to add to lists (- in front will remove)***********"));        
        add(tadd);
        JButton b = new JButton(
            "--         Click here to get something done       --");        
        add(b);
        add(toutput);    
        
        b.addActionListener(this);
        endline= System.getProperty("line.separator");    
     }
     
    public void actionPerformed(ActionEvent evt) {
        String str;
        toutput.setText("");          
        toutput.append(" myList selected index = " + myList.getSelectedIndex() +
                        " item = "  + myList.getSelectedValue() + endline);

        int[] indices = myMultList.getSelectedIndices();
        Object[] values = myMultList.getSelectedValues();
        for (int i=0; i < indices.length; i++)
        {
            toutput.append(" myMultList index="+indices[i]+ " value="+ values[i] +endline);
        }
        
        str = tadd.getText();
        str = str.trim();
        
        // If any string is found in the tadd TextField, we will either try
        // to add a string to the choice, list and multiple list components
        // or remove a string.  Removing happens if the string starts with a "-"
        
        if (str.length() > 0)
        {
            if (str.charAt(0) != '-')
                {
                    vList.add(str);
                    myList.setListData(vList);
                    myMultList.setListData(vList);
                    toutput.append("Successfully added " + str +
                        " to lists " + endline);

                }
             else
                {
                    // Remove from lists
                   
                    str = str.substring(1); // remove - sign
                    if (vList.remove(str))                      
                        toutput.append("Successfully removed " + str +
                                " from lists " + endline);
                    
                
                }
        }
       }
   
 
  public static void main(String[] args) { 
    Selection aFrame = new Selection("Selection");    
    aFrame.setSize(600,480);     
    aFrame.setVisible(true); 
  } // end of main
}