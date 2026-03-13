package guc.supermarket.products;

public class GroceryProduct {
    private String name;
    private double price, discount;

    public GroceryProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        setDiscount(discount);
    }

    public final String getName() { return name; }
    public final double getPrice() { return price; }
    public final double getDiscount() { return discount; }
    public final double getActualPrice() { return price-(price*(discount/100)); }

    protected final void setName(String name) { this.name = name; }
    protected final void setPrice(double price) { this.price = price; }
    protected final void setDiscount(double discount) {
        if (discount >= 0 && discount <= 100) this.discount = discount;
        else throw new IllegalArgumentException("Discount should range from 0 to 100.");
    }

    @Override public String toString() {
        return "Name: "+name+"\nPrice: "+price+" L.E.\nDiscount: "+discount+" %";
    }
}