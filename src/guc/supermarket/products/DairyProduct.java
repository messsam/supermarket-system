package guc.supermarket.products;

public class DairyProduct extends GroceryProduct {
    private Fat fat;

    public DairyProduct(String name, double price, double discount, Fat fat) {
        super(name, price, discount);
        this.fat = fat;
    }

    protected final void setFat(Fat fat) { this.fat = fat; }
    public final Fat getFat() { return fat; }

    @Override public String toString() {
        return super.toString()+"\nFat Level: "+fat;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DairyProduct other)) return false;
        return super.equals(o)&&fat==other.fat;
    }
}