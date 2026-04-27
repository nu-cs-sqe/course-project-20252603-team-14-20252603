package ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerDeckView {

    private final PlayerDeckController controller;

    private VBox root;

    public PlayerDeckView(PlayerDeckController controller) {
        this.controller = controller;
        buildUI();
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI() {
        root = new VBox();

        VBox gameBoardSection = buildGameBoardSection();
        VBox playerChoiceSection = buildPlayerChoiceSection();

        root.getChildren().addAll(gameBoardSection, playerChoiceSection);
    }

    private VBox buildGameBoardSection() {
        VBox gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");
        gameBoardSection.getChildren().add(new Label("gameBoardSection"));

        VBox playerHeaderSection = buildPlayerHeaderSection();

        gameBoardSection.getChildren().addAll(playerHeaderSection);

        return gameBoardSection;
    }

    private VBox buildPlayerHeaderSection() {
        VBox playerHeaderSection = new VBox();
        playerHeaderSection.setSpacing(12);
        playerHeaderSection.setAlignment(Pos.CENTER);

        HBox playerNamesBar = buildPlayerNamesBar();
        Text playerHeaderCaption = buildPlayerHeaderCaption();
        playerHeaderSection.getChildren().addAll(playerNamesBar, playerHeaderCaption);

        return playerHeaderSection;
    }

    private HBox buildPlayerNamesBar() {
        HBox playerNamesBar = new HBox();

        for (String playerName : UIConstants.PLAYER_NAMES) {
            Node nameTag = buildNameTag(playerName);
            playerNamesBar.getChildren().add(nameTag);
        }

        return playerNamesBar;
    }

    private Button buildNameTag(String playerName) {
        Button nameTag = new Button("");

        Text nameText = buildNameTagText(playerName);
        nameTag.setGraphic(nameText);

        nameTag.getStyleClass().add("name-tag");
        return nameTag;
    }

    private Text buildNameTagText(String playerName) {
        Text nameText = new Text(playerName);
        nameText.setFill(UIGradients.GRADIENT_2);
        nameText.getStyleClass().add("h3");
        return nameText;
    }

    private Text buildPlayerHeaderCaption() {
        Text playerHeaderCaption = new Text(UIConstants.PLAYER_HEADER_CAPTION);
        playerHeaderCaption.getStyleClass().add("caption");
        return playerHeaderCaption;
    }

    private VBox buildPlayerChoiceSection() {
        VBox playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().addAll("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));
        return playerChoiceSection;
    }

}
