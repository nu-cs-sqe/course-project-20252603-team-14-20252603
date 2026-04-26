package ui;

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
        Scene scene = new Scene(root, 1000, 700);

        stage.setScene(scene);
        stage.setTitle("Exploding Kittens");

        stage.setMinWidth(800);
        stage.setMinHeight(500);

        stage.show();
    }


}
