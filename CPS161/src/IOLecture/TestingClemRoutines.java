package IOLecture;

public class TestingClemRoutines {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyInput mi = new MyInput();
		MyOutput mo = new MyOutput();
		
		String s = mi.get();
		mo.println(s);
		
		MyInput mi2 = new MyInput("fo.txt");
		String s2 = mi2.get();
		MyOutput mo2 = new MyOutput("MyOutputJunk.txt");
		mo2.println(s2);
		

	}

}
