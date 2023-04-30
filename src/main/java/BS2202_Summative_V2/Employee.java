package BS2202_Summative_V2;

import javax.persistence.*;
@Entity
public class Employee
{
    private int employeeID;
    private String name;
    private String gender;
    private int deptNo;
    @Id
    public int getEmployeeID()
    {
        return employeeID;
    }
    public void setEmployeeID(int newID)
    {
        employeeID = newID;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public String getGender()
    {
        return gender;
    }
    public void setGender(String newGender)
    {
        gender = newGender;
    }
    public int getDeptNo()
    {
        return deptNo;
    }
    public void setDeptNo(int newDeptNo)
    {
        deptNo = newDeptNo;
    }
}
