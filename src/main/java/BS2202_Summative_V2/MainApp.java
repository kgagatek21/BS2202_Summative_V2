package BS2202_Summative_V2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class MainApp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
        Scene scene = new Scene(root, 1512, 982);
        primaryStage.setTitle("Labyrinth Library");
        primaryStage.setScene(scene);
        primaryStage.show();

        User myUsr = new User();
        myUsr.setUsername("Hibernate_Dude");
        myUsr.setPassword("password");
        myUsr.setPersonID(1);
        myUsr.setIsUserAdmin(true);
        myUsr.setFullName("Hibernate Dude");

        try
        {
            DatabaseConnection.addUserToDatabase(myUsr);

        }catch (Exception e)
        {
            System.out.println(e);
        }

        List<?> list = DatabaseConnection.getEmployee(1);
        User usr = (User) list.get(0);
        System.out.println(usr.getFullName());
        System.out.println(usr.getUsername());
        System.out.println(usr.getPassword());
        System.out.println(usr.getIsUserAdmin());
        System.out.println(usr.getPersonID());




    }

    public static void main(String[] args) {
        launch(args);
    }
}
