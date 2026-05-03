package ui;

import domain.GameState;

public class PlayerDeckController {

    private final PlayerDeckView view;
    private final GameState model;

    public PlayerDeckController(GameState model, AssetManager assets) {
        this.view = new PlayerDeckView(model, assets);
        this.model = model;

        bindUI();
    }

    private void bindUI() {
        view.bindNameTags(this::onNameTag);
        view.bindHandVisibilityToggle(this::onToggleHandVisibility);
        view.bindPlayerHandCards(this::onPlayerHandCard);
        view.bindStartGameButton(this::onStartGameButton);
    }

    private void onNameTag(int playerIndex) {
        if (model.getCurrentPlayerIndex() != playerIndex) {
            handleChangeCurrentPlayer(playerIndex);
        }
        System.out.println("NAME TAG CLICKED");
    }

    private void handleChangeCurrentPlayer(int playerIndex) {
        model.changeCurrentPlayerIndexAndSetIsFaceUpToFalse(playerIndex);

        view.renderPlayerNameTags();
        view.renderHandVisibilityToggle();
        renderAndBindPlayerHandCards();
    }

    private void renderAndBindPlayerHandCards() {
        view.renderPlayerHandCards();
        view.bindPlayerHandCards(this::onPlayerHandCard);
    }

    private void onToggleHandVisibility() {
        model.setIsFaceUpToOpposite();

        view.renderHandVisibilityToggle();
        renderAndBindPlayerHandCards();

        System.out.println("HAND VISIBILITY TOGGLE CLICKED");
    }

    private void onPlayerHandCard(int playerIndex) {
        if (!model.getIsFaceUp()) {
            onToggleHandVisibility();

            System.out.println("FACE DOWN HAND CARD CLICKED");
        }
        else {
            System.out.println("FACE UP HAND CARD CLICKED");
        }
    }

    private void onStartGameButton() {
        model.startGame();

        handleChangeCurrentPlayer(model.getStartingPlayerIndex());

        view.renderPlayerHeaderSection();
        view.renderTurnControlSection();

        System.out.println("START GAME BUTTON CLICKED");
    }

    public PlayerDeckView getView() {
        return view;
    }

}
