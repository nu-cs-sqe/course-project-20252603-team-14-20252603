package ui;

public class StartController {

    private final SceneManager sceneManager;
    private final StartView view;

    public StartController(AssetManager assets, SceneManager sceneManager) {
        this.sceneManager = sceneManager;
        this.view = new StartView(this, assets);
    }

    public StartView getStartView() {
        return view;
    }
    public void startGame() {
        sceneManager.showPlayerCreateView();
    }
}
