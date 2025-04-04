package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.ControlManager;

public class HomeView extends View
{
    private JButton logoutButton;
    private JButton createButton;
    private JButton myProfileButton;
    public JButton arrayPostButton;

    private View container;

    private GridBagConstraints gbc;

    public HomeView(ControlManager m)
    {
        super(m);

        logoutButton = new JButton("LogOut");

        createButton = new JButton("Create"); 
        myProfileButton = new JButton("My Profile");      
        arrayPostButton = new JButton("Home");

        View buttons = new View(m);
        buttons.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        b.fill = GridBagConstraints.BOTH;
        buttons.add(arrayPostButton, b);
        b.gridy = 1;
        buttons.add(myProfileButton, b);
        b.gridy = 2;
        buttons.add(createButton, b);
        b.gridy = 3;
        buttons.add(logoutButton, b);
        buttons.setPreferredSize(new Dimension(400, 400));

        // layout stuff

        setLayout(new BorderLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(buttons, BorderLayout.LINE_START);

        // right panel
        View rightPanel = new View(m);
        rightPanel.setPreferredSize(new Dimension(250, 100));;
        add(rightPanel, BorderLayout.LINE_END);
    }

    public void replaceContainer(View newContainer)
    {
        remove(container);
        container = newContainer;

        // layout
        newContainer.setPreferredSize(new Dimension(400, 400));
        newContainer.setMaximumSize(new Dimension(600, 600));

        add(newContainer, BorderLayout.CENTER);
        
        setUpView();
    }
    
    public void addLogoutListener(ActionListener l)
    {
        logoutButton.addActionListener(l);
    }
    public void addCreateListener(ActionListener l)
    {
        createButton.addActionListener(l);
    }
    public void addMyProfileListener(ActionListener l)
    {
        myProfileButton.addActionListener(l);
    }
    public void addArrayPostListener(ActionListener l)
    {
        arrayPostButton.addActionListener(l);
    }

    // SETGET


    public JButton getLogoutButton() {
        return this.logoutButton;
    }
    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JButton getCreateButton() {
        return this.createButton;
    }
    public void setCreateButton(JButton createButton) {
        this.createButton = createButton;
    }

    public View getCont() {
        return this.container;
    }
    public void setContainer(View container) {
        this.container = container;
    }

    public JButton getMyProfileButton() {
        return this.myProfileButton;
    }
    public void setMyProfileButton(JButton myProfileButton) {
        this.myProfileButton = myProfileButton;
    }

}
