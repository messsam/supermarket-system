package guc.supermarket.products;

public class Beverage extends GroceryProduct {
    private SugarLevel sugarLevel;

    public Beverage(String name, double price, double discount, SugarLevel sugarLevel) {
        super(name, price, discount);
        this.sugarLevel = sugarLevel;
    }

    protected final void setSugarLevel(SugarLevel sugarLevel) { this.sugarLevel = sugarLevel; }
    public final SugarLevel getSugarLevel() { return sugarLevel; }
    public final double getActualPrice(double extra) {
        return getPrice()-(getPrice()*((getDiscount()+extra)/100));
    }

    @Override public String toString() {
        return super.toString()+"\nSugar Level: "+sugarLevel;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage other)) return false;
        return super.equals(o)&&sugarLevel==other.sugarLevel;
    }
}