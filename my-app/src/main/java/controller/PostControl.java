package controller;

import javax.swing.JOptionPane;

import objects.Post;
import objects.User;
import view.PostView;
import view.Popup;
import model.InteractionOption;
import model.PostOption;
import model.UserOption;

public class PostControl extends Control
{
    private PostView view;

    private int postId;
    private String title;
    private String description;
    private User author;

    private Post post;

    private ArrayCommentControl arrayComments;

    public PostControl(ControlManager m, int postId)
    {
        super(m);

        populate(postId);

        view = new PostView(m, post);

        arrayComments = new ArrayCommentControl(m, postId);

        view.addArrayComments(arrayComments.getView());

        view.addLikeListener(e -> addLike());
        view.addShareListener(e -> addShare());
        view.addCommentListener(e -> addComment(view.commentField.getText()));

        // setup popup menu
        String[] popupOptions;
        Popup popup;

        // add options popup stuff
        if(post.getUserId() == m.getCurrentUserId())
        {
            // only show delete if post belongs to you
            popupOptions = new String[]{"Report", "Edit", "Delete"};
            popup = new Popup(m, "Options", popupOptions);
            popup.getItems()[1].addActionListener(e -> getManager().getMainHome().makeActiveEdit(post));
            popup.getItems()[2].addActionListener(e -> deleteConfirm());
        }
        else
        {
            popupOptions = new String[]{"Report"};
            popup = new Popup(m, "Menu", popupOptions);
        }
        popup.getItems()[0].addActionListener(e -> PostOption.reportPost(postId));

        view.addOptions(popup);
    }

    public void getPostValues(Post p)
    {
        title = p.getTitle();
        description = p.getDescription();
        //getFile(p.filePath);
        author = UserOption.readUser(p.getUserId());
    }

    public void deleteConfirm()
    {
        int response = JOptionPane.showConfirmDialog(getManager().getFrame(), "Are you sure you wish to delete this post?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION)
        {
            int success = PostOption.deletePost(post.getPostId());

            if(success == 0)
            {
                JOptionPane.showMessageDialog(getManager().getFrame(), "Post deleted successfully.");
                getManager().makeActiveHome();
            }
        }
    }

    public void populate(int postId)
    {
        post = PostOption.readPost(postId);
    }

    public void populateComments()
    {
        view.remove(arrayComments.getView());
        arrayComments = new ArrayCommentControl(getManager(), post.getPostId());
        view.addArrayComments(arrayComments.getView());
        
        view.revalidate();
        view.repaint();
    }

    public void addLike()
    {
        InteractionOption.checkInteraction(post.getPostId(), getManager().getCurrentUserId(), 0);
        view.resetInteractionText();
    }

    public void addShare()
    {
        InteractionOption.checkInteraction(post.getPostId(), getManager().getCurrentUserId(), 1);
        view.resetInteractionText();
    }

    public void addComment(String comment)
    {
        InteractionOption.createComment(post.getPostId(), getManager().getCurrentUserId(), comment);
        view.resetInteractionText();
        view.commentField.setText("");
        populateComments();
    }

    // SETGET

    public PostView getView() {
        return this.view;
    }

    public void setView(PostView view) {
        this.view = view;
    }

    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public ArrayCommentControl getArrayComments() {
        return this.arrayComments;
    }

    public void setArrayComments(ArrayCommentControl arrayComments) {
        this.arrayComments = arrayComments;
    }
    
}
