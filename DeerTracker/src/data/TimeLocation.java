package data;

public class TimeLocation {
	
	public long time;
	public String location;
	
	TimeLocation(long time, String location)
	{
		this.time = time;
		this.location = location;
	}
	
	TimeLocation()
	{
		this(-1, null);
	}
	
	public long getTime()
	{
		return time;
	}
	
	public String getLocation()
	{
		return location;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
