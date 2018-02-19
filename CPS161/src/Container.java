abstract class Container {
	double height;
	Container(double height)
	{
		this.height = height;
	}
	abstract double getTopArea();
	abstract double getTopPerimeter();
	
	double getVolume()
	{
		return height * getTopArea();
	}
	double getSurfaceArea()
	{
		return 2*getTopArea() + height * getTopPerimeter();
	}
}

class CircularContainer extends Container
{
	private double radius;
        
	CircularContainer(double height, double radius)
	{
		super(height);
		this.radius = radius;
		
	}
	
	double getTopArea()
	{
		return Math.PI * radius * radius;
	}
	
	double getTopPerimeter()
	{
		return 2.0 * Math.PI * radius;
	}
	
}

class RectangularContainer extends Container
{
	private double width;
	private double length;
	
	RectangularContainer(double height, double width, double length)
	{
		super(height);
		this.width = width;
		this.length = length;
		
	}
	double getTopArea()
	{
		return width * length;
	}
	
	double getTopPerimeter()
	{
		return 2.0 * (width + length);
	}
	
}

class TriangularContainer extends Container
{
	private double side_a;
	private double side_b;
	private double side_c;
	
	TriangularContainer(double height, double side_a, double side_b, double side_c)
	{
		super(height);
		this.side_a = side_a;
		this.side_b = side_b;
		this.side_c = side_c;
		
	}
	
	double getTopArea()
	{
		double s = (side_a + side_b + side_c)/2.0;
		return Math.sqrt(s*(s-side_a)*(s-side_b)*(s-side_c));
	}
	
	double getTopPerimeter()
	{
		return side_a + side_b + side_c;
	}
	
}


class RegularPolygonContainer extends Container
{
	private double side;
	private int numSides;
	
	RegularPolygonContainer(double height, double side, int numSides)
	{
		super(height);
		this.side = side;
		this.numSides = numSides;
	}
	
	double getTopArea()
	{
		return numSides * side * side / ( 4*Math.tan(Math.PI/numSides));
	}
	
	double getTopPerimeter()
	{
		return numSides * side;
	}
}

