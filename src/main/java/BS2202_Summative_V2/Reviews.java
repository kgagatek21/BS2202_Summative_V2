package BS2202_Summative_V2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reviews
{

    @Id
    private Long reviewID;

    private Long customerID;

    private Long itemID;

    private String reviewTitle;

    private float reviewStars;

    public void setReviewID(Long reviewID) {
        this.reviewID = reviewID;
    }

    public Long getReviewID() {
        return reviewID;
    }

    public void setCustomerID(Long id) {customerID = id;}

    public Long getCustomerID() {
        return customerID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getItemID() {
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
