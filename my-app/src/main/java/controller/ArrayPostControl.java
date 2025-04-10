package controller;

import view.ArrayPostView;
import model.PostOption;
import objects.Post;

public class ArrayPostControl extends Control
{
    private ArrayPostView view;

    private PostControl[] postArray;

    public ArrayPostControl(ControlManager m, int userId)
    {
        super(m);

        // GET POSTS
        Post[] posts = PostOption.readPosts(userId, 10);

        view = new ArrayPostView(m, posts);

        view.setUpView();
    }

    public void populate(int userId)
    {
        // if userId = -1, then its a main feed
        // else, its a user post feed
    }

    public ArrayPostView getView(){return view;}

    // SETGET
    public void setView(ArrayPostView view) {
        this.view = view;
    }

    public PostControl[] getPostArray() {
        return this.postArray;
    }

    public void setPostArray(PostControl[] postArray) {
        this.postArray = postArray;
    }

}
