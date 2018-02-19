package abstract_class;

public class Square extends Shape {

	double side;
	
	Square (double s)
	{
		side = s;
	}
	
	public double getArea()
	{
		return side*side;
	}
	
	public double getPerimeter()
	{
		return side * 4;
	}

}
