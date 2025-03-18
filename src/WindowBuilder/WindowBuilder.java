package WindowBuilder;

import java.awt.Color;
import WindowBuilder.helper_classes.*;
import javax.swing.*;

public class WindowBuilder
{
  public static void main(String[] args) {

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(1138, 615);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#1e1e1e"));

     JTextField element1 = new JTextField("");
     element1.setBounds(536, 219, 149, 21);
     element1.setFont(CustomFontLoader.loadContentFont(14.0f));
     element1.setBackground(Color.decode("#B2B2B2"));
     element1.setForeground(Color.decode("#656565"));
     element1.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element1, "", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element1);

     JPasswordField element2 = new JPasswordField("");
     element2.setBounds(533, 272, 149, 21);
     element2.setFont(CustomFontLoader.loadContentFont(14.0f));
     element2.setBackground(Color.decode("#B2B2B2"));
     element2.setForeground(Color.decode("#656565"));
     element2.setBorder(new RoundedBorder(2, Color.decode("#979797"), 0));
     OnFocusEventHelper.setOnFocusText(element2, "", Color.decode("#353535"),   Color.decode("#656565"));
     panel.add(element2);

     JButton element3 = new JButton("Log In");
     element3.setBounds(512, 335, 106, 30);
     element3.setBackground(Color.decode("#2e2e2e"));
     element3.setForeground(Color.decode("#D9D9D9"));
     element3.setFont(CustomFontLoader.loadContentFont(14));
     element3.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     element3.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element3, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(element3);

     JLabel element4 = new JLabel("Username:");
     element4.setBounds(457, 226, 69, 18);
     element4.setFont(CustomFontLoader.loadContentFont(14));
     element4.setForeground(Color.decode("#D9D9D9"));
     panel.add(element4);

     JLabel element5 = new JLabel("Password:");
     element5.setBounds(455, 281, 67, 17);
     element5.setFont(CustomFontLoader.loadContentFont(14));
     element5.setForeground(Color.decode("#D9D9D9"));
     panel.add(element5);

     JButton element6 = new JButton("Sign Up");
     element6.setBounds(515, 386, 106, 30);
     element6.setBackground(Color.decode("#2e2e2e"));
     element6.setForeground(Color.decode("#D9D9D9"));
     element6.setFont(CustomFontLoader.loadContentFont(14));
     element6.setBorder(new RoundedBorder(4, Color.decode("#979797"), 1));
     element6.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(element6, Color.decode("#232323"), Color.decode("#2e2e2e"));
     panel.add(element6);

     JLabel element7 = new JLabel("ArtShare");
     element7.setBounds(500, 167, 118, 37);
     element7.setFont(CustomFontLoader.loadTitleFont(14));
     element7.setForeground(Color.decode("#D9D9D9"));
     panel.add(element7);

     frame.add(panel);
     frame.setVisible(true);

  }
}