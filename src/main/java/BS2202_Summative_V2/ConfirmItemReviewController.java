package BS2202_Summative_V2;

import BS2202_Summative_V2.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void receiveInformation(Item item)
    {
        selectedItem = item;

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        itemLabel.setText(selectedItem.getName());
    }

    public void handleContinueButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("item_review.fxml"));
        Parent root = loader.load();

        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();
    }
}
