package guc.supermarket.products;

public class DairyProduct extends GroceryProduct {
    private Fat fat;

    public DairyProduct(String name, double price, double discount, Fat fat) {
        super(name, price, discount);
        this.fat = fat;
    }

    public final Fat getFat() { return fat; }
    protected final void setFat(Fat fat) { this.fat = fat; }

    @Override public String toString() {
        return super.toString()+"\nFat Level: "+fat;
    }
}