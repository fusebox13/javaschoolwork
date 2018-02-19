package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.JMapViewerTree;
import org.openstreetmap.gui.jmapviewer.tilesources.BingAerialTileSource;

public class TrackerGUI extends JFrame {
	
	
	JMapViewerTree JMap = null;
	
	TrackerGUI()
	{
		super("Deer Tracker");
		
		Dimension d = new Dimension(800, 600);
		
		this.setSize(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMap = new JMapViewerTree("Test");
		//map().setTileSource(new BingAerialTileSource());
		map().setDisplayPositionByLatLon(38.898748, -77.037684, 14);
		add(JMap);
		
		
		
	}
	
	private JMapViewer map(){
        return JMap.getViewer();
    }
	
	public static void main(String[] args) {
		
		new TrackerGUI().setVisible(true);

	}

}
