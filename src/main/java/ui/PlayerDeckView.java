package ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PlayerDeckView {

    private VBox root;

    public PlayerDeckView(PlayerDeckController controller) {
        buildUI(controller);
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI(PlayerDeckController controller) {
        root = new VBox();

        VBox gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");
        gameBoardSection.getChildren().add(new Label("gameBoardSection"));

        VBox playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().add("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));

        root.getChildren().addAll(gameBoardSection, playerChoiceSection);
    }

}
