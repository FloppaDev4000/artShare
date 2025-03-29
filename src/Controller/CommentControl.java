package Controller;

import Objects.Comment;
import View.CommentView;

public class CommentControl extends Control
{
    CommentView view;

    public CommentControl(ControlManager m, Comment c)
    {
        super(m);

        view = new CommentView(m, c);
    }   
}
