class ContainerCollection
{
	Container[] collection;
	int numContainers;
	int containerCount=0;
	
	ContainerCollection(int numContainers)
	{
		this.numContainers = numContainers;
		collection = new Container[numContainers];
	}
	
	void addContainer( Container c)
	{
		if(containerCount < numContainers)
		{
			containerCount++;
			collection[containerCount - 1] = c;
		}
		else
			System.out.println("Container is full");
	}
	
	double getTotalVolume()
	{
		double totalVolume = 0;
		for(int index = 0; index < containerCount; index++)
			totalVolume+=collection[index].getVolume();
		
		return totalVolume;
	}
	
	double getTotalSurfaceArea()
	{
		double totalSurfaceArea = 0;
		for(int index = 0; index < containerCount; index++)
			totalSurfaceArea+=collection[index].getSurfaceArea();
		
		return totalSurfaceArea;
	}
	
	public static void main(String[] args)
	{
		ContainerCollection cc = new ContainerCollection(10);
		
		cc.addContainer(new CircularContainer(10., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(10., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(10., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(10., 1.0, 4)); // height, side, num_sides
		

		cc.addContainer(new CircularContainer(5., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(5., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(5., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(5., 1.0, 4)); // height, side, num_sides
		

		cc.addContainer(new CircularContainer(2., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(2., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(2., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(2., 1.0, 4)); // height, side, num_sides
		
		System.out.println("Total Volume of all containers = " + cc.getTotalVolume());
		System.out.println("Total Surface Area of all containers = " + cc.getTotalSurfaceArea());
	}
}