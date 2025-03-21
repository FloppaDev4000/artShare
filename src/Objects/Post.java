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
    private int postId;
    private String title;
    private String description;

    // file
    private String filePath;

    // interactions (length = 3)
    private int[] interactions;

    // foreign key
    private int userId;

    // auto get post values
    public void getData(int postId)
    {
        Post temp = PostOption.readPost(postId);
        int[] interactions = InteractionOption.getInteraction(postId);
        
        postId = temp.postId;
        title = temp.title;
        description = temp.description;
        this.interactions = interactions;
    }

    // SETGET


    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int[] getInteractions() {
        return this.interactions;
    }

    public void setInteractions(int[] interactions) {
        this.interactions = interactions;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
