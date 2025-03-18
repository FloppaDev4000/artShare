package Controller;

import Model.PostOptions;
import Model.UserOption;
import Objects.ArrayPost;
import Objects.Post;
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
        middleControl = new ArrayPostControl(manager);

        view = new HomeView(m);

        view.setContainer(new ArrayPostView(m));
        view.add(view.getContainer());
        manager.getFrame().frameReset();

        view.addLogoutListener(e -> logout());
        view.addCreateListener(e -> makeActiveCreate());

        makeActivePost(0);
    }

    void makeActivePost(int postId)
    {
        // place homePost's view inside home's view
        // give post values to post

        PostControl pCtrl = new PostControl(manager, postId);
        view.replaceContainer(pCtrl.getView());

        manager.getFrame().frameReset();
    }

    // return to base post scroll
    public void makeActiveArrayPost()
    {
        ArrayPostControl a = new ArrayPostControl(manager);
        view.replaceContainer(a.getView());

        manager.getFrame().frameReset();
    }

    public void makeActiveCreate()
    {
        CreatePostControl c = new CreatePostControl(manager);
        
        view.replaceContainer(c.getView());
        
        manager.getFrame().frameReset();
        
        middleControl = c;
    }

    public void logout()
    {
        int uid = -1;

        manager.makeActiveLogin();
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
