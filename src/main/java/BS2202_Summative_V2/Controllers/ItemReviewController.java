package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.Item;
import BS2202_Summative_V2.JavaClasses.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

import java.io.IOException;

public class ItemReviewController {

    public Rating itemRating;
    public Button submitButton;
    public TextField typeHereTextField;

    public Item selectedItem;

    private String loggedinUser;

    private Customer selectedCustomer;

    public void receiveInformation(String user, Item item, Customer customer)
    {
        selectedCustomer = customer;
        loggedinUser = user;
        selectedItem = item;

    }


    public void handleSubmitButtonAction(ActionEvent event) throws IOException {

        System.out.println(itemRating.getRating());


        Review newReview = new Review();
        newReview.setReviewTitle(typeHereTextField.getText());
        newReview.setReviewStars((float) itemRating.getRating());
        newReview.setItemID(selectedItem.getItemID());
        newReview.setCustomerID(selectedCustomer.getPersonID());

        DatabaseConnection.addReviewToDatabase(newReview);
        System.out.println("Item Review Successful ");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Item Review Successful");
        alert.setHeaderText(null);
        alert.setContentText("Item Review Successful");
        alert.showAndWait();


        Stage stage = (Stage) submitButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/main_screen_admin.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();
    }
}
