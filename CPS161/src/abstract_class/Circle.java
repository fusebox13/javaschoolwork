package abstract_class;

public class Circle extends Shape {

	public double radius;
	
	Circle(double r)
	{
		radius = r;
	}
	
	public double getArea()
	{
		return Math.PI * radius * radius;
	}
	
	public double getPerimeter()
	{
		return Math.PI * radius * 2;
	}	

}
