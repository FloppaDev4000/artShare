package Controller;

import javax.swing.*;
import java.awt.*;

import View.MainView;

public class MainFrame extends JFrame
{
    private MainView mainPanel;

    public MainFrame()
    {
        setTitle("ArtShare");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // set up panels
        mainPanel = new MainView();

        add(mainPanel);
    }

    public void switchView(JPanel newView, String name)
    {
        mainPanel.removeAll();
        mainPanel.add(newView);
        System.out.println("Switching view to " + newView + "!");
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void setupHomeView()
    {
        
    }
}
