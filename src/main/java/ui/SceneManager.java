package ui;

import datasource.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private final Stage stage;
    private final AssetManager assets;

    public SceneManager(Stage stage, AssetManager assets) {
        this.stage = stage;
        this.assets = assets;
    }

    public void showStartView() {
        assets.loadGlobalFiles();
        StartController controller = new StartController(assets);
        setScene(controller.getStartView().getRoot());
    }

    private void setScene(Parent root) {
        Scene scene = new Scene(root, UIConstants.SCENE_WIDTH, UIConstants.SCENE_HEIGHT);

        String cssUrl = assets.getStylesheet();
        scene.getStylesheets().add(cssUrl);

        stage.setScene(scene);
        stage.setTitle(UIConstants.TITLE);
        stage.setResizable(false);

        stage.show();
    }

}