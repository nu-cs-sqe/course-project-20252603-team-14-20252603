package ui;

import javafx.scene.paint.LinearGradient;

public class UIGradients {

    private UIGradients() {}

    public static final LinearGradient GRADIENT_1 = createGradient(UIConstants.YELLOW_3, UIConstants.ORANGE_3, UIConstants.RED_3);
    public static final LinearGradient GRADIENT_2 = createGradient(UIConstants.YELLOW_1, UIConstants.YELLOW_4);
    public static final LinearGradient GRADIENT_3 = createGradient(UIConstants.MAGENTA_3, UIConstants.MAGENTA_4);

    private static LinearGradient createGradient(String... colors) {

        String gradientString = String.format(
                "from %s %s to %s %s",
                UIConstants.MIN_PERCENT+"%",
                UIConstants.MIN_PERCENT+"%",
                UIConstants.MIN_PERCENT+"%",
                UIConstants.MAX_PERCENT+"%"
        );

        for (String color : colors) {
            gradientString += ", " + color;
        }

        return javafx.scene.paint.LinearGradient.valueOf(gradientString);
    }
}
