package Controller;

import Model.PostOptions;
import Model.UserOption;
import Objects.*;
import View.*;

public class PostControlBare extends Control
{
    PostView view;

    int postId;
    String title;
    String description;
    User author;

    Post post;

    public PostControlBare(ControlManager m, Post p)
    {
        super(m);

        // add values

        view = new PostView(m, p);
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
        post = PostOptions.readPost(postId);
    }

    // SETGET
    public View getView(){return view;}
}
