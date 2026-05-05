package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class ExplodingKittensApp extends Application {

    @Override
    public void start(Stage stage) {
        AssetManager assets = new AssetManager();

        SceneManager sceneManager = new SceneManager(stage, assets);
        sceneManager.showStartView();
    }

    public static void main(String[] args) {
        launch();
    }

}