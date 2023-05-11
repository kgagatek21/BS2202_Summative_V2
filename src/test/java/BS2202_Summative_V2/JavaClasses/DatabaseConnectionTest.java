package BS2202_Summative_V2.JavaClasses;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;

public class DatabaseConnectionTest {

    @Test
    void getUserTest()
    {
        List<?> list = DatabaseConnection.getUser(1);
        User user = (User) list.get(0);

        assertEquals(1, user.getPersonID());

    }

    @Test
    void getItemTest()
    {
        List<?> list = DatabaseConnection.getItem(1);
        Item item = (Item) list.get(0);

        assertEquals(1, item.getItemID());
    }

    @Test
    void getCustomerTest()
    {
        List<?> list = DatabaseConnection.getCustomer(1);
        Customer customer = (Customer) list.get(0);

        assertEquals(1, customer.getPersonID());
    }

}
