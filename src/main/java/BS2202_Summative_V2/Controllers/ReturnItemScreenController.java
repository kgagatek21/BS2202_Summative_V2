package BS2202_Summative_V2.Controllers;

import BS2202_Summative_V2.JavaClasses.DatabaseConnection;
import BS2202_Summative_V2.JavaClasses.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReturnItemScreenController implements Initializable {
    public TableView loanTableView;
    public TableColumn customerNameColumn;
    public TableColumn itemNameColumn;
    public TableColumn loanStartDateColumn;
    public TableColumn expReturnDateColumn;
    public TableColumn lateFeesColumn;
    public Button continueButton;
    public Button backButton;

    private String loggedinUser;

    public String getLoggedinUser()
    {

        return loggedinUser;

    }

    public void receiveInformation(String information)
    {

        loggedinUser = information;
        backButton.setGraphic(new ImageView(new Image("/img/return.png")));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        this method would be assigning appropriate attributes of the query to columns
//        and populating the table with values from getLoan method

//        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
//        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
//        loanStartDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
//        expReturnDateColumn.setCellValueFactory(new PropertyValueFactory<>("expReturnDate"));
//        lateFeesColumn.setCellValueFactory(new PropertyValueFactory<>("lateFees"));
//
//
//        loanTableView.setItems(getLoan());
    }

//    public ObservableList<Item> getLoan()
    {
//        The line below should be using an inner join query but I cannot get it to work
//        List<ItemsOnLoan> list1 = DatabaseConnection.getLoan();

//        ObservableList<Item> list = FXCollections.observableArrayList();
//
//        list.addAll(list1);
//
//        return list;
    }

    public void handleContinueButtonAction(ActionEvent event) throws IOException {
//        ItemsOnLoan loan = (ItemsOnLoan) loanTableView.getSelectionModel().getSelectedItem();

        Stage stage = (Stage) continueButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/confirm_item_return_1.fxml"));
        Parent root = loader.load();

        ConfirmItemReturn1Controller controller = loader.getController();
        controller.receiveInformation(loggedinUser);

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/main_screen_admin.fxml"));
            Parent root = loader.load();

            MainScreenAdminController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }else

        {

            Stage stage = (Stage) backButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/BS2202_Summative_v2/FxmlFiles/main_screen.fxml"));
            Parent root = loader.load();

            MainScreenController controller = loader.getController();
            controller.receiveInformation(loggedinUser);

            Scene changeScene = new Scene(root, 600, 400);
            stage.setScene(changeScene);
            stage.show();
        }
    }
}
