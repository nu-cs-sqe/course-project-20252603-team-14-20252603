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
        StackPane startScreen = buildStartScreen();
        root.getChildren().add(startScreen);
    }

    private StackPane buildStartScreen() {
        StackPane startScreen = new StackPane();
        startScreen.getStyleClass().add("start-screen");

        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(30);

        Text title = buildTitle();
        ImageView explosionCat = buildExplosionImage();
        Button playButton = buildPlayButton();

        content.getChildren().addAll(title,explosionCat,playButton);
        startScreen.getChildren().add(content);
        return startScreen;

    }
    private Text buildTitle() {
        Text title = new Text("EXPLODING WILDKITTENS");
        title.getStyleClass().add("title-text");
        return title;
    }

    private ImageView buildExplosionImage() {
        Image image = assets.getImage("explosion-cat");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    private Button buildPlayButton() {
        Button playButton = new Button("START");
        playButton.getStyleClass().add("play-button");

        playButton.setOnAction(e -> controller.startGame());

        return playButton;
    }
}
