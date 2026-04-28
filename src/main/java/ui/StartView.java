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

    }

    public Parent getRoot() { return root; }


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
