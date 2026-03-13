package guc.supermarket.products;

public class Beverage extends GroceryProduct {
    private SugarLevel sugarLevel;

    public Beverage(String name, double price, double discount, SugarLevel sugarLevel) {
        super(name, price, discount);
        this.sugarLevel = sugarLevel;
    }

    public final SugarLevel getSugarLevel() { return sugarLevel; }
    protected final void setSugarLevel(SugarLevel sugarLevel) { this.sugarLevel = sugarLevel; }

    @Override public String toString() {
        return super.toString()+"\nSugar Level: "+sugarLevel;
    }
}