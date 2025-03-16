package View;

import java.awt.event.ActionListener;

import javax.swing.*;
import Controller.*;

public class HomeView extends View
{
    public JButton logoutButton;

    public HomeView(ControlManager m)
    {
        super(m);
        System.out.println("WEE");

        JLabel title = new JLabel("Home Screen", SwingConstants.CENTER);
        logoutButton = new JButton("LogOut");

        add(title);
        add(logoutButton);
    }

    
    public void addLogoutListener(ActionListener l)
    {
        logoutButton.addActionListener(l);
    }
}
