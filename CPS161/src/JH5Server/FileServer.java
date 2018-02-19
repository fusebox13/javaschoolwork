package JH5Server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileServer extends EchoServer
{
    StringTokenizer parseCommand;
    PrintStream outputPS = null;


    public void delete()
    {
    	File f = getFile();
    	
    	if (f.exists())
    	{
    		outputPS.println("Deleting " + f.getAbsolutePath());
    		if(f.delete()) //Does not throw exceptions
    		{
    			outputPS.println("Delete Successful");
    		}
    	}
    	else
    		outputPS.println("File not found");
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
    			outputPS.println("Renaming " + OldFile.getAbsolutePath() + " to " + NewFile.getAbsolutePath());
    			outputPS.println("Successful rename.");
    		}
    		else
    			outputPS.println("Rename failed.");
    	}
    	else
    		outputPS.println("File Not Found");

    }
    
    
    public void list()
    {
    	File f = getFile();
    	
    	if(f.exists())
    	{
    		String[] list = f.list();
    		for(int i = 0; i < list.length; i++)
    			outputPS.println(list[i]);
    	}
    	else
    		outputPS.println("File Not Found");
    }
    
    
    public void size()
    {
    	File f = getFile();
    
    	if(f.exists())
    	{
    		outputPS.println("Size for " + f.getAbsolutePath() + ": " + f.length());
    	}
    	else
    		outputPS.println("File not found");
    }
    
    
    public void lastModified()
    {
    	File f = getFile();
    	
    	if(f.exists())
    	{
    		
    		outputPS.println("Last modified for " + f.getAbsolutePath() + ": " + new Date(f.lastModified()));
    	}
    	else
    		outputPS.println("File not found.");
    }
    
    
    public void mkdir()
    {
    	File f = getFile();
    	
    	if (!f.exists())
    	{
    		f.mkdirs();
    		outputPS.println("mkdir successful: " + f.getAbsolutePath());
    	
    	}
    	else
    		outputPS.println("Directories already exist");
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
    				outputPS.println("Parent folder does not exist, creatings new folders.");
	    			f.getParentFile().mkdirs();
	    		}
	    		else
	    			outputPS.println("Parent directory: " + f.getParent() + " already exists. Attempting to create " + f.getName() + " within " + f.getParent() + ".");  
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
    	
    	outputPS.println("Created file for " + f.getAbsolutePath());
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
					outputPS.println(scan.nextLine());
				}
				scan.close();
				outputPS.println("Printed file for " + f.getAbsolutePath());
			}
    		else
    			outputPS.println("File not found.");
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
				outputPS.println(s.nextLine());
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
        	outputPS.println("Missing a File name");                  
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
    		outputPS.println("===>");
    		outputPS.println("Processing: " + line);
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
	    		outputPS.println("Bad Command");
	    	}
	    	outputPS.println("*******************************");
    	}
    	else
    		outputPS.println("Error: No commands.");
    	
    	outputPS.println("");
    }
    
    void processStream(InputStream is, OutputStream os)
    {
    	outputPS = new PrintStream(os);
        System.out.println("FileServer.processStream begins");
        Scanner input = new Scanner(is);
        
        while (input.hasNextLine())
        {
        	String command = input.nextLine();
        	System.out.println("Recieved from Client: " + command);
            processCommandLine(command);
        }
        input.close();
        outputPS.close();
        System.out.println("Exitting processStream");
    }
    
    public static void main(String[] args)
    {
    	FileServer fs = new FileServer();
    	fs.monitorServer();
    	System.out.println("Exiting FileServer");
    }

    
    /*void processCommandFile(String commandFile)
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
    	
    }*/   
    
}