package controller;

import objects.User;
import objects.Post;
import view.PostViewBare;
import model.InteractionOption;
import model.PostOption;
import model.UserOption;

public class PostControlBare extends Control
{
    private PostViewBare view;

    private int postId;
    private String title;
    private String description;
    private User author;

    private Post post;

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
        System.out.println("LIKING WITH ID: " + getManager().getCurrentUserId());
        InteractionOption.checkInteraction(postId, getManager().getCurrentUserId(), 0);
        view.resetInteractionText();
    }

    public void addShare()
    {
        InteractionOption.checkInteraction(postId, getManager().getCurrentUserId(), 1);
        view.resetInteractionText();
    }

    // SETGET

    public PostViewBare getView() {
        return this.view;
    }

    public void setView(PostViewBare view) {
        this.view = view;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
    

}
