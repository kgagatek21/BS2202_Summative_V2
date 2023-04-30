package BS2202_Summative_V2;

import javax.persistence.*;

@Entity
public class User extends Person
{
    protected String username;
    protected String password;
    protected boolean isUserAdmin;

    public User(int id, String _username, String _password, String _fullName)
    {
        super(id, _fullName);
        this.username = _username;
        this.password = _password;
    }

    public User() {

    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String _username){username=_username;}

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String _password) {password = _password;}

    public void setIsUserAdmin(boolean isAdmin) {
        this.isUserAdmin = isAdmin;
    }

    public boolean getIsUserAdmin() {
        return isUserAdmin;
    }
}
