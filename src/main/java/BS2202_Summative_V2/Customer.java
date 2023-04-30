package BS2202_Summative_V2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends Person
{

    private String fullName;
    private String emailAddress;
    private String phoneNo;


    @Override
    public void setPersonID(int id) {
        super.setPersonID(id);
    }
    @Id
    @Override
    public int getPersonID() {
        return super.getPersonID();
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
