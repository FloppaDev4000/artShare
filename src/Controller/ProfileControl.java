package Controller;

import View.*;
import Model.PostOption;
import Model.UserOption;
import Objects.*;

public class ProfileControl extends Control
{
    ProfileView view;

    User user;

    ArrayPostControl postArray;

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
            popup.getItems()[1].addActionListener(e -> manager.getMainHome().makeActiveEdit(user));
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
}
