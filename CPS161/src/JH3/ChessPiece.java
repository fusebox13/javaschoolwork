package JH3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

enum PieceColor {black, white};
enum PieceType 	{Pawn, Rook, Knight, Bishop, Queen, King};

class TileDimensions
{
	int xPosition, yPosition, width, height;
	
	TileDimensions(int x, int y, int width, int height)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = width;
		this.height = height;
	}
}

class Piece
{
	int row, col;
	PieceType pieceType;
	PieceColor pieceColor;
	
	public Piece(PieceType p, PieceColor c, int row, int col)
	{
		this.pieceType = p;
		this.pieceColor = c;
		this.row = row;
		this.col = col;
	}
	
	public void drawInPosition(Graphics g, TileDimensions tile)
	{
		ChessPiece chessPiece = ChessPiece.chessPieces[pieceColor.ordinal()][pieceType.ordinal()];
		//If it's row 0, the width is 0, if it's row one the x position is based on the width of one row etc...
		int x = tile.xPosition + row * tile.width;
		int y = tile.yPosition + col * tile.height;
		chessPiece.draw(g,  x, y, tile.width, tile.height);
	}
	
}

public class ChessPiece 
{
	//Dumps the 
	private static PieceColor[] pieceColor = PieceColor.values();
	private static PieceType[] pieceType = PieceType.values();
	public static ChessPiece[][]chessPieces = new ChessPiece[pieceColor.length][pieceType.length];
	
	private Image pieceImg ;
    private int width, height;
	
    private ChessPiece(int colorIndex, int pieceIndex)
	{
		//Creates the filename for image file for whatever piece and color is indexed
		String imageName = pieceColor[colorIndex].toString() + pieceType[pieceIndex].toString() + ".gif";
		
		pieceImg = loadImage(imageName);
		width = pieceImg.getWidth(null);
		height = pieceImg.getHeight(null);
	}
	
	public static void readInImages()
	{
		for (int i = 0; i < pieceColor.length; i++)
			for (int j = 0; j < pieceType.length; j++)
				chessPieces[i][j] = new ChessPiece(i,j);
	}
	
	private Image loadImage(String fileName)
	{
		return new ImageIcon(fileName).getImage();
	}
	
	public void draw(Graphics g, int x, int y, int width, int height)
	{
		double widthScale = (double)width/this.width;
		double heightScale = (double)height/this.height;
		double scale = Math.min(widthScale, heightScale);
		
		int newHeight = (int)(this.height * scale);
		int newWidth = (int)(this.width * scale);
		
		x = x + width/2 - newWidth/2;
		y = y + height/2 - newHeight/2;
		g.drawImage(pieceImg, x, y, newWidth, newHeight, null);
	}

}
