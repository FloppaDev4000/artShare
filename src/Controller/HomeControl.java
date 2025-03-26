package Controller;

import View.*;

public class HomeControl extends Control
{
    HomeView view;
    Control middleControl;
    View middleView;

    public HomeControl(ControlManager m)
    {
        super(m);

        // set basic middleControl
        middleControl = new ArrayPostControl(manager, -1);

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

        PostControl pCtrl = new PostControl(manager, postId);
        view.replaceContainer(pCtrl.getView());

        //manager.getFrame().frameReset();

        middleControl = pCtrl;
    }

    // return to base post scroll
    public void makeActiveArrayPost(int userId)
    {
        ArrayPostControl a = new ArrayPostControl(manager, userId);
        view.replaceContainer(a.getView());

        //manager.getFrame().frameReset();
    }

    public void makeActiveCreate()
    {
        CreatePostControl c = new CreatePostControl(manager);
        view.replaceContainer(c.getView());
        
        //manager.getFrame().frameReset();
        
        middleControl = c;
    }

    public void makeActiveProfile(int userId)
    {
        ProfileControl c = new ProfileControl(manager, userId);
        view.replaceContainer(c.view);

        //manager.getFrame().frameReset();

        middleControl = c;
    }

    public void logout()
    {
        manager.logout();
        manager.makeActiveSplash();
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
