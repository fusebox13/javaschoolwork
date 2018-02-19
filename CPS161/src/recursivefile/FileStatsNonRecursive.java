package recursivefile;

import java.io.File;
import java.util.ArrayList;


class StatData
{
    long numFiles = 0;
    long numBytes =0;
    long numDirs = 0;
    public String toString()
    {
        return "numFiles =" + numFiles + " numBytes ="+ numBytes + " numDirs="+numDirs;
    }
}

public class FileStatsNonRecursive {
    boolean verbose=false;
    ArrayList<String> stack = new ArrayList<String>();
    
    private void push(String s)
    {
        stack.add(s);
    }
    private String pop()
    {
        String s= stack.remove(stack.size()-1);
        return s;
    }
    private boolean isStackEmpty()
    {
        if (stack.size() == 0)
            return true;
        else
            return false;
    }
    
    FileStatsNonRecursive(boolean verbose)
    {
        this.verbose = verbose;
    }
    
    public void nonRecursiveCollect( String pathname, StatData stats)
    {
        push(pathname);
        
        do
        {  
            String path = pop();
            if (verbose)
                System.out.println(path);
            stats.numFiles +=1;
            File f = new File(path);
            
            if (f.isDirectory())
            {
                stats.numDirs += 1;
                String[] fileNames = f.list();
                if (fileNames != null)
                {
                    for (int i=0; i < fileNames.length; i++)
                    {
                        String newPathname = path + File.separator + fileNames[i];
                        File f2 = new File(newPathname);
                        if (f2.isDirectory())
                        {
                            push(newPathname);
                        }
                        else
                        {
                            if (verbose)
                                System.out.println(newPathname);
                            stats.numBytes += f2.length();
                            stats.numFiles +=1;
                        }
                    }
                }
            }
            else
                stats.numBytes += f.length();
        } while (!isStackEmpty());
        
    }

    public StatData collectData(String pathname)
    {
        StatData stats = new StatData();
        
        File file = new File(pathname);
        System.out.println("pathname="+pathname);
        System.out.println("Full Path="+file.getAbsolutePath());
        nonRecursiveCollect( pathname, stats);
        
        System.out.println(" stats = " + stats);
        
        return stats;
    }
    
    
    public static void main(String[] args) {
        FileStatsNonRecursive fs = new FileStatsNonRecursive(true);
        
        if (args.length > 0)
            fs.collectData(args[0]);
        else
            fs.collectData(".");
    }

}