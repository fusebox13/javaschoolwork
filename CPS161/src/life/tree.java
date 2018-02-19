package life;

public class tree implements Living {

	@Override
	public void move() {
		System.out.println("I really don't move, but I do sway.");
		
	}

	@Override
	public void eat() {
		System.out.println("I suck nutrients from the ground.");
		
	}

	@Override
	public void born() {
		System.out.println("I was born from a seed that was dropped");
	}

	@Override
	public void die() {
		System.out.println("Sometimes people cut me down.");
		// TODO Auto-generated method stub
		
	}
	

	

}
