package Controller;

import View.LoginView;
import View.MainPanel;

class Driver
{

    public static void main(String[] args)
    {
        MainFrame mainFrame = new MainFrame();

        LoginView loginView = new LoginView();

        loginView.addLoginListener(e -> mainFrame.switchView(new MainPanel(), "Main"));

        mainFrame.switchView(loginView, "Login");
        mainFrame.setVisible(true);
    }
}