package BS2202_Summative_V2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenAdminController implements Initializable
{

    @FXML public Button loanNewItemButton;
    @FXML public Button submitReviewButton;
    @FXML public Button returnItemButton;
    @FXML public Button createNewUserButton;
    @FXML public Button logoutButton;
    public Button backButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }
    public void receiveInformation(String information)
    {

        loggedinUser = information;
        backButton.setGraphic(new ImageView(new Image("/img/logout.png")));
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

    @FXML public void handleCreateNewUserButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) createNewUserButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/signup_screen_1.fxml"));
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/loan_new_item_screen.fxml"));
        Parent root = loader.load();
        LoanNewItemScreenController controller = loader.getController();
        controller.receiveInformation(loggedinUser);
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/login_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
        System.out.println("main admin screen: " + loggedinUser);
    }
}
