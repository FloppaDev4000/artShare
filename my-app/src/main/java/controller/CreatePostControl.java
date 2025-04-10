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
    private CreatePostView view;

    private File selectedFile;

    private boolean isEdit;
    private int postId;

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
        getManager().getMainHome().makeActiveArrayPost(-1);
    }

    // submit button pressed
    public int submit()
    {
        // get values from fields, then validate, then submit to model function

        // GET VALUES
        String newTitle = view.getTitleField().getText();
        String newDesc = view.getDescField().getText();

        // VALIDATE

        if(newTitle == "" || newDesc == "")
        {
            view.getMessage().setText("Fields cannot be empty!");
            return 1;
        }
        else if(!newTitle.matches(".*"))
        {
            view.getMessage().setText("Title is invalid!");
            return 1;
        }
        else if(!newDesc.matches(".*"))
        {
            view.getMessage().setText("Description is invalid!");
            return 1;
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
            
            if(PostOption.create(newTitle, newDesc, getManager().getCurrentUserId(), path) == 0)
            {
                JOptionPane.showMessageDialog(null, "Post created successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Oh no! A problem occurred! D:");
            }
        }
        
        getManager().getMainHome().makeActiveArrayPost(-1);
        return 0;
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
        int returnVal = fileChoose.showOpenDialog(getManager().getFrame());
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

    // SETGET

    public CreatePostView getView() {
        return this.view;
    }

    public void setView(CreatePostView view) {
        this.view = view;
    }

    public File getSelectedFile() {
        return this.selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }

    public boolean isIsEdit() {
        return this.isEdit;
    }

    public boolean getIsEdit() {
        return this.isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

}
