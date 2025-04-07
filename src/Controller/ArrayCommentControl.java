package controller;

import java.util.Arrays;

import objects.Comment;
import view.ArrayCommentView;
import model.InteractionOption;

public class ArrayCommentControl extends Control
{
    private ArrayCommentView view;

    private CommentControl[] commentsArray;

    public ArrayCommentControl(ControlManager m, int postId)
    {
        super(m);

        view = new ArrayCommentView(m);

        // GET COMMENTS
        Comment[] comments = InteractionOption.readComments(postId, 10);

        CommentControl[] commentControls = new CommentControl[comments.length];

        System.out.println("ARRAY: " + Arrays.toString(comments));
        for(int i = 0; i < commentControls.length; i++)
        {
            commentControls[i] = new CommentControl(m, comments[i]);
            view.add(commentControls[i].getView());
        }

        view.setUpView();
    }

    // SETGET
    

    public ArrayCommentView getView() {
        return this.view;
    }

    public void setView(ArrayCommentView view) {
        this.view = view;
    }

    public CommentControl[] getCommentsArray() {
        return this.commentsArray;
    }

    public void setCommentsArray(CommentControl[] commentsArray) {
        this.commentsArray = commentsArray;
    }

}
