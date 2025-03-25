package Model;

public class Tester
{
    
    public static void mainy(String[] args)
    {
        System.out.println("TEST");

        Global.connect();
        
        PostOption.create("eeee", "this post is really really lame ngl", 1, "");   
    }
}
