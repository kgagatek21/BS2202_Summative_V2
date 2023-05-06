package BS2202_Summative_V2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login_screen.fxml"));
        Scene scene = new Scene(root, 1512, 982);
        primaryStage.setTitle("Labyrinth Library");
        primaryStage.setScene(scene);
        primaryStage.show();


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

//        java.util.Date startDT = new java.util.Date();
//        Date expectedDT = new Date(2023, 6, 16);
//
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String currentTime = sdf.format(startDT);
//        String expectedTime = sdf.format(expectedDT);

//        java.sql.Date startDate = new Date(System.currentTimeMillis());
//
//        ItemsOnLoan myLoan = new ItemsOnLoan();
//        myLoan.setCustomerID(1);
//        myLoan.setItemID(1);
//        myLoan.setStartUserID(1);
//        myLoan.setEndUserID(1);
//        myLoan.setStartDate(startDate);
//        myLoan.setExpectedEndDate("17-05-2023");
//        myLoan.setLateFeesAccumulated(0);
//        myLoan.setLoanIsLive(false);
//        DatabaseConnection.addLoanToDatabase(myLoan);

//        List<?> list = DatabaseConnection.getLoan(1);
//        ItemsOnLoan loan = (ItemsOnLoan) list.get(0);
//        System.out.println(loan.getLoanID());
//        System.out.println(loan.getCustomerID());
//        System.out.println(loan.getItemID());
//        System.out.println(loan.getStartUserID());
//        System.out.println(loan.getEndUserID());
//        System.out.println(loan.getStartDate());
//        System.out.println(loan.getExpectedEndDate());
//        System.out.println(loan.getActualEndDate());
//        System.out.println(loan.getLateFeesAccumulated());
//        System.out.println(loan.isLoanIsLive());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
