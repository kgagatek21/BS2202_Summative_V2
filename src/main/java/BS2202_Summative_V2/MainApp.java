package BS2202_Summative_V2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application
{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main_screen.fxml")); Scene scene = new Scene(root, 1512, 982);
        stage.setTitle("Labyrinth Library");
        stage.setScene(scene);
        stage.show(); }
}
