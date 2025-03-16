package Controller;

import Model.UserOption;
import Objects.*;
import View.*;

public class PostControl extends Control
{
    PostView view;

    int postId;
    String title;
    String description;
    User author;

    public void getPostValues(Post p)
    {
        title = p.title;
        description = p.description;
        //getFile(p.filePath);
        author = UserOption.readUser(p.userId);
    }

    public PostControl(ControlManager manager)
    {
        this.manager = manager;
    }

    public void populate(int postId)
    {

    }
}
