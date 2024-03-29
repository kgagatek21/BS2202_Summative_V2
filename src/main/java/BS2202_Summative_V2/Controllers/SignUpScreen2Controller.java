package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignUpScreen2Controller
{
    public Button createUserButton;
    public PasswordField confirmPasswordPasswordField;
    public PasswordField passwordPasswordField;
    public Button backButton;
    private String loggedinUser;
    private String newUsername;
    private String newFullname;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String loggedinUser_, String newUsername_, String newFullname_)
    {
        loggedinUser = loggedinUser_;
        newFullname = newFullname_;
        newUsername = newUsername_;
        backButton.setGraphic(new ImageView(new Image("/img/return.png")));

    }


    public void handleCreateUserButtonAction(ActionEvent event) throws Exception
    {
        if (passwordPasswordField.getText() == null || passwordPasswordField.getText().trim().isEmpty()
                || confirmPasswordPasswordField.getText() == null || confirmPasswordPasswordField.getText().trim().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Failed");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Password and Confirm Password");
            alert.showAndWait();
            passwordPasswordField.clear();
            confirmPasswordPasswordField.clear();
        }
        else if (!(Objects.equals(passwordPasswordField.getText(), confirmPasswordPasswordField.getText())))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Failed");
            alert.setHeaderText(null);
            alert.setContentText("Please Make Sure The Passwords Are The Same");
            alert.showAndWait();
            passwordPasswordField.clear();
            confirmPasswordPasswordField.clear();
        }
        else
        {
            //here code for database connection  and query
            User newUsr = new User();
            newUsr.setFullName(newFullname);
            newUsr.setUsername(newUsername);
            newUsr.setPassword(passwordPasswordField.getText());
            newUsr.setIsUserAdmin(false);
            DatabaseConnection.addUserToDatabase(newUsr);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Successful");
            alert.setHeaderText(null);
            alert.setContentText("New User Registered Successfully");
            alert.showAndWait();

            Stage stage = (Stage) createUserButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/main_screen_admin.fxml"));
            Parent root = loader.load();
            MainScreenAdminController controller = loader.getController();
            controller.receiveInformation(getLoggedinUser());
            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();

        }
    }

    public void handleBackButton(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/signup_screen_1.fxml"));
        Parent root = loader.load();
        SignUpScreen1Controller controller = loader.getController();
        controller.receiveInformation(getLoggedinUser());
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/signup_screen_1.fxml"));
        Parent root = loader.load();
        MainScreenAdminController controller = loader.getController();
        controller.receiveInformation(getLoggedinUser());
        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();
    }
}
