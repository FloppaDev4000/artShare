package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class LoginView extends View
{
    public JTextField usernameField;
    public JPasswordField passwordField;

    public JButton loginButton;

    public LoginView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("Login Screen", SwingConstants.CENTER);

        usernameField = new JTextField();
        usernameField.setColumns(12);
        passwordField = new JPasswordField();
        passwordField.setColumns(12);

        loginButton = new JButton("Login");

        add(title);
        add(usernameField);
        add(passwordField);
        add(loginButton);
    }

    public void addLoginListener(ActionListener l)
    {
        loginButton.addActionListener(l);
    }
}
