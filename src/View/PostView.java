package View;

import Objects.*;
import tools.*;
import Controller.ControlManager;
import Model.InteractionOption;
import Model.UserOption;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    public JTextField commentField;

    // popup buttons
    JButton deleteButton;

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
        image = new JLabel(ImageTools.resize(imageIcon, 200, 150));

        interactions = new JLabel();
        resetInteractionText();

        likeButton = new JButton("Like");
        shareButton = new JButton("Share");

        commentField = new JTextField(12);
        commentButton = new JButton("Submit Comment");

        // PUT ARRAY COMMENTS STUFF HERE
        arrayComments = new ArrayCommentView(m);

        // layout stuff
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.gridwidth = 2;
        add(author, gbc);

        gbc.gridy = 1;
        add(title, gbc);

        gbc.gridy = 2;
        add(description, gbc);

        gbc.gridy = 3;
        add(image, gbc);

        gbc.gridy = 4;
        add(interactions, gbc);

        gbc.gridy = 5;
        add(likeButton, gbc);

        gbc.gridy = 6;
        add(shareButton, gbc);

        gbc.gridy = 7;
        add(commentField, gbc);

        gbc.gridy = 8;
        add(commentButton, gbc);
    }

    public void addLikeListener(ActionListener l){likeButton.addActionListener(l);}
    public void addShareListener(ActionListener l){shareButton.addActionListener(l);}
    public void addCommentListener(ActionListener l){commentButton.addActionListener(l);}

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
