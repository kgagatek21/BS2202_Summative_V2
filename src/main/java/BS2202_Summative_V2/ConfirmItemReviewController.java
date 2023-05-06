package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        itemLabel.setText(selectedItem.getName());
    }

    public void handleContinueButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("item_review.fxml"));
        Parent root = loader.load();

        ItemReviewController controller = loader.getController();
        controller.receiveInformation(loggedinUser,selectedItem,selectedCustomer);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
