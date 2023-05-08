package BS2202_Summative_V2;

import BS2202_Summative_V2.JavaClasses.Customer;
import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.Item;
import BS2202_Summative_V2.JavaClasses.User;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoanNewItemScreenController implements Initializable
{

    public ImageView returnImageView;
    public Button filterForBooksButton;
    public Button filterForMoviesButton;
    public Button filterForMusicButton;
    public TextField searchTextField;

    public Button continueButton;
    public TableView<Item> itemTableView;
    public TableColumn<Item, String> nameColumn;
    public TableColumn<Item, String> typeColumn;
    public TableColumn<Item, String> lengthColumn;
    public TableColumn<Item, Integer> copiesLoanedColumn;
    public TableColumn<Item, Integer> copiesAvailableColumn;
    public Button printItemButton;
    public Button backButton;
    public Button showItemImageButton;
    public Button searchButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String information)
    {
        loggedinUser = information;
    }

    public void initialize(URL location, ResourceBundle resources)
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        copiesLoanedColumn.setCellValueFactory(new PropertyValueFactory<>("noCopiesLoaned"));
        copiesAvailableColumn.setCellValueFactory(new PropertyValueFactory<>("noCopiesAvailable"));

        itemTableView.setItems(getItem());
    }


    public ObservableList<Item> getItem()
    {
        List<Item> list1 = DatabaseConnection.getItem();

        ObservableList<Item> list = FXCollections.observableArrayList();

        list.addAll(list1);

        return list;
    }

    public void handlePrintItemButtonAction(ActionEvent event) throws IOException {

        Item item = itemTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) printItemButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("item_print.fxml"));
        Parent root = loader.load();

        ItemPrintController controller = loader.getController();
        controller.receiveInformation(loggedinUser, item);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();

    }

    public void handleContinueButtonAction(ActionEvent event) throws IOException {
        Item item = itemTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loan_item_customer_name.fxml"));
        Parent root = loader.load();

        LoanItemCustomerNameController controller = loader.getController();
        controller.receiveInformation(loggedinUser, item);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();

    }

    public void handleBackButtonAction(ActionEvent event) throws IOException {
        List<?> list = DatabaseConnection.getUser(loggedinUser);
        User user = (User) list.get(0);

        if (user.isUserAdmin)
        {
            Stage stage = (Stage) backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen_admin.fxml"));
            Parent root = loader.load();

            MainScreenAdminController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }else

        {

            Stage stage = (Stage) backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main_screen.fxml"));
            Parent root = loader.load();

            MainScreenController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }
    }

    public void handleShowItemImageButtonAction(ActionEvent event) throws IOException {
        Item item = itemTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) showItemImageButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("item_image.fxml"));
        Parent root = loader.load();

        ItemImageController controller = loader.getController();
        controller.receiveInformation(loggedinUser, item);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();
    }

    public void handleSearchButtonAction(ActionEvent event) {

        if (!(searchTextField.getText() == null)) {
            List<Item> list = DatabaseConnection.getItem(searchTextField.getText());
            ObservableList<Item> list1 = FXCollections.observableArrayList();
            list1.addAll(list);
            itemTableView.setItems(list1);
        }else
        {
            itemTableView.setItems(getItem());
        }
    }
}
