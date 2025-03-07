package View;

import java.awt.BorderLayout;

import javax.swing.*;

import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;

public class UiTest
{
    public static void main(String[] args) {
    	
    	MigLayout layout = new MigLayout("debug, fillx", "[grow][grow][grow]", "[][grow]");
    	JPanel content = new JPanel(layout);
    	
    	CC textCC = new CC();
    	textCC.alignX("center").spanX();
    	
    	CC vpCC = new CC(); // verticalPanelCC
    	vpCC.alignY("center").spanY();
    	
    	// panels
    	JPanel westPanel = new JPanel(new MigLayout("debug, insets 0", "", "push[]")); 
    	JPanel centerPanel = new JPanel(new MigLayout("debug, insets 0", "", "push[]")); 
    	JPanel eastPanel = new JPanel(new MigLayout("debug, insets 0", "", "push[]")); 
    	
    	JPanel[] panels = {westPanel, centerPanel, eastPanel};
    	
    	for(int i = 0; i < panels.length; i++)
    	{
    		panels[i].add(new JButton());
    	}
    	
    	
    	
    	// First row        
    	content.add(new JLabel("ArtShare"), textCC);
    	
    	// Second row
    	content.add(westPanel);
    	content.add(centerPanel);
    	content.add(eastPanel);
    	
    	JFrame frame = new JFrame();
    	frame.setSize(800, 500);
    	frame.add(content, BorderLayout.CENTER);
    	
    	frame.pack();
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    }
}
