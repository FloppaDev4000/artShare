class RegisteredUser extends User
{
    String username;
    String password;

    boolean isVerified;

    void verify()
    {

    }

    void createPost()
    {

    }

    // -- interact w/ posts
    void likePost(Post post)
    {
        post.likes++;
    }

    void commentPost(Post post)
    {
        post.comments++;
    }

    void sharePost(Post post)
    {
        post.shares++;
    }
}
