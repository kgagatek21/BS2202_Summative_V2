import BS2202_Summative_V2.Customer;
import BS2202_Summative_V2.DatabaseConnection;
import BS2202_Summative_V2.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
}
