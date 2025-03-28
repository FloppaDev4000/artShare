package Controller;

import javax.swing.*;
import java.awt.*;

import View.MainView;

public class MainFrame extends JFrame
{
    private MainView mainPanel;

    public LoginControl loginControl;
    public HomeControl homeControl;
    public PostControl postControl;

    // constructor
    public MainFrame()
    {
        setTitle("ArtShare");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pack();

        setVisible(true);
    }

    public void frameReset()
    {
        repaint();
        revalidate();
        pack();
    }
}
