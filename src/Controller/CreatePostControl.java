package controller;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.CreatePostView;
import model.FileOption;
import model.FileSaver;
import model.PostOption;
import objects.Post;

public class CreatePostControl extends Control
{
    CreatePostView view;

    File selectedFile;

    boolean isEdit;
    int postId;

    // constructor
    public CreatePostControl(ControlManager m)
    {
        super(m);

        isEdit = false;

        view = new CreatePostView(m);

        // add listeners
        view.addExitListener(e -> exit());
        view.addSubmitListener(e -> submit());
        view.addFileListener(e -> filePopup());

        view.setUpView();
    }

    // edit constructor
    public CreatePostControl(ControlManager m, Post p)
    {
        this(m);

        isEdit = true;
        postId = p.getPostId();

        this.view.getTitleMsg().setText("Edit Post");

        this.view.getTitleField().setText(p.getTitle());
        this.view.getDescField().setText(p.getDescription());

        String path = FileOption.getFilePath(postId);

        if(path != null)
        {
            selectFile(new File(FileOption.getFilePath(postId)));
        }

    }

    // exit button pressed
    public void exit()
    {
        manager.mainHome.makeActiveArrayPost(-1);
    }

    // submit button pressed
    public void submit()
    {
        // get values from fields, then validate, then submit to model function

        // GET VALUES
        String newTitle = view.getTitleField().getText();
        String newDesc = view.getDescField().getText();

        // VALIDATE

        if(newTitle == "" || newDesc == "")
        {
            view.message.setText("Fields cannot be empty!");
            return;
        }

        // SUBMIT

        if(isEdit)
        {
            //save file
            String path = FileSaver.userFilePath + "\\" + selectedFile.getName();
            FileSaver.saveImgToDir(selectedFile);
            
            if(PostOption.edit(newTitle, newDesc, postId, path) == 0)
            {
                JOptionPane.showMessageDialog(null, "Post updated successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Oh no! A problem occurred! D:");
            }
        }
        else
        {
            //save file
            String path = FileSaver.userFilePath + "\\" + selectedFile.getName();
            FileSaver.saveImgToDir(selectedFile);
            
            if(PostOption.create(newTitle, newDesc, manager.getCurrentUserId(), path) == 0)
            {
                JOptionPane.showMessageDialog(null, "Post created successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Oh no! A problem occurred! D:");
            }
        }
        
        manager.getMainHome().makeActiveArrayPost(-1);
    }

    // file popup dialogue
    public void filePopup()
    {

        // init file chooser and filters
        JFileChooser fileChoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (PNG, JPG, JPEG, BMP, TIFF, GIF)", "png", "jpg", "jpeg", "bmp", "tiff", "gif");

        // apply filter
        fileChoose.setFileFilter(filter);
        fileChoose.setAcceptAllFileFilterUsed(false);

        // open dialog and get input
        int returnVal = fileChoose.showOpenDialog(manager.getFrame());
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            selectFile(fileChoose.getSelectedFile());
        }
    }

    public void selectFile(File newFile)
    {
        // set selected file
        selectedFile = newFile;
        view.getFileButton().setText("Selected: " + selectedFile.getName());
    }

    // SETGETS, ETC
    public CreatePostView getView(){return view;}
}
