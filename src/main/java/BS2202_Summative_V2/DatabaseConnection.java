package BS2202_Summative_V2;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;
public class DatabaseConnection
{
    static Session databaseSession = null;
    static SessionFactory sessionFactory = null;

    private static void openDBSession()
    {
        // configure hibernate for application (one per database) & allows creation of sessions
        sessionFactory = new Configuration().configure().buildSessionFactory();
        // used to get a physical connection with the database
        databaseSession = sessionFactory.openSession();
    }
    private static void closeDBSession()
    {
        // close session and the session factory instances
        sessionFactory.close();
        databaseSession.close();
        sessionFactory = null;
        databaseSession = null;
    }

    public static void addUserToDatabase(User userToAdd)
    {
        openDBSession();
//        userToAdd.setPersonID(getNextID());
        databaseSession.beginTransaction();
        databaseSession.save(userToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }
    public static List<?> getUser(int userID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from User where personID = "+userID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }

    public static void addCustomerToDatabase(Customer customerToAdd)
    {
        openDBSession();
        databaseSession.beginTransaction();
        databaseSession.save(customerToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }

    public static List<?> getCustomer(int customerID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from Customer where personID = "+customerID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }

    public static void addItemToDatabase(Item itemToAdd)
    {
        openDBSession();
        databaseSession.beginTransaction();
        databaseSession.save(itemToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }

    public static List<?> getItem(int itemID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from Item where itemID = "+itemID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }

    public static void addReviewToDatabase(Review reviewToAdd)
    {
        openDBSession();
        databaseSession.beginTransaction();
        databaseSession.save(reviewToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }

    public static List<?> getReview(int reviewID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from Review where reviewID = "+reviewID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }

    public static void addLoanToDatabase(ItemsOnLoan loanToAdd)
    {
        openDBSession();
        databaseSession.beginTransaction();
        databaseSession.save(loanToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }

    public static List<?> getLoan(int loanID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from ItemsOnLoan where loanID = "+loanID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }

//    public static int getNextID()
//    {
//        Query query = databaseSession.createQuery("select max(User_ID) from Users ");
//        System.out.println( query.list().get(0));
//        return (Integer) query.list().get(0)+1;
//    }


}
