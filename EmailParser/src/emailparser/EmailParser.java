package emailparser;

import java.io.IOException;

import com.auxilii.msgparser.Message;
import com.auxilii.msgparser.MsgParser;

public class EmailParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MsgParser msgp = new MsgParser();
		try {
			Message msg = msgp.parseMsg("email.msg");
			System.out.println(msg.getBodyText());
			System.out.println(msg.getSubject());
			
			System.out.println(msg.getFromEmail());
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
