package abstract_class;

public abstract class Shape {
    public abstract double getArea();
    public abstract double getPerimeter();
    public double getAPRatio()
    {
        return getArea()/getPerimeter();
    }
}