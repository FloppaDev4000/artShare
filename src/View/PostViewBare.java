package View;

import Objects.*;
import Controller.ControlManager;
import Model.*;

import java.awt.Image;

import javax.swing.*;

public class PostViewBare extends View
{
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

        // author stuff

        title = new JLabel(p.getTitle());
        description = new JLabel(p.getDescription());

        ImageIcon imageIcon = new ImageIcon(p.getFilePath());
        image = new JLabel(imageIcon);

        
        int[] i = p.getInteractions();
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

        add(title);
        add(description);
        add(image);
        add(interactions);
        add(likeButton);
        add(shareButton);
    }
}
