package guc.supermarket.tests;

import org.junit.*;
import static org.junit.Assert.*;
import guc.supermarket.cart.Cart;
import guc.supermarket.products.*;

public class CartTestDrive {
    @Test public void addProductTest() {
        Cart cart = new Cart();
        cart.addProduct(new DairyProduct("Milk", 53, 0, Fat.FULLCREAM));
        assertEquals("It should be of length 1", 1, cart.size());
    }
}