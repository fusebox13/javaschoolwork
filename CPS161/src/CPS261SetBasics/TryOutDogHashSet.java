package CPS261SetBasics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TryOutDogHashSet {

    public static void main(String[] args) {
        
        Set<Dog> set = new HashSet<Dog>();
        //Set<Dog> set = new LinkedHashSet<Dog>();
        
        set.add(new Dog("Pooch",2));
        Dog spike = new Dog("Spike",1);
        set.add(spike);
        set.add(null); // Yes you can store a Null in a Set ... but only one
        
        Dog spot = new Dog("Spot", 3);
        if (set.add(spot))
            System.out.println(spot+ " was added");
        
        if (!set.add(new Dog("Spot", 3)))
            System.out.println(spot+ " was not added again because it is a duplicate");
        
        if (set.contains(new Dog("Spike",1)))
            System.out.println("set should contain " + spike);
        
        set.add(new Dog("Fred",2));
        set.add(new Dog("Barney",3));
        set.add(new Dog("Fido",4));
        set.add(new Dog("Bruno",5));
        set.add(new Dog("Max",6));
        
        System.out.println("******* iteration dump ********");
        Iterator<Dog> iter = set.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());        
        }
        
        iter = set.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());        
        }
    }
    
    
}