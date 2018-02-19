package CPS261SetBasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;


class MyNumber implements Comparable<MyNumber>
{
    static int MaxNumber = 20000000; // 20 million
    int value;
    int iteration;
    MyNumber(int iteration)
    {
        value = (int)(MaxNumber * Math.random());
        this.iteration = iteration;
    }
    public boolean equals(Object ob)
    {
        MyNumber n = (MyNumber)ob;
        if (value == n.value )
            return true;
        else
            return false;
    }
    public String toString()
    {
        return value +":"+ iteration;
    }
    public int hashCode()
    {
        return value;
    }
    @Override
    public int compareTo(MyNumber other) {
        return value - other.value;
    }
}



public class ContainsPerformance {
    static void addManyObjects(int N, Collection<MyNumber> collection)
    {
        Timer timer = new Timer();
        timer.start();
        for (int i=0; i < N; i++)
        {
            MyNumber myNumber = new MyNumber(i);
            if (!collection.contains(myNumber))
                collection.add(myNumber);
        }
        timer.stop();

	     System.out.println(collection.size() + " numbers stored");
        collection.clear();  // Free up memory for next test
        System.out.printf("time elapsed = %.4f  seconds%n" , timer.time());
    }

    
    public static void main(String[] args) {
        
        System.out.println("Enter in N (recommend 2000000 or 60000):");
        Scanner keyboard = new Scanner(System.in);
        int N = keyboard.nextInt();
        
        System.out.println("Try HashSet(3000000):");
        HashSet<MyNumber> hashSet = new HashSet<MyNumber>(3000000);
        addManyObjects(N, hashSet);

        System.out.println("Try HashSet:");
        HashSet<MyNumber> hashSet2 = new HashSet<MyNumber>();
        addManyObjects(N, hashSet2);
        

        System.out.println("Try LinkedHashSet:");
        LinkedHashSet<MyNumber> linkedHashSet = new LinkedHashSet<MyNumber>();
        addManyObjects(N, linkedHashSet);
        
        System.out.println("Try TreeSet:");
        TreeSet<MyNumber> treeSet = new TreeSet<MyNumber>();
        addManyObjects(N, treeSet);

        System.out.println("Try ArrayList:");
        ArrayList<MyNumber> arrayList = new ArrayList<MyNumber>();
        addManyObjects(N, arrayList);
        
        keyboard.close();    
    }

}