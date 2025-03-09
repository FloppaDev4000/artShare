package Controller;

import View.*;

class Driver
{

    public static void main(String[] args)
    {
        MainFrame mainFrame = new MainFrame();

        LoginView loginView = new LoginView();
        HomeView homeView = new HomeView();

        loginView.addLoginListener(e -> mainFrame.switchView(homeView, "Main"));

        mainFrame.switchView(loginView, "Login");
        mainFrame.setVisible(true);
    }
}