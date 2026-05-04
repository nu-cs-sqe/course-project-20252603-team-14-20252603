package domain;

import java.util.*;

public class GameState {

    private final List<String> playerNames;
    private Map<Integer, List<String>> playerHands;
    private int startingPlayerIndex;
    private int currentPlayerIndex;
    private boolean isFaceUp;
    private boolean isGameOngoing;
    private boolean isValidPlay;
    private int currentDrawCount;
    private Deque<String> drawPile;

    public GameState() {
        playerNames = List.of("STEVE", "MONKEY", "JENNY", "ELI", "GEORGE WASHINGTON");
        playerHands = getInitialHands();
        startingPlayerIndex = 0;
        currentPlayerIndex = 0;
        isFaceUp = false;
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

    public boolean getIsValidPlay() {
        return isValidPlay;
    }

    public boolean canEndTurn() {
        return isGameOngoing && currentDrawCount <= 0;
    }

    public void startGame() {
        isGameOngoing = true;
        isValidPlay = false;
        currentDrawCount = 1;
    }

    public boolean canDraw() {
        return isGameOngoing && currentDrawCount > 0;
    }

    private void addCardToCurrentPlayerHand(String cardName) {
        getCurrentPlayerHand().add(cardName);
    }

    public void drawFromPile() {
        String drawnCardName = drawPile.pollFirst();
        addCardToCurrentPlayerHand(drawnCardName);

        currentDrawCount--;
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
