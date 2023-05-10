package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemPrintController implements Initializable {

    public Item selectedItem;
    public Button confirmPrintButton;
    public Label itemNameLabel;
    public Label itemTypeLabel;
    public Label itemLengthLabel;
    public Label lateFeesLabel;
    public Button backButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String user, Item item)
    {

        loggedinUser = user;
        selectedItem = item;
        itemNameLabel.setText(item.getName());
        itemTypeLabel.setText(item.getType());
        itemLengthLabel.setText(item.getLength());
        lateFeesLabel.setText("£0.50 per day");

        backButton.setGraphic(new ImageView(new Image("/img/return.png")));

    }

    public void handleConfirmPrintButtonAction(ActionEvent event) throws IOException {
        //here code for printing a file
        try {
            FileWriter myWriter = new FileWriter(selectedItem.getName() + ".txt");
            myWriter.write("Item Name: " + selectedItem.getName() + "\n" +
                    "Item Type: " + selectedItem.getType() + "\n" +
                    "Item Length: " + selectedItem.getLength() + "\n" +
                    "Item Fees: £0.50 per day");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Successfully wrote to the file.");
            alert.setHeaderText(null);
            alert.setContentText("Successfully wrote to the file.");
            alert.showAndWait();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("An error occurred.");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred. File might already exist.");
            alert.showAndWait();
            e.printStackTrace();
        }

        Stage stage = (Stage) confirmPrintButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/item_print_confirmation.fxml"));
        Parent root = loader.load();
        ItemPrintConfirmationController controller = loader.getController();
        controller.receiveInformation(loggedinUser);
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/loan_new_item_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
