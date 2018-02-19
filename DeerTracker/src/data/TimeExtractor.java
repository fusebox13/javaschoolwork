package data;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.*;
import com.drew.metadata.exif.ExifSubIFDDirectory;

public class TimeExtractor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		File f = new File("deer.jpg");
		try {
			Metadata m = ImageMetadataReader.readMetadata(f);
			
			for (Directory directory : m.getDirectories()) {
			    for (Tag tag : directory.getTags()) {
			        System.out.println(tag);
			    }
			}
			
			ExifSubIFDDirectory directory = m.getDirectory(ExifSubIFDDirectory.class);

			// query the tag's value
			Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
			
			System.out.println("DATE: " + date);
			
		} catch (ImageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub

	}

}
