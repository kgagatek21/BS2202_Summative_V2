package BS2202_Summative_V2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
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
        ObservableList<Item> list = FXCollections.observableArrayList();

        Item item = new Item();
        item.setName("nnnn");
        item.setType("tttt");
        item.setLength("lllll");
        item.setNoCopiesLoaned(2);
        item.setNoCopiesAvailable(3);
        item.setImageUrl("pic.png");

        list.add(item);

        return list;
    }

    public void handleFilterForBooksButtonAction(ActionEvent event) {
    }

    public void handleFilterForMoviesButtonAction(ActionEvent event) {
    }

    public void handleFilterForMusicButtonAction(ActionEvent event) {
    }

    public void handleContinueButtonAction(ActionEvent event) {

    }
}
