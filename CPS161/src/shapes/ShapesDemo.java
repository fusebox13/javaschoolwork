package shapes;

public class ShapesDemo {

    private static int getCount = 1;
    
    public int getCount()
    {
    	return getCount;
    }
    public static void main(String[] args) {
        Shape[] arr = new Shape[5];
        Shape rect = new Rectangle(1, 2, "red", 5, 2);
        arr[0] = new Rectangle(1,2, "red", 4,5);
        arr[1] = new Oval(3,4, "red", 6,8);
        //arr[2] = new Shape(5,6,"green");
        arr[2] = new Oval(4, 6, "blue", 8, 9);	
        arr[3]= new Rectangle(10,12, "blue", 6,8);
        arr[4]= new Oval(10,12, "blue", 6,8);
        Oval o = (Oval)arr[4];
        
        System.out.println(" arr[4] count =" + arr[4].getCount()); // compiler determines type to be a shape
        System.out.println(" arr[4] count =" + o.getCount()); // compiler determines type to be an oval, but they are the same object
        
        
        System.out.println("***************************************");
        double totalArea = 0;
        for (int i=0; i < arr.length; i++)
        {
            //totalArea += arr[i].area();
            Shape s = arr[i];
            totalArea += s.area();
            System.out.println(s);
        }
        
        System.out.println("total area ="+ totalArea);
        
        System.out.println("Total shapes = " + Shape.getCount()); // proper way to call a static method
        System.out.println("Total Ovals = " + Oval.getCount());
        System.out.println("Total Rectangles = " + Rectangle.getCount());
        
    }

}