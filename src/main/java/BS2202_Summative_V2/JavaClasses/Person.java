package BS2202_Summative_V2.JavaClasses;

import javax.persistence.*;

@Entity
public class Person
{
    protected String fullName;

    protected int personID;

    public Person(int id, String _fullName) {
        personID = id;
        fullName = _fullName;
    }

    public Person() {

    }
    @Id
    public int getPersonID() {return personID;}
    public void setPersonID(int id) {personID = id;}

    public String getFullName() {return fullName;}
    public void setFullName(String _fullName) {fullName=_fullName;}


}
