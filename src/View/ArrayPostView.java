package view;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Dimension;

import objects.Post;
import controller.ControlManager;
import controller.PostControlBare;

public class ArrayPostView extends View
{
    private JScrollPane scrollPane;
    private JPanel scrollPaneChild;
    private PostControlBare[] postCtrls;

    private JLabel title;

    public ArrayPostView(ControlManager m, Post[] posts)
    {
        super(m);

        scrollPaneChild = new JPanel();
        scrollPaneChild.setLayout(new BoxLayout(scrollPaneChild, BoxLayout.Y_AXIS));
        add(scrollPaneChild);

        scrollPane = new JScrollPane(scrollPaneChild);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setMinimumSize(new Dimension(150, 150));
        scrollPane.setPreferredSize(new Dimension(400, 695));

        postCtrls = new PostControlBare[posts.length];

        for(int i = 0; i < posts.length; i++)
        {
            if(posts[i] != null)
            {
                postCtrls[i] = new PostControlBare(m, posts[i]);
                postCtrls[i].getView().setPreferredSize(new Dimension(380, 380));
                scrollPaneChild.add(postCtrls[i].getView());
            }
        }
        add(scrollPane);
    }

    // SETGET

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getScrollPaneChild() {
        return this.scrollPaneChild;
    }

    public void setScrollPaneChild(JPanel scrollPaneChild) {
        this.scrollPaneChild = scrollPaneChild;
    }

    public PostControlBare[] getPostCtrls() {
        return this.postCtrls;
    }

    public void setPostCtrls(PostControlBare[] postCtrls) {
        this.postCtrls = postCtrls;
    }

    public JLabel getTitle() {
        return this.title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

}
