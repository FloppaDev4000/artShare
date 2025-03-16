package Objects;

import Model.*;

public class Post
{
    public Post(){}
    public Post(int postId, String title, String description, String filepath, int[] interactions, int userId)
    {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.filePath = filepath;
        this.interactions = interactions;
    }

    // post data
    public int postId;
    public String title;
    public String description;

    // file
    public String filePath;

    // interactions (length = 3)
    public int[] interactions;

    // foreign key
    public int userId;

    // auto get post values
    public void getData(int postId)
    {
        Post temp = PostOptions.readPost(postId);
        int[] interactions = InteractionOption.getInteractions(postId);
        
        postId = temp.postId;
        title = temp.title;
        description = temp.description;
        this.interactions = interactions;
    }
}
