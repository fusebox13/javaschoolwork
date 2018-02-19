package IOLecture;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestingPrintstream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileOutputStream fs = null;
		
		try {
			fs = new FileOutputStream("fo.txt");
			PrintStream ps = new PrintStream(fs);
			ps.println("Testing PrintStream");
			ps.println("Last line!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (fs != null)
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
