package BS2202_Summative_V2;

public class Admin extends Employee
{
    public Admin(String _username, String _password)
    {
        super(_username, _password);

    }

    public boolean isAdmin()
    {
        return true;
    }

}
