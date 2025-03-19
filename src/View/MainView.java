package View;

import javax.swing.*;
import java.awt.*;

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
        add(title);
        container = new View(m);

    }

    public void setContainer(View newView)
    {
        container = newView;
        // set it up so it works
    }

    public void replaceContainer(View newContainer)
    {
        remove(container);
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
