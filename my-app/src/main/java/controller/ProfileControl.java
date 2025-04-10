package controller;

import javax.swing.JOptionPane;
import model.PostOption;
import model.UserOption;
import view.Popup;
import view.ProfileView;

import objects.User;

public class ProfileControl extends Control
{
    private ProfileView view;

    private User user;

    private ArrayPostControl postArray;

    public ProfileControl(ControlManager m, int userId)
    {
        super(m);

        System.out.println("USERID: " + userId);

        user = UserOption.readUser(userId);

        postArray = new ArrayPostControl(m, userId);

        view = new ProfileView(m, user);

        // setup popup menu
        String[] popupOptions;
        Popup popup;

        // add options popup stuff
        if(user.getUserId() == m.getCurrentUserId())
        {
            // only show delete if post belongs to you
            popupOptions = new String[]{"Report", "Edit", "Delete"};
            popup = new Popup(m, "Options", popupOptions);
            popup.getItems()[1].addActionListener(e -> getManager().getMainHome().makeActiveEditProfile(user));
            popup.getItems()[2].addActionListener(e -> deleteConfirm());
        }
        else
        {
            popupOptions = new String[]{"Report"};
            popup = new Popup(m, "Menu", popupOptions);
        }

        popup.getItems()[0].addActionListener(e -> PostOption.reportPost(user.getUserId()));

        view.addOptions(popup);

        view.add(postArray.getView());
    }

    public void deleteConfirm()
    {
        int response = JOptionPane.showConfirmDialog(getManager().getFrame(), "Are you sure you wish to delete your account? This action is irreversible.", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION)
        {
            int success = UserOption.delete(user.getUserId());

            if(success == 0)
            {
                JOptionPane.showMessageDialog(getManager().getFrame(), "Account deleted successfully.");
                getManager().makeActiveSplash();
            }
        }
    }

    // SETGET

    public ProfileView getView() {
        return this.view;
    }

    public void setView(ProfileView view) {
        this.view = view;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayPostControl getPostArray() {
        return this.postArray;
    }

    public void setPostArray(ArrayPostControl postArray) {
        this.postArray = postArray;
    }

}
