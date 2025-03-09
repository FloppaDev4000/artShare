package Controller;

import javax.swing.*;
import java.awt.*;

import View.MainPanel;

public class MainFrame extends JFrame
{
    private MainPanel mainPanel;

    private Session s;

    public MainFrame()
    {
        setTitle("ArtShare");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // set up panels
        mainPanel = new MainPanel();

        add(mainPanel);
    }

    public void switchView(JPanel newView, String name)
    {
        mainPanel.removeAll();
        mainPanel.add(newView);
        System.out.println("Switching view to " + name + "!");
        mainPanel.repaint();
    }
}
