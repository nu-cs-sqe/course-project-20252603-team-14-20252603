package ui;

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
    private VBox gameBoardSection;
        private VBox playerHeaderSection;
            private HBox playerNamesBar;
                private Text playerHeaderCaption;
    private VBox playerChoiceSection;

    public PlayerDeckView(PlayerDeckController controller) {
        this.controller = controller;
        buildUI();
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI() {
        root = new VBox();

        buildGameBoardSection();
        buildPlayerChoiceSection();

        root.getChildren().addAll(gameBoardSection, playerChoiceSection);
    }

    private void buildGameBoardSection() {
        gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");
        gameBoardSection.getChildren().add(new Label("gameBoardSection"));

        buildPlayerHeaderSection();

        gameBoardSection.getChildren().addAll(playerHeaderSection);
    }

    private void buildPlayerHeaderSection() {
        playerHeaderSection = new VBox();
        buildPlayerNamesBar();
        buildPlayerHeaderCaption();
        playerHeaderSection.getChildren().addAll(playerNamesBar, playerHeaderCaption);
    }

    private void buildPlayerNamesBar() {
        playerNamesBar = new HBox();

        for (String playerName : UIConstants.PLAYER_NAMES) {
            Node nameTag = buildNameTag(playerName);
            playerNamesBar.getChildren().add(nameTag);
        }
    }

    private Node buildNameTag(String playerName) {
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

    private void buildPlayerHeaderCaption() {
        playerHeaderCaption = new Text(UIConstants.PLAYER_HEADER_CAPTION);
        playerHeaderCaption.getStyleClass().add("caption");

    }

    private void buildPlayerChoiceSection() {
        playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().addAll("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));
    }

}
