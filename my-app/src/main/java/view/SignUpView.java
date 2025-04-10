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
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmField;
    private JTextField emailField;

    private JButton signUpButton;
    private JButton backButton;

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

    // SETGET

    public JTextField getUsernameField() {
        return this.usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return this.passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getConfirmField() {
        return this.confirmField;
    }

    public void setConfirmField(JPasswordField confirmField) {
        this.confirmField = confirmField;
    }

    public JTextField getEmailField() {
        return this.emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JButton getSignUpButton() {
        return this.signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public JButton getBackButton() {
        return this.backButton;
    }

    public void setBackButton(JButton backButton) {
        this.backButton = backButton;
    }

}
