package ui;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class PlayerDeckView {

    private VBox root;

    public PlayerDeckView(PlayerDeckController controller) {
        buildUI(controller);
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI(PlayerDeckController controller) {
        root = new VBox();
    }

}
