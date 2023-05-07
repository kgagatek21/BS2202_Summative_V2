package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewCustomer1Controller {

    public Button nextButton;
    public TextField fullNameTextField;
    public TextField phoneNumberTextField;
    public Button backButton;
    private String loggedinUser;
    
    public void receiveInformation(String user)
    {

        loggedinUser = user;

    }

    public void handleNextButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) nextButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add_new_customer_2.fxml"));
        Parent root = loader.load();

        AddNewCustomer2Controller controller = loader.getController();
        controller.receiveInformation(loggedinUser, fullNameTextField.getText(), phoneNumberTextField.getText());

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();

    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_item_customer_name.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
