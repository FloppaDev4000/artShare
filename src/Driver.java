

import Controller.*;
import Model.Global;

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