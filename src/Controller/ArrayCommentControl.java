package Controller;

import java.util.Arrays;

import Model.InteractionOption;
import Objects.Comment;
import View.ArrayCommentView;

public class ArrayCommentControl extends Control
{
    ArrayCommentView view;

    CommentControl[] commentsArray;

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
            view.add(commentControls[i].view);
        }

        view.setUpView();
    }

    // SETGET
    

}
