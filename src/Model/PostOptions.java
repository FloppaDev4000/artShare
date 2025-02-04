package Model;

public class PostOptions
{
    public static int create(String name, String description, int userID)
    {
        // create SQL insert statement
        String statement = "INSERT INTO posts VALUES (" + name + ", " + description + ", " + userID + ")";
        
        // communicate with SQL
        
        return 0;
    }

    public int read()
    {
        return 0;
    }

    public int update()
    {
        return 0;
    }

    public int delete(int postID)
    {
        return 0;
    }
}