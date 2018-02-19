package CPS261Generics;


public abstract class Animal {
    String name;
    
    Animal(String name)
    {
        this.name = name;
    }
    abstract void makesNoise();

}

class Cow extends Animal
{
    Cow(String name)
    {
        super(name);
    }
    void makesNoise()
    {
        System.out.println("Moooo");
    }
}

class Snake extends Animal
{
    Snake(String name)
    {
        super(name);
    }
    void makesNoise()
    {
        System.out.println("Hiss");
    }
}

class Horse extends Animal
{
    Horse(String name)
    {
        super(name);
    }
    void makesNoise()
    {
        System.out.println("Whinny");
    }
    
}