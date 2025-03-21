

import Controller.*;
import Model.Global;

class Driver
{
    public static void main(String[] args)
    {
        Global.connect();
        ControlManager cm = new ControlManager();
        cm.run();
    }
}