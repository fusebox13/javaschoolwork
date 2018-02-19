import java.util.StringTokenizer;


public class testclass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long j = 2;
		
		String test = new String("Brave new World");
		test+="yelo";
		
		StringTokenizer parse = new StringTokenizer(test);
		
		while (parse.hasMoreTokens())
			System.out.println(parse.nextToken());

	}

}
