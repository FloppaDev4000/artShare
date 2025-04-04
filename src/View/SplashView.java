package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.ControlManager;

public class SplashView extends View
{

    public JButton loginButton;
    public JButton signupButton;

    public SplashView(ControlManager m)
    {
        super(m);

        loginButton = new JButton("Log In");
        signupButton = new JButton("Sign Up");

        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        add(loginButton);
        add(signupButton);
    }

    public void addLoginListener(ActionListener l){loginButton.addActionListener(l);}

    public void addSignUpListener(ActionListener l){signupButton.addActionListener(l);}
}
