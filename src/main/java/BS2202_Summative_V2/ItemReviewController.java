package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.Item;
import BS2202_Summative_V2.JavaClasses.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.io.IOException;

public class ItemReviewController {

    public Rating itemRating;
    public Button submitButton;
    public TextField typeHereTextField;

    public Item itemToBeReviewed;

    public Customer customerThatReviews;


    public void handleSubmitButtonAction(ActionEvent event) throws IOException {

        Review newReview = new Review();
        newReview.setReviewTitle(typeHereTextField.getText());
        newReview.setReviewStars((float) itemRating.getRating());
//        newReview.setItemID(itemToBeReviewed.getItemID());
//        newReview.setCustomerID(customerThatReviews.getPersonID());

//        This is commented out because I cant get itemToBeReviewed and customerThatReviews to be passed from previous screens
//        DatabaseConnection.addReviewToDatabase(newReview);
        System.out.println("Item Review Successful (not really)");

        Stage stage = (Stage) submitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen_admin.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();
    }
}
