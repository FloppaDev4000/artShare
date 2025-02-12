package Controller;
class Post
{
    int postID;
    String postTitle;
    String postDescription;
    String author;

    // immediate viewable values
    int likes;
    int comments;
    int shares;

    Post(){}

    Post(String postTitle, RegisteredUser user, String postDescription)
    {
        this.postTitle = postTitle;
        this.postDescription = postDescription;
        this.author = user.username;

        likes = 0;
        comments = 0;
        shares = 0;
    }

    Post(String postTitle, String author, String postDescription)
    {
    	
    }

    int interact(int userID)
    {
        // add immediate interaction


        // add to database


        return 0;
    }

    int comment(int userID, String comment)
    {
        return 0;
    }

    static int saveToDatabase(String postTitle, String postDescription, int userID)
    {
        // create post in SQL
        Model.PostOptions.create(postTitle, postDescription, userID);

        // retrieve postID
        
        return 0;
    }

    void getPostData()
    {
        // put into sql postRead
    }
}