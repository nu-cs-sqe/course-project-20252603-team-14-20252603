package ui;

import datasource.FileLoader;
import datasource.StyleSheetLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private final Stage stage;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void showPlayerDeckView() {
        PlayerDeckController controller = new PlayerDeckController();
        setScene(controller.getView().getRoot());
    }

    private void setScene(Parent root) {
        Scene scene = new Scene(root, UIConstants.SCENE_WIDTH, UIConstants.SCENE_HEIGHT);

        String cssFileString = loadGlobalFiles();
        scene.getStylesheets().add(cssFileString);

        stage.setScene(scene);
        stage.setTitle(UIConstants.TITLE);

        stage.setMinWidth(UIConstants.MIN_WINDOW_WIDTH);
        stage.setMinHeight(UIConstants.MIN_WINDOW_HEIGHT);

        stage.show();
    }

    private String loadGlobalFiles() {
        FileLoader loader = new StyleSheetLoader();
        loader.open("/styles.css");
        return loader.getFileUrl().toExternalForm();
    }

}
