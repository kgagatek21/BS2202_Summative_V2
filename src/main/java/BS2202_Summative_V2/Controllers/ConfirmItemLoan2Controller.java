package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ConfirmItemLoan2Controller {
    public Button returnToMainMenuButton;
    public Button backButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String user) {

        loggedinUser = user;
    }

    public void handleReturnToMainMenuButtonAction(ActionEvent event) throws IOException {


        List<?> list = DatabaseConnection.getUser(loggedinUser);
        User user = (User) list.get(0);

        if (user.isUserAdmin)
        {
            Stage stage = (Stage) returnToMainMenuButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlFiles/main_screen_admin.fxml"));
            Parent root = loader.load();

            MainScreenAdminController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }else

            {

                Stage stage = (Stage) returnToMainMenuButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlFiles/main_screen.fxml"));
                Parent root = loader.load();

                MainScreenController controller = loader.getController();
                controller.receiveInformation(loggedinUser);

                Scene changeScene = new Scene(root, 600, 400);
                stage.setScene(changeScene);
                stage.show();
            }

    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlFiles/confirm_item_loan_1.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
