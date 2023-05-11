package BS2202_Summative_V2.JavaClasses;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ItemTest {


    private final Item item = new Item(1, "Harry Potter", "400 pages", "Hardcover Book",
                                        10, 2, "/img/hp.png");

    @Test
    void getItemIDTest()
    {
        assertEquals(1, item.getItemID());
    }

    @Test
    void getNameTest()
    {
        assertEquals("Harry Potter", item.getName());
    }

    @Test
    void getLengthTest()
    {
        assertEquals("400 pages", item.getLength());
    }

    @Test
    void getTypeTest()
    {
        assertEquals("Hardcover Book", item.getType());
    }

    @Test
    void getNoCopiesAvailableTest()
    {
        assertEquals(10, item.getNoCopiesAvailable());
    }

    @Test
    void getNoCopiesLoanedTest()
    {
        assertEquals(3, item.getNoCopiesLoaned());
    }

    @Test
    void getImageUrlTest()
    {
        assertEquals("/img/hp.png", item.getImageUrl());
    }

}
