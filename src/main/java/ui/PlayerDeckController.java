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
    }

    private void onNameTag(int playerIndex) {
        if (model.getCurrentPlayerIndex() != playerIndex) {
            model.changeCurrentPlayerIndexAndSetIsFaceUpToFalse(playerIndex);

            view.renderPlayerNameTags();
            view.renderHandVisibilityToggle();
            renderAndBindPLayerHandCards();

            System.out.println("SWITCHED TO DIFFERENT PLAYER AND HID CARDS");
        }
    }

    private void renderAndBindPLayerHandCards() {
        view.renderPlayerHandCards();
        view.bindPlayerHandCards(this::onPlayerHandCard);
    }

    private void onToggleHandVisibility() {
        model.setIsFaceUpToOpposite();

        view.renderHandVisibilityToggle();
        renderAndBindPLayerHandCards();

        System.out.println("HAND VISIBILITY CHANGED");
    }

    private void onPlayerHandCard(int playerIndex) {
        if (!model.getIsFaceUp()) {
            onToggleHandVisibility();
        }
    }

    public PlayerDeckView getView() {
        return view;
    }

}
