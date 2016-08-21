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
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Site {

	private String name;
	private List<Site> connections;
	private HashMap<String, Integer> artifactsPerPeriod;
	
	public static final String LBI_II_ARTIFACT_COUNT_KEY = "LBI_II";
	public static final String LBIII_A1_ARTIFACT_COUNT_KEY = "LBIII_A1";
	public static final String LBIII_A2_ARTIFACT_COUNT_KEY = "LBIII_A2";
	public static final String LBIII_B1_ARTIFACT_COUNT_KEY = "LBIII_B1";
	public static final String LBIII_B2_ARTIFACT_COUNT_KEY = "LBIII_B2";
	public static final String LBIII_C_ARTIFACT_COUNT_KEY = "LBIII_C";
	public static final String TOTAL_ARTIFACT_COUNT_KEY = "TOTAL";

	
	//calculated through a random walk
	private int primaryImportance;
	
	
	private Point location;
	private Rectangle labelRect;
	

	
	public Site(){
		
	}
	
	public HashMap<String, Integer> getArtifactsPerPeriod(){
		return artifactsPerPeriod;
	}
	
	public Site(String name, Point location) {
		this.name = name;
		this.location = location;
		this.connections = new ArrayList<Site>();
		this.artifactsPerPeriod = new HashMap <String, Integer>();
	}
	public int getPrimaryImportance(){
		return primaryImportance;
	}
	public void incrementPrimaryImportance(){
		primaryImportance ++;
	}
	public void addSiteConnection(Site friend){
		connections.add(friend);
	}
	public List<Site> getConnections(){
		return connections;
	}
//	public int getConnectionCount(){
//		return connections.size() / 2;
//	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getLocation() {
		return location;
	}
	
	public Rectangle getLabelRect(){
		return labelRect;
	}
	
	public void setLabelRect(Rectangle labelRect){
		this.labelRect = labelRect;
	}
	

	public void setType(Point location) {
		this.location = location;
	}	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Site Details - ");
		sb.append("Name:" + getName());
		sb.append(", ");
		sb.append("Location:" + getLocation());
		sb.append(", ");
		sb.append("LBI_II_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBI_II_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("LBIII_A1_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBIII_A1_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("LBIII_A2_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBIII_A2_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("LBIII_B1_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBIII_B1_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("LBIII_B2_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBIII_B2_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("LBIII_C_ARTIFACT_COUNT: " + artifactsPerPeriod.get(LBIII_C_ARTIFACT_COUNT_KEY));
		sb.append(", ");
		sb.append("TOTAL_ARTIFACT_COUNT: " + artifactsPerPeriod.get(TOTAL_ARTIFACT_COUNT_KEY));



		return sb.toString();
	}
}
