package objects;

import model.InteractionOption;
import model.UserOption;

public class User
{
    private int userId;
    private String username;
    private boolean isVerified;
    private String bio;
    private int[] interactions;

    public void getData(int userId)
    {
        User temp = UserOption.readUser(userId);
        interactions = InteractionOption.getInteraction(userId);
        
        this.userId = userId;
        username = temp.username;
        isVerified = temp.isVerified;
    }


    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getBio() {
        return this.bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int[] getInteractions() {
        return this.interactions;
    }

    public void setInteractions(int[] interactions) {
        this.interactions = interactions;
    }



    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", username='" + getUsername() + "'" +
            ", isVerified='" + getIsVerified() + "'" +
            ", bio='" + getBio() + "'" +
            "}";
    }
    
}
