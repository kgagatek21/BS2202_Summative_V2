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
        userToAdd.setPersonID(getNextID());
        databaseSession.beginTransaction();
        databaseSession.save(userToAdd);
        databaseSession.getTransaction().commit();
        closeDBSession();
    }
    public static List<?> getEmployee(int userID)
    {
        openDBSession();
        Query query = databaseSession.createQuery("from User where personID = "+userID);
        List<?> list = query.list();
        closeDBSession();
        return list;
    }
    private static int getNextID()
    {
        Query query = databaseSession.createQuery("select max(User_ID) from Users ");
        System.out.println( query.list().get(0));
        return (Integer) query.list().get(0)+1;
    }
}
