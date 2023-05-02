package BS2202_Summative_V2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Date;
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


//        Review myRev = new Review();
//        myRev.setCustomerID(3);
//        myRev.setItemID(3);
//        myRev.setReviewTitle("Very Good");
//        myRev.setReviewStars(4.5F);
//
//        DatabaseConnection.addReviewToDatabase(myRev);
//        List<?> list = DatabaseConnection.getReview(3);
//        Review review = (Review) list.get(0);
//        System.out.println(review.getReviewID());
//        System.out.println(review.getCustomerID());
//        System.out.println(review.getItemID());
//        System.out.println(review.getReviewTitle());
//        System.out.println(review.getReviewStars());

        java.util.Date startDT = new java.util.Date();
        Date expectedDT = new Date(2023, 6, 16);

        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String currentTime = sdf.format(startDT);
        String expectedTime = sdf.format(expectedDT);

        ItemsOnLoan myLoan = new ItemsOnLoan();
        myLoan.setCustomerID(1);
        myLoan.setItemID(1);
        myLoan.setStartUserID(1);
        myLoan.setEndUserID(1);
        myLoan.setStartDate(currentTime);
        myLoan.setExpectedEndDate(expectedTime);
        myLoan.setLateFeesAccumulated(0);
        myLoan.setLoanIsLive(true);
        DatabaseConnection.addLoanToDatabase(myLoan);







    }

    public static void main(String[] args) {
        launch(args);
    }
}
