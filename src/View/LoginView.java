package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class LoginView extends View
{
    public JButton loginButton;

    public String username = "";
    public String password = "";

    public LoginView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("Login Screen", SwingConstants.CENTER);
        loginButton = new JButton("Login");

        add(title);
        add(loginButton);
    }

    public void addLoginListener(ActionListener l)
    {
        loginButton.addActionListener(l);
    }
}
