package View;

import Objects.*;
import Controller.ControlManager;
import Model.InteractionOption;
import Model.UserOption;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PostView extends View
{
    AuthorView author;

    int postId;

    boolean hasUserLiked;
    boolean hasUserShared;

    JLabel title;
    JLabel description;

    JLabel image;

    JLabel interactions;
    int likes;
    int shares;
    int comments;

    JButton likeButton;
    JButton shareButton;

    JButton commentButton;
    JTextField commentField;

    ArrayCommentView arrayComments;

    public PostView(ControlManager m, Post p)
    {
        super(m);

        postId = p.getPostId();

        System.out.println("POST VIEW!");

        // author stuff
        author = new AuthorView(m, UserOption.readUser(p.getUserId()));

        title = new JLabel(p.getTitle());
        description = new JLabel(p.getDescription());

        ImageIcon imageIcon = new ImageIcon(p.getFilePath());
        image = new JLabel(imageIcon);

        resetInteractionText();
        likeButton = new JButton("Like");
        shareButton = new JButton("Share");

        commentField = new JTextField();
        commentButton = new JButton("Submit Comment");

        // PUT ARRAY COMMENTS STUFF HERE

        add(author);
        add(title);
        add(description);
        add(image);
        add(interactions);
        add(likeButton);
        add(shareButton);
        add(commentField);
        add(commentButton);
    }

    public void addLikeListener(ActionListener l){likeButton.addActionListener(l);}
    public void addShareListener(ActionListener l){shareButton.addActionListener(l);}

    public void resetInteractionText()
    {
        int[] i = InteractionOption.getInteraction(postId);
        
        // ensure i exists
        if(i == null)
        {
            i = new int[3];
            for(int index = 0; index < i.length; index++)
            {
                i[index] = 0;
            }
        }

        likes = i[0];
        shares = i[1];
        comments = i[2];
        String newText = "LIKES: " + likes + ", SHARES: " + shares + ", COMMENTS: " + comments;
        interactions.setText(newText);
    }
}
