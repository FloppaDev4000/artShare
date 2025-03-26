package View;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.*;

public class CreatePostView extends View
{
    JTextField titleField;
    JTextArea descField;
    JButton fileButton;
    JLabel fileLabel;

    JFileChooser fileChoose;

    JButton submitButton;
    JButton exitButton;

    public CreatePostView(ControlManager m)
    {
        super(m);

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(12);
        JLabel descLabel = new JLabel("Description:");
        descField = new JTextArea(5, 12);

        fileButton = new JButton("Select File");
        fileLabel = new JLabel("");

        fileChoose = new JFileChooser();

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));


        add(titleLabel);
        add(titleField);
        add(descLabel);
        add(descField);

        add(fileButton);
        add(fileLabel);

        add(submitButton);
        add(exitButton);
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

    public JLabel getFileLabel() {
        return this.fileLabel;
    }

    public void setFileLabel(JLabel fileLabel) {
        this.fileLabel = fileLabel;
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
    
}
