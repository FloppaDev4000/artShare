package Model;

import java.io.File;
import java.util.Arrays;

public class Tester
{
    
    public static void main(String[] args)
    {
        String classpath = System.getProperty("java.class.path");
        String[] classPathValues = classpath.split(File.pathSeparator);
        System.out.println(Arrays.toString(classPathValues));

        System.out.println("TEST");
        
        PostOptions.create("first post", "this is the first post", 0);
    }
}
