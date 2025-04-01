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
        
        title = new JLabel("Array of posts.");
        add(title);

        scrollPaneChild = new JPanel();
        scrollPaneChild.setLayout(new BoxLayout(scrollPaneChild, BoxLayout.Y_AXIS));
        add(scrollPaneChild);

        scrollPane = new JScrollPane(scrollPaneChild);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(420, 600));
        

        postCtrls = new PostControlBare[posts.length];

        for(int i = 0; i < posts.length; i++)
        {
            if(posts[i] != null)
            {
                postCtrls[i] = new PostControlBare(m, posts[i]);
                postCtrls[i].getView().setPreferredSize(new Dimension(380, 280));
                scrollPaneChild.add(postCtrls[i].getView());
            }
        }
        add(scrollPane);
    }
}
