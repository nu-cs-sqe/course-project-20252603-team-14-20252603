package ui;

import domain.GameState;
import javafx.application.Application;
import javafx.stage.Stage;

public class ExplodingKittensApp extends Application {

    @Override
    public void start(Stage stage) {
        GameState model = new GameState();
        AssetManager assets = new AssetManager();

        SceneManager sceneManager = new SceneManager(stage, model, assets);
        sceneManager.showPlayerDeckView();
    }

    public static void main(String[] args) {
        launch();
    }
}
