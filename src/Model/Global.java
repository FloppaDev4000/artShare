package Model;

public abstract class Global
{
    public static final String URL = "jdbc:sqlite:res/data.sqlite";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    //public static final String FULL_URL = "jdbc:mysql://c00299231.candept.com:3306/artShare?user=user1&password=pr4ssw0ld4!";

    //public static String getFullUrl(){return FULL_URL;}

    public static String fullUrl()
    {
        return URL + "?user=" + USER + "&password=" + PASSWORD;
    }

}
