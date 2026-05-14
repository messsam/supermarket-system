package eg.edu.guc.supermarket.controller;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;

import eg.edu.guc.supermarket.model.cart.Cart;
import eg.edu.guc.supermarket.model.products.GroceryProduct;
import eg.edu.guc.supermarket.model.supermarket.Supermarket;
import eg.edu.guc.supermarket.view.SupermarketView;
import eg.edu.guc.supermarket.exceptions.NotEnoughProductException;

public class SupermarketGUI extends Application {
    private Supermarket supermarket;
    private SupermarketView supermarketView;

    Media cashRegisterSound;
    MediaPlayer player;

    @Override
    public void init() {
        // Cash-audio loading.
        File file = new File("cash-register-peep.wav");
        cashRegisterSound = new Media(file.toURI().toString());
        player = new MediaPlayer(cashRegisterSound);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the supermarket
        supermarket = new Supermarket();

        // Initialize the SupermarketView
        supermarketView = new SupermarketView();
        HBox view = supermarketView.placeUIComponents();

        // Create buttons for each product in the supermarket
        for (GroceryProduct product : supermarket.getProducts()) {
            int index = supermarket.getProducts().indexOf(product);
            Button productBtn = supermarketView.addProduct(product.toString() + " count: " + Supermarket.getProductsCount().get(index));
            productBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
                    player.stop();
                    player.play();
                    try {
			            // Invoke the buy method on the product
			            supermarket.buy(product);
			            // Update the button text
			            supermarketView.updateButton(productBtn, product.toString() + " count: " + Supermarket.getProductsCount().get(index));
			            // Call the onCartUpdated method
			            onCartUpdated(supermarket.getCart());
			        } catch (NotEnoughProductException e) {
			            // Show a message dialog indicating the product is out of stock
			        	displayAlert("Not Enough Product!","Sorry, we ran out of this product.");
			        }
				}
            });
        }

        // Set the VBox as the root of the scene
        Scene scene = new Scene(view, 1000, 500);

        File icon = new File("icon.png");
        primaryStage.getIcons().add(new Image(icon.toURI().toString()));
        primaryStage.setTitle("Supermarket System");

        // Set the scene to the stage and show it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void onCartUpdated(Cart cart) {
        // Create a list of products info
        ArrayList<String> products = new ArrayList<>();
        for (GroceryProduct product : cart.getProducts()) {
            products.add(product.toString());
        }
        // Set the list along with the total to the supermarketView's updateCart method
        supermarketView.updateCart(products, cart.getTotal());
    }
    
    // Method to display a custom alert.
    private void displayAlert(String title, String message) {
        Stage alertStage = new Stage();
        alertStage.setTitle(title);

        Label label = new Label(message);
        Button closeButton = new Button("Continue Shopping");
        closeButton.setOnAction(event -> alertStage.close());

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(closeButton);

        Scene scene = new Scene(pane, 500, 100);
        alertStage.setScene(scene);
        alertStage.show();
    }

    public static void main(String[] args) {
        // Launch the application.
        launch(args);
    }
}