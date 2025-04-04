package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import controller.ControlManager;

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
        JLabel title = new JLabel("Sign Up", SwingConstants.CENTER);

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

        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);

        // ADD ITEMS WITH LAYOUT CONSTRAINTS

        // title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        // label stuff
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = 1;

        gbc.gridy = 1;
        add(usernameLabel, gbc);
        gbc.gridy = 2;
        add(emailLabel, gbc);
        gbc.gridy = 3;
        add(passwordLabel, gbc);
        gbc.gridy = 4;
        add(confirmLabel, gbc);

        // field stuff
        gbc.gridx = 1;

        gbc.gridy = 1;
        add(usernameField, gbc);
        gbc.gridy = 2;
        add(emailField, gbc);
        gbc.gridy = 3;
        add(passwordField, gbc);
        gbc.gridy = 4;
        add(confirmField, gbc);
        
        // buttons
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(signUpButton, gbc);
        gbc.gridy = 6;
        add(backButton, gbc);
    }

    public void addSignUpListener(ActionListener l){signUpButton.addActionListener(l);}
    public void addBackListener(ActionListener l){backButton.addActionListener(l);}
}
