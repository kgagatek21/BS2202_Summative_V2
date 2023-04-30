package BS2202_Summative_V2;

public class User extends Person
{
    protected String username;
    protected String password;

    public User(String _username, String _password, String _fullName)
    {
        super(_fullName);
        this.username = _username;
        this.password = _password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

}
