package view;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControlManager;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class EditProfileView extends View
{
    JLabel titleMsg;

    JTextField nameField;
    JTextArea bioField;

    JButton submitButton;
    JButton exitButton;

    public JLabel message;

    public EditProfileView(ControlManager m)
    {
        super(m);

        titleMsg = new JLabel("Edit Profile");

        JLabel nameLabel = new JLabel("Username:");
        nameField = new JTextField(12);

        JLabel bioLabel = new JLabel("Bio:");
        bioField = new JTextArea(5, 12);

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

        message = new JLabel("");

        // layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(titleMsg, gbc);
        gbc.gridy = 1;
        gbc.gridwidth = 1;

        add(nameLabel, gbc);
        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(bioLabel, gbc);
        gbc.gridx = 1;
        add(bioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(submitButton, gbc);
        gbc.gridx = 1;
        add(exitButton, gbc);

        gbc.gridy = 5;
        add(message, gbc);
    }

    public void addExitListener(ActionListener l)
    {
        exitButton.addActionListener(l);
    }

    public void addSubmitListener(ActionListener l)
    {
        submitButton.addActionListener(l);
    }

    // SETGET

    public JTextField getNameField() {
        return this.nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextArea getBioField() {
        return this.bioField;
    }

    public void setBioField(JTextArea bioField) {
        this.bioField = bioField;
    }

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JButton getExitButton() {
        return this.exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }



    public JLabel getTitleMsg() {
        return this.titleMsg;
    }

    public void setTitleMsg(JLabel titleMsg) {
        this.titleMsg = titleMsg;
    }

    public JLabel getMessage() {
        return this.message;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }
    
}
