package controller;

import objects.User;
import objects.Post;
import view.HomeView;
import view.View;

public class HomeControl extends Control
{
    private HomeView view;
    private Control middleControl;
    private View middleView;

    public HomeControl(ControlManager m)
    {
        super(m);

        // set basic middleControl
        middleControl = new ArrayPostControl(getManager(), -1);

        view = new HomeView(m);

        view.setContainer(new View(m));
        view.add(view.getCont());
        //manager.getFrame().frameReset();

        view.addLogoutListener(e -> logout());
        view.addCreateListener(e -> makeActiveCreate());
        view.addMyProfileListener(e -> makeActiveProfile(m.getCurrentUserId()));
        view.addArrayPostListener(e -> makeActiveArrayPost(-1));

        makeActiveArrayPost(-1);
    }

    public void makeActivePost(int postId)
    {
        // place homePost's view inside home's view
        // give post values to post

        PostControl pCtrl = new PostControl(getManager(), postId);
        view.replaceContainer(pCtrl.getView());

        middleControl = pCtrl;
    }

    // move to post scroll (-1 for home feed)
    public void makeActiveArrayPost(int userId)
    {
        ArrayPostControl a = new ArrayPostControl(getManager(), userId);
        view.replaceContainer(a.getView());

        middleControl = a;
    }

    public void makeActiveCreate()
    {
        CreatePostControl c = new CreatePostControl(getManager());
        view.replaceContainer(c.getView());
                
        middleControl = c;
    }

    public void makeActiveEdit(Post p)
    {
        CreatePostControl e = new CreatePostControl(getManager(), p);
        view.replaceContainer(e.getView());

        middleControl = e;
    }

    public void makeActiveEditProfile(User u)
    {
        EditProfileControl e = new EditProfileControl(getManager(), u);
        view.replaceContainer(e.getView());

        middleControl = e;
    }

    public void makeActiveProfile(int userId)
    {
        ProfileControl c = new ProfileControl(getManager(), userId);
        view.replaceContainer(c.getView());

        middleControl = c;
    }

    public void logout()
    {
        getManager().logout();
        getManager().makeActiveSplash();
    }

    public void Hello()
    {
        System.err.println("Hello");
    }

    // SETGET

    public HomeView getView() {
        return this.view;
    }

    public void setView(HomeView view) {
        this.view = view;
    }

    public Control getMiddleControl() {
        return this.middleControl;
    }

    public void setMiddleControl(Control middleControl) {
        this.middleControl = middleControl;
    }

    public View getMiddleView() {
        return this.middleView;
    }

    public void setMiddleView(View middleView) {
        this.middleView = middleView;
    }
    
}
