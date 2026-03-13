package guc.supermarket.tests;

import org.junit.*;
import static org.junit.Assert.*;
import guc.supermarket.products.GroceryProduct;

public class GroceryProductTestDrive {
    GroceryProduct product;

    @Before public void setUp() {
        product = new GroceryProduct("Juhayna Greek Yoghurt", 40, 25);
    }
    @Test public void actualPriceTest() {
        assertEquals("The output should be 7.5", 30, product.getActualPrice(), 0);
    }
    @Test public void toStringTest() {
        assertEquals("""
                Name: Juhayna Greek Yoghurt
                Price: 40.0 L.E.
                Discount: 25.0 %""", product.toString());
    }
}