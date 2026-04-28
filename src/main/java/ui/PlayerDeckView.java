package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

public class PlayerDeckView {

    private final PlayerDeckController controller;
    private final AssetManager assets;

    private StackPane root;
    private HBox handCards;
    private boolean isFaceUp = true;
    private Button[] nameTags = new Button[UIConstants.PLAYER_NAMES.length];

    public PlayerDeckView(PlayerDeckController controller, AssetManager assets) {
        this.controller = controller;
        this.assets = assets;
        buildUI();
    }

    public Parent getRoot() {
        return root;
    }

    public void bindNameTags(java.util.function.BiConsumer<Button, Integer> handler) {
        for (int i = 0; i < nameTags.length; i++) {
            handler.accept(nameTags[i], i);
        }
    }

    private void buildUI() {
        root = new StackPane();

        StackPane gameScreen = buildGameScreen();
        root.getChildren().add(gameScreen);
    }

    private StackPane buildGameScreen() {
        StackPane gameScreen = new StackPane();

        VBox contentSection = buildContentSection();
        StackPane overlayLayer = buildOverlayLayer();
        gameScreen.getChildren().addAll(contentSection, overlayLayer);

        return gameScreen;
    }

    private VBox buildContentSection() {
        VBox contentSection = new VBox();
        contentSection.getStyleClass().add("content-section");

        VBox gameBoardSection = buildGameBoardSection();
        VBox playerChoiceSection = buildPlayerChoiceSection();

        contentSection.getChildren().addAll(gameBoardSection, playerChoiceSection);

        return contentSection;
    }

    private VBox buildGameBoardSection() {
        VBox gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");

        VBox playerHeaderSection = buildPlayerHeaderSection();
        HBox cardPileSection = buildCardPilesSection();

        gameBoardSection.getChildren().addAll(playerHeaderSection, cardPileSection);

        return gameBoardSection;
    }

    private VBox buildPlayerHeaderSection() {
        VBox playerHeaderSection = new VBox();
        playerHeaderSection.setSpacing(12);
        playerHeaderSection.setAlignment(Pos.CENTER);

        HBox playerNamesBar = buildPlayerNamesBar();
        Text playerHeaderCaption = buildCaption(UIConstants.PLAYER_HEADER_CAPTION);
        playerHeaderSection.getChildren().addAll(playerNamesBar, playerHeaderCaption);

        return playerHeaderSection;
    }

    private HBox buildPlayerNamesBar() {
        HBox playerNamesBar = new HBox();
        playerNamesBar.getStyleClass().add("player-names-bar");

        for (int i = 0; i < UIConstants.PLAYER_NAMES.length; i++) {
            Button nameTag = buildNameTag(UIConstants.PLAYER_NAMES[i]);
            playerNamesBar.getChildren().add(nameTag);
            nameTags[i] = nameTag;
        }

        return playerNamesBar;
    }

    private Button buildNameTag(String playerName) {
        Button nameTag = new Button("");

        Text nameText = buildNameTagText(playerName);
        nameTag.setGraphic(nameText);
        nameTag.getStyleClass().add("name-tag");

        return nameTag;
    }

    private Text buildNameTagText(String playerName) {
        Text nameText = new Text(playerName);
        nameText.setFill(UIGradients.GRADIENT_2);
        nameText.getStyleClass().add("h4");

        return nameText;
    }

    private Text buildCaption(String text) {
        Text caption = new Text(text);
        caption.getStyleClass().add("caption");

        return caption;
    }

    private HBox buildCardPilesSection() {
        HBox cardPileSection = new HBox();
        cardPileSection.setAlignment(Pos.CENTER);
        cardPileSection.getStyleClass().add("card-piles-section");

        VBox drawPileSection = buildDrawPileSection();
        VBox discardPileSection = buildDiscardPileSection();
        cardPileSection.getChildren().addAll(drawPileSection, discardPileSection);

        return cardPileSection;
    }

    private VBox buildDrawPileSection() {
        VBox drawPileSection = new VBox();
        drawPileSection.setAlignment(Pos.CENTER);
        drawPileSection.getStyleClass().add("card-pile-section");

        VBox drawPile = buildCardBack();
        Text drawPileCaption = buildCaption(UIConstants.DRAW_PILE_CAPTION);

        drawPileSection.getChildren().addAll(drawPile, drawPileCaption);

        return drawPileSection;
    }

    private VBox buildCardBack() {
        VBox drawPile = new VBox();
        drawPile.setAlignment(Pos.CENTER);

        ImageView cardBackIconView = buildCardBackIconView();
        VBox explodingKittensText = buildExplodingKittensText();

        drawPile.getStyleClass().add("card-back");

        drawPile.getChildren().addAll(cardBackIconView, explodingKittensText);

        return drawPile;
    }

    private ImageView buildCardBackIconView() {
        Image card_back_icon = assets.getImage("placeholder");
        ImageView card_back_icon_view = new ImageView(card_back_icon);

        card_back_icon_view.setFitWidth(UIConstants.CARD_BACK_ICON_WIDTH);
        card_back_icon_view.setPreserveRatio(true);

        return card_back_icon_view;
    }

    private VBox buildExplodingKittensText() {
        VBox explodingKittensText = new VBox();
        explodingKittensText.setAlignment(Pos.CENTER);
        explodingKittensText.setSpacing(-20);

        String[] title_words = UIConstants.TITLE.split(" ");
        Text explodingText = buildExplodingText(title_words[0]);
        Text kittensText = buildKittensText(title_words[1]);

        explodingKittensText.getChildren().addAll(explodingText, kittensText);

        return explodingKittensText;
    }

    private Text buildExplodingText(String text) {
        Text explodingText = new Text(text);
        explodingText.setFill(UIGradients.GRADIENT_1);
        explodingText.getStyleClass().add("h5");

        return explodingText;
    }

    private Text buildKittensText(String text) {
        Text kittensText = new Text(text);
        kittensText.getStyleClass().addAll("kittens-text", "h3");

        return kittensText;
    }

    private VBox buildDiscardPileSection() {
        VBox discardPileSection = new VBox();
        discardPileSection.setAlignment(Pos.CENTER);
        discardPileSection.getStyleClass().add("card-pile-section");

        VBox discardPile = buildDiscardPile();
        Text discardPileCaption = buildCaption(UIConstants.DISCARD_PILE_CAPTION);

        discardPileSection.getChildren().addAll(discardPile, discardPileCaption);

        return discardPileSection;
    }

    private VBox buildDiscardPile() {
        VBox discardPile = new VBox();
        discardPile.setAlignment(Pos.CENTER);
        discardPile.getStyleClass().add("empty-pile");

        return discardPile;
    }

    private VBox buildPlayerChoiceSection() {
        VBox playerChoiceSection = new VBox();

        VBox playerHandSection = buildPlayerHandSection();
        HBox turnControlSection = buildTurnControlSection();

        playerChoiceSection.getChildren().addAll(playerHandSection, turnControlSection);

        return playerChoiceSection;
    }

    private VBox buildPlayerHandSection() {
        VBox playerHandSection = new VBox();
        playerHandSection.setAlignment(Pos.CENTER);

        Button handVisibilityToggle = buildHandVisibilityToggle();
        ScrollPane handScrollPane = buildHandScrollPane();
        Text handCaption = buildCaption(UIConstants.HAND_CAPTION);

        playerHandSection.getChildren().addAll(handVisibilityToggle, handScrollPane, handCaption);

        return playerHandSection;
    }

    private Button buildHandVisibilityToggle() {
        Button handVisibilityToggle = new Button(UIConstants.SHOW_HAND_LABEL);
        handVisibilityToggle.getStyleClass().addAll("hand-visibility-toggle", "h6");

        return handVisibilityToggle;
    }

    private ScrollPane buildHandScrollPane() {
        ScrollPane handScrollPane = new ScrollPane();
        handScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        handScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        handScrollPane.getStyleClass().add("scroll-pane");

        buildHandCardsContainer();
        handScrollPane.setContent(handCards);

        return handScrollPane;
    }

    private void buildHandCardsContainer() {
        handCards = new HBox();
        handCards.setAlignment(Pos.CENTER);
        handCards.setMinWidth(UIConstants.SCENE_WIDTH);
        handCards.getStyleClass().add("hand-cards-container");

        buildPlayerHandCards(UIConstants.PLAYER_NAMES[0]);
    }

    private void buildPlayerHandCards(String player) {
        for (String cardName : UIConstants.INITIAL_PLAYER_HANDS.get(player)) {
            VBox handCard = buildHandCard(cardName);
            handCards.getChildren().add(handCard);
        }
    }

    private VBox buildHandCard(String card) {
        VBox handCard;

        if (isFaceUp) {
            handCard = buildCardFront(card);
        }
        else {
            handCard = buildCardBack();
        }

        handCard.getStyleClass().add("card-enabled");

        return handCard;
    }

    private VBox buildCardFront(String card) {
        VBox cardFront = new VBox();
        cardFront.getStyleClass().add("card-front");
        cardFront.getChildren().add(new Text(card));
        return cardFront;
    }

    private HBox buildTurnControlSection() {
        HBox turnControlSection = new HBox();
        turnControlSection.setAlignment(Pos.CENTER_RIGHT);
        turnControlSection.getStyleClass().add("turn-control-section");

        Button startGameButton = buildStartGameButton();

        turnControlSection.getChildren().add(startGameButton);

        return turnControlSection;
    }

    private Button buildStartGameButton() {
        Button startGameButton = new Button(UIConstants.START_GAME_LABEL);
        startGameButton.getStyleClass().addAll("start-game-button", "h5");
        return startGameButton;
    }

    private StackPane buildOverlayLayer() {
        StackPane overlayLayer = new StackPane();
        overlayLayer.setPickOnBounds(false);

        Button restartButton = buildRestartButton();
        overlayLayer.getChildren().add(restartButton);

        Insets insets = new Insets(8, 8, 0, 0);
        StackPane.setMargin(restartButton, insets);
        StackPane.setAlignment(restartButton, Pos.TOP_RIGHT);

        return overlayLayer;
    }

    private Button buildRestartButton() {
        Button restartButton = new Button();
        restartButton.getStyleClass().add("icon-button");

        SVGPath restartIcon = buildIcon("restart");
        restartButton.setGraphic(restartIcon);

        return restartButton;
    }

    private SVGPath buildIcon(String key) {
        SVGPath icon = new SVGPath();
        icon.setContent(assets.getSvg(key));
        icon.getStyleClass().add(String.format("%s-icon", key));

        return icon;
    }

    public void renderPlayerHand(String player) {
        handCards.getChildren().clear();
        buildPlayerHandCards(player);
    }

}
