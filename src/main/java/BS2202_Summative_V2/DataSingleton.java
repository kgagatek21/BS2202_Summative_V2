package BS2202_Summative_V2;

public class DataSingleton
{
    private final static DataSingleton instance = new DataSingleton();

    private String username;

    DataSingleton(){}

    public static DataSingleton getInstance()
    {
        return instance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String _user)
    {
        username = _user;
    }
}
