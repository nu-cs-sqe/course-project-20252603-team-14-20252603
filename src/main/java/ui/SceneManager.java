package ui;

import datasource.FileLoader;
import datasource.FontLoader;
import datasource.ImageLoader;
import datasource.StyleSheetLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class SceneManager {

    private final Stage stage;
    private final AssetManager assets = new AssetManager();

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void showPlayerDeckView() {
        loadGlobalFiles();
        PlayerDeckController controller = new PlayerDeckController(assets);
        setScene(controller.getView().getRoot());
    }

    private void setScene(Parent root) {
        Scene scene = new Scene(root, UIConstants.SCENE_WIDTH, UIConstants.SCENE_HEIGHT);

        String cssUrl = assets.getStylesheet();
        scene.getStylesheets().add(cssUrl);

        stage.setScene(scene);
        stage.setTitle(UIConstants.TITLE);

        stage.setMinWidth(UIConstants.MIN_WINDOW_WIDTH);
        stage.setMinHeight(UIConstants.MIN_WINDOW_HEIGHT);

        stage.show();
    }

    private void loadGlobalFiles() {
        loadCSS();
        loadImages();

        loadFont("/fonts/Koulen-Regular.ttf");
        loadFont("/fonts/NationalPark-VariableFont_wght.ttf");
    }

    private void loadCSS() {
        FileLoader loader = new StyleSheetLoader();
        loader.open("/styles.css");
        String cssUrl = loader.getFileUrl().toExternalForm();
        assets.setStylesheet(cssUrl);
    }

    private void loadImages() {
        FileLoader loader = new ImageLoader();
        loader.open("/images/placeholder.png");
        String imageUrl = loader.getFileUrl().toExternalForm();
        assets.addImage("placeholder", imageUrl);
    }

    private void loadFont(String fileName) {
        FileLoader loader = new FontLoader();
        loader.open(fileName);
        InputStream fontStream = getClass().getResourceAsStream(fileName);
        Font.loadFont(fontStream, 12);
    }

}
