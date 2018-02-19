package parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("http://www.lushusa.com").get();
			//Element paragraph = doc.select("p").first();
			Elements paragraphs = doc.select("p");
			
			//Element content = doc.getElementById("content");
			//Elements links = content.getElementsByTag("p");
			
			for (Element paragraph : paragraphs ) {
				System.out.println(paragraph.text());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
