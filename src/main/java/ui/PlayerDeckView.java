package ui;

import domain.GameState;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PlayerDeckView {

    private final AssetManager assets;
    private final GameState model;

    private final List<ToggleButton> nameTagToggleButtons;

    private StackPane root;
    private VBox playerHeaderSection;
    private HBox playerNamesContainer;
    private VBox drawPile;
    private HBox handCardsContainer;
    private Button handVisibilityToggle;
    private Button startGameButton;
    private HBox turnControlSection;

    public PlayerDeckView(GameState model, AssetManager assets) {
        this.assets = assets;
        this.model = model;

        this.nameTagToggleButtons = new ArrayList<>();

        buildUI();
    }

    public Parent getRoot() {
        return root;
    }

    public void renderPlayerHeaderSection() {
        playerHeaderSection.getChildren().clear();

        if (model.getIsGameOngoing()) {
            playerHeaderSection.getChildren().add(playerNamesContainer);
        }
    }

    public void renderPlayerNameTags() {
        for (int i = 0; i < nameTagToggleButtons.size(); i++) {
            boolean isAtCurrentPlayerIndex = (i == model.getCurrentPlayerIndex());
            nameTagToggleButtons.get(i).setSelected(isAtCurrentPlayerIndex);

            if (model.getIsGameOngoing()) {
                nameTagToggleButtons.get(i).setDisable(true);
            }
        }
    }

    public void renderDrawPile() {
        drawPile.setDisable(!model.canDraw());
        drawPile.setVisible(!model.isDrawPileEmpty());
    }

    public void renderHandVisibilityToggle() {
        if (model.getIsFaceUp()) {
            handVisibilityToggle.setText(UIConstants.HIDE_HAND_LABEL);
        }
        else {
            handVisibilityToggle.setText(UIConstants.SHOW_HAND_LABEL);
        }
    }

    public void renderPlayerHandCards() {
        handCardsContainer.getChildren().clear();
        buildPlayerHandCards();
    }

    public void renderTurnControlSection() {
        turnControlSection.getChildren().clear();

        Button playCardsButton = buildTurnControlButton(UIConstants.PLAY_CARDS_LABEL);

        if (model.getIsValidPlay()) {
            playCardsButton.getStyleClass().add("enabled");
        }
        else {
            playCardsButton.getStyleClass().add("disabled");
        }

        Button endTurnButton = buildTurnControlButton(UIConstants.END_TURN_LABEL);

        if (model.canEndTurn()) {
            endTurnButton.getStyleClass().add("enabled");
        }
        else {
            endTurnButton.getStyleClass().add("disabled");
        }

        turnControlSection.getChildren().addAll(playCardsButton, endTurnButton);
    }

    public void bindNameTags(Consumer<Integer> handler) {
        for (int i = 0; i < nameTagToggleButtons.size(); i++) {
            int index = i;
            nameTagToggleButtons.get(i).setOnMouseClicked((e ->
                handler.accept(index)
            ));
        }
    }

    public void bindDrawPile(Runnable handler) {
        drawPile.setOnMouseClicked(e ->
            handler.run());
    }

    public void bindHandVisibilityToggle(Runnable handler) {
        handVisibilityToggle.setOnMouseClicked(e ->
            handler.run()
        );
    }

    public void bindPlayerHandCards(Consumer<Integer> handler) {
        ObservableList<Node> handCards = handCardsContainer.getChildren();

        for (int i = 0; i < handCards.size(); i++) {
            int index = i;
            handCards.get(i).setOnMouseClicked((e ->
                handler.accept(index)
            ));
        }
    }

    public void bindStartGameButton(Runnable handler) {
        startGameButton.setOnMouseClicked(e ->
            handler.run()
        );
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

        VBox.setVgrow(gameBoardSection, Priority.ALWAYS);
        contentSection.getChildren().addAll(gameBoardSection, playerChoiceSection);

        return contentSection;
    }

    private VBox buildGameBoardSection() {
        VBox gameBoardSection = new VBox();
        gameBoardSection.getStyleClass().add("game-board-section");

        buildPlayerHeaderSection();
        HBox cardPileSection = buildCardPilesSection();

        gameBoardSection.getChildren().addAll(playerHeaderSection, cardPileSection);

        return gameBoardSection;
    }

    private void buildPlayerHeaderSection() {
        playerHeaderSection = new VBox();
        playerHeaderSection.setAlignment(Pos.CENTER);
        playerHeaderSection.getStyleClass().add("player-header-section");

        buildPlayerNamesContainer();

        playerHeaderSection.getChildren().add(playerNamesContainer);

        Text playerHeaderCaption = buildCaption(UIConstants.PLAYER_HEADER_CAPTION);
        playerHeaderSection.getChildren().add(playerHeaderCaption);
    }

    private void buildPlayerNamesContainer() {
        playerNamesContainer = new HBox();
        playerNamesContainer.getStyleClass().add("player-names-container");
        buildPlayerNameTags();
    }

    private void buildPlayerNameTags() {
        for (int i = 0; i < model.getPlayerNames().size(); i++) {
            ToggleButton nameTag = buildNameTag(model.getPlayerNames().get(i));

            boolean isAtCurrentPlayerIndex = (i == model.getCurrentPlayerIndex());
            nameTag.setSelected(isAtCurrentPlayerIndex);

            nameTagToggleButtons.add(nameTag);
            playerNamesContainer.getChildren().add(nameTag);
        }
    }

    private ToggleButton buildNameTag(String playerName) {
        ToggleButton nameTag = new ToggleButton(playerName);
        nameTag.getStyleClass().addAll("name-tag", "h4");
        return nameTag;
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

        StackPane drawPileContainer = buildDrawPileContainer();
        drawPile.setDisable(!model.canDraw());

        Text drawPileCaption = buildCaption(UIConstants.DRAW_PILE_CAPTION);

        drawPileSection.getChildren().addAll(drawPileContainer, drawPileCaption);

        return drawPileSection;
    }

    private StackPane buildDrawPileContainer() {
        StackPane drawPileContainer = new StackPane();

        VBox emptyCard = buildEmptyPile();
        drawPile = buildCardBack();

        drawPileContainer.getChildren().addAll(emptyCard, drawPile);

        return drawPileContainer;
    }

    private VBox buildEmptyPile() {
        VBox discardPile = new VBox();
        discardPile.setAlignment(Pos.CENTER);
        discardPile.getStyleClass().addAll("card", "empty");

        return discardPile;
    }

    private VBox buildCardBack() {
        VBox drawPile = new VBox();
        drawPile.setAlignment(Pos.CENTER);
        drawPile.getStyleClass().addAll("card", "back");

        ImageView cardBackIconView = buildCardBackIconView();
        VBox explodingKittensText = buildExplodingKittensText();

        drawPile.getChildren().addAll(cardBackIconView, explodingKittensText);

        return drawPile;
    }

    private ImageView buildCardBackIconView() {
        Image cardBackIcon = assets.getImage("placeholder");
        ImageView cardBackIconView = new ImageView(cardBackIcon);

        cardBackIconView.setFitWidth(UIConstants.CARD_BACK_ICON_WIDTH);
        cardBackIconView.setPreserveRatio(true);

        return cardBackIconView;
    }

    private VBox buildExplodingKittensText() {
        VBox explodingKittensText = new VBox();
        explodingKittensText.setAlignment(Pos.CENTER);
        explodingKittensText.getStyleClass().add("exploding-kittens-text");

        String[] title_words = UIConstants.TITLE.split(" ");
        Text explodingText = buildExplodingText(title_words[0]);
        Text kittensText = buildKittensText(title_words[1]);

        explodingKittensText.getChildren().addAll(explodingText, kittensText);

        return explodingKittensText;
    }

    private Text buildExplodingText(String text) {
        Text explodingText = new Text(text);
        explodingText.getStyleClass().addAll("exploding-text", "h5");

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

        StackPane discardPileContainer = buildDiscardPileContainer();
        Text discardPileCaption = buildCaption(UIConstants.DISCARD_PILE_CAPTION);

        discardPileSection.getChildren().addAll(discardPileContainer, discardPileCaption);

        return discardPileSection;
    }

    private StackPane buildDiscardPileContainer() {
        StackPane discardPileContainer = new StackPane();

        VBox emptyCard = buildEmptyPile();

        discardPileContainer.getChildren().addAll(emptyCard);

        return discardPileContainer;
    }

    private VBox buildPlayerChoiceSection() {
        VBox playerChoiceSection = new VBox();

        VBox playerHandSection = buildPlayerHandSection();
        buildTurnControlSection();

        playerChoiceSection.getChildren().addAll(playerHandSection, turnControlSection);

        return playerChoiceSection;
    }

    private VBox buildPlayerHandSection() {
        VBox playerHandSection = new VBox();
        playerHandSection.setAlignment(Pos.CENTER);

        buildHandVisibilityToggle();
        ScrollPane handScrollPane = buildHandScrollPane();
        Text handCaption = buildCaption(UIConstants.HAND_CAPTION);

        playerHandSection.getChildren().addAll(handVisibilityToggle, handScrollPane, handCaption);

        return playerHandSection;
    }

    private void buildHandVisibilityToggle() {
        handVisibilityToggle = new Button(UIConstants.SHOW_HAND_LABEL);
        handVisibilityToggle.getStyleClass().addAll("hand-visibility-toggle", "h6");
    }

    private ScrollPane buildHandScrollPane() {
        ScrollPane handScrollPane = new ScrollPane();
        handScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        handScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        handScrollPane.getStyleClass().add("scroll-pane");

        buildHandCardsContainer();
        handScrollPane.setContent(handCardsContainer);

        return handScrollPane;
    }

    private void buildHandCardsContainer() {
        handCardsContainer = new HBox();
        handCardsContainer.setAlignment(Pos.CENTER);
        handCardsContainer.setMinWidth(UIConstants.SCENE_WIDTH);
        handCardsContainer.getStyleClass().add("hand-cards-container");

        buildPlayerHandCards();
    }

    private void buildPlayerHandCards() {
        for (String cardName : model.getCurrentPlayerHand()) {
            VBox handCard = buildHandCard(cardName);
            handCardsContainer.getChildren().add(handCard);
        }
    }

    private VBox buildHandCard(String cardName) {
        VBox handCard;

        if (model.getIsFaceUp()) {
            handCard = buildCardFront(cardName);
            handCard.setDisable(true);
        }
        else {
            handCard = buildCardBack();
        }

        return handCard;
    }

    private VBox buildCardFront(String cardName) {
        VBox cardFront = new VBox();
        cardFront.getStyleClass().addAll("card", "front");

        VBox cardFrontContent = buildCardFrontContent(cardName);

        cardFront.getChildren().add(cardFrontContent);
        return cardFront;
    }

    private VBox buildCardFrontContent(String cardName) {
        VBox cardFrontContent = new VBox();
        cardFrontContent.getStyleClass().add("card-front-content");

        HBox cardHeader = buildCardHeader(cardName);
        StackPane cardVisualSection = buildCardVisualSection(cardName);

        cardFrontContent.getChildren().addAll(cardHeader, cardVisualSection);
        return cardFrontContent;
    }

    private HBox buildCardHeader(String cardName) {
        HBox cardHeader = new HBox();
        cardHeader.setAlignment(Pos.CENTER_LEFT);
        cardHeader.getStyleClass().add("card-header");

        StackPane cardCircle = buildCardCircle();
        VBox cardTitleSection = buildCardTitleSection(cardName);

        cardHeader.getChildren().addAll(cardCircle, cardTitleSection);
        return cardHeader;
    }

    private StackPane buildCardCircle() {
        StackPane cardCircle = new StackPane();
        cardCircle.getStyleClass().add("card-circle");
        return cardCircle;
    }

    private VBox buildCardTitleSection(String cardName) {
        VBox cardTitleSection = new VBox();
        cardTitleSection.getStyleClass().add("card-title-section");

        Text cardTitle = buildCardTitle(cardName);
        Text cardSubtitle = buildCardSubtitle(cardName);

        cardTitleSection.getChildren().addAll(cardTitle, cardSubtitle);
        return cardTitleSection;
    }

    private Text buildCardTitle(String title) {
        Text cardTitle = new Text(title);
        cardTitle.getStyleClass().addAll("card-title", "b1");

        return cardTitle;
    }

    private Text buildCardSubtitle(String subtitle) {
        Text cardSubtitle = new Text(subtitle);
        cardSubtitle.getStyleClass().addAll("card-subtitle", "b2");

        return cardSubtitle;
    }

    private StackPane buildCardVisualSection(String description) {
        StackPane cardVisualSection = new StackPane();

        ImageView cardImageView = buildCardImageView();
        HBox cardDescriptionSection = buildCardDescriptionSection(description);

        Insets inset = new Insets(0, 0, UIConstants.CARD_IMAGE_BOTTOM_PADDING, 0);
        StackPane.setMargin(cardDescriptionSection, inset);

        cardVisualSection.getChildren().addAll(cardImageView, cardDescriptionSection);
        return cardVisualSection;
    }

    private ImageView buildCardImageView() {
        Image cardImage = assets.getImage("placeholder");
        ImageView cardImageView = new ImageView(cardImage);

        cardImageView.setFitWidth(UIConstants.CARD_IMAGE_WIDTH);
        cardImageView.setFitHeight(UIConstants.CARD_IMAGE_HEIGHT);

        return cardImageView;
    }

    private HBox buildCardDescriptionSection(String description) {
        HBox cardDescriptionSection = new HBox();
        cardDescriptionSection.setAlignment(Pos.BOTTOM_CENTER);
        cardDescriptionSection.getStyleClass().add("card-description-section");

        SVGPath leftBracketIcon = buildLeftBracketIcon();
        Text cardDescription = buildCardDescription(description);
        SVGPath rightBracketIcon = buildRightBracketIcon();

        cardDescriptionSection.getChildren().addAll(leftBracketIcon, cardDescription, rightBracketIcon);
        return cardDescriptionSection;
    }

    private SVGPath buildLeftBracketIcon() {
        SVGPath leftBracketIcon = buildIcon("left-bracket");
        leftBracketIcon.getStyleClass().add("bracket-icon");

        return leftBracketIcon;
    }

    private SVGPath buildRightBracketIcon() {
        SVGPath rightBracketIcon = buildLeftBracketIcon();
        rightBracketIcon.setScaleX(-1);

        return rightBracketIcon;
    }

    private Text buildCardDescription(String description) {
        Text cardDescription = new Text(description);

        cardDescription.setWrappingWidth(UIConstants.CARD_DESCRIPTION_WRAPPING_WIDTH);
        cardDescription.getStyleClass().addAll("card-description", "b2");

        return cardDescription;
    }

    private void buildTurnControlSection() {
        turnControlSection = new HBox();
        turnControlSection.setAlignment(Pos.CENTER_RIGHT);
        turnControlSection.getStyleClass().add("turn-control-section");

        Button playCardsButton = buildTurnControlButton(UIConstants.PLAY_CARDS_LABEL);
        playCardsButton.getStyleClass().add("disabled");

        startGameButton = buildTurnControlButton(UIConstants.START_GAME_LABEL);
        startGameButton.getStyleClass().add("enabled");

        turnControlSection.getChildren().addAll(playCardsButton, startGameButton);
    }

    private Button buildTurnControlButton(String label) {
        Button turnControlButton = new Button(label);
        turnControlButton.getStyleClass().addAll("turn-control-button", "h5");
        return turnControlButton;
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

}
