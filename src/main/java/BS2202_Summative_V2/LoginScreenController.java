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

import java.util.Objects;

public class LoginScreenController
{
    @FXML public ImageView usernameImageView;
    @FXML public ImageView passwordImageView;
    @FXML private Button logInButton;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordPasswordField;

    public String getPassword()
    {
        String username = "user";
        return username;
    }
    public String getUsername()
    {
        String password = "user";
        return password;
    }
    public String getAdminUsername()
    {
        String adminUsername = "admin";
        return adminUsername;
    }
    public String getAdminPassword()
    {
        String adminPassword = "admin";
        return adminPassword;
    }

    @FXML protected void handleLogInButtonAction(ActionEvent event) throws Exception
    {
        //thought i could use "==" but it doesn't work so used object.equals() instead
        if ((Objects.equals(usernameTextField.getText(), this.getAdminUsername())) && (Objects.equals(passwordPasswordField.getText(), this.getAdminPassword())))
        {
            Stage stage = (Stage) logInButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen_admin.fxml"));
            Parent root = loader.load();
            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }
        else if ((Objects.equals(usernameTextField.getText(), this.getUsername())) && (Objects.equals(passwordPasswordField.getText(), this.getPassword())))
        {
            Stage stage = (Stage) logInButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen.fxml"));
            Parent root = loader.load();
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
}
