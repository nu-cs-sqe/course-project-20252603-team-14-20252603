package ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class PlayerDeckView {

    private final PlayerDeckController controller;
    private final AssetManager assets;

    private VBox root;

    public PlayerDeckView(PlayerDeckController controller, AssetManager assets) {
        this.controller = controller;
        this.assets = assets;
        buildUI();
    }

    public Parent getRoot() {
        return root;
    }

    private void buildUI() {
        root = new VBox();

        VBox gameBoardSection = buildGameBoardSection();
        VBox playerChoiceSection = buildPlayerChoiceSection();

        root.getChildren().addAll(gameBoardSection, playerChoiceSection);
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

        for (String playerName : UIConstants.PLAYER_NAMES) {
            Node nameTag = buildNameTag(playerName);
            playerNamesBar.getChildren().add(nameTag);
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
        playerChoiceSection.getStyleClass().addAll("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));

        VBox playerHandSection = buildPlayerHandSection();

        playerChoiceSection.getChildren().addAll(playerHandSection);

        return playerChoiceSection;
    }

    private VBox buildPlayerHandSection() {
        VBox playerHandSection = new VBox();

        Button handVisibilityToggle = buildHandVisibilityToggle();
        ScrollPane handScrollPane = buildHandScrollPane();

        playerHandSection.getChildren().addAll(handVisibilityToggle, handScrollPane);

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

        HBox handCards = buildHandCards();
        handScrollPane.setContent(handCards);

        return handScrollPane;
    }

    private HBox buildHandCards() {
        HBox handCards = new HBox();
        handCards.setAlignment(Pos.CENTER);
        handCards.setMinWidth(UIConstants.SCENE_WIDTH);
        handCards.getStyleClass().add("hand-cards");

        for (String cardName : UIConstants.INITIAL_PLAYER_HANDS.get("STEVE")) {
            VBox cardBack = buildCardBack();
            cardBack.getStyleClass().add("card-enabled");

            handCards.getChildren().add(cardBack);
        }

        return handCards;
    }

}
