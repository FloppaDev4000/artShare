

import controller.ControlManager;
import model.Global;

class Driver
{
    public static void main(String[] args)
    {
        // set up connection
        Global.connect();

        // init manager
        ControlManager cm = new ControlManager();

        // start program
        cm.run();
    }
}