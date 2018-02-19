package CPS261ListPerformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InsertionPerformanceComparisons {
    
    Integer nextNum()
    {
        return (int)(Math.random() * 1000);
    }
    
    void frontBuild(List<Integer> list, int n)
    {
        Timer timeIt = new Timer();
        timeIt.start();
        
        for (int i=0; i < n; i++)
        {
            list.add(0, nextNum());
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }
    void middleBuild(List<Integer> list, int n)
    {
        Timer timeIt = new Timer();
        timeIt.start();
        
        for (int i=0; i < n; i++)
        {
            list.add(i/2, nextNum());
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    void endBuild(List<Integer> list, int n)
    {
        Timer timeIt = new Timer();
        timeIt.start();
        
        for (int i=0; i < n; i++)
        {
            list.add(list.size() , nextNum());
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }
    
    
    
    
    
    public static void main(String[] args) {
                
        System.out.println("Enter in N ");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        
        InsertionPerformanceComparisons ipc = new InsertionPerformanceComparisons();
        
        List<Integer> list = new ArrayList<Integer>();
        // Also try ArrayList
        
        
        System.out.println("endBuild");    
        ipc.endBuild(list, n);
    
        
        list.clear();
        System.out.println("frontBuild");
        ipc.frontBuild( list, n);
        
        list.clear();
        System.out.println("middleBuild");
        ipc.middleBuild( list, n);
        
        keyboard.close();
    }

}