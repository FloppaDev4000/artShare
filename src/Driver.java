

import Controller.*;
import View.*;

class Driver
{

    public static void main(String[] args)
    {
        MainFrame mainControl = new MainFrame();

        LoginView loginView = new LoginView();
        HomeView homeView = new HomeView();

        loginView.addLoginListener(e -> mainControl.switchView(homeView, "Main"));

        mainControl.switchView(loginView, "Login");
        mainControl.setVisible(true);
    }
}