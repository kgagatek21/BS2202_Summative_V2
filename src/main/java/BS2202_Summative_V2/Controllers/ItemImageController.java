package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ItemImageController {
    public Button returnToItemListButton;
    public Button backButton;
    public ImageView itemImageView;
    private String loggedinUser;

    private Item item;

    public String getLoggedinUser()
    {
        return loggedinUser;
    }

    public void receiveInformation(String _user, Item _item)
    {

        loggedinUser = _user;
        item = _item;


        backButton.setGraphic(new ImageView(new Image("/img/return.png")));

        System.out.println("/" + item.getImageUrl());

        itemImageView.setImage(new Image("/img/johnwick.png"));
        //itemImageView.setImage(new Image("/" + item.getImageUrl()));


    }
    public void handleReturnToItemListButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) returnToItemListButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/loan_new_item_screen.fxml"));
        Parent root = loader.load();
        LoanNewItemScreenController controller = loader.getController();
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
