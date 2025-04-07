package view;

import controller.ControlManager;
import objects.User;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridBagConstraints;

public class ProfileView extends View
{
    private JLabel usernameLabel;
    private JLabel bioLabel;
    private JLabel verifiedLabel;
    

    public ProfileView(ControlManager m, User u)
    {
        super(m);
        System.out.println("MY USERNAME: " + u.getUsername());
        usernameLabel = new JLabel(u.getUsername());
        bioLabel = new JLabel(u.getBio());
        verifiedLabel = new JLabel("[Verified]");

        add(usernameLabel);
        add(bioLabel);

        if(u.getIsVerified())
        {
            add(verifiedLabel);
        }
    }

    public void addOptions(JButton option)
    {
        GridBagConstraints b = new GridBagConstraints();
        add(option, b);
    }

    // SETGET

    public JLabel getUsernameLabel() {
        return this.usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getBioLabel() {
        return this.bioLabel;
    }

    public void setBioLabel(JLabel bioLabel) {
        this.bioLabel = bioLabel;
    }

    public JLabel getVerifiedLabel() {
        return this.verifiedLabel;
    }

    public void setVerifiedLabel(JLabel verifiedLabel) {
        this.verifiedLabel = verifiedLabel;
    }

}
