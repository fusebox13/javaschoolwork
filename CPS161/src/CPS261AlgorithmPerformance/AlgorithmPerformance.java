package CPS261AlgorithmPerformance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmPerformance {

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

    void binSearch(List<Integer> list)
    {
        // Assumes that list is sorted
        Timer timeIt = new Timer();
        timeIt.start();

        int n = list.size();
        for (int i=0; i < n; i++)
        {
            Integer i2 = nextNum();
            Collections.binarySearch(list, i2);
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    void shuffle(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();

        Collections.shuffle(list);
        
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }
    
    public static void main(String[] args) {
        System.out.println("Enter in N");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        
        AlgorithmPerformance sp = new AlgorithmPerformance();
        
        List<Integer> list = new LinkedList<Integer>();
        
        
        System.out.println("endBuild");    
        sp.endBuild(list, n);
        
        System.out.println("shuffle");
        sp.shuffle(list);
        
        System.out.println("sort");
        sp.sort(list);
        
        System.out.println("binsearch");
        sp.binSearch(list);
            
        keyboard.close();

    }


}