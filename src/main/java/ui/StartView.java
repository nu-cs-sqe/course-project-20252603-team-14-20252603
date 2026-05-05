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
    private final AssetManager assets;
    private StackPane root;

    public StartView(AssetManager assets){
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

        VBox titleBox = buildExplodingKittensText();
        ImageView explosionCat = buildExplosionImage();
        Button playButton = buildPlayButton();

        content.getChildren().addAll(titleBox,explosionCat,playButton);
        startScreen.getChildren().add(content);
        return startScreen;

    }


    private ImageView buildExplosionImage() {
        Image image = assets.getImage("placeholder");
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    private Button buildPlayButton() {
        Button startButton = new Button("");

        Text startButtonText = buildStartText();
        startButton.setGraphic(startButtonText);
        startButton.getStyleClass().add("name-tag");

        return startButton;
    }


    private Text buildStartText() {
        Text startText = new Text("Play");
        startText.setFill(UIGradients.GRADIENT_2);
        startText.getStyleClass().add("h4");

        return startText;
    }

    private VBox buildExplodingKittensText() {
        VBox explodingKittensText = new VBox();
        explodingKittensText.setAlignment(Pos.CENTER);

        String title_words = UIConstants.TITLE;
        Text explodingText = buildExplodingText(title_words);

        explodingKittensText.getChildren().addAll(explodingText);

        return explodingKittensText;
    }

    private Text buildExplodingText(String text) {
        Text explodingText = new Text(text);
        explodingText.setFill(UIGradients.GRADIENT_1);
        explodingText.getStyleClass().add("h7");

        return explodingText;
    }

    private Text buildKittensText(String text) {
        Text kittensText = new Text(text);
        kittensText.getStyleClass().addAll("kittens-text", "h3");

        return kittensText;
    }


}
