package Objects;

import Model.*;

public class User
{
    public int userId;
    public String username;
    public boolean isVerified;

    public void getData(int userId)
    {
        User temp = UserOption.readUser(userId);
        int[] interactions = InteractionOption.getInteraction(userId);
        
        this.userId = userId;
        username = temp.username;
        isVerified = temp.isVerified;
    }
}
