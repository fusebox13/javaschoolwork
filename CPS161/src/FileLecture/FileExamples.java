package FileLecture;

import java.io.File;
import java.util.Date;

public class FileExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//You create the file object first
		//then you attem
		File f = new File("abc.txt"); // this is only a path name to some potential file in the working directory
		
		//Checks if a file is a director
		if (f.isDirectory())
			System.out.println(f + " is a directory");
		else 
			System.out.println(f + " is not a directory");
		
		//Checks if a file exists
		if (f.exists())
		{
			System.out.println(f + " exists.");
		}
		else
			System.out.println("Doesn't exist");
		
		//Makes a directory
		File dir = new File("MyDir");
		if (dir.mkdir())
			System.out.println(dir + " has been created.");
		else
			System.out.println("Could not create" + dir);
		
		//see if file is a directory or a file
		if (dir.isDirectory())
			System.out.println(dir + " is a directory");
		else 
			System.out.println(dir + " is not a directory");
		
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getName());
		
		//rename a directory
		File dirNew = new File("NewMyDir");
		dir.renameTo(dirNew);
		
		//Moves a file to a new directory
		//Create a file object with new path name
		//overwrite using renameTo() the old path name for
		//the file you want to move
		File fNew = new File (dirNew + File.separator + "abc.txt");
		f.renameTo(fNew);
		
		//Deletes at file
		File fDelete = new File("xyz.txt");
		fDelete.delete();
		
		//How to find when the file was last modified
		//lastModified returns a long which is the amount of millisends
		//since the clocks first started in 1970
		//can convert to current date using the date class
		File fStatic = new File("staticFile.txt");
		long time = fStatic.lastModified();
		Date d = new Date(time);
		System.out.println("Last modified: " + d);
		
		
		//Determine the length of a file
		long size = fStatic.length();
		System.out.println("Length = " + size);
		
		File currWorkingDirectory = new File(".");
		
		String[] fileNames = currWorkingDirectory.list();
		
		//lists all the files and directories within a directory
		for (int i = 0; i < fileNames.length; i++)
		{
			System.out.println(fileNames[i]);
		}
	}

}
