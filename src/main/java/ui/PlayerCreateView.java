package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;


public class PlayerCreateView {

    private final AssetManager assets;

    private StackPane root;
    private VBox playerFieldsContainer;
    private Button addPlayerButton;
    private Button confirmButton;
    private Button backButton;


    private static final int MAX_PLAYERS = 5;

    public PlayerCreateView(AssetManager assets) {
        this.assets = assets;
    }

    public Parent getRoot() {
        return root;
    }


    private VBox buildTitleSection() {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);

        Text title = new Text(UIConstants.TITLE);
        title.getStyleClass().addAll("exploding-text", "h7");

        box.getChildren().add(title);
        return box;
    }


}