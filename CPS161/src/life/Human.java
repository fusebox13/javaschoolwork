package life;

public class Human implements Living {

	@Override
	public void move() {
		System.out.println("Steps Forward");
		
	}

	@Override
	public void eat() {
		System.out.println("Eats McDonalds");
	}

	@Override
	public void born() {
		System.out.println("Goo goo gaga!");
	}

	@Override
	public void die() {
		System.out.println("Pushing out daisies");
	}



}
