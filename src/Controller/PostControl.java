package Controller;

import javax.swing.JOptionPane;

import Model.InteractionOption;
import Model.PostOption;
import Model.UserOption;
import Objects.*;
import View.*;

public class PostControl extends Control
{
    PostView view;

    int postId;
    String title;
    String description;
    User author;

    Post post;

    ArrayCommentControl arrayComments;

    public PostControl(ControlManager m, int postId)
    {
        super(m);

        populate(postId);

        view = new PostView(m, post);

        arrayComments = new ArrayCommentControl(m, postId);

        view.add(arrayComments.view);

        view.addLikeListener(e -> addLike());
        view.addShareListener(e -> addShare());

        // setup popup menu
        String[] popupOptions;
        Popup popup;

        // add options popup stuff
        if(post.getUserId() == m.getCurrentUserId())
        {
            // only show delete if post belongs to you
            popupOptions = new String[]{"Report", "Edit", "Delete"};
            popup = new Popup(m, "Options", popupOptions);
            popup.getItems()[1].addActionListener(e -> manager.getMainHome().makeActiveEdit(post));
            popup.getItems()[2].addActionListener(e -> deleteConfirm());
        }
        else
        {
            popupOptions = new String[]{"Report"};
            popup = new Popup(m, "Menu", popupOptions);
        }
        popup.getItems()[0].addActionListener(e -> PostOption.reportPost(postId));

        view.add(popup);
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
        int response = JOptionPane.showConfirmDialog(manager.getFrame(), "Are you sure you wish to delete this post?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION)
        {
            int success = PostOption.deletePost(post.getPostId());

            if(success == 0)
            {
                JOptionPane.showMessageDialog(manager.getFrame(), "Post deleted successfully.");
                manager.makeActiveHome();
            }
        }
    }

    public void populate(int postId)
    {
        post = PostOption.readPost(postId);
    }

    public void addLike()
    {
        InteractionOption.checkInteraction(postId, manager.getCurrentUserId(), 0);
        view.resetInteractionText();
    }

    public void addShare()
    {
        InteractionOption.checkInteraction(postId, manager.getCurrentUserId(), 1);
        view.resetInteractionText();
    }

    // SETGET
    public View getView(){return view;}
}
