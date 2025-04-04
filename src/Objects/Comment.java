package objects;

import model.InteractionOption;

public class Comment
{
    private int interactionId;
    private int userId;
    private int postId;
    private String value;

    public Comment(){}
    public Comment(int interactionId, int userId, int postId, String value)
    {
        this.interactionId = interactionId;
        this.userId = userId;
        this.postId = postId;
        this.value = value;
    }
    public Comment(int interactionId)
    {
        System.out.println("GETTING COMMENT " + interactionId);
        Comment c = InteractionOption.readComment(interactionId);

        interactionId = c.getInteractionId();
        userId = c.getUserId();
        postId = c.getPostId();
        value = c.getValue();
    }

    // SETGET
    public int getInteractionId() {
        return this.interactionId;
    }
    public void setInteractionId(int interactionId) {
        this.interactionId = interactionId;
    }

    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return this.postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
