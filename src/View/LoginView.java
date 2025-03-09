package View;

import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView extends JPanel
{
    public JButton loginButton;

    public LoginView()
    {
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
