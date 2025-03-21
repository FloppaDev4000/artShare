package Controller;

import Model.PostOption;
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

    Post post;

    public PostControl(ControlManager m, int postId)
    {
        super(m);

        populate(postId);

        view = new PostView(m, post);
    }

    public void getPostValues(Post p)
    {
        title = p.getTitle();
        description = p.getDescription();
        //getFile(p.filePath);
        author = UserOption.readUser(p.getUserId());
    }

    public void populate(int postId)
    {
        post = PostOption.readPost(postId);
    }

    // SETGET
    public View getView(){return view;}
}
