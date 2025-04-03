package View;

import javax.swing.*;
import java.awt.*;

import Controller.*;
import Objects.Post;

public class ArrayPostView extends View
{
    private JScrollPane scrollPane;
    private JPanel scrollPaneChild;
    private PostControlBare[] postCtrls;

    public JLabel title;

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
}
