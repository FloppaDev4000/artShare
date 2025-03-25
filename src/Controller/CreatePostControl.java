package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.FileSaver;
import Model.PostOption;
import View.*;

public class CreatePostControl extends Control
{
    CreatePostView view;

    File selectedFile;

    public CreatePostControl(ControlManager m)
    {
        super(m);

        view = new CreatePostView(m);

        view.addExitListener(e -> exit());
        view.addSubmitListener(e -> submit());
        view.addFileListener(e -> filePopup());

        view.setUpView();
    }

    public void exit()
    {
        manager.mainHome.makeActiveArrayPost(-1);
    }

    public void submit()
    {
        // get values from fields, then validate, then submit to model function

        // GET VALUES
        String newTitle = view.getTitleField().getText();
        String newDesc = view.getDescField().getText();

        // VALIDATE

        if(newTitle == "" || newDesc == "")
        {
            System.out.println("Fields cannot be empty!");
            return;
        }

        // SUBMIT
        //save file
        String path = FileSaver.userFilePath + "\\" + selectedFile.getName();
        FileSaver.saveImgToDir(selectedFile);
        PostOption.create(newTitle, newDesc, manager.getCurrentUserId(), path);
        System.out.println("Post Created!");
    }

    public void filePopup()
    {
        JFileChooser fileChoose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images (PNG, JPG, JPEG, BMP, TIFF, WEBP, GIF)", "png", "jpg", "jpeg", "bmp", "tiff", "webp", "gif");
        fileChoose.setFileFilter(filter);
        fileChoose.setAcceptAllFileFilterUsed(false);

        int returnVal = fileChoose.showOpenDialog(manager.getFrame());

        if(returnVal == fileChoose.APPROVE_OPTION)
        {
            selectedFile = fileChoose.getSelectedFile();
            view.getFileLabel().setText("Selected: " + selectedFile.getName());
        }
    }

    public void writeFile(File f, String dirName)
    {
        try
        {
            Writer output = null;
            output = new BufferedWriter(new FileWriter(f));

            File dir = new File(dirName);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // SETGETS, ETC
    public CreatePostView getView(){return view;}
}
