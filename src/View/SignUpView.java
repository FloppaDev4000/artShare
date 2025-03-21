package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class SignUpView extends View
{
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JPasswordField confirmField;
    public JTextField emailField;

    public JButton signUpButton;
    public JButton backButton;

    public SignUpView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("Sign Up Screen", SwingConstants.CENTER);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(12);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(12);

        JLabel confirmLabel = new JLabel("Confirm password:");
        confirmField = new JPasswordField(12);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(12);

        signUpButton = new JButton("Submit");
        backButton = new JButton("Back");

        add(title);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmLabel);
        add(confirmField);
        add(emailLabel);
        add(emailField);

        add(signUpButton);
        add(backButton);
    }

    public void addSignUpListener(ActionListener l){signUpButton.addActionListener(l);}
    public void addBackListener(ActionListener l){backButton.addActionListener(l);}
}
