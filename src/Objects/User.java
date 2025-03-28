package Objects;

import Model.*;

public class User
{
    public int userId;
    public String username;
    public boolean isVerified;
    public String bio;

    public void getData(int userId)
    {
        User temp = UserOption.readUser(userId);
        int[] interactions = InteractionOption.getInteraction(userId);
        
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

    public boolean isVerified() {
        return this.isVerified;
    }

    public boolean getIsVerified() {
        return this.isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }



    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", username='" + getUsername() + "'" +
            ", isVerified='" + isVerified() + "'" +
            ", bio='" + bio + "'" +
            "}";
    }
    
}
