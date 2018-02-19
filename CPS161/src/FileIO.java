import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class FileIO {

	void myRoutine()
	{
		
	}
    int[] readNumbers(int num)
    {
        int[] arr = new int[num];
        Scanner keyboard = new Scanner(System.in);
        for (int i=0; i < num; i++)
        {
            arr[i] = keyboard.nextInt();
        }
        return arr;
    }
    int[] readNumbers(int num, String filename) throws FileNotFoundException
    {
        int[] arr = new int[num];
        File f = new File(filename);
        Scanner keyboard = null;
        //try {
            keyboard = new Scanner(f);
        /*} catch (FileNotFoundException e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }*/
        for (int i=0; i < num; i++)
        {
            arr[i] = keyboard.nextInt();
        }
        keyboard.close();
        return arr;
    }
    void printNumbers(int[] arr)
    {
        for (int i=0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    void printNumbers(int[] arr, String filename)
    {
        PrintStream ps =null;
        try {
            ps = new PrintStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
        for (int i=0; i < arr.length; i++)
            ps.println(arr[i]);
        
        ps.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        FileIO fio = new FileIO();
        int[] arr = fio.readNumbers(5);
        fio.printNumbers(arr);
        

        arr = fio.readNumbers(5, "temp.txt");
        fio.printNumbers(arr, "tempOutput.txt");
        
        
    }

}