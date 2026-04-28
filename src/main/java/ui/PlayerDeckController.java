package ui;

import javafx.scene.control.Button;

public class PlayerDeckController {

    private final PlayerDeckView view;
    private String[] players;
    private int currentPlayerIndex;

    public PlayerDeckController(AssetManager assets) {
        this.view = new PlayerDeckView(this, assets);
        this.players = UIConstants.PLAYER_NAMES;
        this.currentPlayerIndex = 0;
        initializeBindings();
    }

    private void initializeBindings() {
        view.bindNameTags(this::bindNameTag);
    }

    private void bindNameTag(Button nameTag, int playerIndex) {
        nameTag.setOnAction(e -> {
            currentPlayerIndex = playerIndex;
            updateViewToCurrentPlayer();
        });
    }

    public PlayerDeckView getView() {
        return view;
    }

    private void updateViewToCurrentPlayer() {
        String player = players[currentPlayerIndex];
        view.renderPlayerHand(player);
    }
}
