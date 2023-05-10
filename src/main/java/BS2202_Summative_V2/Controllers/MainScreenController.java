package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.DataSingleton;
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

public class MainScreenController implements Initializable
{
    @FXML public Button loanNewItemButton;
    @FXML public Button submitReviewButton;
    @FXML public Button returnItemButton;
    @FXML public Button logoutButton;
    private String loggedinUser;

    DataSingleton data = DataSingleton.getInstance();


    public void receiveInformation(String information)
    {
        loggedinUser = information;
    }

    @FXML public void handleLoanNewItemButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) loanNewItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/loan_new_item_screen.fxml"));
        Parent root = loader.load();
        LoanNewItemScreenController controller = loader.getController();
        controller.receiveInformation(loggedinUser);
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleSubmitReviewButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) submitReviewButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/select_item_for_review.fxml"));
        Parent root = loader.load();
        SelectItemForReviewController controller = loader.getController();
        controller.receiveInformation(loggedinUser);
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleReturnItemButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) returnItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/return_item_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @FXML public void handleLogoutButton(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/login_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
        System.out.println("logged out of main screen: " + loggedinUser);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        System.out.println(data.getUsername());
    }
}
