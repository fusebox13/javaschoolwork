package recursivefile;

import java.io.File;

class Stats
{
	long numFiles = 0;
	long numBytes = 0;
	long numDirs = 0;
	
	public String toString()
	{
		return "Number of Files: " + numFiles + " Number of Bytes: " + numBytes + " Number of directories: " + numDirs;
	}
}

public class FileStats 
{
	boolean verbose = false;
	
	FileStats(boolean verbose)
	{
		this.verbose = verbose;
	}
	
	public Stats collectData(String pathname)
	{
		Stats stats = new Stats();
		
		File file = new File(pathname);
		System.out.println("Pathname: " + pathname);
		System.out.println("Full Pathname: " + file.getAbsolutePath());
		recursiveCollect(file, pathname, stats);
		System.out.println("Stats: " + stats);
		return stats;
	}
	
	//starts at mydir, reads that it's a directory so it stores the list in an array
	//iterates through each element on the list
	//the first being file a
	//since a is a file, it adds the number of bytes to the stats object and the next
	//file or directory on the list will be read in the for loop, file b
	//when it gets to a directory, it creates a new instance of the for loop
	//to list the files in the directory.  Once each of those files are done
	//it reads the next file, d in the original for loop that resumes after the
	//loops to read cdir finish.
	public void recursiveCollect(File f, String pathname, Stats stats)
	{
		if (verbose)
			System.out.println(pathname);
		stats.numFiles += 1;
		if(f.isDirectory())
		{
			stats.numDirs +=1;
			String[] fileNames = f.list();
			if (fileNames != null)
			{
				for (int i=0; i < fileNames.length; i++)
				{
					String newPathname = pathname + File.separator + fileNames[i];
					File f2 = new File(newPathname);
					recursiveCollect(f2, newPathname, stats);
				}
			}
			
		}
		else
			stats.numBytes += f.length(); // length for file objects return amount of bytes
	}

	
	public static void main(String[] args) 
	{
		FileStats fs = new FileStats(true);
		
		if(args.length > 0)
			fs.collectData(args[0]);
		else
			fs.collectData(".");

	}

}
