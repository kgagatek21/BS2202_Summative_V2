package BS2202_Summative_V2;


import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SelectItemForReviewController implements Initializable
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

    public void handleFilterForBooksButtonAction(ActionEvent event) {
    }

    public void handleFilterForMoviesButtonAction(ActionEvent event) {
    }

    public void handleFilterForMusicButtonAction(ActionEvent event) {
    }

    public void handleContinueButtonAction(ActionEvent event) throws IOException {
        Item item = itemTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("review_item_customer_name.fxml"));
        Parent root = loader.load();


        ReviewItemCustomerNameController controller = loader.getController();
        controller.receiveInformation(loggedinUser, item);

        Scene changeScene = new Scene(root, 1512, 982);
        stage.setScene(changeScene);
        stage.show();

    }
}
