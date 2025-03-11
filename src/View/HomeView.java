package View;

import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeView extends JPanel
{
    public JButton logoutButton;

    public HomeView()
    {
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
