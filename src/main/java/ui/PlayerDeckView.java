package ui;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayerDeckView {

    private VBox root;
    private VBox gameBoardSection;
        private VBox playerHeaderSection;
            private HBox playerNamesBar;
    private VBox playerChoiceSection;

    public PlayerDeckView(PlayerDeckController controller) {
        buildUI(controller);
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI(PlayerDeckController controller) {
        root = new VBox();

        buildGameBoardSection(controller);
        buildPlayerChoiceSection(controller);

        root.getChildren().addAll(gameBoardSection, playerChoiceSection);
    }

    private void buildGameBoardSection(PlayerDeckController controller) {
        gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");
        gameBoardSection.getChildren().add(new Label("gameBoardSection"));

        buildPlayerHeaderSection(controller);

        gameBoardSection.getChildren().addAll(playerHeaderSection);
    }

    private void buildPlayerHeaderSection(PlayerDeckController controller) {
        playerHeaderSection = new VBox();
        buildPlayerNamesBar(controller);
        playerHeaderSection.getChildren().addAll(playerNamesBar);
    }

    private void buildPlayerNamesBar(PlayerDeckController controller) {
        playerNamesBar = new HBox();

        for (String playerName : UIConstants.PLAYER_NAMES) {
            Node nameTag = buildNameTag(controller, playerName);
            playerNamesBar.getChildren().add(nameTag);
        }
    }

    private Node buildNameTag(PlayerDeckController controller, String playerName) {
        Button nameTag = new Button(playerName);
        return nameTag;
    }

    private void buildPlayerChoiceSection(PlayerDeckController controller) {
        playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().add("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));
    }

}
