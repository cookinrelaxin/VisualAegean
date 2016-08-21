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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegionSelectionPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6405526794861324740L;
	private NetworkMapPanel nmp;
	
	public RegionSelectionPanel(NetworkMapPanel nmp){
		this.nmp = nmp;
		String[] countryOfOriginStrings = { "Anatolia", "Cyprus", "Egypt", "Italy", "Mesopotamia", "The Levant", "Total"};

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox<String> countryList = new JComboBox<String>(countryOfOriginStrings);
		countryList.setSelectedIndex(6);
		countryList.addActionListener(this);
		add(countryList);
		JLabel label = new JLabel("Region of Origin");
		add(label);
		setBackground(new Color(0,0,0,1));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String countryName = (String)cb.getSelectedItem();
        if(countryName.equals("Anatolia")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_ANATOLIA);
        }
        else if(countryName.equals("Cyprus")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_CYPRUS);
        }
        else if(countryName.equals("Egypt")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_EGYPT);
        }
        else if(countryName.equals("Italy")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_ITALY);
        }
        else if(countryName.equals("Mesopotamia")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_MESOPOTAMIA);
        }
        else if(countryName.equals("The Levant")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_THE_LEVANT);
        }
        else if(countryName.equals("Total")){
        	nmp.updateCurrentMap(NetworkMapPanel.CurrentMap.FROM_TOTAL);
        }
		
	}
}
