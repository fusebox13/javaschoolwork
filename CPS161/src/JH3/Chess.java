package JH3;

import imagelecture.ChessProgram;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;

public class Chess extends JFrame
{
	Image bufferedImage = null;
	Dimension screenDimension = null;
	
	Chess()
	{
		super("Chess Program");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ChessPiece.readInImages();
		setVisible(true);
	}
	
	public void paint(Graphics screen)
	{
		Dimension d = getSize();
		if(bufferedImage == null || !d.equals(screenDimension))
		{
			screenDimension = d;
			bufferedImage = createImage(d.width, d.height);
		}
		Graphics g = bufferedImage.getGraphics();
		
		super.paint(g);
		Insets insets = getInsets();
		int top = insets.top;
		int bottom = insets.bottom;
		int left = insets.left;
		int right = insets.right;
		
		int frameHeight = getHeight();
		int frameWidth = getWidth();
		
		int tileHeight = (frameHeight - top - bottom)/8;
		int tileWidth = (frameWidth - left - right)/8;
		
		TileDimensions tile = new TileDimensions(left, top, tileWidth, tileHeight);
		
		int x, y;
		
		for(int row = 0; row < 8; row++)
		{
			y = top + row * tileHeight;
			for (int col = 0; col < 8; col++)
			{
				x = left + col * tileWidth;
				boolean coloredTile = (row + col) % 2 == 1;
				
				if(coloredTile)
					g.setColor(Color.black);
				else
					g.setColor(Color.white);
				
				g.fillRect(x, y, tileWidth, tileHeight);
			}
		}
		
		//Create and draw the pawns
		for (int col = 0; col < 8; col++)
		{
			Piece pawns = new Piece(PieceType.Pawn, PieceColor.black, col, 1);
			pawns.drawInPosition(g, tile);
			
			pawns = new Piece(PieceType.Pawn, PieceColor.white, col, 6);
			pawns.drawInPosition(g, tile);
			
		}
		
		//Create and draw the rest of the pieces
		for (int col = 0; col < 8; col++)
		{
			Piece p = new Piece(getPieceType(col), PieceColor.black, col, 0);
			p.drawInPosition(g, tile);
			
			p = new Piece(getPieceType(col), PieceColor.white, col, 7);
			p.drawInPosition(g, tile);
		}
		
		screen.drawImage(bufferedImage,0,0,this);
		
	}
	
	public PieceType getPieceType(int col)
	{
		switch (col)
		{
		case 0: case 7:
			return PieceType.Rook;
		case 1: case 6:
			return PieceType.Knight;
		case 2: case 5:
			return PieceType.Bishop;
		case 3:
			return PieceType.Queen;
		case 4:
			return PieceType.King;
		default:
				return null;
		}
	}
	public static void main(String[] args) {
		Chess cp = new Chess();

	}

}
