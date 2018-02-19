package orchestra_interface;



public class DemoOrchestra {

	public static void main(String[] args)
	{
		MakeMusic[] orchestra = new MakeMusic[4];
		
		orchestra[0] = new Drum();
		orchestra[1] = new Tuba();
		//orchestra[2] = new MakeMusic();
		orchestra[2] = new Singer("Grace", 25);
		orchestra[3] = new Brass();
		
		for (int i = 0; i < orchestra.length; i++)
		{
			MakeMusic m = orchestra[i];
			System.out.println(m.getType() + " makes the sound " + m.play());
		}
	}
}
