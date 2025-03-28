package Controller;

import Model.InteractionOption;
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

    ArrayCommentControl arrayComments;

    public PostControl(ControlManager m, int postId)
    {
        super(m);

        populate(postId);

        view = new PostView(m, post);

        view.addLikeListener(e -> addLike());
        view.addShareListener(e -> addShare());
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

    public void addLike()
    {
        InteractionOption.checkInteraction(postId, manager.getCurrentUserId(), 0);
        view.resetInteractionText();
    }

    public void addShare()
    {
        InteractionOption.checkInteraction(postId, manager.getCurrentUserId(), 1);
        view.resetInteractionText();
    }

    // SETGET
    public View getView(){return view;}
}
