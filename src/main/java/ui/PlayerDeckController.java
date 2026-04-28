package ui;

import javafx.scene.control.Button;

public class PlayerDeckController {

    private final PlayerDeckView view;
    private String[] players;
    private int currentPlayerIndex;
    private boolean isFaceUp = false;

    public PlayerDeckController(AssetManager assets) {
        this.view = new PlayerDeckView(this, assets);
        this.players = UIConstants.PLAYER_NAMES;
        this.currentPlayerIndex = 0;
        initializeBindings();
        view.renderPlayerHand(players[currentPlayerIndex], isFaceUp);
    }

    private void initializeBindings() {
        view.bindNameTags(this::bindNameTag);
        view.bindHandVisibilityToggle(this::onToggleHandVisibility);
    }

    private void bindNameTag(Button nameTag, int playerIndex) {
        nameTag.setOnMouseClicked(e -> {
            if (currentPlayerIndex != playerIndex) {
                currentPlayerIndex = playerIndex;
                isFaceUp = false;
                view.renderPlayerHand(players[currentPlayerIndex], isFaceUp);

                System.out.println("NAME TAG CLICKED");
            }
        });
    }

    private void onToggleHandVisibility() {
        isFaceUp = !isFaceUp;
        view.renderPlayerHand(players[currentPlayerIndex], isFaceUp);
        System.out.println("HAND VISIBILITY TOGGLE CLICKED");
    }

    public PlayerDeckView getView() {
        return view;
    }
}
