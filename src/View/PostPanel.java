package View;

import javax.swing.*;
import java.awt.*;

public class PostPanel extends JPanel
{
    ScrollPane mainScroll;


    //AuthorPanel authorPanel;

    JLabel titleLabel;
    JLabel descLabel;
    ImageIcon imgIcon;

    JPanel buttonPanel;
    JButton likeButton;
    JButton shareButton;
    JButton commentButton;

    // under everything, comments will stack on bottom

    

    //--------------------------METHODS

    public PostPanel(String title, String desc, String imgPath)
    {
        super();
        titleLabel = new JLabel(title);
        descLabel = new JLabel(desc);
        imgIcon = new ImageIcon(imgPath);
    }

    
}

