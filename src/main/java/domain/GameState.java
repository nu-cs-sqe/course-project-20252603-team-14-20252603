package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {

    private final List<String> playerNames;
    private HashMap<Integer, List<String>> playerHands;
    private int currentPlayerIndex;
    private boolean isFaceUp;

    public GameState() {
        playerNames = List.of("STEVE", "MONKEY", "JENNY", "ELI", "GEORGE WASHINGTON");
        playerHands = getInitialHands();
        currentPlayerIndex = 0;
        isFaceUp = false;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int index) {
        currentPlayerIndex = index;
    }

    public List<String> getCurrentPlayerHand() {
        return playerHands.get(getCurrentPlayerIndex());
    }

    public boolean getIsFaceUp() {
        return isFaceUp;
    }

    public void setIsFaceUp(boolean value) {
        isFaceUp = value;
    }

    private static HashMap<Integer, List<String>> getInitialHands() {
        return new HashMap<>(Map.of(
            0, List.of(
                    "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                ),
            1, List.of(
                    "ATTACK", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                ),
            2, List.of(
                    "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                ),
            3, List.of(
                    "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                ),
            4, List.of(
                    "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                )
        ));
    }
}
