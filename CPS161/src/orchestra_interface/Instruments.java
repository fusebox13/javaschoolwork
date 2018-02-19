package orchestra_interface;

class Drum implements MakeMusic // base class is object
{
	public String getType()
	{
		return "drum";
	}
	
	public String play()
	{
		return "rat a tat tat";
	}
}

class Brass implements MakeMusic
{
	public String getType()
	{
		return "Brass";
	}
	
	public String play()
	{
		return "Some brass sound";
	}
}

class Tuba extends Brass
{
	public String getType()
	{
		return "Tuba";
	}
	
	public String play()
	{
		return "Oomp Pa Pa";
	}
}