package guc.supermarket.people;

import guc.supermarket.cart.Cart;
import guc.supermarket.products.*;
import guc.supermarket.exceptions.CannotBuyException;
import guc.supermarket.exceptions.IncorrectFatTypeException;
import guc.supermarket.exceptions.IncorrectSugarLevelException;

public class Customer {
	private String name;
	private Cart myCart;
    private Fat preferableFatLevel;
    private SugarLevel preferableSugarLevel;

    public Customer(String name) {
        this.name = name;
        this.myCart = new Cart();
    }
    public Customer(String name, Cart cart) {
        this.name = name;
        this.myCart = cart;
    }
    public Customer(String name, Fat preferableFatLevel, SugarLevel preferableSugarLevel) {
        this.name = name;
        this.myCart = new Cart();
        this.preferableFatLevel = preferableFatLevel;
        this.preferableSugarLevel = preferableSugarLevel;
    }
	public Customer(String name, Cart cart, Fat preferableFatLevel, SugarLevel preferableSugarLevel) {
        this.name = name;
		this.myCart = cart;
        this.preferableFatLevel = preferableFatLevel;
        this.preferableSugarLevel = preferableSugarLevel;
	}

    public Fat getPreferableFatLevel() { return preferableFatLevel; }
    public SugarLevel getPreferableSugarLevel() { return preferableSugarLevel; }

	public void buy(GroceryProduct product) throws CannotBuyException {
        if (product instanceof DairyProduct dairyProduct && dairyProduct.getFat() != preferableFatLevel)
            throw new IncorrectFatTypeException(name+" only takes "+preferableFatLevel+" dairy products.");
        else if (product instanceof Beverage beverage && beverage.getSugarLevel() != preferableSugarLevel)
            throw new IncorrectSugarLevelException(name+" only drinks "+preferableSugarLevel+" beverages.");

		System.out.println(name+" bought "+product.getName()+".");
		myCart.addProduct(product);
	}
}