package BS2202_Summative_V2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpScreen1Controller
{
    public TextField usernameTextField;
    public TextField fullNameTextField;
    public Button nextButton;
    public Button backButton;
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

    public void handleNextButtonAction(ActionEvent event) throws Exception
    {
        if (usernameTextField.getText() == null || usernameTextField.getText().trim().isEmpty()
                || fullNameTextField.getText() == null || fullNameTextField.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Failed");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Full Name and Username");
            alert.showAndWait();
            usernameTextField.clear();
            fullNameTextField.clear();
        }
        else
        {
            Stage stage = (Stage) nextButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/signup_screen_2.fxml"));
            Parent root = loader.load();
            SignUpScreen2Controller controller = loader.getController();
            controller.receiveInformation(getLoggedinUser(), usernameTextField.getText(), fullNameTextField.getText());
            Scene changeScene = new Scene(root, 1512, 982);
            stage.setScene(changeScene);
            stage.show();
        }
    }


    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/main_screen_admin.fxml"));
        Parent root = loader.load();
        MainScreenAdminController controller = loader.getController();
        controller.receiveInformation(getLoggedinUser());
        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();
    }
}
