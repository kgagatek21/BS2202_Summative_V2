package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AddNewCustomer2Controller {
    public Button addButton;
    public TextField emailTextField;
    public TextField confirmEmailTextField;
    private String loggedinUser;

    private String fullName;

    private String phoneNo;

    public void receiveInformation(String _user, String _fullName, String _phoneNo)
    {

        loggedinUser = _user;
        fullName = _fullName;
        phoneNo = _phoneNo;

    }

    public void handleAddButtonAction(ActionEvent event) throws IOException {

        if(Objects.equals(emailTextField.getText(), confirmEmailTextField.getText())) {
            Customer newCustomer = new Customer();
            newCustomer.setFullName(fullName);
            newCustomer.setEmailAddress(emailTextField.getText());
            newCustomer.setPhoneNo(phoneNo);

            DatabaseConnection.addCustomerToDatabase(newCustomer);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("New Customer Added Successfully!");
            alert.showAndWait();

            Stage stage = (Stage) addButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_new_item_screen.fxml"));
            Parent root = loader.load();

            LoanNewItemScreenController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 1512, 982);
            stage.setScene(changeScene);
            stage.show();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Failed");
            alert.setHeaderText(null);
            alert.setContentText("Emails do not match up, please try again.");
            alert.showAndWait();
            emailTextField.clear();
            confirmEmailTextField.clear();
        }
    }
}
