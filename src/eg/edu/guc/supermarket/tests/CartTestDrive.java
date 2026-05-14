package eg.edu.guc.supermarket.tests;

import org.junit.*;
import static org.junit.Assert.*;
import eg.edu.guc.supermarket.model.cart.Cart;
import eg.edu.guc.supermarket.model.products.*;

public class CartTestDrive {
    @Test public void addProductTest() {
        Cart cart = new Cart();
        cart.addProduct(new DairyProduct("Milk", 53, 0, Fat.FULLCREAM));
        assertEquals("It should be of length 1", 1, cart.size());
    }
}