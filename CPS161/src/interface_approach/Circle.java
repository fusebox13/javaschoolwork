package interface_approach;

public class Circle implements Shape {

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

	public double getAPRatio() {
		return getArea() / getPerimeter();
	}	

}
