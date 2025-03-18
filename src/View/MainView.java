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
        subView = new View(getManager());
    }

    public void setContainer(View newView)
    {
        subView = newView;
        // set it up so it works
    }

    public void replaceContainer(View newContainer)
    {
        removeAll();
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

    public View getContainer() {
        return this.container;
    }


    public View getSubView() {
        return this.subView;
    }

    public void setSubView(View subView) {
        this.subView = subView;
    }
    
}
