package Controller;
class RegisteredUser extends User
{
    int userID;
    String username;
    String password;

    boolean isVerified;

    void verify()
    {

    }

    void createPost()
    {
        // get post values
        String postTitle  = "Generic Title";
        String postDescription = "A generic description.";

        // create post
        Post p = new Post(postTitle, this, postDescription);

    }
}
