package guc.supermarket.tests;

import org.junit.*;
import static org.junit.Assert.*;
import guc.supermarket.products.DairyProduct;
import guc.supermarket.products.Fat;

public class DairyProductTestDrive {
    DairyProduct product;

    @Before public void setUp() {
        product = new DairyProduct("Juhayna Milk", 10, 25, Fat.HALFCREAM);
    }
    @Test public void actualPriceTest() {
        assertEquals("The output should be 7.5", 7.5, product.getActualPrice(), 2);
    }
    @Test public void toStringTest() {
        assertEquals("""
                Name: Juhayna Milk
                Price: 10.0 L.E.
                Discount: 25.0 %
                Fat Level: HALFCREAM""", product.toString());
    }
}