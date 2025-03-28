package Controller;

import Model.PostOption;
import Objects.*;
import View.ArrayCommentView;
import View.ArrayPostView;

public class ArrayCommentControl extends Control
{
    ArrayCommentView view;

    CommentControl[] commentsArray;

    public ArrayCommentControl(ControlManager m)
    {
        super(m);

        // GET POSTS
        Comment[] comments = PostOption.readComments();

        view = new ArrayCommentView(m);

        view.setUpView();
    }
}
