package ui;

import domain.GameState;

public class PlayerDeckController {

    private final PlayerDeckView view;
    private GameState model;

    public PlayerDeckController(GameState model, AssetManager assets) {
        this.view = new PlayerDeckView(model, assets);
        this.model = model;

        bindUI();
    }

    private void bindUI() {
        view.bindNameTags(this::onNameTag);
        view.bindHandVisibilityToggle(this::onToggleHandVisibility);
        view.bindHandCardsContainer(this::onHandCardContainer);
    }

    private void onNameTag(int playerIndex) {
        if (model.getCurrentPlayerIndex() != playerIndex) {
            model.changeCurrentPlayerIndexAndFlipCardsDown(playerIndex);

            view.renderPlayerNameTags();
            view.renderPlayerHandCards();
            System.out.println("NAME TAG CHANGED");
        }
    }

    private void onToggleHandVisibility() {
        model.setIsFaceUpToOpposite();

        view.renderPlayerHandCards();
        System.out.println("HAND VISIBILITY CHANGED");
    }

    private void onHandCardContainer() {
        if (!model.getIsFaceUp()) {
            onToggleHandVisibility();
        }
    }

    public PlayerDeckView getView() {
        return view;
    }
}
