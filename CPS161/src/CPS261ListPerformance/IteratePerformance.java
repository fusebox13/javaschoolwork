package CPS261ListPerformance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IteratePerformance {


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
    void iterate(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext())
        {
            Integer i2 = iter.next();
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    void forLoop(List<Integer> list)
    {
        Timer timeIt = new Timer();
        timeIt.start();
        int len = list.size();

        for (int i=0; i < len; i++)
        {
            Integer i2 = list.get(i); // This is a bad call to make for LinkedList
        }
        timeIt.stop();
        System.out.printf("time=%.2f seconds%n", timeIt.time() );
    }

    public static void main(String[] args) {
        System.out.println("Enter in N");
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();

        IteratePerformance ipc = new IteratePerformance();

        List<Integer> list = new ArrayList<Integer>();
       // Re-run this with ArrayList


        System.out.println("endBuild");    
        ipc.endBuild(list, n);

        System.out.println("iterate");
        ipc.iterate(list);

        System.out.println("forLoop");
        ipc.forLoop(list);

        keyboard.close();

    }

}