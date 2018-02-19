package normal_class;

public class Rectangle extends Shape {

	public double width;
	public double length;
	
	Rectangle(double w, double l)
	{
		width = w;
		length = l;
	}
	
	public double getArea()
	{
		return width * length;
	}
	
	public double getPerimeter()
	{
		return (width + length) * 2;
	}


}
