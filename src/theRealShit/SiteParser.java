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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SiteParser {

	public HashMap<String, ArrayList<Site>> siteLists;
	private Document dom;
	public static final String ANATOLIA_FILE_NAME_AND_KEY = "stuff/artifacts per site from anatolia.xml";
	public static final String CYPRUS_FILE_NAME_AND_KEY = "stuff/artifacts per site from cyprus.xml";
	public static final String EGYPT_FILE_NAME_AND_KEY = "stuff/artifacts per site from Egypt.xml";
	public static final String ITALY_FILE_NAME_AND_KEY = "stuff/artifacts per site from italy.xml";
	public static final String MESOPOTAMIA_FILE_NAME_AND_KEY = "stuff/artifacts per site from mesopotamia.xml";
	public static final String THE_LEVANT_FILE_NAME_AND_KEY = "stuff/artifacts per site from the levant.xml";
	public static final String TOTAL_FILE_NAME_AND_KEY = "stuff/artifacts per site total.xml";

	public SiteParser(){
		//create a list to hold the employee objects
		siteLists = new HashMap<String, ArrayList<Site>>();
	}
	
	public void parse(String XMLFileToParse){
		parseXmlFile(XMLFileToParse);
		parseDocument(XMLFileToParse);
	}
	private void parseXmlFile(String XMLFileToParse){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			//parse using builder to get DOM representation of the XML file
			dom = db.parse(XMLFileToParse);
			

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	private void parseDocument(String siteListName){
		ArrayList<Site> newSiteList = new ArrayList<Site>();
		//get the root elememt
		Element docEle = dom.getDocumentElement();
		
		//get a nodelist of <site> elements
		NodeList nl = docEle.getElementsByTagName("site");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {
				
				Element el = (Element)nl.item(i);
				
				Site e = getSite(el);
				
				//add it to list
				newSiteList.add(e);
			}
		}
		siteLists.put(siteListName, newSiteList);
	}


	/**
	 * I take an employee element and read the values in, create
	 * an Employee object and return it
	 * @param empEl
	 * @return
	 */
	private Site getSite(Element siteEl) {
		
		String name = getTextValue(siteEl,"name");
		int xLocation = getIntValue(siteEl,"xlocation");
		int yLocation = getIntValue(siteEl,"ylocation");
		
		Point sitePoint = new Point(xLocation, yLocation);
		Site e = new Site(name,sitePoint);
		
		Element artifactsPerPeriod = (Element)siteEl.getElementsByTagName("artifactsPerPeriod").item(0);

		HashMap<String, Integer> artifactsPerPeriodHashMap = e.getArtifactsPerPeriod();
		artifactsPerPeriodHashMap.put(Site.LBI_II_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBI-II"));
		artifactsPerPeriodHashMap.put(Site.LBIII_A1_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBIIIA1"));
		artifactsPerPeriodHashMap.put(Site.LBIII_A2_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBIIIA2"));
		artifactsPerPeriodHashMap.put(Site.LBIII_B1_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBIIIB1"));
		artifactsPerPeriodHashMap.put(Site.LBIII_B2_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBIIIB2"));
		artifactsPerPeriodHashMap.put(Site.LBIII_C_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "LBIIIC"));
		artifactsPerPeriodHashMap.put(Site.TOTAL_ARTIFACT_COUNT_KEY, getIntValue(artifactsPerPeriod, "total"));
		
		return e;
	}

	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}

	
	/**
	 * Calls getTextValue and returns a int value
	 * @param ele
	 * @param tagName
	 * @return
	 */
	private int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	/**
	 * Iterate through the list and print the 
	 * content to console
	 */

}
