package BS2202_Summative_V2;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemsOnLoan {
    @Id
    private int loanID;
    private int itemID;
    private int customerID;
    private  int startUserID;
    private int endUserID;
    private String startDate;
    private String expectedEndDate;
    private String actualEndDate;
    private float lateFeesAccumulated;
    private boolean loanIsLive;

    public void setLoanID(int loanID) {
        this.loanID = loanID;
    }

    public int getLoanID() {
        return loanID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setStartUserID(int startUserID) {
        this.startUserID = startUserID;
    }

    public int getStartUserID() {
        return startUserID;
    }

    public void setEndUserID(int endUserID) {
        this.endUserID = endUserID;
    }

    public int getEndUserID() {
        return endUserID;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setExpectedEndDate(String expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public String getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public String getActualEndDate() {
        return actualEndDate;
    }

    public void setLateFeesAccumulated(float lateFeesAccumulated) {
        this.lateFeesAccumulated = lateFeesAccumulated;
    }

    public float getLateFeesAccumulated() {
        return lateFeesAccumulated;
    }

    public void setLoanIsLive(boolean live) {
        loanIsLive = live;
    }

    public boolean isLoanIsLive() {
        return loanIsLive;
    }
}
