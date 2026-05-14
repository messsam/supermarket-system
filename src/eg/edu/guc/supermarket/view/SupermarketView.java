package eg.edu.guc.supermarket.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class SupermarketView {
    private GridPane productsGrid;
    private TextArea txtCart;

    public SupermarketView() {
        // Create a grid pane to hold the products buy buttons
    	productsGrid = new GridPane();
    	productsGrid.setPadding(new Insets(10));
    	productsGrid.setHgap(10);
    	productsGrid.setVgap(10);

        // Create a text area to hold the text of the cart
        txtCart = new TextArea("Cart:");
        txtCart.setEditable(false);
        txtCart.setPrefWidth(200);
    }

    public GridPane getProductsGrid() { return productsGrid; }
    public void setProductsGrid(GridPane productsGrid) { this.productsGrid = productsGrid; }
    public TextArea getTxtCart() { return txtCart; }
    public void setTxtCart(TextArea txtCart) { this.txtCart = txtCart; }
    
    public HBox placeUIComponents(){
    	HBox view = new HBox();
    	view.getChildren().addAll(productsGrid,txtCart);
    	return view;
    }

    public Button addProduct(String btnText) {
    	
    	Button btn = new Button(btnText);
    	btn.setPrefWidth(250);
    	btn.setPrefHeight(250);
    	// Get the next row and col this button must be placed at
    	int row = productsGrid.getChildren().size()/3;
    	int col = productsGrid.getChildren().size()%3;
        // Add the product button to the grid pane
        productsGrid.add(btn, col, row);
        return btn;
    }
    
    public void updateButton(Button btn, String btnText){
    	btn.setText(btnText);
    }

    public void updateCart(ArrayList<String> products, double total) {
        // Update the text of the cart
        StringBuilder cartText = new StringBuilder();
        cartText.append("Cart:\n");
        cartText.append("'''''\n");
        for (String product : products) {
            cartText.append("- ").append(product).append("\n");
        }
        if (!products.isEmpty()) {
            cartText.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
        cartText.append(String.format("\nTotal: $%.2f", total));
        txtCart.setText(cartText.toString());
    }
}