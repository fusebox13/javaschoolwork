package CPS261SetBasics;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class TryOutSortedSetInterface {
    
    static void dump(SortedSet<String> ss)
    {
        Iterator<String> iter = ss.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());
        }
        System.out.println("********************************");
        System.out.println();
    }

    
    public static void main(String[] args) {
        String[] greek={"zeta", "epsilon", "delta", "alpha", "pi", "rho", "gamma", "tau", "eta",
                "alpha", "theta", "sigma", "phi", "omega", "gamma", "lambda"};
        
        SortedSet<String> sortedSet = new TreeSet<String>();
        for (int i=0; i < greek.length; i++)
        {
            if (!sortedSet.add(greek[i]))
            {
                System.out.println("The following was a duplicate: "+ greek[i]);
            }
        }
        
        System.out.println("***** Total Iteration dump *****");
        dump(sortedSet);
        
        // Methods from SortedSet:
        System.out.println("first() = " + sortedSet.first());
        System.out.println("last() = " + sortedSet.last());
        
        System.out.println("***** headSet(gamma) *****");
        SortedSet ss = sortedSet.headSet("gamma");
        dump(ss);
        
        System.out.println("***** tailSet(rho) *****");
        ss = sortedSet.tailSet("rho");
        dump(ss);
        
        System.out.println("***** subSet(gamma, rho) *****");
        ss = sortedSet.subSet("gamma", "rho");
        dump(ss);      
    }
}