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

import controller.*;
import tools.UiTools;

public class MainView extends View
{
    private JButton logoutButton;
    private View container;
    private View subView;

    public MainView(ControlManager m)
    {
        super(m);
        setLayout(new BorderLayout());

        // title
        JLabel title = new JLabel("ArtShare");
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
