package BS2202_Summative_V2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfirmItemReturn1Controller {

    // this class would be displaying loan details in order to insure the right loan is being dealt with


    public Button backButton;
    public Label phoneNumberLabel;
    public Label customerNameLabel;
    public Label lateFeesLabel;
    public Label itemLengthLabel;
    public Label emailAddressLabel;
    public Label itemNameLabel;
    public Button confirmReturnButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String information)
    {

        loggedinUser = information;
        backButton.setGraphic(new ImageView(new Image("/img/return.png")));
    }

    public void handleConfirmReturnButtonAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) confirmReturnButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/confirm_item_return_2.fxml"));
        Parent root = loader.load();

        ConfirmItemReturn2Controller controller = loader.getController();
        controller.receiveInformation(loggedinUser);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/return_item_screen.fxml"));
        Parent root = loader.load();

//        MainScreenController controller = loader.getController();
//        controller.receiveInformation(loggedinUser);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
