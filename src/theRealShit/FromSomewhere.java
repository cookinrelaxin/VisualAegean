/*
 <The Visual Aegean demonstrates trading patterns in the Late Bronze Age Aegean.
 All data obtained from 
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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



import theRealShit.NetworkMapPanel.CurrentMap;
import theRealShit.NetworkMapPanel.CurrentPeriod;

public class FromSomewhere {
	private ArrayList<Site> siteList;
	private final String DEFAULT_TYPE = Font.SANS_SERIF;
	private Font siteNameFont = new Font(DEFAULT_TYPE, Font.PLAIN, 10);
	private final int DISTANCE_MAXIMUM_FOR_CONNECTION = 200;
	private final int MINIMUM_FONT_SIZE = 15;
	
	public FromSomewhere(ArrayList<Site> siteList){
		this.siteList = siteList;
		
	}
	
	public void draw(Graphics g, BufferedImage map, CurrentPeriod currentPeriod, CurrentMap currentMap, NetworkMapPanel nmp, boolean generateConnections){
		String periodString = String.valueOf(currentPeriod);
    	//System.out.println("draw");
      Graphics2D g2d = (Graphics2D) g;
     // g2d.setColor(LINE_COLOR);

	  g2d.drawImage(map, 0, 0, null);

      for (Site site : siteList){
      	Point siteLocation = site.getLocation();
      	int artifactCount = site.getArtifactsPerPeriod().get(periodString);
      	if(artifactCount != 0){
      		if(generateConnections){
      			generateConnections(g2d, site);
      		}
      		
	      	siteNameFont = new Font(DEFAULT_TYPE, Font.PLAIN, calculateFontSize(artifactCount));
	  		g2d.setFont(siteNameFont); 
	  		FontMetrics fm = g2d.getFontMetrics(siteNameFont);
	  		int fontHeight = fm.getHeight();
	  		int fontWidth = fm.stringWidth(site.getName());
	      	
	      	site.setLabelRect(new Rectangle(site.getLocation().x, site.getLocation().y, fontWidth, fontHeight));
	      	calculateLabelRect(site);
	      	Dimension ovalSize = new Dimension(artifactCount, artifactCount);
	      	
  	      	g2d.setStroke(new BasicStroke(calculateLineThickness(artifactCount)));

	      	g2d.drawOval(siteLocation.x - ovalSize.width / 2, siteLocation.y - ovalSize.height / 2, ovalSize.width, ovalSize.height);
	      	
      		g2d.drawString(site.getName(), site.getLabelRect().x, site.getLabelRect().y);
	      	
            Stroke dashed = new BasicStroke(calculateLineThickness(artifactCount), BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
            g2d.setStroke(dashed);
            
  	      	g2d.drawLine(siteLocation.x, siteLocation.y, site.getLabelRect().x + (site.getLabelRect().width / 2), site.getLabelRect().y);
  	      	g2d.setStroke(new BasicStroke(1, 1, 1));
      	}
      	

      }
	}
	
	private Rectangle calculateLabelRect(Site site){
		for(Site siteAgain : siteList){
      		if (siteAgain.getLabelRect() == null){
      			continue;
      		}
      		if (siteAgain == site){
      			continue;
      		}
      		if (site.getLabelRect().intersects(siteAgain.getLabelRect())){
      			Rectangle minRect = calculateMinimumRect(siteAgain.getLabelRect(), site.getLabelRect());
      			site.setLabelRect(new Rectangle(minRect.x + minRect.width, minRect.y - minRect.height, minRect.width, minRect.height));
      			calculateLabelRect(site);	
      		}
      	}
      return site.getLabelRect();
	}
	
	private void generateConnections(Graphics2D g2d, Site site){
		for (Site secondSite : siteList){
			double distance = calculateDistance(site, secondSite);
			if(distance < DISTANCE_MAXIMUM_FOR_CONNECTION){
				g2d.setColor(Color.BLACK);
	  	      	g2d.setStroke(new BasicStroke(.1f, 1, 1));
				g2d.drawLine(site.getLocation().x, site.getLocation().y, secondSite.getLocation().x, secondSite.getLocation().y);
				g2d.setColor(Color.BLACK);

			}
		}
	}
	
	private double calculateDistance(Site s1, Site s2){
		Point s1Point = s1.getLocation();
		Point s2Point = s2.getLocation();
		
		return Math.sqrt((s1Point.x - s2Point.x) * (s1Point.x - s2Point.x) + (s1Point.y - s2Point.y) * (s1Point.y - s2Point.y));

	}
	
	private Rectangle calculateMinimumRect(Rectangle r1, Rectangle r2){
		return (r1.width < r2.width) ? r1 : r2;
	}
	
	private int calculateFontSize(int artifactCount){
		//artifactCount /= 2;
		if (artifactCount < MINIMUM_FONT_SIZE){
			return MINIMUM_FONT_SIZE;
		}
		return artifactCount;
	}
	
	private int calculateLineThickness(int artifactCount){
		if (artifactCount < 10){
			return 1;
		}
		if (artifactCount < 20){
			return 2;
		}
		if (artifactCount < 30){
			return 3;
		}
		if (artifactCount < 40){
			return 4;
		}
		return 5;
//		if (artifactCount < 50){
//			return 5;
//		}
//		if (artifactCount < 60){
//			return 6;
//		}
//		if (artifactCount < 70){
//			return 7;
//		}
//		return 8;
		
	}
	

}
