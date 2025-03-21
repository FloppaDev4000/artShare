package View;

import Controller.ControlManager;
import javax.swing.*;
import Objects.*;

public class AuthorView extends View
{
    JLabel authorName;

    public AuthorView(ControlManager m, User u)
    {
        super(m);

        authorName = new JLabel(u.getUsername());

        add(authorName);
        System.out.println("author panel created");
    }
}
