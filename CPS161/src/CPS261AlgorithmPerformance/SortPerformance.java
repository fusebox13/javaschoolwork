package CPS261AlgorithmPerformance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortPerformance {

    Integer nextNum()
    {
        return (int)(Math.random() * 1000);
    }
    void endBuild(List<Integer> list, int n)
    {
        Timer timeIt = new Timer();
        timeIt.start();
        
        for (int i=0; i < n; i++)
        {
            list.add(nextNum());
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }
    void sort(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();

        Collections.sort(list);
        
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    void selectionSort(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();

        SelectionSort.sort(list);
        
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    void quickSort(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();

        QuickSort.sort(list);
        
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    
    
    public static void main(String[] args) {
        System.out.println("Enter in N");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        
        SortPerformance sp = new SortPerformance();
        
        List<Integer> list = new ArrayList<Integer>();
        
        
        System.out.println("endBuild");    
        sp.endBuild(list, n);
        
        System.out.println("Collections.sort");
        sp.sort(list);
        
        System.out.println("QuickSort.sort");
        sp.quickSort(list);
        
        System.out.println("SelectionSort.sort");
        sp.selectionSort(list);
            
        keyboard.close();

    }

}