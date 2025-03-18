package View;

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
        titleField = new JTextField();
        JLabel descLabel = new JLabel("Description:");
        descField = new JTextArea();

        fileButton = new JButton("Select File");
        fileLabel = new JLabel("");

        fileChoose = new JFileChooser();

        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");

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
    public JLabel getFileLabel(){return fileLabel;}
}
