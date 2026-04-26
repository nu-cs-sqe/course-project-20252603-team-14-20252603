package ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerDeckView {

    private VBox root;
    private VBox gameBoardSection;
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
    }

    private void buildPlayerChoiceSection(PlayerDeckController controller) {
        playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().add("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));
    }

}
