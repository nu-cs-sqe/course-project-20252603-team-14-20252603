package ui;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class StartView {
    private final StartController controller;
    private final AssetManager assets;
    private StackPane root;

    public StartView(StartController controller, AssetManager assets){
        this.controller = controller;
        this.assets = assets;
        buildUI();
    }

    public Parent getRoot() { return root; }

    private void buildUI() {

    }

}
