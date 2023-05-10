package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoanItemCustomerNameController implements Initializable
{


    public TableView<Customer> customerTableView;
    public TableColumn<Customer, String> emailColumn;
    public TableColumn<Customer, String> phoneColumn;
    public TableColumn<Customer, String> fullNameColumn;
    public Button addNewCustomerButton;
    public Button continueButton;

    public Item selectedItem;
    public Button backButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String user, Item item)
    {

        loggedinUser = user;
        selectedItem = item;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));


        customerTableView.setItems(getCustomer());
    }

    public ObservableList<Customer> getCustomer()
    {
        List<Customer> list1 = DatabaseConnection.getCustomer();

        ObservableList<Customer> list = FXCollections.observableArrayList();

        list.addAll(list1);

        return list;
    }

    public void handleContinueButtonAction(ActionEvent event) throws IOException {
        Customer customer = customerTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/confirm_item_loan_1.fxml"));
        Parent root = loader.load();

        ConfirmItemLoan1Controller controller = loader.getController();
        controller.receiveInformation(loggedinUser, selectedItem, customer);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleAddNewCustomerButtonAction(ActionEvent event) throws IOException {

        Stage stage = (Stage) addNewCustomerButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/add_new_customer_1.fxml"));
        Parent root = loader.load();

        AddNewCustomer1Controller controller = loader.getController();
        controller.receiveInformation(loggedinUser);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/loan_new_item_screen.fxml"));
        Parent root = loader.load();
        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }
}
