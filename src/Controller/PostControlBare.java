package Controller;

import Model.InteractionOption;
import Model.PostOption;
import Model.UserOption;
import Objects.User;
import Objects.Post;
import View.PostViewBare;
import View.View;

public class PostControlBare extends Control
{
    PostViewBare view;

    int postId;
    String title;
    String description;
    User author;

    Post post;

    public PostControlBare(ControlManager m, Post p)
    {
        super(m);

        postId = p.getPostId();

        // add values

        view = new PostViewBare(m, p);

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
        System.out.println("LIKING WITH ID: " + manager.getCurrentUserId());
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
