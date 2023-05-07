package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.Item;
import BS2202_Summative_V2.JavaClasses.ItemsOnLoan;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

public class ConfirmItemLoan1Controller {
    public Item selectedItem;
    public Customer selectedCustomer;
    public Button confirmLoanButton;


    public Label itemNameLabel;
    public Label emailAddressLabel;
    public Label itemLengthLabel;
    public Label lateFeesLabel;
    public Label customerNameLabel;
    public Label phoneNumberLabel;
    public Button backButton;


    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String user, Item item, Customer customer)
    {

        loggedinUser = user;
        selectedItem = item;
        selectedCustomer = customer;
        itemNameLabel.setText(item.getName());
        itemLengthLabel.setText(item.getLength());
        lateFeesLabel.setText("£0.50 per day");
        customerNameLabel.setText(customer.getFullName());
        emailAddressLabel.setText(customer.getEmailAddress());
        phoneNumberLabel.setText(customer.getPhoneNo());

    }

    public void handleConfirmLoanButtonAction(ActionEvent event) throws ParseException {
        try {
            ItemsOnLoan loan = new ItemsOnLoan();
            loan.setItemID(selectedItem.getItemID());
            loan.setCustomerID(selectedCustomer.getPersonID());
            loan.setLoanIsLive(true);
            loan.setStartUserID(1);
            loan.setEndUserID(1);
            loan.setStartDate(new Date(System.currentTimeMillis()));
            loan.setExpectedEndDate("30-06-2023");
            loan.setLateFeesAccumulated(0);

            DatabaseConnection.addLoanToDatabase(loan);

            Stage stage = (Stage) confirmLoanButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("confirm_item_loan_2.fxml"));
            Parent root = loader.load();

            ConfirmItemLoan2Controller controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 1512, 982);
            stage.setScene(changeScene);
            stage.show();

        }catch (Exception e)
        {
            System.out.println(e);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Action Failed");
            alert.setHeaderText(null);
            alert.setContentText("Action Failed, please try again");
            alert.showAndWait();

        }



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
