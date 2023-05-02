package BS2202_Summative_V2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;


public class MainApp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
//        Scene scene = new Scene(root, 1512, 982);
//        primaryStage.setTitle("Labyrinth Library");
//        primaryStage.setScene(scene);
//        primaryStage.show();

//        User myUsr = new User();
//        myUsr.setUsername("Hibernate_Dude12345678");
//        myUsr.setPassword("password12345678");
//        myUsr.setIsUserAdmin(true);
//        myUsr.setFullName("Hibernate Dude12345678");
//        DatabaseConnection.addUserToDatabase(myUsr);
//
//        List<?> list = DatabaseConnection.getUser(8);
//        User usr = (User) list.get(0);
//        System.out.println(usr.getFullName());
//        System.out.println(usr.getUsername());
//        System.out.println(usr.getPassword());
//        System.out.println(usr.getIsUserAdmin());
//        System.out.println(usr.getPersonID());


        Customer myCust = new Customer();
        myCust.setFullName("New Customer");
        myCust.setEmailAddress("new.customer@email.com");
        myCust.setPhoneNo("07771 234545");
        DatabaseConnection.addCustomerToDatabase(myCust);
        List<?> list = DatabaseConnection.getCustomer(8);
        Customer cust = (Customer) list.get(0);
        System.out.println(cust.getFullName());
        System.out.println(cust.getPersonID());
        System.out.println(cust.getEmailAddress());
        System.out.println(cust.getPhoneNo());






    }

    public static void main(String[] args) {
        launch(args);
    }
}
