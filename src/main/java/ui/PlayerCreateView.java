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

import java.util.ArrayList;
import java.util.List;


public class PlayerCreateView {

    private final AssetManager assets;

    private StackPane root;
    private VBox playerFieldsContainer;
    private Button addPlayerButton;
    private Button confirmButton;
    private Button backButton;

    private final List<TextField> playerFields = new ArrayList<>();
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

    private VBox buildFieldsContainer() {
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(12);
        return container;
    }

    private Button buildAddPlayerButton() {
        Button button = new Button("+");
        button.getStyleClass().add("add-player-button");
        return button;
    }

    private Button buildConfirmButton() {
        Button button = new Button("CONFIRM");
        button.getStyleClass().addAll("turn-control-button", "enabled", "h5");
        return button;
    }

    private StackPane buildOverlayLayer() {
        StackPane overlayLayer = new StackPane();
        overlayLayer.setPickOnBounds(false);

        backButton = buildBackButton();
        overlayLayer.getChildren().add(backButton);

        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        StackPane.setMargin(backButton, new Insets(8));

        return overlayLayer;
    }

    private Button buildBackButton() {
        Button button = new Button();
        button.getStyleClass().add("icon-button");

        SVGPath backIcon = buildIcon("restart");
        button.setGraphic(backIcon);

        return button;
    }

    private SVGPath buildIcon(String key) {
        SVGPath icon = new SVGPath();
        icon.setContent(assets.getSvg(key));
        icon.getStyleClass().add(key + "-icon");
        return icon;
    }

    private void addPlayerField() {
        if (playerFields.size() >= MAX_PLAYERS) return;

        TextField field = new TextField();
        field.setPromptText("PLAYER " + (playerFields.size() + 1));
        field.getStyleClass().add("name-box");

        playerFields.add(field);
        playerFieldsContainer.getChildren().add(field);

        updateAddButtonState();
    }

    private void updateAddButtonState() {
        if (addPlayerButton == null) return;

        boolean isFull = playerFields.size() >= MAX_PLAYERS;
        addPlayerButton.setDisable(isFull);

        if (isFull) {
            addPlayerButton.getStyleClass().add("disabled");
        } else {
            addPlayerButton.getStyleClass().remove("disabled");
        }
    }

}