package BS2202_Summative_V2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenAdminController implements Initializable
{

    @FXML public Button loanNewItemButton;
    @FXML public Button submitReviewButton;
    @FXML public Button returnItemButton;
    @FXML public Button createNewUserButton;
    @FXML public Button logoutButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }
    public void receiveInformation(String information)
    {
        loggedinUser = information;
    }

    @FXML public void handleLogoutButton(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();

    }

    @FXML public void handleSubmitReviewButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) submitReviewButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("select_item_for_review.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleReturnItemButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) returnItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("return_item_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleCreateNewUserButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) createNewUserButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup_screen_1.fxml"));
        Parent root = loader.load();
        SignUpScreen1Controller controller = loader.getController();
        controller.receiveInformation(getLoggedinUser());
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleLoanNewItemButton(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) loanNewItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_new_item_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(loggedinUser);
    }
}
