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
        view.bindHandVisibilityToggle(this::onToggleHandVisibility);
    }

    private void bindNameTag(Button nameTag, int playerIndex) {
        nameTag.setOnMouseClicked(e -> {
            if (currentPlayerIndex != playerIndex) {
                currentPlayerIndex = playerIndex;
                updateViewToCurrentPlayer();
                view.toggleHandVisibility();
                System.out.println("NAME TAG CLICKED");
            }
        });
    }

    private void updateViewToCurrentPlayer() {
        String player = players[currentPlayerIndex];
        view.renderPlayerHand(player);
    }

    private void onToggleHandVisibility() {
        view.toggleHandVisibility();
        System.out.println("HAND VISIBILITY TOGGLE CLICKED");
    }

    public PlayerDeckView getView() {
        return view;
    }
}
