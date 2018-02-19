package IOLecture;

import java.io.*;

public class MyInput {
// If a file is not passed in, we will open up a Buffered Reader
// created from System.in

   InputStreamReader instream = new InputStreamReader(System.in);
   BufferedReader in = new BufferedReader(instream);
   String fileName=null;

// read from keyboard
public MyInput()  {
   }

//read from file f
public MyInput(String f)
   {   
     fileName = f; 
     if (!open(fileName))
         System.out.println("Defaulting to reading from keyboard");          
   }
public boolean open(String file)
   { 
       try {               
               if (file.length() > 0)
                   {
                       FileReader fr = new FileReader(file);
                       in =    new BufferedReader(fr);
                   }
               return true;
       }
       catch (FileNotFoundException e) {
           System.out.println("File Not Found Exception in get");
           return false;
       }
   }

public void close()
{
   try {
       in.close();
       }
   catch (IOException e){
       System.out.println("IO Exception on close call");
       }
}

protected void finalize()
{
    close();
}

public String get()
   {
       try {
               return in.readLine();
       }
       catch (FileNotFoundException e) {
           System.out.println("File Not Found Exception in get");
           return null;
       }
       catch(IOException e) {
           System.out.println("IO Exception in get");
           return null;
       }
   }

public int getInt()
{    
    String str = get();
    if (str != null)
    {
       try {
            return Integer.parseInt(str);
            }
       catch (NumberFormatException e) { /* Do Nothing */} 
    }
    System.out.println("Bad int input");
    return -1;
}

public static void main(String args[])  {
       MyInput input;
       String str;

       if (args.length > 0)
           input = new MyInput(args[0]);
       else
           input = new MyInput();

       do {
           str = input.get();
           if (str != null)
           {
               System.out.println(str);
                   if (str.equals("####"))
                       break;
           }
       } while (str != null);  

       input.close();    
       
   }
}