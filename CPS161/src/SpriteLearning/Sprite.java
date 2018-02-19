package SpriteLearning;

import java.awt.Frame;
import java.awt.MediaTracker;


public class Sprite extends Frame implements Runnable {

	private MediaTracker mediaTracker;
	
	Sprite()
	{
		mediaTracker = new MediaTracker(this);
	}
	
	public void run()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
