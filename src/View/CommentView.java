package view;

import javax.swing.JLabel;

import model.UserOption;
import objects.Comment;
import controller.ControlManager;

public class CommentView extends View
{

    private AuthorView author;
    private JLabel commentText;

    public CommentView(ControlManager m, Comment c)
    {
        super(m);

        author = new AuthorView(m, UserOption.readUser(c.getUserId()));

        commentText = new JLabel(c.getValue());

        add(author);

        add(commentText);
    }

    // SETGET

    public AuthorView getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorView author) {
        this.author = author;
    }

    public JLabel getCommentText() {
        return this.commentText;
    }

    public void setCommentText(JLabel commentText) {
        this.commentText = commentText;
    }
    
}
