package objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ErrorWriter
{
    public int writeError(String error)
    {
        try
        {
            File f = new File("Error.log");
    
            PrintStream ps = new PrintStream(f);
            System.setErr(ps);
        }
        catch(FileNotFoundException f)
        {
            f.printStackTrace();
        }
        return 0;
    }

    public void closeFile(Scanner input)
    {
        input.close();
    }
}
