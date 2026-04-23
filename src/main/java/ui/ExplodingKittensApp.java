package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExplodingKittensApp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Label("It works"), 1000, 700);
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setTitle("Exploding Kittens");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
