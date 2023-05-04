package BS2202_Summative_V2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    public ListView<String> itemListView;

    public void initialize(URL location, ResourceBundle resources)
    {
        itemListView = new ListView<String>();
//        itemListView.getItems().addAll("Item 1", "item 2", "item 3");

//
//        ObservableList<String> items = FXCollections.observableArrayList (
//                "Single", "Double", "Suite", "Family App");
        itemListView.getItems().add("item 1");

        System.out.println(itemListView.getItems());
    }


    public void handleFilterForBooksButtonAction(ActionEvent event) {
    }

    public void handleFilterForMoviesButtonAction(ActionEvent event) {
    }

    public void handleFilterForMusicButtonAction(ActionEvent event) {
    }

    public void handleContinueButtonAction(ActionEvent event) {
        itemListView = new ListView<>();
        itemListView.getItems().addAll("Item 1", "item 2", "item 3");
    }
}
