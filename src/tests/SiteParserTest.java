/*
 <Sailing on the Wine Dark Sea visually demonstrates trading patterns in the Late Bronze Age Aegean.
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
package tests;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import theRealShit.SiteParser;
import theRealShit.ViewController;

public class SiteParserTest {
	//private SiteParser sp;
	//@Test
	//public void test() {
	//	sp = new SiteParser();
	//}
	
	@Test
	public void makeMapFile() throws IOException{
		File f = new File(ViewController.aegeanMapURL);
		BufferedImage map = ImageIO.read(f);
		assertNotNull(map);

	}
	
	
	@Test
	public void testParseAnatoliaFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.ANATOLIA_FILE_NAME_AND_KEY);
		
//		ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from anatolia.xml");
//		for(Site s : siteList){
//			System.out.println(s);
//		}
		
	}
	
	
	@Test
	public void testParseCyprusFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.CYPRUS_FILE_NAME_AND_KEY);
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from cyprus.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
		//}
	}
	
	@Test
	public void testParseEgyptFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.EGYPT_FILE_NAME_AND_KEY);
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from Egypt.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
		//}
	}
	
	@Test
	public void testParseItalyFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.ITALY_FILE_NAME_AND_KEY);
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from italy.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
	//	}
		
	}
	
	@Test
	public void testParseMesopotamiaFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.MESOPOTAMIA_FILE_NAME_AND_KEY);
		
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from mesopotamia.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
	//	}
		
	}
	
	@Test
	public void testParseTheLevantFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.THE_LEVANT_FILE_NAME_AND_KEY);
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site from the levant.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
		//}
		
	}
	
	@Test
	public void testParseTotalFile(){
		SiteParser sp = new SiteParser();
		//File f = new File("stuff/artifacts per site from anatolia.xml");
		sp.parse(SiteParser.TOTAL_FILE_NAME_AND_KEY);
		
		//ArrayList<Site> siteList = sp.siteLists.get("stuff/artifacts per site total.xml");
		//for(Site s : siteList){
		//	System.out.println(s);
		//}
		
	}
	
	
	

}
