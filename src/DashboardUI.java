import java.awt.*;
import javax.swing.*;

public class DashboardUI {
    public static void mainy(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Forum UI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 700);
            frame.setLayout(new BorderLayout());
            
            // Top Navigation Bar
            JPanel navBar = new JPanel();
            navBar.setLayout(new FlowLayout(FlowLayout.LEFT));
            navBar.add(new JButton("Home"));
            navBar.add(new JButton("Profile"));
            navBar.add(new JButton("Messages"));
            navBar.add(new JButton("Notifications"));
            navBar.add(new JButton("Settings"));
            navBar.add(new JButton("Log Out"));
            frame.add(navBar, BorderLayout.NORTH);
            
            // Post Panel (Contains Author Panel and Post Content)
            JPanel postPanel = new JPanel();
            postPanel.setLayout(new BorderLayout());
            
            // Author Panel (Top)
            JPanel authorPanelTop = new JPanel();
            authorPanelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
            authorPanelTop.add(new JLabel("Author: User123"));
            postPanel.add(authorPanelTop, BorderLayout.NORTH);
            
            // Post Content
            JTextArea postContent = new JTextArea(10, 40);
            postContent.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            postPanel.add(postContent, BorderLayout.CENTER);
            
            // Interact with Post Buttons
            JPanel postButtons = new JPanel();
            postButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
            postButtons.add(new JButton("Like"));
            postButtons.add(new JButton("Comment"));
            postButtons.add(new JButton("Share"));
            postPanel.add(postButtons, BorderLayout.SOUTH);
            
            // Comment Panel (Contains Author Panel and Comments)
            JPanel commentPanel = new JPanel();
            commentPanel.setLayout(new BorderLayout());
            
            // Author Panel (Bottom)
            JPanel authorPanelBottom = new JPanel();
            authorPanelBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
            authorPanelBottom.add(new JLabel("Comment by: User456"));
            commentPanel.add(authorPanelBottom, BorderLayout.NORTH);
            
            // Comments Section
            JTextArea comments = new JTextArea(5, 40);
            comments.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            commentPanel.add(comments, BorderLayout.CENTER);
            
            // Interact with Comment Button
            JButton commentButton = new JButton("Reply");
            commentPanel.add(commentButton, BorderLayout.SOUTH);
            
            // Main Layout
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
            mainPanel.add(postPanel);
            mainPanel.add(commentPanel);
            
            frame.add(mainPanel, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}