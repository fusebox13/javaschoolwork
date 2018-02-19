package CPS261SetBasics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class TryOutSetInterface {

    public static void main(String[] args) {
        
//HashSet iterates in a random fashion
        //Set<String> set = new HashSet<String>();
//LinkedHashSet maintains the ordering of the insertion
        //Set<String> set = new LinkedHashSet<String>();
//TreeSet maintains the ordering sorted by "Natural Ordering"
        Set<String> set = new TreeSet<String>();
        
        set.add("one");
        set.add("two");
        //set.add(null); // Yes some of the Set implementations allow a null  ... but only one
        
        if (set.add("three"))
            System.out.println("three was added");
        
        if (!set.add("three"))
            System.out.println("three was not added again because it is a duplicate");
        
        if (set.contains("two"))
            System.out.println("set should contain two");
        
        if (!set.contains("fifty"))
            System.out.println("set should not contain fifty");
        
        set.add("four");
        set.add("five");
        set.add("six");
        set.add("seven");
        set.add("eight");
        
        System.out.println("******* iteration dump ********");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());        
        }
    }

}
