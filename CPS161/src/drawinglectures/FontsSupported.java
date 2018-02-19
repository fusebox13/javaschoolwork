package drawinglectures;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class FontsSupported {

    public static void main(String[] args) {
        Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();
        for ( int i = 0; i < fonts.length; ++i ) {
            System.out.print( fonts[i].getFontName() + " : " );
            System.out.print( fonts[i].getFamily() + " : " );
            System.out.println( fonts[i].getName() );
        }
        System.out.println( "\n\n\tAvailable Fonts:\n" );
        String[] names = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for ( int i = 0; i < names.length; ++i )
            System.out.println( names[i] );
    }

}