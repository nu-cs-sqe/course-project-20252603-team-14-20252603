package ui;

public class StartController {

    private final StartView view;

    public StartController(AssetManager assets) {
        this.view = new StartView(assets);
    }

    public StartView getStartView() {
        return view;
    }

}