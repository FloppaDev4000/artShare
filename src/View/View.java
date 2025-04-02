package View;

import javax.swing.JPanel;


import java.awt.event.MouseEvent;       // For MouseEvent class
import java.awt.event.MouseAdapter;     // For MouseAdapter (an abstract class)

import java.awt.Color;

import Controller.*;
import Model.Global;
import tools.UiTools;

public class View extends JPanel
{
    private ControlManager manager;

    public View(ControlManager m)
    {
        manager = m;

        if(Global.SECRET_DEBUG_MODE)
        {
            addListeners();
        }
    }

    public void setUpView()
    {
        revalidate();
        repaint();
    }

    // SETGET

    public ControlManager getManager() {
        return this.manager;
    }

    public void setManager(ControlManager manager) {
        this.manager = manager;
    }

    // DEBUG HOVER THINGY
    public void addListeners()
    {
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)
            {
                setBackground(new Color(UiTools.DEFAULT_GREY_HOVER));
                System.out.println("\nELEMENT: " + getClass());
                System.out.println("SIZE: " + getSize());
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                setBackground(new Color(UiTools.DEFAULT_GREY));
            }
        }
        );
    }

}
