package ui;

public class PlayerDeckController {

    private final PlayerDeckView view;

    public PlayerDeckController() {
        this.view = new PlayerDeckView(this);
    }

    public PlayerDeckView getView() {
        return view;
    }
}
