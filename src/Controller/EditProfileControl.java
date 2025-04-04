package Controller;

import javax.swing.JOptionPane;

import Model.UserOption;
import Objects.User;
import View.EditProfileView;

public class EditProfileControl extends Control
{
    EditProfileView view;

    int userId;

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
        manager.mainHome.makeActiveArrayPost(-1);
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
        
        manager.getMainHome().makeActiveArrayPost(-1);
    }

    // SETGETS, ETC
    public EditProfileView getView(){return view;}
}
