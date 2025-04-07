package controller;

import javax.swing.JFrame;

public class MainFrame extends JFrame
{
    private LoginControl loginControl;
    private HomeControl homeControl;
    private PostControl postControl;

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

    // SETGET


    public LoginControl getLoginControl() {
        return this.loginControl;
    }

    public void setLoginControl(LoginControl loginControl) {
        this.loginControl = loginControl;
    }

    public HomeControl getHomeControl() {
        return this.homeControl;
    }

    public void setHomeControl(HomeControl homeControl) {
        this.homeControl = homeControl;
    }

    public PostControl getPostControl() {
        return this.postControl;
    }

    public void setPostControl(PostControl postControl) {
        this.postControl = postControl;
    }

}
