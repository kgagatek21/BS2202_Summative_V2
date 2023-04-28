package BS2202_Summative_V2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginScreenController
{
    @FXML private Button logInButton;
    @FXML private TextField usernameTextField;

    private String username = new String("admin");
    private String password = new String("admin");
    public String getPassword()
    {
        return password;
    }
    public String getUsername()
    {
        return username;
    }

    @FXML protected void handleLogInButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 600, 400);
        stage.setScene(changeScene);
        stage.show();

    }




}
