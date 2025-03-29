package View;

import javax.swing.*;
import java.awt.event.*;
import Controller.*;

public class Popup extends JButton
{
    ControlManager manager;

    

    JMenuItem[] items;

    public Popup(ControlManager m, String newText, String[] options)
    {
        // Create a JButton
        setText(newText);

        // Create a JPopupMenu (the popup menu)
        JPopupMenu popupMenu = new JPopupMenu();

        manager = m;

        // init items
        items = new JMenuItem[options.length];
        for(int i = 0; i < options.length; i++)
        {
            items[i] = new JMenuItem(options[i]);
            popupMenu.add(items[i]);
        }

        // Add an action listener to the button to show the popup menu when clicked
        addActionListener(e -> popupMenu.show(this, 0, getHeight()));
    }


    public ControlManager getManager() {
        return this.manager;
    }

    public void setManager(ControlManager manager) {
        this.manager = manager;
    }

    public JMenuItem[] getItems() {
        return this.items;
    }

    public void setItems(JMenuItem[] items) {
        this.items = items;
    }


}
