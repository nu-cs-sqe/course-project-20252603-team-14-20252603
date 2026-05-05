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
        view.bindDrawPile(this::onDrawPile);
        view.bindHandVisibilityButton(this::onHandVisibilityButton);
        view.bindPlayerHandCardButtons(this::onPlayerHandCardButton);
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
        view.renderHandVisibilityButton();
        renderAndBindPlayerHandCards();
    }

    private void renderAndBindPlayerHandCards() {
        view.renderPlayerHandCards();
        view.bindPlayerHandCardButtons(this::onPlayerHandCardButton);
    }

    private void onDrawPile() {
        model.drawFromPile();

        view.renderDrawPile();
        renderAndBindPlayerHandCards();
        view.renderTurnControlSection();

        System.out.println("CARD DRAWN FROM PILE");
    }

    private void onHandVisibilityButton() {
        model.setIsFaceUpToOpposite();

        view.renderHandVisibilityButton();
        renderAndBindPlayerHandCards();

        System.out.println("HAND VISIBILITY TOGGLE CLICKED");
    }

    private void onPlayerHandCardButton(int handCardIndex) {
        if (!model.getIsFaceUp()) {
            onFaceDownPlayerHandCardButton();
        }
        else {
            onFaceUpPlayerHandCardButton(handCardIndex);
            view.renderTurnControlSection();
        }
    }

    private void onFaceDownPlayerHandCardButton() {
        onHandVisibilityButton();

        System.out.println("FACE DOWN HAND CARD BUTTON CLICKED");
    }

    private void onFaceUpPlayerHandCardButton(int handCardIndex) {
        String selectedCard = model.getCurrentPlayerHand().get(handCardIndex);

        if (view.isSelectedHandCard(handCardIndex)) {
            model.addToSelectedHandCards(selectedCard);

            System.out.println(selectedCard + " IN HAND SELECTED");
        }
        else {
            model.removeFromSelectedHandCards(selectedCard);

            System.out.println(selectedCard + " IN HAND DESELECTED");
        }
    }

    private void onStartGameButton() {
        model.startGame();

        handleChangeCurrentPlayer(model.getStartingPlayerIndex());

        view.renderPlayerHeaderSection();
        view.renderDrawPile();
        view.renderTurnControlSection();

        System.out.println("START GAME BUTTON CLICKED");
    }

    public PlayerDeckView getView() {
        return view;
    }

}
