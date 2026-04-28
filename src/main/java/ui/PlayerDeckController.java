package ui;

import domain.GameConstants;

import java.util.HashMap;

public class PlayerDeckController {

    private final PlayerDeckView view;
    private String[] playerNames;
    private HashMap<Integer, String[]> playerHands;
    private int currentPlayerIndex;
    private boolean isFaceUp;

    public PlayerDeckController(AssetManager assets) {
        this.view = new PlayerDeckView(assets);

        initializeState();
        renderInitialState();
        bindUI();
    }

    private void initializeState() {
        this.playerNames = GameConstants.PLAYER_NAMES;
        this.playerHands = GameConstants.INITIAL_PLAYER_HANDS;
        this.currentPlayerIndex = GameConstants.STARTING_PLAYER_INDEX;
        this.isFaceUp = false;
    }

    private void renderInitialState() {
        view.renderPlayerNameTags(playerNames);
        view.renderPlayerHandCards(getCurrentPlayerCards(), isFaceUp);
    }

    private void bindUI() {
        view.bindNameTags(this::onNameTag);
        view.bindHandVisibilityToggle(this::onToggleHandVisibility);
        view.bindHandCardsContainer(this::onHandCardContainer);
    }

    private void onNameTag(int playerIndex) {
        if (currentPlayerIndex != playerIndex) {
            currentPlayerIndex = playerIndex;
            isFaceUp = false;

            view.renderPlayerHandCards(getCurrentPlayerCards(), isFaceUp);
            System.out.println("NAME TAG CHANGED");
        }
    }

    private void onToggleHandVisibility() {
        isFaceUp = !isFaceUp;

        view.renderPlayerHandCards(getCurrentPlayerCards(), isFaceUp);
        System.out.println("HAND VISIBILITY CHANGED");
    }

    private void onHandCardContainer() {
        if (!isFaceUp) {
            onToggleHandVisibility();
        }
    }

    private String[] getCurrentPlayerCards() {
        return playerHands.get(currentPlayerIndex);
    }


    public PlayerDeckView getView() {
        return view;
    }
}
