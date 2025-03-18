package Controller;

import View.ArrayPostView;

public class ArrayPostControl extends ArrayControl
{
    ArrayPostView view;

    PostControl[] postArray;

    public ArrayPostControl(ControlManager m)
    {
        super(m);

        view = new ArrayPostView(m);

        view.setUpView();
    }

    public void populate(int userId)
    {
        // if userId = -1, then its a main feed
        // else, its a user post feed
    }

    public ArrayPostView getView(){return view;}
}
