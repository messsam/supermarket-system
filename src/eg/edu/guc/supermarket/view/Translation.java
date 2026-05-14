package guc.gui;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Translation extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rect1 = new Rectangle(20, 20, 200, 150);
        rect1.setFill(Color.RED);
        TranslateTransition translate = new TranslateTransition();
        translate.setByX(100);
        translate.setByY(100);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(10);
        translate.setAutoReverse(true);
        translate.setNode(rect1);
        translate.play();
        Group root = new Group();
        root.getChildren().add(rect1);
        Scene s = new Scene(root, 500, 400);
        stage.setScene(s);
        stage.setTitle("Translation Example");
        stage.show();
    }
}