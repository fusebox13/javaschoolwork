package orchestra_abstract;


public abstract class MakeMusic {
	
	abstract String getType();
	
	abstract String play();
	
	
	

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