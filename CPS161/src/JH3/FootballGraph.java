package JH3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;

class PlayerData
{
	private String name;
	private int rating;
	
	PlayerData(String n, int r)
	{
		this.name = n;
		this.rating = r;
	}
	
	String getName()
	{
		return this.name;
	}
	
	int getRating()
	{
		return this.rating;
	}
	
	public String toString()
	{
		return name + " " + rating;
	}
}

class fileUtil
{
	private String title;
	private ArrayList<PlayerData> playerDataArray;
	
	fileUtil(File f)
	{
		try
		{
			Scanner fileScanner = new Scanner(f);
			playerDataArray = new ArrayList<PlayerData>();
			title = fileScanner.nextLine();
			
			while (fileScanner.hasNextLine())
			{
				String unparsedData = fileScanner.nextLine();
				StringTokenizer parsedData = new StringTokenizer(unparsedData, ";");
				
				String name = parsedData.nextToken();
				int rating = Integer.parseInt(parsedData.nextToken().trim());
				System.out.println(name);
				System.out.println(rating);
				
				
				playerDataArray.add(new PlayerData(name, rating));
				
				
			}
			System.out.println(title);
			System.out.println(playerDataArray.toString());
			
			fileScanner.close();
				
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException(f + " was not found.");
		}
		
		
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public ArrayList<PlayerData> getArrayList()
	{
		return this.playerDataArray;
	}
	
}

public class FootballGraph extends JFrame
{
	ArrayList<PlayerData> playerDataArray;
	Image bufferedImage = null;
	Dimension screenDimension = null;
	
	FootballGraph(File f)
	{
		super("Fantasy Football");
		
		try
		{
			fileUtil utils = new fileUtil(f);
			this.playerDataArray = utils.getArrayList();
			setTitle(utils.getTitle());
			setSize(600, 600);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}
	}
	
	int getMaxStringWidth(FontMetrics fm)
	{
		int maxTextWidth = 0;
		for(int i = 0; i < this.playerDataArray.size(); i++)
		{
			int width = fm.stringWidth(this.playerDataArray.get(i).getName());
			if (width > maxTextWidth)
				maxTextWidth = width;
			
		}
		return maxTextWidth;
	}
	
	int getMaxBarWidth()
	{
		int maxBarWidth = 0;
		for (int i=0; i < this.playerDataArray.size(); i++)
		{
			int rating = playerDataArray.get(i).getRating();
			if (rating > maxBarWidth)
				maxBarWidth = rating;
		}
		
		return maxBarWidth;
	}
	
	public void paint(Graphics screen)
	{
		//super.paint(g);
	
		Dimension d = getSize();
		if(bufferedImage == null || !d.equals(screenDimension))
		{
			screenDimension = d;
			bufferedImage = createImage(d.width, d.height);
		}
		Graphics g = bufferedImage.getGraphics();
		
		int border = 10;
		int pad = 5;
		
		//Insets vars with the border thickness added to them
		Insets insets = getInsets();
		int top = insets.top + border;
		int bottom = insets.bottom + border;
		int left = insets.left + border;
		int right = insets.right + border;
		
		//Font utilities to get font height and width
		Font font = g.getFont();
		FontMetrics fm = getFontMetrics(font);
		int fontHeight = fm.getHeight();
		int maxAscent = fm.getMaxAscent();
		
		//Gets the largest string in the array list, gets the pixel size, add the left inset plus a padding to the overall width
		int maxStringWidth = getMaxStringWidth(fm) + left + pad;
		
		//using the width of the largest string in the ArrayList, saves an x-location based on that width plus a pad
		int _xBarLocation = maxStringWidth + pad;
		
		//Calculates the scale factor for the bars.  The text height and width will remain fixed, while the bars can be resized to scale
		int maxBarWidth = getMaxBarWidth();
		double scale = (d.width - _xBarLocation - right) / (double) maxBarWidth;
		
		//y is the first y coordinate that is the window and inside the border
		int _y = top;
		int barHeight = fontHeight;
		
		//draws the bordered frame
		g.setColor(Color.darkGray);
		g.fillRect(0, 0, d.width, d.height);	
		g.setColor(Color.gray);
		g.fillRect(left, top, d.width - right - left, d.height - bottom - top);
		
		//draws each data element in the ArrayList
		for (int i = 0; i < playerDataArray.size(); i++)
		{
			//Gets the name string and the rating to be drawn to the screen.
			String name = playerDataArray.get(i).getName();
			int rating = playerDataArray.get(i).getRating();
			
			//Sets the width of the string, and the width of the bars
			int nameStringWidth = fm.stringWidth(name) + pad;
			int scaledBarWidth = (int)(rating * scale) + 1;
			
			//x coord is shifted to the right(-), y coord is shifted down(+)
			g.setColor(Color.white);
			g.drawString(name, maxStringWidth - nameStringWidth, _y + maxAscent);
			
			//x coord already determined, y coord is the current changing y coord needed to created rows
			g.setColor(Color.pink);
			g.fillRect(_xBarLocation, _y, scaledBarWidth, barHeight);
			
			//create a new row by shift the y coord to the height of the fond plus a pad
			_y += fontHeight + pad;
		}
		
		//draws the dividing line
		g.setColor(Color.white);
		g.drawLine(maxStringWidth, top, maxStringWidth, d.height - bottom - 1);
		screen.drawImage(bufferedImage,0,0,this);
	}

	
	
	public static void main(String[] args) 
	{
		FootballGraph f = new FootballGraph(new File("footballstats.txt"));
	}

}
