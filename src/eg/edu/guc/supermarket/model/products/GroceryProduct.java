package eg.edu.guc.supermarket.model.products;

import eg.edu.guc.supermarket.exceptions.InvalidDiscountException;

public abstract class GroceryProduct {
    private String name;
    private double price, discount;

    public GroceryProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        setDiscount(discount);
    }

    public final void setName(String name) { this.name = name; }
    public final void setPrice(double price) { this.price = price; }
    public final void setDiscount(double discount) throws InvalidDiscountException {
        if (discount >= 0 && discount <= 100) this.discount = discount;
        else throw new InvalidDiscountException("Discount should range from 0% to 100%.");
    }

    public final String getName() { return name; }
    public final double getPrice() { return price; }
    public final double getDiscount() { return discount; }
    public final double getActualPrice() { return price-price*discount/100; }

    @Override public String toString() {
        // return "Name: "+name+"\nPrice: "+price+" L.E.\nDiscount: "+discount+" %";
        return String.format("%s ($%.2f)", name, getActualPrice()); // %.2f limits double values to 2 decimal places
    }
    @Override public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof GroceryProduct other)
            return name.equals(other.name)&&price==other.price&&discount==other.discount;
        return false;
    }

    public abstract boolean refrigerate();
}