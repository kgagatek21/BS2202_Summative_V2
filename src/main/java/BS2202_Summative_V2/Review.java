package BS2202_Summative_V2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review
{

    @Id
    private int reviewID;

    private int customerID;

    private int itemID;

    private String reviewTitle;

    private float reviewStars;

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setCustomerID(int id) {customerID = id;}

    public int getCustomerID() {
        return customerID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewStars(float reviewStars) {
        this.reviewStars = reviewStars;
    }

    public float getReviewStars() {
        return reviewStars;
    }
}
