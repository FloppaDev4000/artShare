package view;

import model.InteractionOption;
import model.UserOption;
import tools.ImageTools;
import controller.ControlManager;

import objects.Post;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.ImageIcon;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

public class PostView extends View
{
    private AuthorView author;

    private int postId;

    private boolean hasUserLiked;
    private boolean hasUserShared;

    private JLabel title;
    private JLabel description;

    private JLabel image;

    private JLabel interactions;
    private int likes;
    private int shares;
    private int comments;

    private JButton likeButton;
    private JButton shareButton;

    private JButton commentButton;
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
        
        gbc.gridwidth = 2;
        add(author, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridy = 1;
        add(title, gbc);

        gbc.gridy = 2;
        add(description, gbc);

        gbc.gridy = 3;
        add(image, gbc);

        gbc.gridy = 4;
        add(interactions, gbc);

        gbc.weightx = 1.0;

        gbc.gridwidth = 1;
        gbc.gridy = 5;
        add(likeButton, gbc);

        gbc.gridx = 1;
        add(shareButton, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(commentField, gbc);

        gbc.gridx = 1;
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

    public void addArrayComments(ArrayCommentView a)
    {
        GridBagConstraints b = new GridBagConstraints();

        b.gridy = 7;
        add(a, b);
    }

    public void addOptions(JButton option)
    {
        GridBagConstraints b = new GridBagConstraints();
        add(option, b);
    }

    // SETGET

    public AuthorView getAuthor() {
        return this.author;
    }

    public void setAuthor(AuthorView author) {
        this.author = author;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public boolean isHasUserLiked() {
        return this.hasUserLiked;
    }

    public boolean getHasUserLiked() {
        return this.hasUserLiked;
    }

    public void setHasUserLiked(boolean hasUserLiked) {
        this.hasUserLiked = hasUserLiked;
    }

    public boolean isHasUserShared() {
        return this.hasUserShared;
    }

    public boolean getHasUserShared() {
        return this.hasUserShared;
    }

    public void setHasUserShared(boolean hasUserShared) {
        this.hasUserShared = hasUserShared;
    }

    public JLabel getTitle() {
        return this.title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getDescription() {
        return this.description;
    }

    public void setDescription(JLabel description) {
        this.description = description;
    }

    public JLabel getImage() {
        return this.image;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public JLabel getInteractions() {
        return this.interactions;
    }

    public void setInteractions(JLabel interactions) {
        this.interactions = interactions;
    }

    public int getLikes() {
        return this.likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getShares() {
        return this.shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getComments() {
        return this.comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public JButton getLikeButton() {
        return this.likeButton;
    }

    public void setLikeButton(JButton likeButton) {
        this.likeButton = likeButton;
    }

    public JButton getShareButton() {
        return this.shareButton;
    }

    public void setShareButton(JButton shareButton) {
        this.shareButton = shareButton;
    }

    public JButton getCommentButton() {
        return this.commentButton;
    }

    public void setCommentButton(JButton commentButton) {
        this.commentButton = commentButton;
    }

    public JTextField getCommentField() {
        return this.commentField;
    }

    public void setCommentField(JTextField commentField) {
        this.commentField = commentField;
    }

    public JButton getDeleteButton() {
        return this.deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public ArrayCommentView getArrayComments() {
        return this.arrayComments;
    }

    public void setArrayComments(ArrayCommentView arrayComments) {
        this.arrayComments = arrayComments;
    }

}
