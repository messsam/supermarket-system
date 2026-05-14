package eg.edu.guc.supermarket.model.products;

public class DairyProduct extends GroceryProduct {
    private Fat fat;

    public DairyProduct(String name, double price, double discount, Fat fat) {
        super(name, price, discount);
        this.fat = fat;
    }

    public final void setFat(Fat fat) { this.fat = fat; }
    public final Fat getFat() { return fat; }

    @Override public boolean refrigerate() { return true; }
    @Override public String toString() { return super.toString()+"\nFat Level: "+fat; }
    @Override public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof DairyProduct other)
            return super.equals(obj)&&fat==other.fat;
        return false;
    }
}