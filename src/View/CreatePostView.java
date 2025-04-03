package View;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.*;

public class CreatePostView extends View
{
    JLabel titleMsg;

    JTextField titleField;
    JTextArea descField;
    JButton fileButton;
    JLabel fileLabel;

    JFileChooser fileChoose;

    JButton submitButton;
    JButton exitButton;

    public JLabel message;

    public CreatePostView(ControlManager m)
    {
        super(m);

        titleMsg = new JLabel("Create a New Post");

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(12);

        JLabel descLabel = new JLabel("Description:");
        descField = new JTextArea(5, 12);

        fileButton = new JButton("Select File");
        fileLabel = new JLabel("");

        fileChoose = new JFileChooser();

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

        add(titleLabel, gbc);
        gbc.gridx = 1;
        add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(descLabel, gbc);
        gbc.gridx = 1;
        add(descField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(fileButton, gbc);

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

    public void addFileListener(ActionListener l)
    {
        fileButton.addActionListener(l);
    }

    // SETGET

    public JTextField getTitleField() {
        return this.titleField;
    }

    public void setTitleField(JTextField titleField) {
        this.titleField = titleField;
    }

    public JTextArea getDescField() {
        return this.descField;
    }

    public void setDescField(JTextArea descField) {
        this.descField = descField;
    }

    public JButton getFileButton() {
        return this.fileButton;
    }

    public void setFileButton(JButton fileButton) {
        this.fileButton = fileButton;
    }

    public JFileChooser getFileChoose() {
        return this.fileChoose;
    }

    public void setFileChoose(JFileChooser fileChoose) {
        this.fileChoose = fileChoose;
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

    public JLabel getFileLabel() {
        return this.fileLabel;
    }

    public void setFileLabel(JLabel fileLabel) {
        this.fileLabel = fileLabel;
    }

    public JLabel getMessage() {
        return this.message;
    }

    public void setMessage(JLabel message) {
        this.message = message;
    }
    
}
