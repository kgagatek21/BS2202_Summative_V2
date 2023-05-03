package BS2202_Summative_V2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;
import java.util.Objects;

public class LoginScreenController
{
    @FXML public ImageView usernameImageView;
    @FXML public ImageView passwordImageView;
    @FXML private Button logInButton;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;


    @FXML protected void handleLogInButtonAction(ActionEvent event) throws Exception
    {
        try
        {
            List<?> list = DatabaseConnection.getUser(usernameTextField.getText());
            User user = (User) list.get(0);


            //thought i could use "==" but it doesn't work so used object.equals() instead
            if ((user.isUserAdmin) && (Objects.equals(passwordPasswordField.getText(), user.getPassword())))
            {
                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen_admin.fxml"));
                Parent root = loader.load();
                MainScreenAdminController controller = loader.getController();
                controller.receiveInformation(user.getUsername());
                Scene changeScene = new Scene(root, 600, 400);
                stage.setScene(changeScene);
                stage.show();
            }
            else if (!(user.isUserAdmin) && (Objects.equals(passwordPasswordField.getText(), user.getPassword())))
            {
                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen.fxml"));
                Parent root = loader.load();
                MainScreenController controller = loader.getController();
                controller.receiveInformation(user.getUsername());
                Scene changeScene = new Scene(root, 600, 400);
                stage.setScene(changeScene);
                stage.show();
            }
            else
            {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Login Credentials Invalid, Please Try Again");
                alert.showAndWait();
                usernameTextField.clear();
                passwordPasswordField.clear();
            }
        }
        catch(Exception e)
        {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Login Credentials Invalid, Please Try Again");
            alert.showAndWait();
            usernameTextField.clear();
            passwordPasswordField.clear();
        }
    }
}
