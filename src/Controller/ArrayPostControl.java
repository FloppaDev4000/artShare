package Controller;

import Model.PostOptions;
import View.ArrayPostView;
import Objects.Post;

public class ArrayPostControl extends ArrayControl
{
    ArrayPostView view;

    PostControl[] postArray;

    public ArrayPostControl(ControlManager m, int userId)
    {
        super(m);

        // GET POSTS
        Post[] posts = PostOptions.readPosts(userId, 10);

        view = new ArrayPostView(m, posts);

        view.setUpView();
    }

    public void populate(int userId)
    {
        // if userId = -1, then its a main feed
        // else, its a user post feed
    }

    public ArrayPostView getView(){return view;}
}
