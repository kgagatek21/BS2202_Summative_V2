import BS2202_Summative_V2.DatabaseConnection;
import BS2202_Summative_V2.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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

}
