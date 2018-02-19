package JH1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Concat {
	
	Concat()
	{	
	}
	
	
    public void copy(InputStream is, PrintStream ps)
    {
    	
	    Scanner scan = new Scanner(is);
	    boolean done = false;
	    while(scan.hasNextLine() && !done)
	    {
	    	String s = scan.nextLine();
	    	if (s.trim().length() == 0)
	    	{
	    		done = true;
	    	}
	    	
	    	ps.println(s);
	    }
	    scan.close();
    }
    
    
    void concat(String[] inFiles,  int numInputs, String outFile)
    {
    	PrintStream ps = null;
    	InputStream is = null;
    	int fileListIndex = 0;
    	
    	
    	if(numInputs > 0)
		{
    		try
        	{
    	    	ps = new PrintStream(outFile);
    	    }
    		catch(IOException e)
        	{
        		//Do nothing - Program will default to printing to the screen
        	}
        	catch(NullPointerException e)
        	{
        		//Do nothing - Program will default to printing to the screen
        	}
        	
    		try
    		{
    			for(int i = 0; i < numInputs; i++)
	    		{
	    			fileListIndex = i;
	    			if(thisFileHasValidSuffix(inFiles[i]))
	    			{
	    				is = new FileInputStream(inFiles[i]);
	    				copy(is, ps);
	    				is.close();
	    			}
	    		}
    		}
    		catch (FileNotFoundException e)
        	{
        		throw new RuntimeException("File not found: [" + inFiles[fileListIndex] + "]");
        	} 
    		catch (IOException e) 
        	{
    			throw new RuntimeException("Fatal error.  Unable to close: [" + inFiles[fileListIndex] + "]");
			}
		}
    	else
    		copy(System.in, System.out);
    	
    	
    	ps.close();                         
    }
    
    
    public boolean thisFileHasValidSuffix(String s)
    {
    	if (s.endsWith(".java") || s.endsWith(".txt"))
    		return true;
    	else
    		throw new RuntimeException("Invalid file format, must be .java or .txt: [" + s + "]");
    }
  
    
    public void process(String[] args)
    {
     switch(args.length)
       {
       case 0:
           System.out.println("No input files, defaulting to reading from the keyboard and writing to the screen");
           concat(args, 0, null);
           break;
       case 1:
           System.out.println("No output file, defaulting to writing to the screen");
           concat(args,  1, null);
           break;
       default:
           concat(args,  args.length-1, args[args.length-1]);
           break;
       }    
    }
    

    public static void main(String[] args) {
       
        Concat concat = new Concat();
        try
        {
            concat.process(args);
        }
        catch (RuntimeException e)
        {   
            System.out.println(" Error in Concat:"+e);
            e.printStackTrace();
        }
    }
    
   

}