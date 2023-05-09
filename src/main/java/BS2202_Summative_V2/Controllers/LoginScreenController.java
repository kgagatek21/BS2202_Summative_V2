package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

//    DataSingleton data = new DataSingleton();


    @FXML protected void handleLogInButtonAction(ActionEvent event) throws Exception
    {


        try
        {
            List<?> list = DatabaseConnection.getUser(usernameTextField.getText());
            User user = (User) list.get(0);
//            data.setUsername(user.getUsername());
            System.out.println("login screen user:" + usernameTextField.getText());




            //thought I could use "==" but it doesn't work so used object.equals() instead
            if ((user.isUserAdmin) && (Objects.equals(passwordPasswordField.getText(), user.getPassword())))
            {

                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlFiles/main_screen_admin.fxml"));
                Parent root = loader.load();

                MainScreenAdminController controller = loader.getController();
                controller.receiveInformation(usernameTextField.getText());


                Scene changeScene = new Scene(root, 600, 400);
                stage.setScene(changeScene);
                stage.show();

            }
            else if (!(user.isUserAdmin) && (Objects.equals(passwordPasswordField.getText(), user.getPassword())))
            {
                Stage stage = (Stage) logInButton.getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FxmlFiles/main_screen.fxml"));
                Parent root = loader.load();

                MainScreenController controller = loader.getController();
                controller.receiveInformation(usernameTextField.getText());

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
            System.out.println(e);
        }
    }
}
