package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class LoginView extends View
{
    public JTextField usernameField;
    public JPasswordField passwordField;

    public JButton loginButton;
    public JButton backButton;

    public LoginView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("Login Screen", SwingConstants.CENTER);

        usernameField = new JTextField(12);
        passwordField = new JPasswordField(12);

        loginButton = new JButton("Submit");
        backButton = new JButton("Back");

        add(title);
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(backButton);
    }

    public void addLoginListener(ActionListener l){loginButton.addActionListener(l);}
    public void addBackListener(ActionListener l){backButton.addActionListener(l);}
}
