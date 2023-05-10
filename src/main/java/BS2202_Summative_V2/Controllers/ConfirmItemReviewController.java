package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmItemReviewController implements Initializable
{
    public Button continueButton;
    public Label itemLabel;

    public Item selectedItem;
    public Label sureReviewItemLabel;
    public Button backButton;

    private String loggedinUser;

    private Customer selectedCustomer;

    public String getLoggedinUser()
    {

        return loggedinUser;

    }

    public void receiveInformation(String user, Item item, Customer customer)
    {
        selectedCustomer = customer;
        loggedinUser = user;
        selectedItem = item;
        sureReviewItemLabel.setText("Are you sure you want to review this item \n " +
                "for Customer: " + customer.getFullName() + " ?");
        itemLabel.setText("Item: " + item.getName());
        backButton.setGraphic(new ImageView(new Image("/img/return.png")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        itemLabel.setText(selectedItem.getName());
    }

    public void handleContinueButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/item_review.fxml"));
        Parent root = loader.load();

        ItemReviewController controller = loader.getController();
        controller.receiveInformation(loggedinUser,selectedItem,selectedCustomer);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/select_item_for_review.fxml"));
        Parent root = loader.load();

        SelectItemForReviewController controller = loader.getController();
        controller.receiveInformation(loggedinUser);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
