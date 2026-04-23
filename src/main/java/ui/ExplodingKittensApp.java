package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ExplodingKittensApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(new Label("It works"), 400, 300));
        stage.setTitle("Exploding Kittens");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
