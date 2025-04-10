package controller;

import view.CommentView;
import objects.Comment;

public class CommentControl extends Control
{
    private CommentView view;

    public CommentControl(ControlManager m, Comment c)
    {
        super(m);

        view = new CommentView(m, c);
    }

    // SETGET

    public CommentView getView() {
        return this.view;
    }

    public void setView(CommentView view) {
        this.view = view;
    }

}
