package eg.edu.guc.supermarket.model.people;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import eg.edu.guc.supermarket.model.products.*;
import eg.edu.guc.supermarket.exceptions.CannotBuyException;
import eg.edu.guc.supermarket.exceptions.InvalidProductException;

public class Simulator {
	public void simulate() {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.csv"))) {
            String currentLine = "";
            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.isBlank()) continue;
                String[] data = currentLine.split(",");

                // Customer data.
                Customer customer = new Customer(data[0], getFatFromString(data[1]), getSugarLevelFromString(data[2]));
                // Product data.
                GroceryProduct product = switch (data[3]) {
                    case "DairyProduct" -> new DairyProduct(data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]), getFatFromString(data[7]));
                    case "Beverage" -> new Beverage(data[4], Double.parseDouble(data[5]), Double.parseDouble(data[6]), getSugarLevelFromString(data[7]));
                    default -> throw new InvalidProductException("Invalid product.");
                };

                try { customer.buy(product); }
                catch (CannotBuyException e) { System.out.println("The customer cannot buy the product as "+e.getMessage()); }
            }
        }
        catch (FileNotFoundException f) { System.out.println("The file should be placed in the project folder"); }
        catch (IOException e) { System.out.println("Cannot read from the file");}
	}

    private Fat getFatFromString(String s) {
        return switch (s) {
            case "Fat.FULLCREAM" -> Fat.FULLCREAM;
            case "Fat.HALFCREAM" -> Fat.HALFCREAM;
            case "Fat.SKIMMED" -> Fat.SKIMMED;
            default -> null;
        };
    }
    private SugarLevel getSugarLevelFromString(String s) {
        return switch (s) {
            case "SugarLevel.ADDED_SUGAR" -> SugarLevel.ADDED_SUGAR;
            case "SugarLevel.NO_ADDED_SUGAR" -> SugarLevel.NO_ADDED_SUGAR;
            case "SugarLevel.LIGHT" -> SugarLevel.LIGHT;
            case "SugarLevel.ZERO" -> SugarLevel.ZERO;
            default -> null;
        };
    }

	public static void main(String[] args) {
		Simulator simulator = new Simulator();
		simulator.simulate();
	}
}