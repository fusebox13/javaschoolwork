package CPS261Generics;

import java.util.ArrayList;

public class AnimalCollection<X extends Animal> {
    ArrayList<X> collection = new ArrayList<X>();
    
  
    void add(X animal)
    {
        collection.add(animal);
    }
    void makeAllNoises()
    {
        for (int i=0; i < collection.size(); i++)
        {
            X animal = collection.get(i);
            animal.makesNoise();
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Dairy:");
        AnimalCollection<Cow> dairy = new AnimalCollection<Cow>();
        dairy.add(new Cow("Molly"));
        dairy.add(new Cow("Bess"));
        dairy.makeAllNoises();
        
        System.out.println("***********************");
        System.out.println("SnakePit:");
        
        AnimalCollection<Snake> snakePit = new AnimalCollection<Snake>();
        snakePit.add(new Snake("Judas"));
        snakePit.add(new Snake("Benedict"));
        snakePit.makeAllNoises();
        
        //dairy.add(new Snake("Jezebel"));
        
        
        System.out.println("***********************");
        System.out.println("Zoo:");
        AnimalCollection<Animal> zoo = new AnimalCollection<Animal>();
        zoo.add(new Horse("Prince"));
        zoo.add(new Cow("Molly"));
        zoo.add(new Snake("Judas"));
        zoo.makeAllNoises();
        
        //snakePit.add(new Horse("Gettup"));
        
    }

}