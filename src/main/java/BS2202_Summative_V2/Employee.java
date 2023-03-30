package BS2202_Summative_V2;

public class Employee {
    protected String username;
    protected String password;

    public Employee(String _username, String _password)
    {
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
