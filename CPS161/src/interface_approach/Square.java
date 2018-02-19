package interface_approach;

public class Square implements Shape {

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

	public double getAPRatio() 
	{
		return getArea() / getPerimeter();
		
	}

}
