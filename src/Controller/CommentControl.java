package controller;

import view.CommentView;
import objects.Comment;

public class CommentControl extends Control
{
    CommentView view;

    public CommentControl(ControlManager m, Comment c)
    {
        super(m);

        view = new CommentView(m, c);
    }   
}
