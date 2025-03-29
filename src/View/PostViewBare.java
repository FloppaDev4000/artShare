package View;

import Objects.*;
import tools.ImageTools;
import tools.UiTools;
import Controller.ControlManager;
import Model.InteractionOption;
import Model.UserOption;

import javax.swing.*;

import java.awt.event.MouseEvent;       // For MouseEvent class
import java.awt.event.MouseListener;    // For MouseListener interface
import java.awt.event.MouseAdapter;     // For MouseAdapter (an abstract class)

import java.awt.Color;
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
        image = new JLabel(ImageTools.resize(imageIcon, 200, 150));
        
        interactions = new JLabel();
        resetInteractionText();

        likeButton = new JButton("Like");
        shareButton = new JButton("Share");

        add(author);
        add(title);
        add(description);
        add(image);
        add(interactions);
        add(likeButton);
        add(shareButton);

        // CLICKABLE
        addListeners();
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

    public void addListeners()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("Panel clicked at position: " + e.getPoint());
                getManager().getMainHome().makeActivePost(postId);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                setBackground(new Color(UiTools.DEFAULT_GREY_HOVER));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBackground(new Color(UiTools.DEFAULT_GREY));
            }
        }
        );
    }
}
