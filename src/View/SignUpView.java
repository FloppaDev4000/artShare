package View;

import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.ControlManager;

public class SignUpView extends View
{
    public JTextField usernameField;
    public JPasswordField passwordField;
    public JPasswordField confirmField;

    public JButton signUpButton;
    public JButton backButton;

    public SignUpView(ControlManager m)
    {
        super(m);
        JLabel title = new JLabel("Sign Up Screen", SwingConstants.CENTER);

        JLabel usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        usernameField.setColumns(12);

        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        passwordField.setColumns(12);

        JLabel confirmLabel = new JLabel("Confirm password");
        confirmField = new JPasswordField();
        confirmField.setColumns(12);

        signUpButton = new JButton("Submit");
        backButton = new JButton("Back");

        add(title);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(confirmLabel);
        add(confirmField);

        add(signUpButton);
        add(backButton);
    }

    public void addSignUpListener(ActionListener l){signUpButton.addActionListener(l);}
    public void addBackListener(ActionListener l){backButton.addActionListener(l);}
}
