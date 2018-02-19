package JH2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileOperations 
{
    StringTokenizer parseCommand;


    public void delete()
    {
    	File f = getFile();
    	
    	if (f.exists())
    	{
    		System.out.println("Deleting " + f.getAbsolutePath());
    		if(f.delete()) //Does not throw exceptions
    		{
    			System.out.println("Delete Successful");
    		}
    	}
    	else
    		System.out.println("File not found");
    }
    
    
    public void rename()
    {
    	File OldFile = getFile();
    	File NewFile = getFile();
    
    	if (OldFile.exists())
    	{
    		NewFile.delete();
    		
    		if (OldFile.renameTo(NewFile)) //Does not throw exceptions
    		{
    			System.out.println("Renaming " + OldFile.getAbsolutePath() + " to " + NewFile.getAbsolutePath());
    			System.out.println("Successful rename.");
    		}
    		else
    			System.out.println("Rename failed.");
    	}
    	else
    		System.out.println("File Not Found");

    }
    
    
    public void list()
    {
    	File f = getFile();
    	
    	if(f.exists())
    	{
    		String[] list = f.list();
    		for(int i = 0; i < list.length; i++)
    			System.out.println(list[i]);
    	}
    	else
    		System.out.println("File Not Found");
    }
    
    
    public void size()
    {
    	File f = getFile();
    
    	if(f.exists())
    	{
    		System.out.println("Size for " + f.getAbsolutePath() + ": " + f.length());
    	}
    	else
    		System.out.println("File not found");
    }
    
    
    public void lastModified()
    {
    	File f = getFile();
    	
    	if(f.exists())
    	{
    		
    		System.out.println("Last modified for " + f.getAbsolutePath() + ": " + new Date(f.lastModified()));
    	}
    	else
    		System.out.println("File not found.");
    }
    
    
    public void mkdir()
    {
    	File f = getFile();
    	
    	if (!f.exists())
    	{
    		f.mkdirs();
    		System.out.println("mkdir successful: " + f.getAbsolutePath());
    	
    	}
    	else
			System.out.println("Directories already exist");
    }
    
    
    public void createFile()
    {
    	PrintStream contents = null;
    	File f = getFile();
    
    	try 
    	{
    		if(f.getParent() != null)
    		{
    			if(!f.getParentFile().exists())
	    		{
	    			System.out.println("Parent folder does not exist, creatings new folders.");
	    			f.getParentFile().mkdirs();
	    		}
	    		else
	    			System.out.println("Parent directory: " + f.getParent() + " already exists. Attempting to create " + f.getName() + " within " + f.getParent() + ".");  
	    	}
			
    		contents = new PrintStream(f);
			while(parseCommand.hasMoreTokens())
				contents.println(parseCommand.nextToken());	
			contents.close();
		
    	} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		} 
    	catch(NullPointerException e) 
    	{
			e.printStackTrace();
		}
    	
    	System.out.println("Created file for " + f.getAbsolutePath());
    }

    
    public void printFile()
    {
    	File f = getFile();
    
    	try 
    	{
    		if(f.exists())
			{
    			Scanner scan = new Scanner(f);
				while(scan.hasNextLine())
				{
					System.out.println(scan.nextLine());
				}
				scan.close();
				System.out.println("Printed file for " + f.getAbsolutePath());
			}
    		else
    			System.out.println("File not found.");
		} 
    	catch (FileNotFoundException e) 
    	{
			e.printStackTrace();
		}
    	
    	
    }
       
    
    void printUsage()
    {
    	Scanner s = null;
	
    	try 
    	{
			s = new Scanner(new File("commands.txt"));
			while(s.hasNextLine())
	    	{
	    		System.out.println(s.nextLine());
	    	}
			s.close();
		} 
    	catch (FileNotFoundException e) 
    	{
			e.printStackTrace();
		}
    }

    
    private String getNextToken()
    {
        if (parseCommand.hasMoreTokens())
            return parseCommand.nextToken();
        else
            return null;
    }
    
    
    private File getFile()
    {
        File f = null;
        String fileName = getNextToken();
        
        if (fileName == null)     
            System.out.println("Missing a File name");                  
        else
            f = new File(fileName);      

        return f;
    }
 
    
    public void processCommandLine(String line)    
    {
    	parseCommand = new StringTokenizer(line);
    	String s = new String();
    	s = parseCommand.nextToken();
    	
    	if (line != null)
    	{
    		System.out.println("===>");
    		System.out.println("Processing: " + line);
	    	switch(s)
	    	{
	    	case "?":
	    		printUsage();
	    		break;
	    	case "createFile":
	    		createFile();
	    		break;
	    	case "printFile":
	    		printFile();
	    		break;
	    	case "lastModified":
	    		lastModified();
	    		break;
	    	case "size":
	    		size();
	    		break;
	    	case "rename":
	    		rename();
	    		break;
	    	case "mkdir":
	    		mkdir();
	    		break;
	    	case "delete":
	    		delete();
	    		break;
	    	case "list":
	    		list();
	    		break;
	    	default:
	    		System.out.println("Bad Command");
	    	}
	    	System.out.println("*******************************");
    	}
    	else
    		System.out.println("Error: No commands.");
    }

    
    void processCommandFile(String commandFile)
    {
    	Scanner commandScanner = null;
    	System.out.println("===>");
    	System.out.println("Processing:" + commandFile);
    	
    	try 
    	{
			commandScanner = new Scanner(new File(commandFile));
			
			while (commandScanner.hasNextLine())
			{
				String s = commandScanner.nextLine();
				processCommandLine(s);
			}
		} 
    	catch (FileNotFoundException e) 
    	{
			System.out.println("No command file found.");
		}
    	
    	
    	try	
    	{
    		commandScanner.close();
    	} 
    	catch(NullPointerException e) 
    	{
    		System.out.println("Skipping: " + commandFile);
    	}
    	
    	System.out.println("*******************************");
    	
    }
    
    
    public static void main(String[] args) 
    {
        FileOperations fo= new FileOperations();
        
        for (int i=0; i < args.length; i++)
            fo.processCommandFile(args[i]);

        System.out.println("Done with FileOperations");
    }
    
}