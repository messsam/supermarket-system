package guc.supermarket.cart;

import java.util.ArrayList;
import guc.supermarket.products.GroceryProduct;

public class Cart {
    private ArrayList<GroceryProduct> products;

    public Cart() { products = new ArrayList<>(); }

    public int size() { return products.size(); }
    public void addProduct(GroceryProduct product) { products.add(product); }
    public ArrayList<GroceryProduct> getProducts() { return products; }
    public double getTotal() {
        double total = 0;
        for (GroceryProduct p : products)
            total += p.getActualPrice();
        return total;
    }

    @Override public String toString() {
        StringBuilder list = new StringBuilder();
        for (GroceryProduct p : products)
            list.append(p.toString()).append("\n——————————\n");
        return list.toString();
    }
}