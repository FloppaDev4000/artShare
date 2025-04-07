package controller;

import javax.swing.JOptionPane;

import objects.User;
import view.EditProfileView;
import model.UserOption;

public class EditProfileControl extends Control
{
    private EditProfileView view;

    private int userId;

    // edit constructor
    public EditProfileControl(ControlManager m, User u)
    {
        super(m);

        view = new EditProfileView(m);

        // add listeners
        view.addExitListener(e -> exit());
        view.addSubmitListener(e -> submit());
        view.setUpView();

        userId = u.getUserId();

        view.getTitleMsg().setText("Edit Profile");

        view.getNameField().setText(u.getUsername());
        view.getBioField().setText(u.getBio());
    }

    // exit button pressed
    public void exit()
    {
        getManager().getMainHome().makeActiveArrayPost(-1);
    }

    // submit button pressed
    public void submit()
    {
        // get values from fields, then validate, then submit to model function

        // GET VALUES
        String newName = view.getNameField().getText();
        String newBio = view.getBioField().getText();

        // VALIDATE

        if(newName == "" || newBio == "")
        {
            view.message.setText("Fields cannot be empty!");
            return;
        }

        // SUBMIT
        
        if(UserOption.editUser(userId, newName, newBio) == 0)
        {
            JOptionPane.showMessageDialog(null, "Profile updated successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Oh no! A problem occurred! D:");
        }
        
        getManager().getMainHome().makeActiveArrayPost(-1);
    }

    // SETGETS, ETC

    public EditProfileView getView() {
        return this.view;
    }

    public void setView(EditProfileView view) {
        this.view = view;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
