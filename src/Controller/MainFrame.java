package controller;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
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
