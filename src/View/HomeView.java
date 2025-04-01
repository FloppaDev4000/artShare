package View;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controller.*;

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

        logoutButton = new JButton("LogOut");

        createButton = new JButton("Create"); 
        myProfileButton = new JButton("My Profile");      
        arrayPostButton = new JButton("Home");

        // layout stuff

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        buttons.add(logoutButton);
        buttons.add(createButton);
        buttons.add(myProfileButton);
        buttons.add(arrayPostButton);
        add(buttons);
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
