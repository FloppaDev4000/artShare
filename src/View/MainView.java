package view;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import WindowBuilder.helper_classes.CustomFontLoader;
import controller.*;
import tools.UiTools;

public class MainView extends View
{
    private JButton logoutButton;

    public View container;
    
    public View subView;

    public MainView(ControlManager m)
    {
        super(m);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("ArtShare");
        title.setFont(CustomFontLoader.loadTitleFont(24.0f));
        title.setBorder(new EmptyBorder(10,10,10,10));
        JPanel titleP = new JPanel(new GridBagLayout());
        titleP.add(title, new GridBagConstraints());

        add(titleP, BorderLayout.PAGE_START);

        container = new View(m);
        add(container, BorderLayout.CENTER);

        // bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(640, 48));
        bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(UiTools.DEFAULT_GREY_DARK)));
        add(bottomPanel, BorderLayout.PAGE_END);

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
        add(container, BorderLayout.CENTER);
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
