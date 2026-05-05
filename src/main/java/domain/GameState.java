package domain;

import java.util.*;

public class GameState {

    // initialized before game starts
    private final List<String> playerNames;
    private Map<Integer, List<String>> playerHands;
    private int startingPlayerIndex;
    private int currentPlayerIndex;
    private boolean isFaceUp;
    private boolean canPlayCards;
    private boolean isGameOngoing;
    private Deque<String> drawPile;

    // initialized after game starts
    private List<String> selectedCardsToPlay;
    private int currentDrawCount;

    public GameState() {
        playerNames = List.of("STEVE", "MONKEY", "JENNY", "ELI", "GEORGE WASHINGTON");
        playerHands = getInitialHands();
        startingPlayerIndex = 0;
        currentPlayerIndex = 0;
        isFaceUp = false;
        canPlayCards = false;
        isGameOngoing = false;
        drawPile = new ArrayDeque<>(
                List.of("ATTACK", "SEE THE FUTURE", "NOPE")
        );
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public int getStartingPlayerIndex() {
        return startingPlayerIndex;
    }

    public List<String> getCurrentPlayerHand() {
        return playerHands.get(getCurrentPlayerIndex());
    }

    public boolean getIsFaceUp() {
        return isFaceUp;
    }

    public boolean getCanPlayCards() {
        return canPlayCards;
    }

    public void changeCurrentPlayerIndexAndSetIsFaceUpToFalse(int playerIndex) {
        currentPlayerIndex = playerIndex;
        isFaceUp = false;
    }

    public void setIsFaceUpToOpposite() {
        isFaceUp = !isFaceUp;
    }

    public boolean getIsGameOngoing() {
        return isGameOngoing;
    }

    public boolean isValidPlay() {
        return !selectedCardsToPlay.isEmpty() && (
                isOneOfAKind() ||
                isNOfAKind(2) ||
                isNOfAKind(3)
        );
    }

    private boolean isOneOfAKind() {
        String cardName = selectedCardsToPlay.get(0);

        boolean isOneCard = selectedCardsToPlay.size() == 1;
        boolean isCatCard = Objects.equals(cardName, "CAT");
        boolean isDefuseCard = Objects.equals(cardName, "DEFUSE");

        return isOneCard && !isCatCard && !isDefuseCard;
    }

    private boolean isNOfAKind(int n) {
        boolean isNCards = selectedCardsToPlay.size() == n;
        return isNCards && isAllSameCards(selectedCardsToPlay);
    }

    private boolean isAllSameCards(List<String> cards) {
        return new HashSet<>(cards).size() <= 1;
    }

    public boolean canEndTurn() {
        return isGameOngoing && currentDrawCount <= 0;
    }

    public void startGame() {
        isGameOngoing = true;
        selectedCardsToPlay = new ArrayList<>();
        currentDrawCount = 1;
        canPlayCards = true;
    }

    public boolean canDraw() {
        return isGameOngoing && currentDrawCount > 0;
    }

    private void addCardToCurrentPlayerHand(String cardName) {
        getCurrentPlayerHand().add(cardName);
    }

    public void addToSelectedCardsToPlay(String cardName) {
        selectedCardsToPlay.add(cardName);
    }

    public void drawFromPile() {
        String drawnCardName = drawPile.pollFirst();
        addCardToCurrentPlayerHand(drawnCardName);

        currentDrawCount--;
        canPlayCards = false;
    }

    public boolean isDrawPileEmpty() {
        return drawPile.isEmpty();
    }

    private static Map<Integer, List<String>> getInitialHands() {
        return new HashMap<>(Map.of(
            0, new ArrayList<>(List.of(
                    "DEFUSE", "ATTACK", "CAT", "CAT", "CLONE", "DRAW FROM THE BOTTOM"
                )),
            1, new ArrayList<>(List.of(
                    "DEFUSE", "ATTACK", "CAT", "SWAP TOP AND BOTTOM", "CAT", "CAT"
                )),
            2, new ArrayList<>(List.of(
                    "DEFUSE", "CAT", "CLONE", "RAISING HECK", "GODCAT", "CAT"
                )),
            3, new ArrayList<>(List.of(
                    "DEFUSE", "CAT", "CAT", "CAT", "CAT", "CAT"
                )),
            4, new ArrayList<>(List.of(
                    "DEFUSE", "FEED THE DEAD", "ATTACK", "ATTACK", "CAT", "CAT"
                ))
        ));
    }

}
