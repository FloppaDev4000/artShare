package View;

import javax.swing.*;

import java.awt.FlowLayout;

import Controller.*;
import WindowBuilder.helper_classes.CustomFontLoader;

public class MainView extends View
{
    private JButton logoutButton;

    public View container;
    
    public View subView;

    public MainView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("ArtShare");
        title.setFont(CustomFontLoader.loadTitleFont(20.0f));

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        add(title);
        container = new View(m);
        add(container);
        setUpView();

    }

    public void setContainer(View newView)
    {
        container = newView;
        // set it up so it works
    }

    public void replaceContainer(View newContainer)
    {
        if(isAncestorOf(container))
        {
            remove(container);
        }
        container = newContainer;
        add(container);
        setUpView();
    }

    public void switchContainer(View view)
    {

    }

    // SETGET

    public JButton getLogoutButton() {
        return this.logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    
}
