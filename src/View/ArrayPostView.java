package View;

import javax.swing.JLabel;

import Controller.*;
import Objects.Post;

public class ArrayPostView extends View
{
    private PostControlBare[] postCtrls;

    public ArrayPostView(ControlManager m, Post[] posts)
    {
       super(m);

       JLabel label = new JLabel("Array of posts.");

       add(label);

       postCtrls = new PostControlBare[posts.length];

       //for(int i = 0; i < posts.length; i++)
       //{
       //     postCtrls[i] = new PostControlBare(m, posts[i]);
       //     add(postCtrls[i].getView());
       //}

    }
}
