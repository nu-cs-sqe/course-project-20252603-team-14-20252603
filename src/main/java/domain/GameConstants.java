package domain;

import java.util.HashMap;
import java.util.Map;

public class GameConstants {

    private GameConstants() {}

    public static final int STARTING_PLAYER_INDEX = 0;

    // PLAYER_NAMES, INITIAL_PLAYER_HANDS, getInitialHands are temporary and will be eventually fetched from model
    public static final String[] PLAYER_NAMES = {
            "STEVE", "MONKEY", "JENNY", "ELI", "GEORGE WASHINGTON"
    };
    public static final HashMap<Integer, String[]> INITIAL_PLAYER_HANDS = getInitialHands(PLAYER_NAMES);
    private static HashMap<Integer, String[]> getInitialHands(String[] playerNames) {
        HashMap<Integer, String[]> initialPlayerHands = new HashMap<>(Map.of(
                0, new String[]{
                        "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                },
                1, new String[]{
                        "ATTACK", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                },
                2, new String[]{
                        "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                },
                3, new String[]{
                        "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                },
                4, new String[]{
                        "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE", "DEFUSE"
                }
        ));

        return initialPlayerHands;
    }
}
