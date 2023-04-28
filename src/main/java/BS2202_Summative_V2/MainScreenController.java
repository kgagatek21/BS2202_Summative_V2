package BS2202_Summative_V2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreenController
{
    @FXML public Button loanNewItemButton;
    @FXML public Button submitReviewButton;
    @FXML public Button returnItemButton;


    @FXML public void handleLoanNewItemButtonAction(ActionEvent event) throws Exception
    {
        Stage stage = (Stage) loanNewItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_new_item_screen.fxml"));
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
}
