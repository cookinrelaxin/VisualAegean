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

public class TimePeriodSelectionPanel extends JPanel implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 3067928632249868090L;
private NetworkMapPanel nmp;
	
	public TimePeriodSelectionPanel(NetworkMapPanel nmp){
		this.nmp = nmp;
		String[] periodStrings = { "LBI-II", "LBIII-A1", "LBIII-A2", "LBIII-B1", "LBIII-B2", "LBIII-C", "Total"};

		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		JComboBox<String> periodList = new JComboBox<String>(periodStrings);
		periodList.setSelectedIndex(6);
		periodList.addActionListener(this);
		add(periodList);
		JLabel label = new JLabel("Time Period");
		add(label);
		setBackground(new Color(0,0,0,1));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>)e.getSource();
        String periodName = (String)cb.getSelectedItem();
        if(periodName.equals("LBI-II")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBI_II);
        }
        else if(periodName.equals("LBIII-A1")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBIII_A1);
        }
        else if(periodName.equals("LBIII-A2")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBIII_A2);
        }
        else if(periodName.equals("LBIII-B1")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBIII_B1);
        }
        else if(periodName.equals("LBIII-B2")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBIII_B2);
        }
        else if(periodName.equals("LBIII-C")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.LBIII_C);
        }
        else if(periodName.equals("Total")){
        	nmp.updateCurrentPeriod(NetworkMapPanel.CurrentPeriod.TOTAL);
        }
		
	}
}
