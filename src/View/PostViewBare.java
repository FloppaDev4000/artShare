package View;

import Objects.*;
import Controller.ControlManager;
import Model.InteractionOption;
import Model.UserOption;

import javax.swing.*;
import java.awt.event.ActionListener;

public class PostViewBare extends View
{
    AuthorView author;

    int postId;

    JLabel title;
    JLabel description;

    JLabel image;

    JLabel interactions;
    int likes;
    int shares;
    int comments;

    JButton likeButton;
    JButton shareButton;

    public PostViewBare(ControlManager m, Post p)
    {
        super(m);

        postId = p.getPostId();

        // author stuff
        author = new AuthorView(m, UserOption.readUser(p.getUserId()));

        title = new JLabel(p.getTitle());
        description = new JLabel(p.getDescription());

        ImageIcon imageIcon = new ImageIcon(p.getFilePath());
        System.out.println("FILEPATH: " + p.getFilePath());
        image = new JLabel(imageIcon);

        
        int[] i = InteractionOption.getInteraction(postId);
        
        // ensure i exists
        if(i == null)
        {
            i = new int[3];
            for(int index = 0; index < i.length; index++){i[index] = 0;}
        }
        likes = i[0];
        shares = i[1];
        comments = i[2];
        interactions = new JLabel("LIKES: " + likes + ", SHARES: " + shares + ", COMMENTS: " + comments);

        likeButton = new JButton("Like");
        shareButton = new JButton("Share");

        // PUT ARRAY COMMENTS STUFF HERE

        add(author);
        add(title);
        add(description);
        add(image);
        add(interactions);
        add(likeButton);
        add(shareButton);
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
