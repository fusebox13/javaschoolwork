package orchestra_regular_class;

public class MakeMusic {
	
	String getType()
	{
		return "I'm just a generic Music Thing";
	}
	
	String play()
	{
		return "I'm a generic play sound";
	}
	
	public static void main(String[] args)
	{
		MakeMusic[] orchestra = new MakeMusic[4];
		
		orchestra[0] = new Drum();
		orchestra[1] = new Tuba();
		orchestra[2] = new MakeMusic();
		orchestra[3] = new Brass();
		
		for (int i = 0; i < orchestra.length; i++)
		{
			MakeMusic m = orchestra[i];
			System.out.println(m.getType() + " makes the sound " + m.play());
		}
	}
	

}

class Drum extends MakeMusic
{
	String getType()
	{
		return "drum";
	}
	
	String play()
	{
		return "rat a tat tat";
	}
}

class Brass extends MakeMusic
{
	String getType()
	{
		return "Brass";
	}
	
	String play()
	{
		return "Some brass sound";
	}
}

class Tuba extends Brass
{
	String getType()
	{
		return "Tuba";
	}
	
	String play()
	{
		return "Oomp Pa Pa";
	}
}