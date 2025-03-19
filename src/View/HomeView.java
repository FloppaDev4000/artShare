package View;

import java.awt.event.ActionListener;

import javax.swing.*;
import Controller.*;
import net.miginfocom.layout.AC;

public class HomeView extends View
{
    private JButton logoutButton;
    private JButton createButton;
    private JButton myProfileButton;
    public JButton arrayPostButton;

    private View container;

    public HomeView(ControlManager m)
    {
        super(m);

        JLabel homeScreen = new JLabel("Home Screen", SwingConstants.CENTER);
        logoutButton = new JButton("LogOut");

        createButton = new JButton("Create"); 
        myProfileButton = new JButton("My Profile");      
        arrayPostButton = new JButton("Home"); 

        add(homeScreen);
        add(logoutButton);
        add(createButton);
        add(myProfileButton);
        add(arrayPostButton);
    }

    public void replaceContainer(View newContainer)
    {
        remove(container);
        container = newContainer;
        add(newContainer);
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
