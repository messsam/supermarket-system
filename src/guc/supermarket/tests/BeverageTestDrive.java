package guc.supermarket.tests;

import org.junit.*;
import static org.junit.Assert.*;
import guc.supermarket.products.Beverage;
import guc.supermarket.products.SugarLevel;

public class BeverageTestDrive {
    Beverage product;

    @Before public void setUp() {
        product = new Beverage("Pepsi Can", 5, 0, SugarLevel.ADDED_SUGAR);
    }
    @Test public void actualPriceTest() {
        assertEquals("The output should be 5", 5, product.getActualPrice(), 0);
    }
    @Test public void toStringTest() {
        assertEquals("""
                Name: Pepsi Can
                Price: 5.0 L.E.
                Discount: 0.0 %
                Sugar Level: ADDED_SUGAR""", product.toString());
    }
}