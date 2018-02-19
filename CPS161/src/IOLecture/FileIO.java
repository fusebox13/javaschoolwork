package IOLecture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class FileIO {

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


    int[] readNumbers(int num, String filename)
    {
        int[] arr = new int[num];
        File f = new File(filename);

// In the video, the "input" variable was called keyboard (which is dumb)
        Scanner input = null;
        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }
        for (int i=0; i < num; i++)
        {
            arr[i] = input.nextInt();
        }
        input.close();
        return arr;
    }
    void printNumbers(int[] arr)
    {
        for (int i=0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    void printNumbers(int[] arr, String filename) throws FileNotFoundException
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
    public static void main(String[] args) throws FileNotFoundException{
        FileIO fio = new FileIO();
        int[] arr = fio.readNumbers(5);
        fio.printNumbers(arr);
        

        arr = fio.readNumbers(5, "temp.txt");
        fio.printNumbers(arr, "tempOutput.txt");
        
        System.out.println("Complete!!");
    }

}