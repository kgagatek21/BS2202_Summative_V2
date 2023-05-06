package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemPrintConfirmationController {
    public Button returnToItemListButton;
    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String user)
    {

        loggedinUser = user;

    }
    public void handleReturnToItemListButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) returnToItemListButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_new_item_screen.fxml"));
        Parent root = loader.load();
        LoanNewItemScreenController controller = loader.getController();
        controller.receiveInformation(loggedinUser);
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
