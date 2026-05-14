package eg.edu.guc.supermarket.controller;

import java.util.Random;

import eg.edu.guc.supermarket.model.products.GroceryProduct;
import eg.edu.guc.supermarket.model.supermarket.Supermarket;
import eg.edu.guc.supermarket.exceptions.NotEnoughProductException;

public class SupermarketConsole {
	public static void main(String[] args) {
		Supermarket supermarket = new Supermarket();

		// go through all the grocery products in the supermarket
		System.out.println("Visiting:");
		for (GroceryProduct product : supermarket.getProducts()) {
			System.out.println("- " + product);

			// buy a random grocery product
			if (new Random().nextBoolean()) {
				System.out.println("  => Buy");
				try { supermarket.buy(product); }
                catch (NotEnoughProductException e) { e.printStackTrace(); }
			}
		}

		System.out.println("\nCart:");
		// print all the grocery products in the cart
		for (GroceryProduct product : supermarket.getCart().getProducts()) {
			System.out.println("- " + product);
		}
		// print the total of the cart
		System.out.println(String.format("Total: $%.2f", supermarket.getCart().getTotal()));
	}
}