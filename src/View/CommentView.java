package view;

import javax.swing.JLabel;

import model.UserOption;
import objects.Comment;
import controller.ControlManager;

public class CommentView extends View
{

    AuthorView author;
    JLabel commentText;

    public CommentView(ControlManager m, Comment c)
    {
        super(m);

        author = new AuthorView(m, UserOption.readUser(c.getUserId()));

        commentText = new JLabel(c.getValue());

        add(author);

        add(commentText);


    }
}
