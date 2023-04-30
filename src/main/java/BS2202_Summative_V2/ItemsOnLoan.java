package BS2202_Summative_V2;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemsOnLoan {
    @Id
    private Long loanID;
    private Long itemID;
    private Long customerID;
    private  Long startUserID;
    private Long endUserID;
    private Date startDate;
    private Date expectedEndDate;
    private Date actualEndDate;
    private float lateFeesAccumulated;
    private boolean isLive;

    public void setLoanID(Long loanID) {
        this.loanID = loanID;
    }

    public Long getLoanID() {
        return loanID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getItemID() {
        return itemID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setStartUserID(Long startUserID) {
        this.startUserID = startUserID;
    }

    public Long getStartUserID() {
        return startUserID;
    }

    public void setEndUserID(Long endUserID) {
        this.endUserID = endUserID;
    }

    public Long getEndUserID() {
        return endUserID;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setExpectedEndDate(Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public Date getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setLateFeesAccumulated(float lateFeesAccumulated) {
        this.lateFeesAccumulated = lateFeesAccumulated;
    }

    public float getLateFeesAccumulated() {
        return lateFeesAccumulated;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isLive() {
        return isLive;
    }
}
