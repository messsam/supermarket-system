package guc.supermarket.products;

public abstract class GroceryProduct {
    private String name;
    private double price, discount;

    public GroceryProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        setDiscount(discount);
    }

    protected final void setName(String name) { this.name = name; }
    protected final void setPrice(double price) { this.price = price; }
    protected final void setDiscount(double discount) {
        if (discount >= 0 && discount <= 100) this.discount = discount;
        else throw new IllegalArgumentException("Discount should range from 0 to 100.");
    }

    public final String getName() { return name; }
    public final double getPrice() { return price; }
    public final double getDiscount() { return discount; }
    public final double getActualPrice() { return price-(price*(discount/100)); }

    @Override public String toString() {
        return "Name: "+name+"\nPrice: "+price+" L.E.\nDiscount: "+discount+" %";
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryProduct other)) return false;
        return name.equals(other.name)&&price==other.price&&discount==other.discount;
    }

    public abstract boolean refrigerate();
}