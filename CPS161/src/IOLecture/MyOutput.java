package IOLecture;

import java.io.*;

public class MyOutput {
// If a file is not passed in, we will open up a PrintStream
// created from System.out

   PrintStream out = System.out;
   String fileName=null;

// output goes to screen 
public MyOutput()  {
   }

// output goes to a file
public MyOutput(String file)
   {   
   fileName = file;
   open2(fileName, false);           
   }

// If append = true, then the output file will be appended as
// opposed to overwriting from the beginning. 
public MyOutput(String file, boolean append)
   {   
   fileName = file;
   if (!open2(fileName, append))
       System.out.println("Defaulting to Terminal Screen");           
   }


public boolean open(String arg)
   { 
        return open2(arg, false);
    }


public boolean open2(String arg, boolean append)
   { 
       try {
               String file = arg;
               if (file.length() > 0)
                   {
                        FileOutputStream fw;
                        if (append)
                           fw = new FileOutputStream(file, true);
                        else
                           fw = new FileOutputStream(file);
                       out =    new PrintStream(fw);
                   }
               return true;
       }
       catch (FileNotFoundException e) {
           System.out.println("File Not Found Exception in get" + 
                   e.getMessage());
           return false;
       }       
   }

public void println (String str) {
   out.println(str);
}

public void print(String str)
   {
      out.print(str);           
   }
public void close()
{
   out.close();
}
protected void finalize()
{
    close();
}

public static void main(String args[])  {
       // myout1 will write to screen
       MyOutput myout1 = new MyOutput() ;
       
       //myout2 will write to file junk.txt
       MyOutput myout2 = new MyOutput("junk.txt");

       myout1.println("First Line"); // write to screen
       myout2.println("First Line"); // write to junk.txt         
       
       myout1.println("Second Line"); // write to screen
       myout2.println("Second Line"); // write to junk.txt           

       myout1.close();  
       myout2.close();          
   }
}