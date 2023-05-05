package BS2202_Summative_V2;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class ItemsOnLoan {
    @Id
    private int loanID;


    private int itemID;
    private int customerID;
    private  int startUserID;
    private int endUserID;
    @Temporal(TemporalType.DATE)
    private java.sql.Date startDate;
    @Temporal(TemporalType.DATE)
    private java.sql.Date expectedEndDate;
    @Temporal(TemporalType.DATE)
    private java.sql.Date actualEndDate;
    private float lateFeesAccumulated;
    private boolean loanIsLive;

//    @ManyToOne (cascade=CascadeType.ALL)
//    @JoinColumn (name = "Item_ID")
//    private Item items;


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

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public java.sql.Date getStartDate() {
        return startDate;
    }

    public void setExpectedEndDate(String expectedEndDate) throws ParseException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = dateformatter.parse(expectedEndDate);
        long msec = date.getTime();

        this.expectedEndDate = new java.sql.Date(msec);
    }

    public void setExpectedEndDate(java.sql.Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    public java.sql.Date getExpectedEndDate() {
        return expectedEndDate;
    }

    public void setActualEndDate(java.sql.Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public java.sql.Date getActualEndDate() {
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
