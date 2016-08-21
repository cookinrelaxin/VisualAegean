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

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class ViewController extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 355370681356209746L;
	public HashMap<String, ArrayList<Site>> siteLists;
	private NetworkMapPanel sf;
	public static final String aegeanMapURL = "stuff/blankaegeanmap.png";
	
	public ViewController(HashMap<String, ArrayList<Site>> siteLists) {
		this.siteLists = siteLists;
    File file = new File(aegeanMapURL);
      try {
			BufferedImage map = ImageIO.read(file);
			sf = new NetworkMapPanel(siteLists, map);
			add(sf);
			setPreferredSize(new Dimension(map.getWidth(), map.getHeight()));
			//setBounds(0, 0, map.getWidth(), map.getHeight());
			//pack();
			//setSize(500,500);
		//	setLayout(null);
			setResizable(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
  	//setResizable(false);
	setTitle("Visual Aegean");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	SiteParser sp = new SiteParser();
        		sp.parse("stuff/artifacts per site from anatolia.xml");
        		sp.parse("stuff/artifacts per site from cyprus.xml");
        		sp.parse("stuff/artifacts per site from Egypt.xml");
        		sp.parse("stuff/artifacts per site from italy.xml");
        		sp.parse("stuff/artifacts per site from mesopotamia.xml");
        		sp.parse("stuff/artifacts per site from the levant.xml");
        		sp.parse("stuff/artifacts per site total.xml");
        		
        		ViewController vc = new ViewController(sp.siteLists);
        		vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		vc.pack();
        		vc.setVisible(true);
            }
        });

    }
    
}
