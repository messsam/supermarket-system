package guc.gui;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

import eg.edu.guc.supermarket.model.people.Customer;

public class Main extends Application {
    Media cashRegisterSound;
    MediaPlayer player;
    @Override
    public void init() {
        // Step 0: data loading & connection setting.
        cashRegisterSound = new Media(getClass().getResource("/guc/gui/audios/cash-register-peep.wav").toExternalForm());
        player = new MediaPlayer(cashRegisterSound);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Step 1: build a scene graph.
        Group root = new Group();
        TextField text = new TextField();
        Button submit = new Button("Submit");
        Label output = new Label();
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        text.setPromptText("Enter a new customer's name");
        text.setPrefWidth(180);
        hBox.setSpacing(5);
        vBox.setSpacing(3);
        vBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(text, submit);
        vBox.getChildren().addAll(hBox, output);
        root.getChildren().add(vBox);
        /* Event handling. (Anonymous Inner Classes - Lambda expressions)
        submit.setOnAction(event -> {
            if (!text.getText().isEmpty()) {
                player.stop();
                player.play();
                Customer customer = new Customer(text.getText());
                output.setText("Customer "+customer.getName()+" got created with ID "+customer.getId()+".");
            }
            else {
                output.setText("Please enter a name.");
            }
        });*/
        // Step 2: create a scene. (Using root, width, & height)
        Scene scene = new Scene(root, 1200, 600);
        // Step 3: add the scene to the stage. (i.e. window)
        primaryStage.setScene(scene);
        primaryStage.setTitle("Supermarket System");
        Image icon = new Image("/guc/gui/images/icon.png");
        primaryStage.getIcons().add(icon);
        // Step 4: show the stage.
        primaryStage.show();
    }
    @Override
    public void stop() {

    }

    static void main(String[] args) {
        // Step 5: launch the application in main().
        launch(args);
    }
}