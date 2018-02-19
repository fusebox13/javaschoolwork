package CPS261SetBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TryOutDogTreeSet {

    public static void main(String[] args) {
        
        Set<Dog> set = new TreeSet<Dog>();
        
        set.add(new Dog("Pooch",2));
        Dog spike = new Dog("Spike",1);
        set.add(spike);
        
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
        set.add(new Dog("Bruno",1));
        set.add(new Dog("Max",6));
        
        System.out.println("******* iteration dump ********");
        Iterator<Dog> iter = set.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next());        
        }
        
    }

}
