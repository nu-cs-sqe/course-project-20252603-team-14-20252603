package ui;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        gameBoardSection.getChildren().add(new Label("gameBoardSection"));

        VBox playerHeaderSection = buildPlayerHeaderSection();
        HBox cardPileSection = buildCardPileSection();

        gameBoardSection.getChildren().addAll(playerHeaderSection, cardPileSection);

        return gameBoardSection;
    }

    private VBox buildPlayerHeaderSection() {
        VBox playerHeaderSection = new VBox();
        playerHeaderSection.setSpacing(12);
        playerHeaderSection.setAlignment(Pos.CENTER);

        HBox playerNamesBar = buildPlayerNamesBar();
        Text playerHeaderCaption = buildPlayerHeaderCaption();
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

    private Text buildPlayerHeaderCaption() {
        Text playerHeaderCaption = new Text(UIConstants.PLAYER_HEADER_CAPTION);
        playerHeaderCaption.getStyleClass().add("caption");

        return playerHeaderCaption;
    }

    private HBox buildCardPileSection() {
        HBox cardPileSection = new HBox();

        VBox drawPileSection = buildDrawPileSection();
        cardPileSection.getChildren().addAll(drawPileSection);

        return cardPileSection;
    }

    private VBox buildDrawPileSection() {
        VBox drawPileSection = new VBox();
        drawPileSection.setAlignment(Pos.CENTER);
        drawPileSection.getStyleClass().add("draw-pile-section");

        VBox drawPile = buildDrawPile();
        Text drawPileCaption = buildDrawPileCaption();

        drawPileSection.getChildren().addAll(drawPile, drawPileCaption);

        return drawPileSection;
    }

    private Text buildDrawPileCaption() {
        Text drawPileCaption = new Text(UIConstants.DRAW_PILE_CAPTION);
        drawPileCaption.getStyleClass().add("caption");

        return drawPileCaption;
    }

    private VBox buildDrawPile() {
        VBox drawPile = new VBox();
        drawPile.setAlignment(Pos.CENTER);

        ImageView cardBackIconView = buildCardBackIconView();
        VBox explodingKittensText = buildExplodingKittensText();

        drawPile.getStyleClass().add("draw-pile");

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



    private VBox buildPlayerChoiceSection() {
        VBox playerChoiceSection = new VBox();
        playerChoiceSection.getStyleClass().addAll("player-choice-section");
        playerChoiceSection.getChildren().add(new Label("playerChoiceSection"));
        return playerChoiceSection;
    }

}
