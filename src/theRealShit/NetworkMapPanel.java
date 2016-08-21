/*
 <The Visual Aegean demonstrates trading patterns in the Late Bronze Age Aegean. All data obtained from 
 Cline, Eric H. Sailing the Wine-dark Sea: International Trade and the Late Bronze Age Aegean. Tempvs Reparatvm Archaeological and Historical Associates, 1994. Print.>
    Copyright (C) <2014>  <Zachary Feldcamp>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. 
 */
package theRealShit;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class NetworkMapPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6871997625645224506L;
	//private HashMap<String, ArrayList<Site>> siteLists;
	private BufferedImage mapImage; 
	private CurrentMap currentMap;
	private CurrentPeriod currentPeriod;
	private FromSomewhere fromAnatolia;
	private FromSomewhere fromCyprus;
	private FromSomewhere fromEgypt;
	private FromSomewhere fromItaly;
	private FromSomewhere fromMesopotamia;
	private FromSomewhere fromTheLevant;
	private FromSomewhere fromTotal;
	
	private RegionSelectionPanel regionSelectionPanel;
	private TimePeriodSelectionPanel timePeriodSelectionPanel;
	private ConnectionClicker networkChecker;

	public static enum CurrentMap{
		FROM_ANATOLIA, FROM_CYPRUS, FROM_EGYPT, FROM_ITALY, FROM_MESOPOTAMIA, FROM_THE_LEVANT, FROM_TOTAL
	}
	public static enum CurrentPeriod{
		LBI_II, LBIII_A1, LBIII_A2, LBIII_B1, LBIII_B2, LBIII_C, TOTAL
	}
	
	public class ConnectionClicker extends JCheckBox implements ItemListener{
		private NetworkMapPanel nmp;
		
		public ConnectionClicker(String title, boolean checked, NetworkMapPanel nmp){
			super(title, checked);
			this.nmp = nmp;
			addItemListener(this);
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub
			if (isSelected()){
				nmp.updateConnections(true);
				return;
			}
			nmp.updateConnections(false);
			
		}
		
	}
	
	public NetworkMapPanel(HashMap<String, ArrayList<Site>> siteLists, BufferedImage map){
		super();
	//	this.siteLists = siteLists;
		this.mapImage = map;
        fromAnatolia = new FromSomewhere(siteLists.get(SiteParser.ANATOLIA_FILE_NAME_AND_KEY));
        fromCyprus = new FromSomewhere(siteLists.get(SiteParser.CYPRUS_FILE_NAME_AND_KEY));
        fromEgypt = new FromSomewhere(siteLists.get(SiteParser.EGYPT_FILE_NAME_AND_KEY));
        fromItaly = new FromSomewhere(siteLists.get(SiteParser.ITALY_FILE_NAME_AND_KEY));
        fromMesopotamia = new FromSomewhere(siteLists.get(SiteParser.MESOPOTAMIA_FILE_NAME_AND_KEY));
        fromTheLevant = new FromSomewhere(siteLists.get(SiteParser.THE_LEVANT_FILE_NAME_AND_KEY));
        fromTotal = new FromSomewhere(siteLists.get(SiteParser.TOTAL_FILE_NAME_AND_KEY));
        
        currentMap = CurrentMap.FROM_TOTAL;
        currentPeriod = CurrentPeriod.TOTAL;
        
        regionSelectionPanel = new RegionSelectionPanel(this);
        add(regionSelectionPanel);
        
        timePeriodSelectionPanel = new TimePeriodSelectionPanel(this);
        add(timePeriodSelectionPanel);
        
        networkChecker = new ConnectionClicker("Show potential connections", false, this);
        networkChecker.setOpaque(false);
        add(networkChecker);
        
	}

    public BufferedImage getMapImage(){
    	return mapImage;
    }
    
    public void updateCurrentMap(CurrentMap currentMap){
    	this.currentMap = currentMap;
    	repaint();
    }
    
    public void updateCurrentPeriod(CurrentPeriod currentPeriod){
    	this.currentPeriod = currentPeriod;
    	repaint();
    }
    
    public void updateConnections(boolean checked){
    	repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      g2d.setRenderingHint(
	    	        RenderingHints.KEY_TEXT_ANTIALIASING,
	    	        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	      boolean checked = networkChecker.isSelected();
	    switch(currentMap){
	    	case FROM_ANATOLIA:
	    		fromAnatolia.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_CYPRUS:
	    		fromCyprus.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_EGYPT:
	    		fromEgypt.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_ITALY:
	    		fromItaly.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_MESOPOTAMIA:
	    		fromMesopotamia.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_THE_LEVANT:
	    		fromTheLevant.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    	case FROM_TOTAL:
	    		fromTotal.draw(g, mapImage, currentPeriod, currentMap, this, checked);
	    		break;
	    }

    }
}
