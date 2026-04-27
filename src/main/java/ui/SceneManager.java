package ui;

import datasource.FileLoader;
import datasource.FontLoader;
import datasource.StyleSheetLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.InputStream;

public class SceneManager {

    private final Stage stage;
    private String cssFileString;

    public SceneManager(Stage stage) {
        this.stage = stage;
    }

    public void showPlayerDeckView() {
        PlayerDeckController controller = new PlayerDeckController();
        setScene(controller.getView().getRoot());
    }

    private void setScene(Parent root) {
        Scene scene = new Scene(root, UIConstants.SCENE_WIDTH, UIConstants.SCENE_HEIGHT);
        loadGlobalFiles();
        scene.getStylesheets().add(cssFileString);

        stage.setScene(scene);
        stage.setTitle(UIConstants.TITLE);

        stage.setMinWidth(UIConstants.MIN_WINDOW_WIDTH);
        stage.setMinHeight(UIConstants.MIN_WINDOW_HEIGHT);

        stage.show();
    }

    private void loadGlobalFiles() {
        loadCSS();
        loadFont("/fonts/Koulen-Regular.ttf");
        loadFont("/fonts/NationalPark-VariableFont_wght.ttf");
    }

    private void loadCSS() {
        FileLoader loader = new StyleSheetLoader();
        loader.open("/styles.css");
        cssFileString = loader.getFileUrl().toExternalForm();
    }

    private void loadFont(String fileName) {
        FileLoader loader = new FontLoader();
        loader.open(fileName);
        InputStream fontStream = getClass().getResourceAsStream(fileName);
        Font.loadFont(fontStream, 12);
    }

}
