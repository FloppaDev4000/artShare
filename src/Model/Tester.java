package Model;

public class Tester
{
    
    public static void main(String[] args)
    {
        System.out.println("TEST");

        Global.connect();
        
        PostOption.create("eeee", "this post is really really lame ngl", 1);   
    }
}
