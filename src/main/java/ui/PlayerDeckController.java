package ui;

public class PlayerDeckController {

    private final PlayerDeckView view;

    public PlayerDeckController(AssetManager assets) {
        this.view = new PlayerDeckView(this, assets);
    }

    public PlayerDeckView getView() {
        return view;
    }
}
