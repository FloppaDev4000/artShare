package View;

import javax.swing.*;
import java.awt.*;

import Controller.*;

public class MainView extends View
{
    private JButton logoutButton;

    public View container;
    
    public View subView;

    public MainView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("ArtShare", SwingConstants.CENTER);
        subView = new View(manager);
    }

    public void setContainer(View newView)
    {
        subView = newView;
        // set it up so it works
    }

    public void switchContainer(View view)
    {

    }
}
