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
        root = new StackPane();
        root.getStyleClass().add("root");

        StackPane startScreen = buildStartScreen();
        root.getChildren().add(startScreen);
    }

    private StackPane buildStartScreen() {
        StackPane startScreen = new StackPane();

        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(48);
        content.getStyleClass().add("content-section");

        VBox titleBox = buildExplodingKittensText();
        ImageView explosionCat = buildExplosionImage();
        Button playButton = buildPlayButton();

        content.getChildren().addAll(titleBox, explosionCat, playButton);
        startScreen.getChildren().add(content);

        return startScreen;
    }

    private ImageView buildExplosionImage() {
        Image image = assets.getImage("placeholder");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    private Button buildPlayButton() {
        Button button = new Button("Play");
        button.getStyleClass().addAll("name-tag", "h4");

        button.setOnAction(e -> controller.startGame());

        return button;
    }

    private VBox buildExplodingKittensText() {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getStyleClass().add("exploding-kittens-text");

        Text exploding = buildExplodingText(UIConstants.TITLE);

        box.getChildren().addAll(exploding);
        return box;
    }

    private Text buildExplodingText(String text) {
        Text t = new Text(text);
        t.getStyleClass().addAll("exploding-text", "h7");

        return t;
    }

    private Text buildKittensText(String text) {
        Text t = new Text(text);
        t.getStyleClass().addAll("kittens-text", "h3");

        return t;
    }
}